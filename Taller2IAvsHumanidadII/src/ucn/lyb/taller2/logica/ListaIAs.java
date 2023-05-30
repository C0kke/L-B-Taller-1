package ucn.lyb.taller2.logica;

import java.io.FileWriter;
import java.io.IOException;

import ucn.lyb.taller2.dominio.IA;

public class ListaIAs {
	private IA[] listaIAs;
	
	public ListaIAs(int max){
		listaIAs = new IA[max];
	}
	
	public void agregarIA(IA ia, int posicion){
		listaIAs[posicion] = ia;
	}
	
	public IA buscarIA(int posicion){
		return listaIAs[posicion];
	}
	
	public String toString() {
		String ias = "";
		for(int a=0;a<listaIAs.length;a++){
			if(listaIAs[a] != null){
				ias += listaIAs[a].toString();
			}
		}
		return ias;
	}
	public void getDato(String dato, String[] listaStr, int[] listaInt){
		for(int i=0;i<listaIAs.length;i++){
			if(listaIAs[i] != null){
				switch(dato){
				case "nombre":
					listaStr[i] = listaIAs[i].getNombre();
					break;
				case "lenguaje":
					listaStr[i] = listaIAs[i].getLenguaje();
					break;
				case "amenaza":
					listaInt[i] = listaIAs[i].getNivelDeAmenaza();
					break;
				case "debilidad":
					listaStr[i] = listaIAs[i].getDebilidad();
					break;
				case "pais":
					listaStr[i] = listaIAs[i].getPais();
					break;
				case "precision":
					listaStr[i] = listaIAs[i].getPrecision();
					break;
				case "tipo":
					listaStr[i] = listaIAs[i].getTipo();
					break;
				case "id":
					listaInt[i] = listaIAs[i].getIdCreador();
					break;
				}
			}
		}
	}
	public int getCantidad(){
		int cantidad = 0;
		for(int i=0; i<listaIAs.length;i++){
			if(listaIAs[i] != null){
				cantidad++;
			}
		}
		return cantidad;
	}
	public int buscarNombreIA(String nombre){
		int posicion = -1;
		while(posicion == -1){
			for(int i=0; i<listaIAs.length;i++){
				if(listaIAs[i] != null && (listaIAs[i].getNombre().toUpperCase()).equals(nombre)){
					posicion = i;
				}
			}
		}
		return posicion;
	}
	public void Sobreescribir(FileWriter write) throws IOException {
		for(int i=0;i<this.getCantidad();i++){
			write.write(listaIAs[i].reWrite());
		}
	}
}
