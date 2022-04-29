package ar.edu.uno.robot;

import java.util.LinkedList;

import ar.edu.uno.excepciones.DatoNoValidoException;
import ar.edu.uno.excepciones.DatosInsuficientesException;
import ar.edu.uno.util.ManejadorArchivos;

public class JuegoApp {

	private Robot robot;
	private Cuadricula cuadricula;
	private LinkedList<Instruccion> instrucciones;
	private String salidaArchivo;

	public JuegoApp(ManejadorArchivos ma) {
		// Se lee el archivo de input
		try {
			String[] datosIn = ma.leerArchivo();
			parsearInicialización(datosIn[0]);
			parsearIntrucciones(datosIn[1]);

			
			// Se procesan las instrucciones de mover al robot
			ejecutarInstrucciones();
			// Se genera la salida con la posicion del robot

		} catch (Exception e) {
			System.err.println(e.getMessage());
			salidaArchivo = e.getMessage();
		} finally {
			ma.escribirArchivo(salidaArchivo);
		}

	}

	private void parsearInicialización(String inicializacionStr) {
		String[] datosInicializacion = inicializacionStr.split(" ");
		try {
			int x = Integer.parseInt(datosInicializacion[0]);
			int y = Integer.parseInt(datosInicializacion[1]);
			String s = datosInicializacion[2];
			int n = Integer.parseInt(datosInicializacion[3]);
			int m = Integer.parseInt(datosInicializacion[4]);
			this.robot = new Robot(x, y, s);
			this.cuadricula = new Cuadricula(n, m);
		} catch (NumberFormatException e) {
			throw new DatoNoValidoException();
		} catch (IndexOutOfBoundsException e) {
			throw new DatosInsuficientesException();
		}
	}

	private void parsearIntrucciones(String instruccionesStr) {
		this.instrucciones = new LinkedList<Instruccion>();
		// el .in puede no tener excepciones
		if (instruccionesStr != null) {
			if (instruccionesStr.length() > 250) {
				throw new RuntimeException("Demasiadas Instrucciones! (Máx 250 characteres)");
			}

			for (int i = 0; i < instruccionesStr.length(); i = i + 2) {
				char comando = instruccionesStr.charAt(i);
				char numero = instruccionesStr.charAt(i + 1);
				if (Character.isAlphabetic(comando) && Character.isDigit(numero)) {
					instrucciones.add(new Instruccion(comando, Integer.parseInt(Character.toString(numero))));
				} else {
					throw new DatoNoValidoException();
				}
			}

		}

	}

	public void ejecutarInstrucciones() {
		System.out.println("Inicio = "+ obtenerPosicionActualRobot());
		
		for (Instruccion instruccion : this.instrucciones) {
			System.out.println(instruccion);
			switch (instruccion.getTipoComando()) {
			case 'R':
				System.out.println("Mirando al " + robot.getDireccion().getNombre());
				this.robot.rotar(instruccion.getNumero());
				System.out.println("Giro al " + robot.getDireccion().getNombre());
				break;
			case 'A':
				robot.avanzar(instruccion.getNumero(), this.cuadricula);
				System.out.println(obtenerPosicionActualRobot());
				break;
			default:
				throw new RuntimeException(
						"Instrucción no Válida! " + instruccion.getTipoComando() + " no es un comando válido.");
			}
		}
		System.out.println("Fin = "+ obtenerPosicionActualRobot());		
		salidaArchivo = obtenerPosicionActualRobot();
	}

	public String obtenerPosicionActualRobot() {
		return this.robot.getPosicionEnX() + " " + this.robot.getPosicionEnY();
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ManejadorArchivos manejador;
		JuegoApp juegoApp;
		/*
		 * 
		 * // Se crea una instancia de la clase encargada de los archivos ma = new
		 * ManejadorArchivos("robot.in", "robot.out"); // Se crea la instancia del juego
		 * segun los datos de entrada juegoApp = new JuegoApp(ma);
		 */

		// Se crea una instancia de la clase encargada de los archivos
		manejador = new ManejadorArchivos("in/caso_01_entrada_varios_comandos.in", "out/caso_01.out");
		// Se crea la instancia del juego segun los datos de entrada
		juegoApp = new JuegoApp(manejador);

	}
}
