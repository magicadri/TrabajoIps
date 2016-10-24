package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.Actividad2;
import logic.Instalacion2;
import logic.Recibo2;
import logic.Reserva2;
import logic.Socio2;

public class Parser {
	
	List<Socio2> socios = new ArrayList<Socio2>();
	List<Instalacion2> instalaciones = new ArrayList<Instalacion2>();
	List<Reserva2> reservas = new ArrayList<Reserva2>();
	List<Recibo2> recibos = new ArrayList<Recibo2>();
	List<Actividad2> actividades = new ArrayList<Actividad2>();
	Connection c = Database.getInstance().getC();
	
	public void fillArrays() throws SQLException
	{
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("Select * From SOCIO");
		while(rs.next())
		{
			socios.add(new Socio2(rs.getString("socioID")));
		}
		
		s = c.createStatement();
		rs = s.executeQuery("Select * From INSTALACION");
		while(rs.next())
		{
			instalaciones.add(new Instalacion2(rs.getString("instalacionID")));
		}
		
		s = c.createStatement();
		rs = s.executeQuery("Select * From RESERVA");
		while(rs.next())
		{
			reservas.add(new Reserva2(rs.getInt("reservaID"), rs.getString("socioID"), rs.getInt("instalacionID"), 
					rs.getTimestamp("horaComienzo"), rs.getTimestamp("horaFinal"),
					rs.getTimestamp("horaEntrada"), rs.getTimestamp("horaSalida"), 
					rs.getString("modoPago"), rs.getInt("precio")));
		}
		
		s = c.createStatement();
		rs = s.executeQuery("Select * From RECIBO");
		while(rs.next())
		{
			recibos.add(new Recibo2(rs.getInt("reciboID"), rs.getString("socioID"), rs.getInt("reservaID"), 
					rs.getInt("instalacionID"), rs.getInt("importe")));
		}
		
		s = c.createStatement();
		rs = s.executeQuery("Select * From ACTIVIDAD");
		while(rs.next())
		{
			actividades.add(new Actividad2(rs.getInt("actividadID"), rs.getTimestamp("fechaComienzo"), rs.getTimestamp("fechaFinal")));
		}
		
	}
	
}
