package ucn.lyb.taller2.logica;
import ucn.lyb.taller2.dominio.Usuario;

public class ListaUsuarios {
	
	private Usuario[] listaUsuarios;
	
	public ListaUsuarios(int max){
		listaUsuarios = new Usuario[max];
	}
	
	public void agregarUsuario(Usuario user, int posicion){
		listaUsuarios[posicion] = user;
	}
		
	public Usuario buscarUsuario(int posicion){
		return listaUsuarios[posicion];
	}
		
	public int getCantidad(){
		int cantidad = 0;
		for(int i=0; i<listaUsuarios.length;i++){
			if(listaUsuarios[i] != null){
				cantidad++;
			}
		}
		return cantidad;
	}
	public int buscarNombre(String nombre){
		int posicion = -1;
		while(posicion == -1){
			for(int i=0; i<listaUsuarios.length;i++){
				if(listaUsuarios[i] != null && (listaUsuarios[i].getNombre().toUpperCase()).equals(nombre)){
					posicion = i;
				}
			}
		}
		return posicion;
	}
	public String toString() {
		String usuarios = "";
		for(int a=0;a<listaUsuarios.length;a++){
			if(listaUsuarios[a] != null){
				usuarios += listaUsuarios[a].toString();
			}
		}
		return usuarios;
	}
}
