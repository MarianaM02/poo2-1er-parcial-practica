package ar.edu.uno.robot;

public class Instruccion {

	private char tipoComando;
	private int numero;

	public Instruccion(char tipoComando, int numero) {
		this.tipoComando = tipoComando;
		this.numero = numero;
	}

	public char getTipoComando() {
		return tipoComando;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "[" + tipoComando + " -> " + numero + "]";
	}

}
