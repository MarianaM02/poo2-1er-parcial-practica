package ar.edu.uno.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import ar.edu.uno.robot.Cuadricula;
import ar.edu.uno.robot.Direccion;
import ar.edu.uno.robot.JuegoApp;
import ar.edu.uno.robot.ManejadorArchivos;
import ar.edu.uno.robot.Robot;

public class JuegotAppTests {
	ManejadorArchivos manejador;
	JuegoApp juegoApp;
	Robot robot;
	Cuadricula cuadricula;

	@Before
	public void setUp() {
		robot = new Robot(1, 1, "N");
		cuadricula = new Cuadricula(5, 5);
	}
	
	@Test
	public void construccionRobotTest() {
		assertNotNull(robot);
	}
	
	@Test
	public void construccionCuadriculaTest() {
		assertNotNull(cuadricula);
	}
	
	@Test
	public void avanzarRobot0EspaciosTest() {
		robot.avanzar(0, cuadricula);
		assertEquals(1, robot.getPosicionEnX());
		assertEquals(1, robot.getPosicionEnY());

	}
	@Test
	public void avanzarRobotSinChocarBordeTest() {
		robot.avanzar(2, cuadricula);
		assertEquals(1, robot.getPosicionEnX());
		assertEquals(3, robot.getPosicionEnY());	
	}
	
	@Test
	public void avanzarRobotChocarBordeTest() {
		robot.avanzar(7, cuadricula);
		assertEquals(1, robot.getPosicionEnX());
		assertEquals(5, robot.getPosicionEnY());	
	}
	
	@Test
	public void avanzarRobotGirarAntesTest() {
		robot.rotar(1);
		robot.avanzar(7, cuadricula);
		assertEquals(5, robot.getPosicionEnX());
		assertEquals(1, robot.getPosicionEnY());	
	}
	
	@Test
	public void rotarRobotTest() {
		assertEquals(Direccion.N, robot.getDireccion());
		robot.rotar(1);
		assertEquals(Direccion.E, robot.getDireccion());
		robot.rotar(4);
		assertEquals(Direccion.E, robot.getDireccion());
		robot.rotar(7);
		assertEquals(Direccion.N, robot.getDireccion());
		robot.rotar(2);
		assertEquals(Direccion.S, robot.getDireccion());
		robot.rotar(1);
		assertEquals(Direccion.O, robot.getDireccion());
	}
	
	@Test
	public void caso1Test() {
		// Se crea una instancia de la clase encargada de los archivos
		manejador = new ManejadorArchivos("caso_01_entrada_varios_comandos.in", "caso_01.out");
		// Se crea la instancia del juego segun los datos de entrada
		juegoApp = new JuegoApp(manejador);

	}

	@Test
	public void caso2Test() {
		// Se crea una instancia de la clase encargada de los archivos
		manejador = new ManejadorArchivos("caso_02_entrada_un_comando.in", "caso_02.out");
		// Se crea la instancia del juego segun los datos de entrada
		juegoApp = new JuegoApp(manejador);

	}

	@Test
	public void caso3Test() {
		// Se crea una instancia de la clase encargada de los archivos
		manejador = new ManejadorArchivos("caso_03_entrada_No_tiene_comandos.in", "caso_03.out");
		// Se crea la instancia del juego segun los datos de entrada
		juegoApp = new JuegoApp(manejador);
	}

	@Test
	public void caso4Test() {
		// Se crea una instancia de la clase encargada de los archivos
		manejador = new ManejadorArchivos("caso_04_entrada_supera_tamaño_cuadricula.in", "caso_04.out");
		// Se crea la instancia del juego segun los datos de entrada
		juegoApp = new JuegoApp(manejador);
	}

	@Test
	public void caso5Test() {
		// Se crea una instancia de la clase encargada de los archivos
		manejador = new ManejadorArchivos("caso_05_entrada_falta_dato_inicializacion.in", "caso_05.out");
		// Se crea la instancia del juego segun los datos de entrada
		juegoApp = new JuegoApp(manejador);
	}

	@Test
	public void caso6Test() {
		// Se crea una instancia de la clase encargada de los archivos
		manejador = new ManejadorArchivos("caso_06_posicion_supera_limite_cuadricula.in", "caso_06.out");
		// Se crea la instancia del juego segun los datos de entrada
		juegoApp = new JuegoApp(manejador);
	}

	@Test
	public void casoDeStressTest() {
		// Se crea una instancia de la clase encargada de los archivos
		manejador = new ManejadorArchivos("caso_de_stress.in", "caso_de_stress.out");
		// Se crea la instancia del juego segun los datos de entrada
		juegoApp = new JuegoApp(manejador);
	}

}
