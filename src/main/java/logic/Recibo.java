package logic;

public class Recibo {
	
	private float precio;
	private Socio socio;
	private Instalacion inst;
	
	public Recibo(float precio, Socio socio, Instalacion inst)
	{
		this.precio=precio;
		this.socio=socio;
		this.inst=inst;
	}

	public double getPrecio() {
		return precio;
	}

	public Socio getSocio() {
		return socio;
	}

	public Instalacion getInst() {
		return inst;
	}

}
