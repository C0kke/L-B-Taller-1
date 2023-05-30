package ucn.lyb.taller2.logica;
import java.io.FileWriter;
import java.io.IOException;

import ucn.lyb.taller2.dominio.Pais;


public class ListaPaises {
	private Pais[] listaPaises;
	private int max;
	private int cantidad;
	
	public ListaPaises(int max){
		listaPaises = new Pais[max];
	}
	
	public int getMax() {
		return max;
	}

	public void agregarPais(Pais pais, int posicion){
		listaPaises[posicion] = pais;
	}
		
	public Pais buscarPais(int posicion){
		return listaPaises[posicion];
	}
	public int getCantidad(){
		cantidad = 0;
		for(int i=0; i<listaPaises.length;i++){
			if(listaPaises[i] != null){
				cantidad++;
				}
			}
		return cantidad;
	}
		
	public String toString() {
		String paises = "";
		for(int a=0;a<listaPaises.length;a++){
			if(listaPaises[a] != null){
				paises += listaPaises[a].toString();
			}
		}
		return paises;
	}
	public void Sobreescribir(FileWriter write) throws IOException {
		for(int i=0;i<this.getCantidad();i++){
			write.write(listaPaises[i].reWrite());
		}
	}
}
