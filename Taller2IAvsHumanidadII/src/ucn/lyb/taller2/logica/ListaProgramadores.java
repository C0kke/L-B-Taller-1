package ucn.lyb.taller2.logica;

import java.util.Arrays;

import ucn.lyb.taller2.dominio.Programador;

public class ListaProgramadores {
	private Programador[] listaProgramadores;
	
	public ListaProgramadores(int max){
		listaProgramadores = new Programador[max];
	}
	public void agregarProgramador(Programador p, int posicion){
		listaProgramadores[posicion] = p;
	}
	public String getProgramadores() {
	    return Arrays.toString(listaProgramadores);
	}
	
	
}