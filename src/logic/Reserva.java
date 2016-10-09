package logic;

import java.util.Date;

public class Reserva {
	
	String reservaID;
	Date horaComienzo;
	Date horaFinal;
	boolean admin=false;
	Socio socio;
	float precio;
	Instalacion instalacion;
	
	public Reserva(String reservaID, Date horaComienzo, Date horaFinal, Socio socio, float precio, Instalacion instalacion)
	{
		
		this.horaComienzo= horaComienzo;
		this.horaFinal= horaFinal;
		if(socio.getSocioID() == "admin")
			this.admin=true;
		this.socio= socio;
		this.precio= precio;
		this.instalacion= instalacion;
	}
}
