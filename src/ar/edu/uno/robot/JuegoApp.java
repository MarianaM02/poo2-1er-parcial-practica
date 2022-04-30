package ar.edu.uno.robot;

import java.util.LinkedList;

import ar.edu.uno.excepciones.DatoNoValidoException;
import ar.edu.uno.excepciones.DatosInsuficientesException;

/**
 * Esta clase se encarga de ejecutar toda la lógica del problema al instanciarse
 *
 */
public class JuegoApp {
	private Robot robot;
	private Cuadricula cuadricula;
	private LinkedList<Instruccion> instrucciones;
	private String salidaArchivo;

	/**
	 * Constructor de JuegoApp. Inicializa atributos y ejecuta las instrucciones con
	 * el input obtenido por parametro y luego genera la salida.
	 * 
	 * @param manejador de archivos que controla la entrada y salida
	 */
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

	/**
	 * Inicializa los atributos robot y cuadricula a partir del parseo de un String
	 * pasado por parametro
	 * 
	 * @param inicializacionStr String con los datos de inicializacion
	 */
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

	/**
	 * Inicializa el atributo instrucciones a partir del parseo de un String pasado
	 * por parametro
	 * 
	 * @param instruccionesStr String con los datos de las instrucciones
	 */
	private void parsearIntrucciones(String instruccionesStr) {
		int maxInstrucciones = 250;
		this.instrucciones = new LinkedList<Instruccion>();
		// el .in puede no tener instrucciones
		if (instruccionesStr != null) {
			if (instruccionesStr.length() > maxInstrucciones) {
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

	/**
	 * Se encarga de dar la intrucciones al robot segun el comando correspondiente
	 */
	private void ejecutarInstrucciones() {
		for (Instruccion instruccion : this.instrucciones) {

			switch (instruccion.getTipoComando()) {
			case 'R':
				this.robot.rotar(instruccion.getNumero());
				break;
			case 'A':
				robot.avanzar(instruccion.getNumero(), this.cuadricula);
				break;
			default:
				throw new RuntimeException(
						"Instrucción no Válida! " + instruccion.getTipoComando() + " no es un comando válido.");
			}
		}
		salidaArchivo = obtenerPosicionActualRobot();
	}

	/**
	 * Devuelve la posicion del robot como un String de formato "x y"
	 * 
	 * @return String con posicion x y del robot
	 */
	private String obtenerPosicionActualRobot() {
		return this.robot.getPosicionEnX() + " " + this.robot.getPosicionEnY();
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ManejadorArchivos manejador;
		JuegoApp juegoApp;

		// Se crea una instancia de la clase encargada de los archivos
		manejador = new ManejadorArchivos("ROBOT.IN", "ROBOT.OUT");
		// Se crea la instancia del juego segun los datos de entrada
		juegoApp = new JuegoApp(manejador);
	}

}
