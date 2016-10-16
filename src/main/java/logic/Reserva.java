package logic;

import java.util.Date;

public class Reserva {
	
	// Hora de comienzo
	private Date horaComienzo;
	// Hora de final
	private Date horaFinal;
	// Dia de la reserva
	private int dia;
	// Administrador
	private boolean admin=false;
	// Socio
	private Socio socio;
	// Precio
	float precio;
	// Instalacion que se reserva
	Instalacion instalacion;

	/**
	 * Constructor dela clase Reserva
	 * @param horaComienzo
	 * @param horaFinal
	 * @param admin
	 * @param socio
	 * @param precio
	 * @param instalacion
	 */
	public Reserva(int dia, Date horaComienzo, Date horaFinal, Socio socio, float precio,
			Instalacion instalacion) {

		this.dia = dia;
		this.horaComienzo = horaComienzo;
		this.horaFinal = horaFinal;
		if(socio.getSocioID().equals("admin"))
			this.admin = true;
		this.socio = socio;
		this.precio = precio;
		this.socio.setCuota(socio.getCuota()+precio);
		this.instalacion = instalacion;
		socio.getRecibos().add(new Recibo(precio,socio,instalacion));

	}

	/**
	 * Getter de horaComienzo
	 * 
	 * @return Date
	 */
	public Date getHoraComienzo() {
		return this.horaComienzo;
	}

	/**
	 * Getter de horaFinal
	 * 
	 * @return Date
	 */
	public Date getHoraFinal() {
		return this.horaFinal;
	}
	
	/**
	 * Getter de dia
	 * 
	 * @return integer con el dia
	 */
	public int getDia(){
		return this.dia;
	}
}
