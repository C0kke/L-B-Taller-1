package ucn.lyb.taller2.dominio;

public class Usuario {
	
	private String nombre;
	private int codigo;
	private String contrase�a;
	private int id;
	
	public Usuario(String nombre, int codigo, String contrase�a, int id){
		this.nombre = nombre;
		this.codigo = codigo;
		this.contrase�a = contrase�a;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
