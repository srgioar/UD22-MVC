package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

public class Vista extends JFrame {
	
	private JPanel panelA, panelB;
	public JLabel respuesta;
	public JTextField texto;
	
	public JButton testDB;
	public JButton insertar;
	public JButton modificar;
	public JButton leer;
	public JButton borrar;
	
	public Vista() {
		
		getContentPane().setLayout(new BorderLayout());
		
		panelA = new JPanel();
		panelA.setLayout(new FlowLayout());
		
		panelB = new JPanel();
		panelB.setLayout(new FlowLayout());
		
		testDB = new JButton("TEST DB");
		insertar = new JButton("INSERT");
		modificar = new JButton("UPDATE");
		leer = new JButton("SELECT");
		borrar = new JButton("DELETE");
		
		respuesta = new JLabel("Respuesta: ");
		texto = new JTextField(20);
		
		panelA.add(testDB);
		panelA.add(insertar);
		panelA.add(modificar);
		panelA.add(leer);
		panelA.add(borrar);
		
		panelB.add(respuesta);
		
		add(texto, BorderLayout.CENTER);
		add(panelA, BorderLayout.NORTH);
		add(panelB, BorderLayout.SOUTH);
		
	}
	


}
