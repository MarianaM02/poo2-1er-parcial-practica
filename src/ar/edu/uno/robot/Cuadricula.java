package ar.edu.uno.robot;

public class Cuadricula {
	private final int MAX = 100;
	private final int MIN = 1;
	private int n;
	private int m;

	public Cuadricula(int n, int m) {
		if (n > MAX || m > MAX) {
			throw new RuntimeException("No puede generarse una cuadrícula que supere N=100 o M=100");
		}
		if (n < MIN || m < MIN) {
			throw new RuntimeException("No puede generarse una cuadrícula con valores menores a 1");
		}
		this.n = n;
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public int getM() {

		return m;
	}

	public int getMAX() {
		return MAX;
	}
	
	public int getMIN() {
		return MIN;
	}

	public boolean superaBordeEnX(int n) {
		return n < 1 || n > this.n;
	}

	public boolean superaBordeEnY(int n) {
		return n < 1 || n > this.m;
	}

}
