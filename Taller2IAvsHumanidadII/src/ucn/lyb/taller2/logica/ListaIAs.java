package ucn.lyb.taller2.logica;

import java.util.Arrays;
import java.util.Scanner;

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
		return Arrays.toString(listaIAs);
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
	
	public int buscarNombreIA(Scanner scan){
		int posicion = -1;
		while(posicion == -1){
			System.out.println("Ingrese el Nombre de la IA con la que desee trabajar");
			String nombre = scan.nextLine();
			for(int i=0; i<listaIAs.length;i++){
				if(listaIAs[i] != null && (listaIAs[i].getNombre()).equals(nombre)){
					posicion = i;
				}
			}
			if(posicion == -1){
				System.out.println("No se encontró la IA");
			}
		}
		return posicion;
	}
}
