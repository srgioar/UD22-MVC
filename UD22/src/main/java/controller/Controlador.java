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
	public void actionPerformed(ActionEvent e) {
		
		query = vista.texto.getText();
		
		if (vista.leer == e.getSource()) {
			if (!"".equals(vista.texto.getText())) {
				query = vista.texto.getText();
				modelo.setQuery(query);
				//modelo.insertarDatos();
				vista.respuesta.setText(modelo.getRespuesta());
			}
		}
		
		else if (vista.insertar == e.getSource()) {
			if (!"".equals(vista.texto.getText())) {
				query = vista.texto.getText();
				modelo.setQuery(query);
				//modelo.insertarDatos();
				vista.respuesta.setText(modelo.getRespuesta());
			}
		}
		
		else if (vista.modificar == e.getSource()) {
			if (!"".equals(vista.texto.getText())) {
				query = vista.texto.getText();
				modelo.setQuery(query);
				//modelo.insertarDatos();
				vista.respuesta.setText(modelo.getRespuesta());
			}
		}
		
		else if (vista.borrar == e.getSource()) {
			if (!"".equals(vista.texto.getText())) {
				query = vista.texto.getText();
				modelo.setQuery(query);
				//modelo.insertarDatos();
				vista.respuesta.setText(modelo.getRespuesta());
			}
		}
		
		
	}

}
