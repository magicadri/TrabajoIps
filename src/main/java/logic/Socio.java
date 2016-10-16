package logic;

import java.util.ArrayList;
import java.util.List;

public class Socio {

	private String socioID;
	private float cuota = 0;
	private List<Recibo> recibos = new ArrayList<Recibo>();

	public Socio(String socioID) {
		this.socioID = socioID;
	}

	public String getSocioID() {
		return socioID;
	}

	public List<Recibo> getRecibos() {
		return recibos;
	}

	public void setSocioID(String socioID) {
		this.socioID = socioID;
	}

	public float getCuota() {
		if(recibos.size()>0)
			for (Recibo each : recibos) {
				cuota += each.getPrecio();
			}
		return cuota > 0 ? cuota : 0;
	}

	public void setCuota(float cuota) {
		this.cuota = cuota;
	}
	
}
