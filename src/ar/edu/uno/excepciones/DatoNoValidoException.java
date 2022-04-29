package ar.edu.uno.excepciones;

public class DatoNoValidoException extends NumberFormatException{

	private static final long serialVersionUID = 1L;

	public DatoNoValidoException() {
		super("Error en ingreso de datos");
	}

}
