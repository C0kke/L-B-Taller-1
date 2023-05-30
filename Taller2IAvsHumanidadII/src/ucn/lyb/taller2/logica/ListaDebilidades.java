package ucn.lyb.taller2.logica;
import java.io.FileWriter;
import java.io.IOException;

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
		String debilidades = "";
		for(int a=0;a<listaDebilidades.length;a++){
			if(listaDebilidades[a] != null){
				debilidades += listaDebilidades[a].toString();
			}
		}
		return debilidades;
	}
	public int getCantidad(){
		int cantidad = 0;
		for(int i=0; i<listaDebilidades.length;i++){
			if(listaDebilidades[i] != null){
				cantidad++;
			}
		}
		return cantidad;
	}
	public void Sobreescribir(FileWriter write) throws IOException {
		for(int i=0;i<this.getCantidad();i++){
			write.write(listaDebilidades[i].reWrite());
		}
	}
}
