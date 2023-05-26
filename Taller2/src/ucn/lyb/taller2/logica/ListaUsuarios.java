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
		
	public String toString() {
		return listaUsuarios.toString();
	}
}
