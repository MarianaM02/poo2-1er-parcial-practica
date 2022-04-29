package ar.edu.uno.excepciones;

public class DatosInsuficientesException extends NumberFormatException{

	private static final long serialVersionUID = 1L;

	public DatosInsuficientesException() {
		super("No puede ejecutarse el programa por faltar datos de inicialización");
	}

}
