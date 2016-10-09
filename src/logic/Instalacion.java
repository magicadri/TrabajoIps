package logic;

public class Instalacion {
	
	private String instalacionID;
	private boolean ocupado;
	
	public Instalacion(String instalacionID, boolean ocupado)
	{
		this.setInstalacionID(instalacionID);
		this.setOcupado(ocupado);
	}

	public String getInstalacionID() {
		return instalacionID;
	}

	public void setInstalacionID(String instalacionID) {
		this.instalacionID = instalacionID;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
}
