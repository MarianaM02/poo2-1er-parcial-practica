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

	public void avanzar(int cantCasillas, Cuadricula cuadricula) {
		// determina el sentido del movimiento (decremento o incremento)
		int movimiento = cantCasillas * this.direccion.getSentido();
		int posicionNueva;
		switch (this.direccion) {
			case N:
			case S:
				// movimiento vertical (en y)
				// calculo posicion posible
				posicionNueva = this.posicionEnY + movimiento;
				// verifico si la posicion nueva es valida en el tablero
				if(cuadricula.superaBordeEnY(posicionNueva)) {
					// si esta fuera del tablero, establezco como nueva posicion el borde
					posicionNueva = cuadricula.getM();
				}
				// setear nueva posicion
				this.posicionEnY = posicionNueva;
				break;
			case E:
			case O:
				// movimiento horizontal (en X)
				// calculo posicion posible
				posicionNueva = this.posicionEnX + movimiento;
				// verifico si la posicion nueva es valida en el tablero
				if(cuadricula.superaBordeEnX(posicionNueva)) {
					// si esta fuera del tablero, establezco como nueva posicion el borde
					posicionNueva = cuadricula.getN();
				}
				// setear nueva posicion
				this.posicionEnX = posicionNueva;
				break;
		}
		
	
	}

	public void rotar(int cantVeces) {
		this.direccion = this.direccion.girarSentidoHorario(cantVeces);
	}

}
