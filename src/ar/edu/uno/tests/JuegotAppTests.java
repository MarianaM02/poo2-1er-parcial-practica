package ar.edu.uno.tests;

import org.junit.Test;

import ar.edu.uno.robot.JuegoApp;
import ar.edu.uno.util.ManejadorArchivos;

public class JuegotAppTests {
	ManejadorArchivos ma;
	JuegoApp juegoApp;

	@Test
	public void caso1Test() {
		// Se crea una instancia de la clase encargada de los archivos
		ma = new ManejadorArchivos("in/caso_01_entrada_varios_comandos.in", "out/caso_01.out");
		// Se crea la instancia del juego segun los datos de entrada
		juegoApp = new JuegoApp(ma);

	}

	@Test
	public void caso2Test() {
		// Se crea una instancia de la clase encargada de los archivos
		ma = new ManejadorArchivos("in/caso_02_entrada_un_comando.in", "out/caso_02.out");
		// Se crea la instancia del juego segun los datos de entrada
		juegoApp = new JuegoApp(ma);

	}

	@Test
	public void caso3Test() {
		// Se crea una instancia de la clase encargada de los archivos
		ma = new ManejadorArchivos("in/caso_03_entrada_No_tiene_comandos.in", "out/caso_03.out");
		// Se crea la instancia del juego segun los datos de entrada
		juegoApp = new JuegoApp(ma);

	}

	@Test
	public void caso4Test() {
		// Se crea una instancia de la clase encargada de los archivos
		ma = new ManejadorArchivos("in/caso_04_entrada_supera_tamaño_cuadricula.in", "out/caso_04.out");
		// Se crea la instancia del juego segun los datos de entrada
		juegoApp = new JuegoApp(ma);

	}

	@Test
	public void caso5Test() {
		// Se crea una instancia de la clase encargada de los archivos
		ma = new ManejadorArchivos("in/caso_05_entrada_falta_dato_inicializacion.in", "out/caso_05.out");
		// Se crea la instancia del juego segun los datos de entrada
		juegoApp = new JuegoApp(ma);

	}

	@Test
	public void caso6Test() {
		// Se crea una instancia de la clase encargada de los archivos
		ma = new ManejadorArchivos("in/caso_06_posicion_supera_limite_cuadricula.in", "out/caso_06.out");
		// Se crea la instancia del juego segun los datos de entrada
		juegoApp = new JuegoApp(ma);

	}

}
