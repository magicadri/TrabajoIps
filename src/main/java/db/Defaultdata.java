package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Defaultdata {

	private Connection c;
	
	public Defaultdata(Connection c){
		this.c = c;
	}
	
	/**
	 * Mete algunos datos en las tablas
	 * @throws SQLException 
	 */
	public void addData() throws SQLException{
		addDataSocio();
		addDataAdmin();
		addDataInstalacion();
		addDataReserva();
		addDataRecibo();
	}
	
	/**
	 * Inserta datos a la tabla Socio
	 * @throws SQLException 
	 */
	private void addDataSocio() throws SQLException{
		Statement st = c.createStatement();
		StringBuilder query = new StringBuilder();
		
		query.append("INSERT INTO Socio (socioID, cuota)");
		query.append("VALUES");
		query.append("('socio1', '15'),");
		query.append("('socio2', '15'),");
		query.append("('socio3', '15'),");
		query.append("('socio4', '15')");
		
		ResultSet rs = st.executeQuery(query.toString());
		
		rs.close();
		st.close();
		
		System.out.println("Datos insertados en la tabla de socios.");
	}
	
	/**
	 * Inserta datos a la tabla Admin
	 * @throws SQLException 
	 */
	private void addDataAdmin() throws SQLException{
		Statement st = c.createStatement();
		StringBuilder query = new StringBuilder();
		
		query.append("INSERT INTO Admin(adminID)");
		query.append("VALUES");
		query.append("('admin')");
		
		ResultSet rs = st.executeQuery(query.toString());
		
		rs.close();
		st.close();
		
		System.out.println("Datos insertados en la tabla de administradores.");
	}
	
	/**
	 * Inserta datos a la tabla Instalacion
	 * @throws SQLException 
	 */
	private void addDataInstalacion() throws SQLException{
		Statement st = c.createStatement();
		StringBuilder query = new StringBuilder();
		
		query.append("INSERT INTO Instalacion (instalacionID, precio)");
		query.append("VALUES");
		query.append("('piscina', '2'),");
		query.append("('futbol', '1'),");
		query.append("('tenis', '1.5')");
		
		ResultSet rs = st.executeQuery(query.toString());
		
		rs.close();
		st.close();
		
		System.out.println("Datos insertados en la tabla de instalaciones.");
	}
	
	/**
	 * Inserta datos a la tabla Reserva
	 * @throws SQLException 
	 */
	private void addDataReserva() throws SQLException{
		Statement st = c.createStatement();
		StringBuilder query = new StringBuilder();
		
		query.append("INSERT INTO Reserva (socioID, adminID, instalacionID, horaComienzo, horaFinal, fecha)");
		query.append("VALUES");
		query.append("('socio1', null, 'piscina', '5', '6', 2016/10/28),");
		query.append("(null, 'admin', 'piscina', '18', '19', 2016/10/28),");
		query.append("('socio3', null, 'piscina', '22', '23', 2016/10/28),");
		query.append("('socio2', null, 'futbol', '12', '13', 2016/10/29),");
		query.append("(null, 'admin', 'futbol', '14', '15', 2016/10/29),");
		query.append("('socio3', null, 'tenis', '6', '7', 2016/10/30),");
		query.append("(null, 'admin', 'tenis', '11', '12', 2016/10/30),");
		query.append("('socio4', null, 'tenis', '7', '8', 2016/10/30),");
		query.append("(null, 'admin', 'tenis', '14', '15', 2016/10/30),");
		
		ResultSet rs = st.executeQuery(query.toString());
		
		rs.close();
		st.close();
		
		System.out.println("Datos insertados en la tabla de reservas.");
	}
	
	/**
	 * Inserta datos a la tabla Recibo
	 * @throws SQLException 
	 */
	private void addDataRecibo() throws SQLException{
		Statement st = c.createStatement();
		StringBuilder query = new StringBuilder();
		
		query.append("INSERT INTO Recibo (socioID, adminID, instalacionID, pago)");
		query.append("VALUES");
		query.append("('socio1', 'admin', 'piscina', '2'),");
		query.append("('socio3', 'admin', 'piscina', '2'),");
		query.append("('socio2', 'admin', 'futbol', '1'),");
		query.append("('socio3', 'admin', 'tenis', '1.5'),");
		query.append("('socio4', 'admin', 'tenis', '1.5'),");
		
		ResultSet rs = st.executeQuery(query.toString());
		
		rs.close();
		st.close();
		
		System.out.println("Datos insertados en la tabla de recibos.");
	}
}
