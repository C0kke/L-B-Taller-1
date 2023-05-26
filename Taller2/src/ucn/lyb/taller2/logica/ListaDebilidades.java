package ucn.lyb.taller2.logica;

import java.util.Arrays;

import ucn.lyb.taller2.dominio.Debilidad;

public class ListaDebilidades {
	private Debilidad[] listaDebilidades;
	
	public ListaDebilidades(int max){
		listaDebilidades = new Debilidad[max];
	}
	public void agregarDebilidad(Debilidad d, int posicion){
		listaDebilidades[posicion] = d;
	}
	
	public Debilidad buscarDebilidad(int posicion){
		return listaDebilidades[posicion];
	}
	@Override
	public String toString() {
		return "ListaDebilidades [listaDebilidades="
				+ Arrays.toString(listaDebilidades) + "]";
	}
	
}
