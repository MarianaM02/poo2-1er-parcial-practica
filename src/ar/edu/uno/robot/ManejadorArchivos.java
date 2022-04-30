package ar.edu.uno.robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ar.edu.uno.excepciones.DatosInsuficientesException;

/**
 * Clase encargada del manejo de lectura y escritura de archivos 
 */
public class ManejadorArchivos {
	private final String ruta = "./archivos/";
	private String archivoIn;
	private String archivoOut;

	public ManejadorArchivos(String archivoIn, String archivoOut) {
		super();
		this.archivoIn = archivoIn;
		this.archivoOut = archivoOut;
	}

	public String[] leerArchivo(){
		Scanner sc;
		int cantLineas = 2;
		String[] array = new String[cantLineas];
		try {
			sc = new Scanner(new File(ruta + archivoIn));

			array[0] = sc.nextLine();
			if (sc.hasNext()) {
				array[1] = sc.nextLine();
			}
			sc.close();

		} catch (IndexOutOfBoundsException e) {
			throw new DatosInsuficientesException();
		} catch (FileNotFoundException e) {
			throw new DatosInsuficientesException();
		} catch (NoSuchElementException e) {
			throw new DatosInsuficientesException();
		}

		return array;

	}

	public void escribirArchivo(String salidaStr) {
		FileWriter archivo;
		PrintWriter salida;
		try {
			archivo = new FileWriter(ruta + archivoOut);
			salida = new PrintWriter(archivo);

			salida.println(salidaStr);

			salida.close();

		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
