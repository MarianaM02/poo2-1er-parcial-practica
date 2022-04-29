package ar.edu.uno.app;

public class Cuadricula {

	private int N;
	private int M;

	public Cuadricula(int n, int m) {
		super();
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
