package ucn.lyb.taller2.logica;

import ucn.lyb.taller2.dominio.Pais;
import ucn.lyb.taller2.dominio.Programador;


public class ListaPaises {
	private Pais[] listaPaises;
	
	public ListaPaises(int max){
		listaPaises = new Pais[max];
	}
	
	/*public void agregarRegion(String region, Pais pais){
		for(int i=0;i<listaPaises.length;i++){
			if(listaPaises[i] != null && pais == listaPaises[i]){
				String regiones = listaPaises[i].getRegiones();
				String[] ciudades = regiones.split(",");
				boolean existe = false;
				for(int j=0;j<listaPaises.length;j++){
					if((region.toUpperCase()).equals(ciudades[i].toUpperCase().trim())){
						existe = true;
						break;
					}
				}
				if(existe == false){
					regiones +=  " "+region+ ",";
				}
				listaPaises[i].setRegiones(regiones);
			}
			
		}
	}*/
	
	public void agregarPais(Pais pais, int posicion){
		listaPaises[posicion] = pais;
	}
		
	public Pais buscarPais(int posicion){
		return listaPaises[posicion];
	}
		
	public String toString() {
		return listaPaises.toString();
	}
}
