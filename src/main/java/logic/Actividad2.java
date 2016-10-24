package logic;

import java.sql.Timestamp;

public class Actividad2 {
	
	private Timestamp fechaComienzo;
	private Timestamp fechaFinal;
	private int actividadID;
	
	public Actividad2(int actividadID, Timestamp fechaComienzo, Timestamp fechaFinal)
	{
		this.actividadID=actividadID;
		this.fechaComienzo=fechaComienzo;
		this.fechaFinal=fechaFinal;
	}

	public Timestamp getFechaComienzo() {
		return fechaComienzo;
	}

	public Timestamp getFechaFinal() {
		return fechaFinal;
	}

	public int getActividadID() {
		return actividadID;
	}

}
