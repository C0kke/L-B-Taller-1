package ucn.lyb.taller2.dominio;


public class Pais {
	private String nombre;
	private String regiones;
	
	public Pais(String nombrePais, String regiones){
		nombre = nombrePais;
		this.regiones = regiones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegiones() {
		return regiones;
	}

	public void setRegiones(String regiones) {
		this.regiones = regiones;
	}

	@Override
	public String toString() {
		return nombre+" Ciudades: " + regiones + "\n";
	}
	
}
