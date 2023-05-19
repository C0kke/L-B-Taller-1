package ucn.lyb.taller2.dominio;

public class Programador {
	
	private int id;
	private String nombre;
	private String apellido;
	private int añosExperiencia;
	private String lenguajes;
	private String pais;
	private String ciudad;
	
	public Programador(int id, String nombre, String apellido,int añosExperiencia, String lenguajes, String pais, String ciudad) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.añosExperiencia = añosExperiencia;
		this.lenguajes = lenguajes;
		this.pais = pais;
		this.ciudad = ciudad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getAñosExperiencia() {
		return añosExperiencia;
	}

	public void setAñosExperiencia(int añosExperiencia) {
		this.añosExperiencia = añosExperiencia;
	}

	public String getLenguajes() {
		return lenguajes;
	}

	public void setLenguajes(String lenguajes) {
		this.lenguajes = lenguajes;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String toString() {
		return "Programador [id=" + id + ", nombre=" + nombre + ", apellido="
				+ apellido + ", añosExperiencia=" + añosExperiencia
				+ ", lenguajes=" + lenguajes + ", pais=" + pais + ", ciudad="
				+ ciudad + "]";
	}
	
	
	
	
}
