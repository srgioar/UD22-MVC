package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ConectorSQL {
	
	public static Connection conexion;
	
	// Método para testear la conexión
	// Va pasando un string que se aplica al textfield respuesta
	
	public static String testConnection() {
		
		String msg = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.78:3306","remote","Pass_1234");
			msg = "Conexión exitosa...";
			conexion.close();
			
			
		}catch(SQLException | ClassNotFoundException ex  ){
			msg = "No se ha podido conectar con mi base de datos";
			System.out.println(ex.getMessage());
			
		}
		
		return msg;
		
	}
		

	//METODO QUE ABRE LA CONEXION CON SERVER MYSQL
	public static void openConnection() {
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.78:3306","remote","Pass_1234");
			
		}catch(SQLException | ClassNotFoundException ex  ){
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.println(ex.getMessage());
			
		}
			
	}
			
	//METODO QUE CIERRA LA CONEXION CON SERVER MYSQL
	public static void closeConnection() {
		try {
	
			conexion.close();
			System.out.print("Desconectado con éxito");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.print("Error cerrando conexion");

		}
	}
		
	public String manipularBD(String nombre, String accion, String query) {
		try {
			String QueryDB = "USE ud22";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(QueryDB);
			Statement st = conexion.createStatement();
			st.executeUpdate(query);
			return ("Datos " + nombre + " correctamente");
		} catch (SQLException e) {
			return ("Error al " + accion + " datos");
		}
	}
		
	public String Select (String accion, String query) {
		String resultado = "";
		
		try {
			String sql = "Select * from cliente where id = ? " ;
			String QueryDB = "USE ud22";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(QueryDB);
			PreparedStatement consulta = conexion.prepareStatement(sql);
			consulta.setInt(1, Integer.parseInt(query));
			ResultSet res = consulta.executeQuery();
			System.out.println("uwu");
			while (res.next()) {
				resultado += res.getString("id") + " ";
				resultado += res.getString("nombre") + " ";
				resultado += res.getString("apellido") + " ";
				resultado += res.getString("direccion") + " ";
				resultado += res.getString("dni") + " ";
				resultado += res.getString("fecha") + " ";
			}
			res.close();
			return resultado;
		} catch (SQLException e) {
			System.out.println(e);
			return "Error al " + accion + " datos";
		}
	}
		
	}
