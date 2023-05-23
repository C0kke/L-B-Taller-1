package ucn.lyb.taller2.logica;


import ucn.lyb.taller2.dominio.Programador;

public class ListaProgramadores {
	private Programador[] listaProgramadores;
	
	public ListaProgramadores(int max){
		listaProgramadores = new Programador[max];
	}
	public void agregarProgramador(Programador p, int posicion){
		listaProgramadores[posicion] = p;
	}
	public void getProgramadores() {
		for(int i=0;i<10;i++){
			if(listaProgramadores[i] != null){
				System.out.println(listaProgramadores[i]);
			}
		}
	}
	public Programador getDato(String dato, String[] listaStr, int[] listaInt){
		int pos = 0;
		for(int i=0;i<listaProgramadores.length;i++){
			if(listaProgramadores[i] != null){
				switch(dato){
				case "pais":
					listaStr[i] = listaProgramadores[i].getPais();
					break;
				case "ciudad":
					listaStr[i] = listaProgramadores[i].getCiudad();
					break;
				case "experiencia":
					listaInt[i] = listaProgramadores[i].getAñosExperiencia();
					break;
				case "cantLenguajes":
					listaStr[i] = listaProgramadores[i].getLenguajes();
					listaInt[i] = listaProgramadores[i].getCantLenguajes();
					break;
				case "id":
					listaInt[i] = listaProgramadores[i].getId();
					break;
				}
			}
		}
		return listaProgramadores[pos];
	}
}