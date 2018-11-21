package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
	public static void main(String[] args) {
		System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez");
		
		/*Caballo caballo = new Caballo(Color.BLANCO);
		try {
			caballo.mover(Direccion.ARRIBA_IZQUIERDA);
			System.out.println(caballo.getPosicion());
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		
	}
	
	
	// Método mostrar menú
	private static void mostrarMenu() {
		System.out.println("MENÚ: ");
		System.out.println("1: Crear Caballo por defecto");
		System.out.println("2. Crear Caballo de un color");
		System.out.println("3. Crear Caballo de un color en una columna inicial válida");
		System.out.println("4. Mover Caballo");
		System.out.println("5. Salir");

	}

	private static int elegirOpcion() {
		int opcion;
		System.out.println("Indique cuál de las opciones desea pulsar");
		opcion = Entrada.entero();
		return opcion;
	}
	
	private static void ejecutarOpcion(int opcion) {
		boolean salir = false;
		while (!salir) {
			mostrarMenu(); //Llamo al método mostrar menú para que nos muestre las opciones
			elegirOpcion(); //Llamo al método elegir opción 
			switch (opcion) {
			case 1:
				System.out.println("Ha seleccionado la opcion 1");
				break;
			case 2:
				System.out.println("Ha seleccionado la opcion 2");
				break;
			case 3:
				System.out.println("Ha seleccionado la opcion 3");
				break;
			case 4:
				System.out.println("Ha seleccionado la opcion 4");
				break;
			case 5:
				salir = true;
				break;
			default:
				System.out.println("Solo se admiten números entre 1 y 5");
			}
		}
	}
	
	//Método para crear el Caballo por defecto
	private static void crearCaballoDefecto() {
		Caballo caballo = new Caballo();
	}
	
	//Método para crear el Caballo con Color
	private static void crearCaballoDefectoColor() {
		Caballo caballoColor = new Caballo(Color.BLANCO);
	}
	
	//Método para elegir color 
	/*private static Color elegirColor() {
		Color color;
		System.out.println("Introduzca el color que desee para el caballo: ");
		//color = Entrada.
	} */
	
	//Método para crear un Caballo con Color y posición
	private static void crearCaballoColorPosicion() {
		
	}
	
	//Método para escoger la columna inicial del tablero
	private static char elegirColumnaInicial() {
		char columnaInicial;
		System.out.println("Introduzca la columna inicial: ");
		columnaInicial = Entrada.caracter();
		return columnaInicial;
	}
	
	private static void mover() {
		Direccion direccion; 
		System.out.println("Introduzca una dirección para mover el caballo: ");
		//direccion = Entrada
		
	}
	
	
	
	
	
	
	
}