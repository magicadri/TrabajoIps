package logic;

import java.util.ArrayList;
import java.util.Date;

public class Instalacion {

	// ID de la instalacion
	private String id;

	// Lista de reservas para la instalacion
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

	/**
	 * Constructor de la clase Instalacion
	 * 
	 * @param id,
	 *            ID de la instalacion
	 */
	public Instalacion(String id) {
		this.id = id;
	}

	/**
	 * Getter para el ID de la instalacion
	 * 
	 * @return String con el id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Añade una reserva a la lista de reservas
	 * 
	 * @param res,
	 *            reserva a ser añadida
	 */
	public void añadirReserva(Reserva res) {
		reservas.add(res);
	}

	/**
	 * Comprueba si está ocupada en una franja horaria
	 * 
	 * @param horaC,
	 *            hora de comienzo
	 * @param horaF,
	 *            hora final
	 * @return true si está disponible, false si no
	 */
	public boolean comprobarDisponibilidad(Date horaC, Date horaF) {
		boolean resultado = true;

		for (Reserva reserva : reservas) {
			if (reserva.getHoraComienzo().equals(horaC) && reserva.getHoraFinal().equals(horaF)) {
				resultado = false;
			}
		}

		return resultado;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

}
