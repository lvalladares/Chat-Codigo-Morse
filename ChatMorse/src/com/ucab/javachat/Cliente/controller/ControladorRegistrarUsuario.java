package com.ucab.javachat.Cliente.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ucab.javachat.Cliente.model.Criptologia;
import com.ucab.javachat.Cliente.model.Usuario;
import com.ucab.javachat.Cliente.view.VentCliente;
import com.ucab.javachat.Cliente.view.VentRegistro;
import com.ucab.javachat.Cliente.model.Validacion;

/**
 * Esta clase es el controlador de la vista del registro de usuario.
 * Al usuario se le indica con que caracteristica especifica debe contar cada campo 
 * de registro. Luego se obtiene la informacion indicada en los campos mostrados en 
 * las vista y se aplican los metodos necesarios para la comprobacion de la informacion. 
 * Si todos los campos estan correctamente rellenados, se procede a enviar la información
 * al servidor para guardarla.
 * 
 * @authors Grupo 3 - A. Rodriguez, I. Teixeira, L. Valladares, D. Suarez
 * @version 2.0
 * 
 */

public class ControladorRegistrarUsuario implements ActionListener {
	private VentRegistro vista;
	private Usuario nuevoUsuario;
	
	public Usuario getNuevoUsuario() {
		return nuevoUsuario;
	}
	
	/**
	 * Constructor del controlador. Aqui se añaden los Listener a los botones de la vista.
	 * @param vista - Instancia de la ventana para registrar al usuario.
	 * @param cliente - Instancia del modelo en el que se envian los datos del usuario al servidor.
	 */
	public ControladorRegistrarUsuario(VentRegistro vista){
		this.vista = vista;
		this.vista.btnRegistrar.addActionListener(this);
		this.vista.btnSeleccionarFoto.addActionListener(this);
		this.vista.btnSalir.addActionListener(this);
		nuevoUsuario = new Usuario();
		this.vista.frmRegistroDeUsuario.setVisible(true);
	}
	
	public void cerrarVentana() {
		this.vista.frmRegistroDeUsuario.dispose();
	}
	
	/**
	 * Controlador de eventos para los botones de la vista.
	 */
	public void actionPerformed(ActionEvent e) {
		boolean flag = true;
		if (vista.btnSeleccionarFoto == e.getSource()){
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter(".jpg & .gif", "jpg", "gif");
	        chooser.setFileFilter(filtro);
	        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			File archivos = new File (".");
			chooser.setCurrentDirectory(archivos);
			chooser.setDialogTitle("Seleccione una foto.");
			//Elegiremos archivos del directorio;
			chooser.setAcceptAllFileFilterUsed(false);
			//Si seleccionamos algún archivo retornaremos su directorio
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File fichero = chooser.getSelectedFile();
				nuevoUsuario.setImagen(fichero);
				System.out.println(fichero);
			} 	
			else flag = false;
		}
		
		
		if (vista.btnRegistrar == e.getSource()){			
			Validacion validacion = new Validacion();
			if (vista.rdbtnMasculino.isSelected()) 
				nuevoUsuario.setSexo(true);
			else if (vista.rdbtnFemenino.isSelected()) 
				nuevoUsuario.setSexo(false);
			
			if (validacion.validarUsuario(vista.campoUsuario.getText()) == false){
				vista.usuarioValido.setText("ingrese otro nombre de usuario.");
				flag = false;
			}
			else{
				vista.usuarioValido.setText(" ");
				nuevoUsuario.setNombreDeUsuario(vista.campoUsuario.getText());
			}
			
			if (validacion.validarNombreCompleto(vista.campoNombre.getText()) == false){
				vista.nombreValido.setText("escriba nombre valido.");
				flag = false;
			}
			else{
				vista.nombreValido.setText(" ");
				nuevoUsuario.setNombreCompleto(vista.campoNombre.getText());
			}
			
			if (validacion.validarFecha(vista.fechaUsuario.getDate()) == false){
				vista.fechaValida.setText("usted es muy joven.");
				flag = false;
			}
			else{
				vista.fechaValida.setText(" ");
				nuevoUsuario.setFecha(vista.fechaUsuario.getDate());
			}
			
			if (validacion.validarEmail(vista.campoEmail.getText()) == false){
				vista.emailValido.setText("correo en formato incorrecto");
				flag = false;
			}
			else{
				vista.emailValido.setText(" ");
				nuevoUsuario.setEmail(vista.campoEmail.getText());
			}
			
 			if (validacion.validarContraseña(String.valueOf(vista.campoContraseña.getPassword())) == false){
 				vista.contraseñaValida.setText("contraseña invalida.");
 				flag = false;
 			}
 			else{
 				vista.contraseñaValida.setText(" ");
 				nuevoUsuario.setClave(String.valueOf(vista.campoContraseña.getPassword()));
 			}
 		}
		
		if (vista.btnSalir == e.getSource()){
		    vista.frmRegistroDeUsuario.dispose();
		}	
		
		if (flag){
			nuevoUsuario.setEmail(Criptologia.encriptar(nuevoUsuario.getEmail()));
			nuevoUsuario.setClave(Criptologia.encriptar(nuevoUsuario.getClave()));
			VentCliente ventana = new VentCliente();
			new ControladorCliente(ventana, this);
		}
	}
}
