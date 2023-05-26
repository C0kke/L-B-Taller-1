package ucn.lyb.taller2.dominio;

public class IA {
	private String nombre;
	private String lenguaje;
	private int nivelDeAmenaza;
	private String debilidad;
	private String pais;
	private String precision;
	private String tipo;
	private int idCreador;
	
	public IA(String nombre, String lenguaje, int nivelDeAmenaza,String debilidad, String pais, String precision, String tipo,int idCreador) {
		
		this.nombre = nombre;
		this.lenguaje = lenguaje;
		this.nivelDeAmenaza = nivelDeAmenaza;
		this.debilidad = debilidad;
		this.pais = pais;
		this.precision = precision;
		this.tipo = tipo;
		this.idCreador = idCreador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public int getNivelDeAmenaza() {
		return nivelDeAmenaza;
	}

	public void setNivelDeAmenaza(int nivelDeAmenaza) {
		this.nivelDeAmenaza = nivelDeAmenaza;
	}

	public String getDebilidad() {
		return debilidad;
	}

	public void setDebilidad(String debilidad) {
		this.debilidad = debilidad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdCreador() {
		return idCreador;
	}

	public void setIdCreador(int idCreador) {
		this.idCreador = idCreador;
	}

	@Override
	public String toString() {
		return "\nIA (Nombre: " + nombre + ", Lenguaje: " + lenguaje
				+ ", Nivel de Amenaza= " + nivelDeAmenaza + ", Debilidad: "
				+ debilidad + ", Pais: " + pais + ", Precision =" + precision
				+ ", Tipo de IA: " + tipo + ", ID Creador: " + idCreador + ")";
	}
	
	
}
