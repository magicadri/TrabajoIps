package logic;

import java.util.Date;

public class Reserva {
	//Hora comienzo, hora fin, fecha, quien hace la reserva (centro o socio), que socio, precio
	
	Date horaComienzo;
	Date horaFinal;
	boolean admin;
	String socio;
	float precio;
	Instalacion instalacion;
	
	public Reserva(Date horaComienzo, Date horaFinal, boolean admin, String socio, float precio, Instalacion instalacion)
	{
		
		this.horaComienzo= horaComienzo;
		this.horaFinal= horaFinal;
		this.admin= admin;
		this.socio= socio;
		this.precio= precio;
		this.instalacion= instalacion;
		
	}
}
