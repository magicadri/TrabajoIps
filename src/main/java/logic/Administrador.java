package logic;

import java.util.Date;

public class Administrador {
	
	private String id; // ID de administrador
	
	public Administrador(String id){
		this.id = id;
	}
	
	/**
	 * Comprueba si la instalacion está ocupada en esa franja horaria
	 * @param ins, Intalacion a mirar
	 * @param horaC, hora de comiezo
	 * @param horaF, hora final
	 * @return true si está ocupada, false si no
	 */
	public boolean instalacionOcupada(Instalacion ins, Date horaC, Date horaF){
		
		return !ins.comprobarDisponibilidad(horaC, horaF);
		
	}
}
