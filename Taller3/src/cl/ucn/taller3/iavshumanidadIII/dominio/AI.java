package cl.ucn.taller3.iavshumanidadIII.dominio;

public class AI {
	private String nombreIA, clase; 
	private int vida;
	
	public AI(String nombreIA, String clase, int vida) {
		this.nombreIA = nombreIA;
		this.clase = clase;
		this.vida = vida;
	}

	public String getNombreIA() {
		return nombreIA;
	}

	public void setNombreIA(String nombreIA) {
		this.nombreIA = nombreIA;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
}
