package ar.edu.uno.app;

import ar.edu.uno.util.ManejadorArchivos;

public class App {

	public static void main(String[] args) {
		
		ManejadorArchivos ma = new ManejadorArchivos("archivoEntrada.in", "archivoSalida.out");

		System.out.println(ma.leerArchivo());
		
		ma.escribirArchivo(new String[] {"Salida","Adiós!"});
		
	}
}
