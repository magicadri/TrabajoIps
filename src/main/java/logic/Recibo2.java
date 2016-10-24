package logic;

public class Recibo2 {
	
	private int reciboID;
	private String socioID;
	private int reservaID;
	private int instalacionID;
	private int importe;
	
	
	public int getReciboID() {
		return reciboID;
	}


	public String getSocioID() {
		return socioID;
	}


	public int getReservaID() {
		return reservaID;
	}


	public int getInstalacionID() {
		return instalacionID;
	}
	
	public int getImporte()
	{
		return importe;
	}


	public Recibo2(int reciboID, String socioID, int reservaID, int instalacionID, int importe)
	{
		this.reciboID=reciboID;
		this.socioID=socioID;
		this.reservaID=reservaID;
		this.instalacionID=instalacionID;
		this.importe=importe;
	}

}
