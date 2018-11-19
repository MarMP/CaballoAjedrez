package org.iesalandalus.programacion.caballoajedrez;

public class Posicion {
	private int fila; //Van del 1-8 inclusive
	private char columna; //Van de la 'a' a la 'h' inclusive ambos
	

	//Constructor parametrizado de la clase 
	public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}
	
	//Constructor copia 
	public Posicion(Posicion posicion) {
		if (posicion == null) {
			throw new IllegalArgumentException("ERROR: No es posible copiar una posición nula.");
		}
		this.fila = posicion.getFila();
		this.columna = posicion.getColumna();
	}
	
	
	//Getter y setter de la clase posicion
	//Validamos los setter 
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		//Si se sale de la fila que lance una excepci�n 
		if (fila<1 || fila >8) {
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		}
		this.fila = fila;
	}
	public char getColumna() {
		return columna;
	}
	//Si se sale de la columna que lance una excepci�n 
	public void setColumna(char columna) {
		if (columna< 'a' || columna >'h') {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}
		this.columna = columna;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columna;
		result = prime * result + fila;
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
		Posicion other = (Posicion) obj;
		if (columna != other.columna)
			return false;
		if (fila != other.fila)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[fila=" + fila + ", columna=" + columna + "]";
	}
	
	
	
	
}
