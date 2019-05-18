package prLibreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria {
	private static final int CAP_INICIAL = 16;
	private double porcDesc;
	private LibreriaOferta[] listaAutores;
	
	
	public LibreriaOferta(double a, String[] b) {
		 Libreria listaLibros = new Libreria();
		 porcDesc = a;
		 listaAutores = new LibreriaOferta[CAP_INICIAL];
	}
	
	public LibreriaOferta(int a, double b, String[] c) {
		Libreria listaLibros = new Libreria(a);
		porcDesc = b;
		listaAutores = new LibreriaOferta[a]; //tamaño del array que me pasan?
	}
	
	public void setOferta(double a, String[] b) {
		porcDesc = a;
		listaAutores = new LibreriaOferta[CAP_INICIAL]; //CAP INICIAL???
													// TAMAÑO DEL EXISTENTE Y NUEVOS VALORES
	}
	
	public String getOferta() {
		return listaAutores; //como¿???
	}
	
	
	public double getDescuento() {
		return porcDesc;
	}
	
	@Override
	protected void addLibro(String a, String b, double c) {
		if(buscarLibro(a) != -1) {
			LibreriaOferta Libro = new LibroOferta(String a, String b, double c); //MAL??	
		} el
		se { 
			
		}
	}
	
}
