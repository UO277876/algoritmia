package algestudiante.p7;

public class CancionRP {

	private int segundos;
	private String name;
	private int puntuacion;
	
	/**
	 * Constructor de la clase Cancion
	 * 
	 * @param minutos, los minutos que dura la cancion
	 * @param segundos, los segundos que dura la cancion
	 * @param name, el nombre de la cancion
	 * @param puntuacion, la puntuacion de la cancion
	 */
	public CancionRP(int segundos, String name, int puntuacion) {
		this.segundos = segundos;
		this.name = name;
		this.puntuacion = puntuacion;
	}

	/**
	 * @return the segundos
	 */
	protected int getSegundos() {
		return segundos;
	}

	/**
	 * @param segundos the segundos to set
	 */
	protected void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	/**
	 * @return the name
	 */
	protected String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the puntuacion
	 */
	protected int getPuntuacion() {
		return puntuacion;
	}

	/**
	 * @param puntuacion the puntuacion to set
	 */
	protected void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	

}
