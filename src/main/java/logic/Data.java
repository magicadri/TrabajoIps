package logic;

import java.util.Date;

public class Data {
	Instalacion piscina = new Instalacion("pisc");
	Instalacion canchatenis = new Instalacion("ct");
	Instalacion canchafutbol = new Instalacion("cf");
	
	Socio socio1 = new Socio("admin");
	Socio pepe = new Socio("pepe");
	
	public void meterDatos(){		
		Reserva pisc1 = new Reserva(11, new Date(2016, 10, 11, 16, 0), new Date(2016, 10, 11, 17, 0), socio1, 15, piscina);
		Reserva pisc2 = new Reserva(13, new Date(2016, 10, 13, 18, 0), new Date(2016, 10, 13, 19, 0), socio1, 15, piscina);
		Reserva pisc3 = new Reserva(13, new Date(2016, 10, 13, 21, 0), new Date(2016, 10, 13, 22, 0), pepe, 15, piscina);
		Reserva pisc4 = new Reserva(15, new Date(2016, 10, 15, 9, 0), new Date(2016, 10, 15, 10, 0), pepe, 15, piscina);

		piscina.a�adirReserva(pisc1);
		piscina.a�adirReserva(pisc2);
		piscina.a�adirReserva(pisc3);
		piscina.a�adirReserva(pisc4);
		
		
		Reserva tenis1 = new Reserva(11, new Date(2016, 10, 11, 20, 0), new Date(2016, 10, 11, 21, 0), socio1, 15, canchatenis);
		Reserva tenis2 = new Reserva(13, new Date(2016, 10, 13, 20, 0), new Date(2016, 10, 13, 21, 0), socio1, 15, canchatenis);
		Reserva tenis3 = new Reserva(13, new Date(2016, 10, 13, 23, 0), new Date(2016, 10, 13, 24, 0), pepe, 15, canchatenis);
		Reserva tenis4 = new Reserva(15, new Date(2016, 10, 15, 13, 0), new Date(2016, 10, 15, 14, 0), pepe, 15, canchatenis);

		canchatenis.a�adirReserva(tenis1);
		canchatenis.a�adirReserva(tenis2);
		canchatenis.a�adirReserva(tenis3);
		canchatenis.a�adirReserva(tenis4);
	}
	
	public Instalacion getPiscina(){
		return piscina;
	}
	
	public Instalacion getTenis(){
		return canchatenis;
	}
	
	public Instalacion getFutbol(){
		return canchafutbol;
	}
	
	
	}
	

