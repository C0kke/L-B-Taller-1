package ucn.lyb.taller2.logica;

import ucn.lyb.taller2.dominio.Pais;


public class ListaPaises {
	private Pais[] listaPaises;
	
	public ListaPaises(int max){
		listaPaises = new Pais[max];
	}
	
	public void agregarPais(Pais pais, int posicion){
		listaPaises[posicion] = pais;
	}
		
	public Pais buscarPais(int posicion){
		return listaPaises[posicion];
	}
	public int getCantidad(){
		int cantidad = 0;
		for(int i=0; i<listaPaises.length;i++){
			if(listaPaises[i] != null){
				cantidad++;
			}
		}
		return cantidad;
	}
		
	public String toString() {
		return listaPaises.toString();
	}
}
