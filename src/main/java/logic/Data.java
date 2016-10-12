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

		piscina.añadirReserva(pisc1);
		piscina.añadirReserva(pisc2);
		piscina.añadirReserva(pisc3);
		piscina.añadirReserva(pisc4);
		
		
		Reserva tenis1 = new Reserva(11, new Date(2016, 10, 11, 20, 0), new Date(2016, 10, 11, 21, 0), socio1, 15, canchatenis);
		Reserva tenis2 = new Reserva(13, new Date(2016, 10, 13, 20, 0), new Date(2016, 10, 13, 21, 0), socio1, 15, canchatenis);
		Reserva tenis3 = new Reserva(13, new Date(2016, 10, 13, 23, 0), new Date(2016, 10, 13, 24, 0), pepe, 15, canchatenis);
		Reserva tenis4 = new Reserva(15, new Date(2016, 10, 15, 13, 0), new Date(2016, 10, 15, 14, 0), pepe, 15, canchatenis);

		canchatenis.añadirReserva(tenis1);
		canchatenis.añadirReserva(tenis2);
		canchatenis.añadirReserva(tenis3);
		canchatenis.añadirReserva(tenis4);
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
	

