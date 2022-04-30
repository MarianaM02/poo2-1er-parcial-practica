package ar.edu.uno.robot;


/**
 * Listado de direcciones cardinales.
 * 
 */
public enum Direccion {
	N("Norte", 1), E("Este", 1), S("Sur", -1), O("Oeste", -1);

	private String nombre;
	private int sentido;

	Direccion(String nombre, int sentido) {
		this.nombre = nombre;
		this.sentido = sentido;
	}

	
	/**
	 * Devuelve una Direccion a partir de indicarle cuantos giros de 90° se deben hacer
	 * 
	 * @param cantVeces numero de rotaciones de 90°
	 * @return Direccion rotada
	 */
	public Direccion girarSentidoHorario(int cantVeces) {
		Direccion[] direcciones = Direccion.values();
		int nuevaPos = (this.ordinal() + cantVeces) % 4;
		return direcciones[nuevaPos];
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getSentido() {
		return sentido;
	}
	
}
