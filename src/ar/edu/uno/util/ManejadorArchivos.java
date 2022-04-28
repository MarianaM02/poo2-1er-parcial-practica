package ar.edu.uno.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ManejadorArchivos {
	private final String ruta = "./archivos/";
	private String archivoIn;
	private String archivoOut;

	public ManejadorArchivos(String archivoIn, String archivoOut) {
		super();
		this.archivoIn = archivoIn;
		this.archivoOut = archivoOut;
	}

	public String leerArchivo() {
		Scanner sc;
		String linea = "";
		
		try {
			sc = new Scanner(new File(ruta + archivoIn));

			while (sc.hasNext()) {
				linea += sc.nextLine() + "\n";
			}

			sc.close();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		return linea;

	}

	public void escribirArchivo(String[] data) {
		FileWriter archivo;
		PrintWriter salida;
		try {
			archivo = new FileWriter(ruta + archivoOut);
			salida = new PrintWriter(archivo);

			for (String s : data) {
				salida.println(s);
			}
			
			salida.close();
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
