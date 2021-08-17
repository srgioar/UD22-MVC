package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.Modelo;
import view.Vista;

public class Controlador implements ActionListener {
	
	private Modelo modelo;
	private Vista vista;
	private String query;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.testDB.addActionListener(this);
		this.vista.leer.addActionListener(this);
		this.vista.insertar.addActionListener(this);
		this.vista.modificar.addActionListener(this);
		this.vista.borrar.addActionListener(this);
		
	}
	
	// Inicia la ventana principal y la setea
	public void arrancar() {
		vista.setTitle("MVC");
		vista.pack();
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
	}
	
	
	// Responde a los listeners
	// Dependiendo del evento disparado (botón) y del campo de texto ejecuta una query u otra
	// Excepto el testear conexión que solo testea la conexión y devuelve string
	
	public void actionPerformed(ActionEvent e) {
		
		query = vista.texto.getText();
		
		if (vista.testDB == e.getSource()) {
			
                String txt = modelo.funcionTestear();
                vista.respuesta.setText(txt);

		}
		
		else if (vista.leer == e.getSource()) {
			if (!"".equals(vista.texto.getText())) {
				
                query = vista.texto.getText();
                modelo.setQuery(query);
                modelo.funcionLeer();
                vista.respuesta.setText(modelo.getRespuesta());
				
			}
		}
		
		
		
		else if (vista.insertar == e.getSource()) {
			if (!"".equals(vista.texto.getText())) {
				
				modelo.setQuery("insert into cliente (nombre, apellido, direccion, dni, fecha) values (" + query + ");");
				modelo.funcionModificar();
				vista.respuesta.setText(modelo.getRespuesta());
				
			}
		}
		
		else if (vista.modificar == e.getSource()) {
			if (!"".equals(vista.texto.getText())) {
				
                query = vista.texto.getText();
                modelo.setQuery("update cliente set " + query );
                modelo.funcionModificar();
                vista.respuesta.setText(modelo.getRespuesta());
				
			}
		}
		
		else if (vista.borrar == e.getSource()) {
			if (!"".equals(vista.texto.getText())) {
				
				modelo.setQuery("delete from cliente " + query);
				modelo.funcionBorrar();
				vista.respuesta.setText(modelo.getRespuesta());
				
			}
		}
		
		
	}

}
