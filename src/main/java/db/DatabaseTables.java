package db;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTables {

	private Connection c;
	
	public DatabaseTables(Connection c){
		this.c = c;
	}
	
	/**
	 * Crea todas las tablas
	 * @throws SQLException 
	 */
	public void crearTablas() throws SQLException{
		crearTablaSocio();
		crearTablaAdmin();
		crearTablaInstalacion();
		crearTablaReserva();
		crearTablaRecibo();
	}
	
	/**
	 * Crea la tabla Socio
	 * @throws SQLException 
	 */
	private void crearTablaSocio() throws SQLException{
		Statement st = c.createStatement();
		StringBuilder query = new StringBuilder();
		
		query.append("CREATE TABLE Socio");
		query.append("( socioID char(10),");
		query.append("  cuota int");
		query.append(") ");
		
		st.execute(query.toString());
		
		st.close();
		
		System.out.println("Tabla de socios creada.");
	}
	
	/**
	 * Crea la tabla Admin
	 * @throws SQLException 
	 */
	private void crearTablaAdmin() throws SQLException{
		Statement st = c.createStatement();
		StringBuilder query = new StringBuilder();
		
		query.append("CREATE TABLE Admin");
		query.append("( adminID char(10),");
		query.append(") ");
		
		st.execute(query.toString());
		
		st.close();
		
		System.out.println("Tabla de administradores creada.");
	}
	
	/**
	 * Crea la tabla Instalacion
	 * @throws SQLException 
	 */
	private void crearTablaInstalacion() throws SQLException{
		Statement st = c.createStatement();
		StringBuilder query = new StringBuilder();
		
		query.append("CREATE TABLE Instalacion");
		query.append("( instalacionID char(10),");
		query.append("  precio float");
		query.append(") ");

		st.execute(query.toString());
		
		st.close();
		
		System.out.println("Tabla de instalaciones creada.");
	}
	
	/**
	 * Crea la tabla Reserva
	 * @throws SQLException 
	 */
	private void crearTablaReserva() throws SQLException{
		Statement st = c.createStatement();
		StringBuilder query = new StringBuilder();
		
		query.append("CREATE TABLE Reserva");
		query.append("( socioID char(10),");
		query.append("  adminID char(10),");
		query.append("  instalacionID char(10),");
		query.append("  horaComienzo int,");
		query.append("  horaFinal int,");
		query.append("  fecha date");
		query.append(") ");

		st.execute(query.toString());
		
		st.close();
		
		System.out.println("Tabla de reservas creada.");
	}
	
	/**
	 * Crea la tabla Recibo
	 * @throws SQLException 
	 */
	private void crearTablaRecibo() throws SQLException{
		Statement st = c.createStatement();
		StringBuilder query = new StringBuilder();
		
		query.append("CREATE TABLE Recibo");
		query.append("( socioID char(10),");
		query.append("( adminID char(10),");
		query.append("( instalacionID char(10),");
		query.append("  pago float");
		query.append(") ");

		st.execute(query.toString());
		
		st.close();
		
		System.out.println("Tabla de recibos creada.");
	}
}
