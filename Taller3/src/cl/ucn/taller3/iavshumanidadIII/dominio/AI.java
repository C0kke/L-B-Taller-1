package cl.ucn.taller3.iavshumanidadIII.dominio;

public class AI {
	private String name, clas; 
	private int hp;
	
	public AI(String name, String clas, int hp) {
		this.name = name;
		this.clas = clas;
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setNombreIA(String name) {
		this.name = name;
	}

	public String getClas() {
		return clas;
	}

	public void setClase(String clas) {
		this.clas = clas;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	@Override
	public String toString() {
		return "AI [name=" + name + ", clas=" + clas + ", hp=" + hp + "]";
	}
	
}
