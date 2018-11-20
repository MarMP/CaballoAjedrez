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
	
	//Constructor con un parámetro Color 
	public Caballo (Color color) {
		if (color == null ) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}
		
		if (color.equals(Color.BLANCO)) {
			this.posicion = new Posicion(1, 'b');
			this.color = color;
		}
		
		if (color.equals(Color.NEGRO)) {
			this.posicion = new Posicion(8, 'b');
			this.color = color;
		}
			
		
	}
	
	//Constructor con los parámetros color y posición 
	//Controlo las dos excepciones que lanza: si el color es nulo y si la columna no es válida 
	
	public Caballo(Color color, char columnaInicial) {
		
		if (color==null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}
		
		if (columnaInicial =='b' || columnaInicial == 'g') {
			if (color.equals(Color.BLANCO)) {
				this.posicion = new Posicion(1, columnaInicial);
				this.color = color;
			}
			if (color.equals(Color.NEGRO)) {
				this.posicion = new Posicion(8, columnaInicial);
				this.color = color;
			}
		}else {
			throw new IllegalArgumentException("ERROR: Columna inicial no válida.");
			
		}
		
		
	}
	
	
	
}
