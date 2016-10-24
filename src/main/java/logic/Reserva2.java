package logic;

import java.sql.Timestamp;
import java.util.Date;

public class Reserva2 {

	private String socioID;
	private int instalacionID;
	private Timestamp horaComienzo;
	private Timestamp horaFinal;
	private Timestamp horaEntrada;
	private Timestamp horaSalida;
	private String modoPago;
	private int precio;
	private int reservaID;

	public Reserva2(int reservaID, String socioID, int instalacionID, Timestamp horaComienzo, Timestamp horaFinal,
			Timestamp horaEntrada, Timestamp horaSalida, String modoPago, int precio) {
		this.reservaID=reservaID;
		this.socioID=socioID;
		this.instalacionID=instalacionID;
		this.horaComienzo=horaComienzo;
		this.horaFinal=horaFinal;
		this.horaEntrada=horaEntrada;
		this.horaSalida=horaSalida;
		this.modoPago=modoPago;
		this.precio=precio;

	}

	public int getReservaID() {
		return reservaID;
	}

	public String getSocioID() {
		return socioID;
	}

	public int getInstalacionID() {
		return instalacionID;
	}

	public Timestamp getHoraComienzo() {
		return horaComienzo;
	}

	public Timestamp getHoraFinal() {
		return horaFinal;
	}

	public Timestamp getHoraEntrada() {
		return horaEntrada;
	}

	public Timestamp getHoraSalida() {
		return horaSalida;
	}

	public String getModoPago() {
		return modoPago;
	}

	public int getPrecio() {
		return precio;
	}

}
