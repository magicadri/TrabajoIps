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
	
	List<Socio2> socios = new ArrayList<>();
	List<Instalacion2> instalaciones = new ArrayList<>();
	List<Reserva2> reservas = new ArrayList<>();
	List<Recibo2> recibos = new ArrayList<>();
	List<Actividad2> actividades = new ArrayList<>();
	Connection c = Database.getInstance().getC();
	
	public void fillArrays() throws SQLException
	{
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("select * from SOCIO");
		while(rs.next())
		{
			socios.add(new Socio2(rs.getString("socioID")));
		}
		
		s = c.createStatement();
		rs = s.executeQuery("select * from INSTALACION");
		while(rs.next())
		{
			instalaciones.add(new Instalacion2(rs.getString("instalacionID")));
		}
		
		s = c.createStatement();
		rs = s.executeQuery("Select * From RESERVA");
		while(rs.next())
		{
			reservas.add(new Reserva2(rs.getString("socioID"), rs.getInt("instalacionID"),
					rs.getTimestamp("horaComienzo"), rs.getTimestamp("horaFinal"),
					rs.getTimestamp("horaEntrada"), rs.getTimestamp("horaSalida"), 
					rs.getString("modoPago"), rs.getBoolean("pagado"), rs.getInt("precio")));
		}
		
		// TODO cuota y entrada_cuota
		
		s = c.createStatement();
		rs = s.executeQuery("Select * From ACTIVIDAD");
		while(rs.next())
		{
			actividades.add(new Actividad2(rs.getInt("actividadID"), rs.getTimestamp("fechaComienzo"), rs.getTimestamp("fechaFinal")));
		}
		
	}
	
}
