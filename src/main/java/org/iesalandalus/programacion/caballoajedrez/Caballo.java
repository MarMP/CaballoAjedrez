package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

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
	
	//Método mover pieza caballo  
	public void mover(Direccion direccion) throws OperationNotSupportedException{
		if (direccion == null) {
			throw new IllegalArgumentException("ERROR: Movimiento no válido.");
		}
		//Vuelve a la posición inicial en caso de saltar excepción
		//Crea primero una posicionInicial y le asigna un valor predeterminador que se modificará en la siguiente línea
		Posicion posicionInicial = new Posicion(1,'a'); 
		posicionInicial.setColumna(posicion.getColumna());
		posicionInicial.setFila(posicion.getFila()); 
		
		switch (direccion) {
		case ARRIBA_IZQUIERDA:
			try {
				posicion.setFila(posicion.getFila() +2);
				posicion.setColumna((char) (posicion.getColumna()-1));
			} catch (IllegalArgumentException e) {
				posicion = posicionInicial;
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case ARRIBA_DERECHA:
			try {
				posicion.setFila(posicion.getFila() + 2);
				posicion.setColumna((char) (posicion.getColumna() + 1));
			} catch (IllegalArgumentException e) {
				posicion = posicionInicial;
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case DERECHA_ARRIBA:
			try {
				posicion.setFila(posicion.getFila() + 1);
				posicion.setColumna((char) (posicion.getColumna() + 2));
				
			} catch (IllegalArgumentException e) {
				posicion = posicionInicial;
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case DERECHA_ABAJO:
			try {
				posicion.setFila(posicion.getFila() -1);
				posicion.setColumna((char) (posicion.getColumna() +2));
			} catch (IllegalArgumentException e) {
				posicion = posicionInicial;
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case ABAJO_DERECHA:
			try {
				posicion.setFila(posicion.getFila() -2);
				posicion.setColumna((char) (posicion.getColumna() +1));
			} catch (IllegalArgumentException e) {
				posicion = posicionInicial;
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case ABAJO_IZQUIERDA:
			try {
				posicion.setFila(posicion.getFila() -2);
				posicion.setColumna((char) (posicion.getColumna() - 1));
			} catch (IllegalArgumentException e) {
				posicion = posicionInicial;
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case IZQUIERDA_ARRIBA:
			try {
				posicion.setFila(posicion.getFila() +1);
				posicion.setColumna((char) (posicion.getColumna() -2));
				
			} catch (IllegalArgumentException e) {
				posicion = posicionInicial;
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case IZQUIERDA_ABAJO:
			try {
				posicion.setFila(posicion.getFila() - 1);
				posicion.setColumna((char) (posicion.getColumna() - 2));
			
			} catch (IllegalArgumentException e) {
				posicion = posicionInicial;
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		default:
			break;
	}
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caballo other = (Caballo) obj;
		if (color != other.color)
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Caballo [color=" + color + ", posicion=" + posicion + "]";
	}
	
	
	
	
	
}
