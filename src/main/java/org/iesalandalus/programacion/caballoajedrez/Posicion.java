package org.iesalandalus.programacion.caballoajedrez;

public class Posicion {
	private int fila; //Van del 1-8 inclusive
	private char columna; //Van de la 'a' a la 'h' inclusive ambos
	

	//Constructor parametrizado de la clase 
	public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);
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
	
	
	
}
