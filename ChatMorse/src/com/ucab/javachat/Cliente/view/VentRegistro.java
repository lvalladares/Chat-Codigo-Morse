package com.ucab.javachat.Cliente.view;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;


/**
 * Esta clase se encarga de mostrar la vista para cuando sea requerido registrar un usuario.
 * 
 * @author Grupo 3
 * 
 * @version 1.0
 */

@SuppressWarnings("serial")
public class VentRegistro extends JFrame{

	public JFrame frmRegistroDeUsuario;
	public JTextField campoUsuario, campoNombre, campoEmail, nombreImagen;
	public JPasswordField campoContraseña, campoRepContraseña;
	public JRadioButton rdbtnMasculino, rdbtnFemenino;
	public JLabel usuarioValido, nombreValido, fechaValida, sexoValido, emailValido, contraseñaValida, 
	lblContraseñaIgual, lblSexoValido, lblImagenSeleccionada;
	public JButton btnRegistrar, btnSeleccionarFoto, btnSalir;
	public ButtonGroup grupoSexo;
	public JDateChooser fechaUsuario;

	/**
	 * Create the application.
	 */
	public VentRegistro() {
		initialize();
		
	}

	/**
	 * Inicializa los componentes de la ventana
	 */
	private void initialize() {
		frmRegistroDeUsuario = new JFrame();
		frmRegistroDeUsuario.setTitle("Registro de usuario");
		frmRegistroDeUsuario.setBounds(100, 100, 645, 347);
		frmRegistroDeUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeUsuario.getContentPane().setLayout(null);
		
		JLabel labelIntroduccion = new JLabel("Rellene los siguientes campos:");
		labelIntroduccion.setBounds(22, 12, 226, 15);
		frmRegistroDeUsuario.getContentPane().add(labelIntroduccion);
		
		JLabel labelUsuario = new JLabel("Usuario:");
		labelUsuario.setBounds(32, 41, 70, 15);
		frmRegistroDeUsuario.getContentPane().add(labelUsuario);
		
		JLabel labelNombre = new JLabel("Nombre Completo:");
		labelNombre.setBounds(31, 68, 131, 15);
		frmRegistroDeUsuario.getContentPane().add(labelNombre);
		
		JLabel labelFecha = new JLabel("Fecha de nacimiento:\n");
		labelFecha.setBounds(32, 95, 155, 15);
		frmRegistroDeUsuario.getContentPane().add(labelFecha);
		
		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setBounds(32, 122, 50, 15);
		frmRegistroDeUsuario.getContentPane().add(labelEmail);
		
		JLabel labelSexo = new JLabel("Sexo:");
		labelSexo.setBounds(32, 149, 50, 15);
		frmRegistroDeUsuario.getContentPane().add(labelSexo);
		
		JLabel labelContraseña = new JLabel("Contraseña:");
		labelContraseña.setBounds(32, 176, 94, 15);
		frmRegistroDeUsuario.getContentPane().add(labelContraseña);
		
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(192, 39, 155, 19);
		frmRegistroDeUsuario.getContentPane().add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(192, 66, 155, 19);
		frmRegistroDeUsuario.getContentPane().add(campoNombre);
		campoNombre.setColumns(10);
		
		fechaUsuario = new JDateChooser();
		fechaUsuario.setBounds(192, 91, 155, 19);
		frmRegistroDeUsuario.getContentPane().add(fechaUsuario);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(192, 120, 155, 19);
		frmRegistroDeUsuario.getContentPane().add(campoEmail);
		campoEmail.setColumns(10);
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(177, 147, 105, 19);
		frmRegistroDeUsuario.getContentPane().add(rdbtnMasculino);
		
		rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBounds(286, 147, 99, 19);
		frmRegistroDeUsuario.getContentPane().add(rdbtnFemenino);
		
		grupoSexo = new ButtonGroup();
		grupoSexo.add(rdbtnFemenino);
		grupoSexo.add(rdbtnMasculino);
		
		campoContraseña = new JPasswordField();
		campoContraseña.setBounds(192, 174, 155, 19);
		frmRegistroDeUsuario.getContentPane().add(campoContraseña);
		
		usuarioValido = new JLabel("-> 8+ caracteres y solo letras.");
		usuarioValido.setForeground(Color.BLACK);
		usuarioValido.setFont(new Font("Dialog", Font.BOLD, 12));
		usuarioValido.setBounds(365, 41, 266, 15);
		frmRegistroDeUsuario.getContentPane().add(usuarioValido);
		
		nombreValido = new JLabel("-> nombre sin numeros y caract.");
		nombreValido.setForeground(Color.BLACK);
		nombreValido.setFont(new Font("Dialog", Font.BOLD, 12));
		nombreValido.setBounds(365, 68, 266, 15);
		frmRegistroDeUsuario.getContentPane().add(nombreValido);
		
		fechaValida = new JLabel("-> debes ser mayor de 10 años.");
		fechaValida.setForeground(Color.BLACK);
		fechaValida.setFont(new Font("Dialog", Font.BOLD, 12));
		fechaValida.setBounds(365, 95, 254, 15);
		frmRegistroDeUsuario.getContentPane().add(fechaValida);
		
		emailValido = new JLabel("");
		emailValido.setFont(new Font("Dialog", Font.BOLD, 12));
		emailValido.setForeground(new Color(178, 34, 34));
		emailValido.setBounds(365, 122, 254, 15);
		frmRegistroDeUsuario.getContentPane().add(emailValido);
		
		contraseñaValida = new JLabel("-> 6 a 12 caract., mínimo un num.");
		contraseñaValida.setForeground(Color.BLACK);
		contraseñaValida.setFont(new Font("Dialog", Font.BOLD, 12));
		contraseñaValida.setBounds(365, 174, 266, 19);
		frmRegistroDeUsuario.getContentPane().add(contraseñaValida);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(409, 281, 121, 25);
		frmRegistroDeUsuario.getContentPane().add(btnRegistrar);
		
		JLabel lblFotografa = new JLabel("Imagen:");
		lblFotografa.setBounds(32, 230, 94, 15);
		frmRegistroDeUsuario.getContentPane().add(lblFotografa);
		
		btnSeleccionarFoto = new JButton("Seleccionar imagen");
		btnSeleccionarFoto.setBounds(381, 228, 201, 19);
		frmRegistroDeUsuario.getContentPane().add(btnSeleccionarFoto);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(542, 282, 89, 23);
		frmRegistroDeUsuario.getContentPane().add(btnSalir);
		
		nombreImagen = new JTextField();
		nombreImagen.setBounds(192, 228, 155, 19);
		frmRegistroDeUsuario.getContentPane().add(nombreImagen);
		nombreImagen.setColumns(10);
		
		JLabel lblRepetirContraseña = new JLabel("Repetir Contraseña:");
		lblRepetirContraseña.setBounds(32, 203, 144, 15);
		frmRegistroDeUsuario.getContentPane().add(lblRepetirContraseña);
		
		campoRepContraseña = new JPasswordField();
		campoRepContraseña.setBounds(192, 201, 155, 19);
		frmRegistroDeUsuario.getContentPane().add(campoRepContraseña);
		
		lblContraseñaIgual = new JLabel("-> repita la contraseña");
		lblContraseñaIgual.setBounds(365, 201, 266, 15);
		frmRegistroDeUsuario.getContentPane().add(lblContraseñaIgual);
		
		lblSexoValido = new JLabel("");
		lblSexoValido.setBounds(416, 149, 190, 15);
		frmRegistroDeUsuario.getContentPane().add(lblSexoValido);
		
		lblImagenSeleccionada = new JLabel("");
		lblImagenSeleccionada.setBounds(192, 259, 254, 15);
		frmRegistroDeUsuario.getContentPane().add(lblImagenSeleccionada);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setResizable(false);
		
	}
}