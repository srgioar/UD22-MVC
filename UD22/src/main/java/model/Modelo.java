package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Modelo {
	
	public static Connection conexion;
	
	private String query;
	private String respuesta;
	ConectorSQL cSQL;
	
	public Modelo() {
		this.cSQL = new ConectorSQL();
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	public String getQuery() {
		return this.query;
	}
	
	public String getRespuesta() {
		return respuesta;
	}
	
	public String funcionTestear() {
		
		//ConectorSQL.openConnection();
		
		String txt = ConectorSQL.testConnection();
		
		return txt;
		
		//ConectorSQL.closeConnection();
		
	}
	
	public void funcionLeer() {
		
		ConectorSQL.openConnection();
		
		respuesta = cSQL.Select("Seleccionar", query);
		
		ConectorSQL.closeConnection();
		
		
	}

	public void funcionInsertar() {

		ConectorSQL.openConnection();
		
		respuesta = cSQL.manipularBD("Insertados", "Insertar", query);
		
		ConectorSQL.closeConnection();
	}
	
	public void funcionModificar() {
		
		ConectorSQL.openConnection();
		
		respuesta = cSQL.manipularBD("actualizados", "actualizar", query);
		
		ConectorSQL.closeConnection();
		
	}
	
	public void funcionBorrar() {
		
		ConectorSQL.openConnection();
		
		respuesta = cSQL.manipularBD("Eliminados", "Eliminar", query);
		
		ConectorSQL.closeConnection();
		
	}
	


}
