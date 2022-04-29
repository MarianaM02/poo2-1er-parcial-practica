package ar.edu.uno.robot;

public class Cuadricula {
	private final int MAX = 100;
	private final int MIN = 1;
	private int N;
	private int M;

	public Cuadricula(int n, int m) {
		if (n > MAX || m > MAX) {
			throw new RuntimeException("No puede generarse una cuadrícula que supere N=100 o M=100");
		}
		if (n < MIN || m < MIN) {
			throw new RuntimeException("No puede generarse una cuadrícula con valores menores a 1");
		}
		this.N = n;
		this.M = m;
	}

	public int getN() {
		return N;
	}

	public int getM() {
		return M;
	}

	// TODO Validar movimiento
	// chequear (if) si el cálculo no sobrepasa máximos (N o M segun corresponda)
	// setear posicion nueva

	public boolean superaBordeEnX(int n) {
		return n < 1 || n > N;
	}

	public boolean superaBordeEnY(int n) {
		return n < 1 || n > M;
	}

}
