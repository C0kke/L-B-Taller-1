package ucn.lyb.taller2.logica;

import java.util.Arrays;

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
	public String toString() {
		return Arrays.toString(listaUsuarios);
	}
}
