package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Data {
	// ID = piscina
	Instalacion piscina = new Instalacion("piscina");

	// ID = canchatenis
	Instalacion canchatenis = new Instalacion("canchatenis");

	// ID = canchafutbol
	Instalacion canchafutbol = new Instalacion("canchafutbol");

	Socio socio1 = new Socio("admin");
	Socio pepe = new Socio("pepe");
	
	List<Reserva> reservas = new ArrayList<Reserva>();

	public void meterDatos() {
		Reserva pisc1 = new Reserva(11, new Date(2016, 10, 11, 16, 0), new Date(2016, 10, 11, 17, 0), socio1, 15, piscina);
		Reserva pisc2 = new Reserva(13, new Date(2016, 10, 13, 18, 0), new Date(2016, 10, 13, 19, 0), socio1, 15, piscina);
		Reserva pisc3 = new Reserva(13, new Date(2016, 10, 13, 21, 0), new Date(2016, 10, 13, 22, 0), pepe, 15, piscina);
		Reserva pisc4 = new Reserva(15, new Date(2016, 10, 15, 9, 0), new Date(2016, 10, 15, 10, 0), pepe, 15, piscina);
		Reserva pisc5 = new Reserva(11, new Date(2016, 10, 19, 16, 0), new Date(2016, 10, 19, 17, 0), socio1, 15, piscina);
		
		piscina.addReserva(pisc1);
		piscina.addReserva(pisc2);
		piscina.addReserva(pisc3);
		piscina.addReserva(pisc4);
		piscina.addReserva(pisc5);
		

		Reserva tenis1 = new Reserva(11, new Date(2016, 10, 11, 20, 0), new Date(2016, 10, 11, 21, 0), socio1, 15, canchatenis);
		Reserva tenis2 = new Reserva(13, new Date(2016, 10, 13, 20, 0), new Date(2016, 10, 13, 21, 0), socio1, 15, canchatenis);
		Reserva tenis3 = new Reserva(13, new Date(2016, 10, 13, 23, 0), new Date(2016, 10, 13, 24, 0), pepe, 15, canchatenis);
		Reserva tenis4 = new Reserva(15, new Date(2016, 10, 15, 13, 0), new Date(2016, 10, 15, 14, 0), pepe, 15, canchatenis);

		canchatenis.addReserva(tenis1);
		canchatenis.addReserva(tenis2);
		canchatenis.addReserva(tenis3);
		canchatenis.addReserva(tenis4);
		
		Reserva futbol1 = new Reserva(11, new Date(2016, 10, 12, 10, 0), new Date(2016, 10, 13, 11, 0), socio1, 15, canchafutbol);
		Reserva futbol2 = new Reserva(13, new Date(2016, 10, 13, 13, 0), new Date(2016, 10, 13, 14, 0), socio1, 15, canchafutbol);
		Reserva futbol3 = new Reserva(13, new Date(2016, 10, 13, 16, 0), new Date(2016, 10, 13, 17, 0), pepe, 15, canchafutbol);
		Reserva futbol4 = new Reserva(15, new Date(2016, 10, 15, 2, 0), new Date(2016, 10, 15, 3, 0), pepe, 15, canchafutbol);
		
		canchafutbol.addReserva(futbol1);
		canchafutbol.addReserva(futbol2);
		canchafutbol.addReserva(futbol3);
		canchafutbol.addReserva(futbol4);
		
		reservas.addAll(piscina.getReservas());
		reservas.addAll(canchatenis.getReservas());
		reservas.addAll(canchafutbol.getReservas());
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public Instalacion getPiscina() {
		return piscina;
	}

	public Instalacion getTenis() {
		return canchatenis;
	}

	public Instalacion getFutbol() {
		return canchafutbol;
	}

	public Socio getSocio1() {
		return socio1;
	}

	public Socio getPepe() {
		return pepe;
	}

}
