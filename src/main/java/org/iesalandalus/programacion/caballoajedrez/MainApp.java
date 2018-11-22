package org.iesalandalus.programacion.caballoajedrez;

import java.util.InputMismatchException;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
	static Caballo caballo = null;
	static boolean salir = false;
	
	public static void main(String[] args) {
		System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez");
		// Llamámos a los métodos principales del menú para que se ejecute la aplicación

		while (!salir) {
			mostrarMenu();
			int opcion = elegirOpcion();// Se guarda la variable opción
			ejecutarOpcion(opcion);
		}

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

		switch (opcion) {
		case 1:
			System.out.println("Ha seleccionado la opcion 1");
			crearCaballoDefecto();
			break;
		case 2:
			System.out.println("Ha seleccionado la opcion 2");
			crearCaballoDefectoColor();
			break;
		case 3:
			System.out.println("Ha seleccionado la opcion 3");
			crearCaballoColorPosicion();
			break;
		case 4:
			System.out.println("Ha seleccionado la opcion 4");
			mover();
			break;
		case 5:
			salir = true;
			break;
		default:
			System.out.println("Solo se admiten números entre 1 y 5");
		}

	}
	
	//Método para crear el Caballo por defecto
	private static void crearCaballoDefecto() {
		try {
			caballo = new Caballo();
			System.out.println(caballo.toString());
		}catch (IllegalArgumentException iae) {
			System.out.println("Error al crear el caballo");
		}
		
	}
	
	//Método para crear el Caballo con Color
	private static void crearCaballoDefectoColor() {
		try {
			Color color = elegirColor(); //le asigno a la variable el resultado del método
			caballo = new Caballo(color);
			System.out.println(caballo.toString());
		}catch (IllegalArgumentException iae) {
			System.out.println("Error al crear el caballo con color, vuelva a intentarlo");
		}
	}
	
	//Método para elegir color 
	private static Color elegirColor() {
		Color color = null;
		boolean colorCorrecto = false;

		while (!colorCorrecto) {
			System.out.println("Escoja el color que desee para el caballo: ");
			System.out.println("MENÚ: ");
			System.out.println("1.Blanco");
			System.out.println("2.-Negro");
			System.out.println(" ");

			System.out.println("Elige un color");
			int opcion = Entrada.entero();

			switch (opcion) {

			case 1:
				color = Color.BLANCO;
				colorCorrecto = true;
				break;

			case 2:
				color = Color.NEGRO;
				colorCorrecto = true;
				break;
			default:
				System.out.println("Error opción incorrecta");
			}

		}
		return color;
	}
	
	//Método para crear un Caballo con Color y posición
	private static void crearCaballoColorPosicion() {
		try {
			Color color = elegirColor();
			char columnaInicial = elegirColumnaInicial();
			caballo = new Caballo(color, columnaInicial);
			System.out.println(caballo.toString());
		} catch (IllegalArgumentException iae) {
			System.out.println("Dato incorrecto");
		}

	}
	
	// Método para escoger la columna inicial del tablero
	private static char elegirColumnaInicial() {
		char columnaInicial = 'a';
		boolean columnaCorrecta = false;

		while (!columnaCorrecta) {
			System.out.println("Escoja la columna inicial que desee b o g : ");
			columnaInicial = Entrada.caracter();
			switch (columnaInicial) {
			case 'b':
				columnaCorrecta = true;
				break;
			case 'g':
				columnaCorrecta = true;
				break;
			default:
				System.out.println("Error opción incorrecta");
			}

		}
		return columnaInicial;
	}
	
	private static void mover() {
		boolean direccionCorrecta = false;
		if (caballo == null) {
			System.out.println("Tiene que crear un caballo primero");
		} else {
			while (direccionCorrecta == false) {
				mostrarMenuDirecciones();
				// Creo una variable de tipo Dirección y le asigno elegirDireccion para después
				// pasarle como parámetro a mover dirección
				Direccion direccion = elegirDireccion();
				try {
					caballo.mover(direccion);
					System.out.println(caballo.getPosicion()); // estado del caballo
					direccionCorrecta = true;
				} catch (OperationNotSupportedException e) {
					System.out.println("Posicón no válida, introduzca nueva posición por favor ");
				} catch (IllegalArgumentException iae) {
					System.out.println("La opción no es correcta");
				}
			}
		}

	}
	
	private static void mostrarMenuDirecciones() {
		
		System.out.println("Escoja una dirección para mover el caballo: ");
		System.out.println("MENÚ Direcciones: ");
		System.out.println("1.ARRIBA_IZQUIERDA");
		System.out.println("2.ARRIBA_DERECHA");
		System.out.println("3.DERECHA_ARRIBA");
		System.out.println("4.DERECHA_ABAJO");
		System.out.println("5.ABAJO_DERECHA");
		System.out.println("6.ABAJO_IZQUIERDA");
		System.out.println("7.IZQUIERDA_ARRIBA");
		System.out.println("8.IZQUIERDA_ABAJO");
		System.out.println(" ");
	}
	
	
	//Método para elegir la dirección mediante un menú 
	private static Direccion elegirDireccion() {
		Direccion direccion = null;
		
			System.out.println("Elige una opción para la dirección: ");
			int opcion = Entrada.entero();
			switch(opcion) {
			
			case 1:			
				direccion = Direccion.ARRIBA_IZQUIERDA;
				break;
			case 2:
				direccion = Direccion.ARRIBA_DERECHA;
				break;
			case 3:
				direccion = Direccion.DERECHA_ARRIBA;
				break;
			case 4:
				direccion = Direccion.DERECHA_ABAJO;
				break;
			case 5:
				direccion = Direccion.ABAJO_DERECHA;
				break;
			case 6:
				direccion = Direccion.ABAJO_IZQUIERDA;
				break;
			case 7:
				direccion = Direccion.IZQUIERDA_ARRIBA;
				break;
			case 8:
				direccion = Direccion.IZQUIERDA_ABAJO;
				break;
			default:
				System.out.println("Error opción incorrecta");
			}	
			
		return direccion; 
	}
	
	
	
	
	
	
	
}