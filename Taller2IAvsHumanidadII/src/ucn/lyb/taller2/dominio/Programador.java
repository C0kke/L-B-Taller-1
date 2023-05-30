package ucn.lyb.taller2.dominio;

public class Programador {
	
	private int id;
	private String nombre;
	private String apellido;
	private int a�osExperiencia;
	private String lenguajes;
	private int cantLenguajes;
	private String pais;
	private String ciudad;
	
	public Programador(int id, String nombre, String apellido,int a�osExperiencia, String lenguajes, int cantLenguajes, String pais, String ciudad) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.a�osExperiencia = a�osExperiencia;
		this.lenguajes = lenguajes;
		this.cantLenguajes = cantLenguajes;
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

	public int getA�osExperiencia() {
		return a�osExperiencia;
	}

	public void setA�osExperiencia(int a�osExperiencia) {
		this.a�osExperiencia = a�osExperiencia;
	}

	public String getLenguajes() {
		return lenguajes;
	}
	public int getCantLenguajes(){
		return cantLenguajes;
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

	@Override
	public String toString() {
		return "Programador "+ id + ", Nombre: " + nombre + " " + apellido + ", A�os de Experiencia: " + a�osExperiencia
				+ ", Lenguajes:" + lenguajes+ ", Pais:" + pais + ", Ciudad:" + ciudad + "\n";
	}
	public String reWrite(){
		return id+", "+nombre+", "+apellido+", "+a�osExperiencia+","+lenguajes+","+pais+","+ciudad+"\n";
	}
}
