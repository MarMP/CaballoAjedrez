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
	/*Crea un constructor para la clase que acepte como parámetros el color y la columna inicial. 
	 * La columna inicial debe ser la 'b' o la 'g' (de lo contrario debe lanzar la excepción IllegalArgumentException
	 *  con un mensaje adecuado) y creara un caballo del color dado y colocado en dicha columna y 
	 *  cuya fila será la 1 si el blanco y la 8 si es el negro.
	 */
	public Caballo(Color color, char columnaInicial) {
		if (columnaInicial!='b' || columnaInicial != 'g') {
			throw new IllegalArgumentException("ERROR: Columna inicial no válida.");
		}
		
	}
	
	
	
}
