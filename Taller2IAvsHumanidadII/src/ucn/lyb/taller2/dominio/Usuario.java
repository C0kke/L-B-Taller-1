package ucn.lyb.taller2.dominio;

public class Usuario {
	
	private String nombre;
	private String contraseña;
	private int id;
	
	public Usuario(String nombre, String contraseña, int id){
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
