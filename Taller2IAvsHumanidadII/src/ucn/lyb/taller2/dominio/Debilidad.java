package ucn.lyb.taller2.dominio;

public class Debilidad {
	private String debilidad;
	private int nivelMaximo;
	
	public Debilidad(String nombreDebilidad, int nivel){
		debilidad = nombreDebilidad;
		nivelMaximo = nivel;
	}

	public String getDebilidad() {
		return debilidad;
	}

	public void setDebilidad(String debilidad) {
		this.debilidad = debilidad;
	}

	public int getNivelMaximo() {
		return nivelMaximo;
	}

	public void setNivelMaximo(int nivelMaximo) {
		this.nivelMaximo = nivelMaximo;
	}

	@Override
	public String toString() {
		return "*"+debilidad + ", Nivel de amenaza maximo = "
				+ nivelMaximo +"\n";
	}
	public String reWrite(){
		return debilidad+", "+nivelMaximo+"\n";
	}
}
