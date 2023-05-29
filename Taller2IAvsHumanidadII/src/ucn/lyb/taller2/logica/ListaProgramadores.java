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
	
	public Programador buscarProgramador(int posicion){
		return listaProgramadores[posicion];
	}
	
	public int buscarID(int id){
		int posicion = -1;
			for(int i=0; i<listaProgramadores.length;i++){
				if(listaProgramadores[i] != null && listaProgramadores[i].getId() == id){
					posicion = i;
				}
			
		}
		return posicion;
	}
	public int getCantidad(){
		int cantidad = 0;
		for(int i=0; i<listaProgramadores.length;i++){
			if(listaProgramadores[i] != null){
				cantidad++;
			}
		}
		return cantidad;
	}
	@Override
	public String toString() {
		String programadores = "";
		for(int a=0;a<listaProgramadores.length;a++){
			if(listaProgramadores[a] != null){
				programadores += listaProgramadores[a].toString();
			}
		}
		return programadores;
	}
	public void getDato(String dato, String[] listaStr, int[] listaInt){
		for(int i=0;i<listaProgramadores.length;i++){
			if(listaProgramadores[i] != null){
				switch(dato){
				case "nombre":
					listaStr[i] = listaProgramadores[i].getNombre();
					break;
				case "apellido":
					listaStr[i] = listaProgramadores[i].getApellido();
					break;
				case "pais":
					listaStr[i] = listaProgramadores[i].getPais();
					break;
				case "ciudad":
					listaStr[i] = listaProgramadores[i].getCiudad();
					break;
				case "experiencia":
					listaInt[i] = listaProgramadores[i].getAñosExperiencia();
					break;
				case "lenguajes":
					listaStr[i] = listaProgramadores[i].getLenguajes();
					listaInt[i] = listaProgramadores[i].getCantLenguajes();
					break;
				case "id":
					listaInt[i] = listaProgramadores[i].getId();
					break;
				}
			}
		}
	}
}