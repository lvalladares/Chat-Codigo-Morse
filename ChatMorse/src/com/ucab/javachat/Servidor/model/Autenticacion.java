package com.ucab.javachat.Servidor.model;

import java.util.ArrayList;

/** Clase encargada de la autenticacion del usuario en el sistema contrastando los datos recibidos
 * con los almacenados en el servidor. Se encarga ademas de realizar las validaciones necesarias del lado del servidor
 * y de comprobar los valores unicos
 * @author Grupo 3 - A. Rodriguez, I. Teixeira, L. Valladares, D. Suarez
 *
 */
public class Autenticacion {
	Usuario user;
	String nombreDeUsuario;
	String clave;
	String correo;
	ArrayList<Usuario> usuariosArchivo = new ArrayList<Usuario>();
	
	/** Constructor para el registro de un nuevo usuario.
	 * @param user - El usuario a registrar
	 */
	public Autenticacion(Usuario user) {
		ManejoArchivos archivo = new ManejoArchivos();
		this.user = user;
		usuariosArchivo = archivo.getListaUsuarios();
	}
	
	/** Constructor para el inicio de sesion de un usuario.
	 * @param nombreDeUsuario - nombre o correo del usuario que iniciar sesion
	 * @param clave - clave del usuario que iniciara sesion
	 */
	public Autenticacion(String nombreDeUsuario, String clave) {
		ManejoArchivos archivo = new ManejoArchivos();
		usuariosArchivo = archivo.getListaUsuarios();
		this.nombreDeUsuario = nombreDeUsuario;
		try {
			this.clave = Criptologia.desencriptar(clave);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Autenticacion(String correo){
		this.correo = correo;
	}
	
	/** Realiza el proceso de autenticacion del usuario en el sistema contrastando sus datos
	 * con los almacenados en el sistema
	 * @return Verdadero cuando el usuario existe, falso en cualquier otro caso
	 */
	public Usuario autenticar() {
		if(usuariosArchivo != null) {
			for (Usuario usuario : usuariosArchivo) {
				try {
					// comprueba si existe algun usuario con el correo o el nombre de usuario indicado
					if (usuario.getNombreDeUsuario().trim().equals(nombreDeUsuario.trim())) {
						// comprueba si hay algun usuario con esa clave
						if (Criptologia.desencriptar(usuario.getClave()).trim().equals(clave.trim())) { 
							return usuario;
						} else {
							return null;
						}
					} else {
						return null;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			return null;
		}
		return null;
	}
	
	/** Realiza el proceso de registro de usuario, almacenando el nuevo usuario en el archiv con comprobacion previa
	 * si el correo o el nombre de usuario ya estan registrados
	 * @return Verdadero si se registro el usuario, falso en cualquier otro caso
	 */
	public boolean registrar() {
		if(usuariosArchivo != null) {
			for (Usuario usuario : usuariosArchivo) {
				try {
					if (Criptologia.desencriptar(usuario.getEmail()) == Criptologia.desencriptar(user.getEmail())) {
						return false;
					}
					if (usuario.getNombreDeUsuario() == this.user.getNombreDeUsuario()) {
						return false;
					}
					if (user.usuarioVacio()) {
						return false;
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}		
			}
		}
		else
		{
			usuariosArchivo = new ArrayList<Usuario>();
		}
		System.out.println(user);
		usuariosArchivo.add(this.user);
		ManejoArchivos archivo = new ManejoArchivos();
		archivo.escribirArchivo(usuariosArchivo);
		return true;
	}

	public String comparaContraseña(){
		ManejoArchivos archivo = new ManejoArchivos();
		for(Usuario user : archivo.getListaUsuarios()) {
			String email = user.getEmail();
			try {
				if (Criptologia.desencriptar(email).trim().equals(correo.trim())){
					return Criptologia.desencriptar(user.getClave());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
