package logic;

import java.util.Date;

public class Reserva {
	
	// Hora de comienzo
	private Date horaComienzo;
	// Hora de final
	private Date horaFinal;
	// Administrador
	private boolean admin;
	// Socio
	private String socio;
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
	public Reserva(Date horaComienzo, Date horaFinal, boolean admin, String socio, float precio,
			Instalacion instalacion) {

		this.horaComienzo = horaComienzo;
		this.horaFinal = horaFinal;
		this.admin = admin;
		this.socio = socio;
		this.precio = precio;
		this.instalacion = instalacion;

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
}
