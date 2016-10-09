package logic;

public class Socio {
	
	private String socioID;
	private float cuota;
	
	public Socio(String socioID, float cuota)
	{
		this.socioID=socioID;
		this.cuota=cuota;
	}

	public String getSocioID() {
		return socioID;
	}

	public void setSocioID(String socioID) {
		this.socioID = socioID;
	}

	public float getCuota() {
		return cuota;
	}

	public void setCuota(float cuota) {
		this.cuota = cuota;
	}
}
