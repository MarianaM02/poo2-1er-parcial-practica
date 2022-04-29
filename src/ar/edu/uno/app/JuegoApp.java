package ar.edu.uno.app;

import java.util.LinkedList;

import ar.edu.uno.util.ManejadorArchivos;

public class JuegoApp {

	private Robot robot;
	private Cuadricula cuadricula;
	private LinkedList<Instruccion> instrucciones;

	public JuegoApp(String inicializacionStr, String instruccionesStr) {
		String[] datosInit = parsearInicialización(inicializacionStr);

		this.robot = new Robot(Integer.parseInt(datosInit[0]), Integer.parseInt(datosInit[1]), datosInit[2]);
		this.cuadricula = new Cuadricula(Integer.parseInt(datosInit[3]), Integer.parseInt(datosInit[4]));
		this.instrucciones = parsearIntrucciones(instruccionesStr);
	}

	private String[] parsearInicialización(String inicializacionStr) {
		return inicializacionStr.split(" ");
	}

	private LinkedList<Instruccion> parsearIntrucciones(String instruccionesStr) {
		if (instruccionesStr.length() > 250) {
			throw new RuntimeException("Demasiadas Instrucciones! (Máx 250 characteres)");
		}
		LinkedList<Instruccion> instrucciones = new LinkedList<Instruccion>();

		// TODO Error de parseo de instrucciones
		for (int i = 0; i < instruccionesStr.length(); i=i+2) {
			instrucciones.add(new Instruccion(
					instruccionesStr.charAt(i),
					Integer.parseInt(Character.toString(instruccionesStr.charAt(i+1)))));
		}
		return instrucciones;
	}

	public void ejecutarInstrucciones() {
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
	}
	
	public String obtenerPosicionActualRobot() {
		return this.robot.getPosicionEnX() + " " +this.robot.getPosicionEnY(); 
	}

	public static void main(String[] args) {

		// Se crea una instancia de la clase que se encarga de la lectura y escritura de archivos
		ManejadorArchivos ma = new ManejadorArchivos("archivoEntrada.in", "archivoSalida.out");
		// Se lee el archivo de input
		String[] datosIn = ma.leerArchivo();
		// Se crea la instancia del juego segun los datos de entrada
		JuegoApp juegoApp = new JuegoApp(datosIn[0], datosIn[1]);
		// Se procesan las instrucciones de mover al robot
		juegoApp.ejecutarInstrucciones();
		// Se genera la salida con la posicion del robot
		ma.escribirArchivo(juegoApp.obtenerPosicionActualRobot());

	}
}
