package ar.edu.uno.app;

public class Robot {

	private int posicionEnX;
	private int posicionEnY;
	private Direccion direccion;

	public Robot(int posicionEnX, int posicionEnY, String direccion) {
		super();
		this.posicionEnX = posicionEnX;
		this.posicionEnY = posicionEnY;
		this.direccion = Direccion.valueOf(direccion);
	}

	public int getPosicionEnX() {
		return posicionEnX;
	}

	public int getPosicionEnY() {
		return posicionEnY;
	}

	public Direccion getDireccion() {
		return direccion;
	}


	public void avanzar(int numero) {
		// setear nueva posicion
		switch (this.direccion) {
			case N :
			case S :
				this.posicionEnY = numero;
				break;
			case E :
			case O :
				this.posicionEnX = numero;
				break;
		}
	}

	public void rotar(int cantVeces) {
		this.direccion = this.direccion.girarSentidoHorario(cantVeces);
	}

}
