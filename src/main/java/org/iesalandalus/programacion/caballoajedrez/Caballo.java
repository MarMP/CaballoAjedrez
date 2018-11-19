package org.iesalandalus.programacion.caballoajedrez;

public class Caballo {

	private Color color;
	private Posicion posicion;
	
	
	//Setter y getter de la clase 
	public Color getColor() {
		return color;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	private void setColor(Color color) {
		this.color = color;
	}
	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	//Constructor por defecto 
	public Caballo() {
		this.color = Color.NEGRO;
		this.posicion = new Posicion(8, 'b');
	}
	
	
	
	
	
}
