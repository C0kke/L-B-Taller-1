package ucn.lyb.taller2.logica;

import java.io.*;
import java.util.Scanner;

import ucn.lyb.taller2.dominio.Programador;

public class App {

	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		//Archivos para TXT de Usuarios
		File txtUsuarios = new File("Usuarios.txt");
		String users[] = new String [100];
		int codigos[] = new int[100];
		String passwords[] = new String[100];
		int idsUsuarios[] = new int[100];
		CrearListas(txtUsuarios, users, codigos, passwords, idsUsuarios);
		
		//Archivos para TXT de Programadores
		File txtProgramadores = new File("Programadores.txt");
		ListaProgramadores programadores = new ListaProgramadores(10);
		CrearProgramadores(txtProgramadores, programadores);
		
		//Verificar existencia del usuario
		System.out.println("LOGIN");
		System.out.println("\nUser: ");
		String user = scan.nextLine().toLowerCase();
		System.out.println("Password: ");
		String password = scan.nextLine();
		
	
		//Menu Admin
		/*
		 * empanadasconchapalele
		 * suricatarabiosa
		 */
		if(user.equals("empanadasconchapalele") && password.equals("suricatarabiosa")){
			MenuAdmin(programadores);
			int sort = Integer.parseInt(scan.nextLine());
			sort = Limitar(0,5,sort, scan);
			
			OrdenarProgramadores(sort, programadores);
			
			
			/*• Ver todos los programadores, y dentro de esto implementar un filtro, que pueda seleccionar
			a los programadores por:
				o País o Ciudad o Años experiencia
				o Cantidad de lenguajes que conoce o Por ID(Se ordenan los
				programadores de mayor a menor según su ID)
				• Ver todos las IA, y dentro de esto implementar un filtro, que pueda seleccionar a las IA por:
				o Tipo
				o Nombre (Ordenar en orden alfabético) o Precisión o País o Nivel
				de peligrosidad
				• Editar datos Programador: En esta ventana se podrán editar los datos del programador,
				(Agregar lenguaje, años de experiencia, modifica país, ciudad, id, nombre, apellido), tener
				en cuenta que si se cambia el id no se puede repetir con otra ya existente. Además de tener
				que modificarlo en los datos de usuario.
				• Editar datos IA: En esta ventana se podrán editar los datos de la IA, (Nombre, nivel de
				peligrosidad, debilidad, precisión, País, Id creador)
				• Editar datos de Usuario: Se pueden modificar todos los datos de usuario (Nombre usuario,
				contraseña, id). Tener en cuenta que no se puede repetir el id en otro usuario.
				• Crear y visualizar debilidades: Aquí se deben visualizar todas las debilidades y dar la
				posibilidad de agregar una nueva con sus respectivos datos
				• Crear una IA, programador, País: se podrán crear Una IA, Programador y País con los datos
				necesarios para cada uno
				• Dar estadísticas por países:
				o Porcentaje de IA y programadores por países según el total o
				Porcentaje de IA y programadores por Ciudad según el total
			*/
			
		}else{
			boolean valido = Login(users.length, user, password, users, passwords);
			while(valido == false){
				System.out.println("Credeciales invalidas,");
				System.out.println("\nUser: ");
				user = scan.nextLine().toLowerCase();
				System.out.println("Password: ");
				password = scan.nextLine();
					
				valido = Login(users.length, user, password, users, passwords);
			}
			System.out.println("Acceso Correcto");
		}
		scan.close();
	}
	private static void MenuAdmin(ListaProgramadores programadores) { //Imprimir Menú Admininstrador
		System.out.println("HA ACCEDIDO CORRECTAMENTE AL MENÚ ADMINISTRADOR");
		System.out.println("\nProgramadores:");
		programadores.getProgramadores();
		System.out.println("\n¿Cómo desea ordenarlos?");
		System.out.println("1) Por País");
		System.out.println("2) Por Ciudad");
		System.out.println("3) Por años de experiencia");
		System.out.println("4) Por Cantidad de lenguajes");
		System.out.println("5) Por ID");
		System.out.println("0) No Ordenar");
	}
	private static int Limitar(int minimo, int maximo, int variable, Scanner scan) {
		while(variable < minimo || variable > maximo){
			System.out.println("Ingrese una opcion valida");
	        variable = Integer.parseInt(scan.nextLine());
	    }
	    return variable;
	}
	private static void CrearProgramadores(File txt, ListaProgramadores programadores) throws FileNotFoundException{
		int contador = 0;
		Scanner leer = new Scanner(txt);
		while(leer.hasNextLine()){
			String linea = leer.nextLine();
			String partesP[] = linea.split(",");
			
			int id  = Integer.parseInt(partesP[0].trim());
			String nombre = partesP[1].trim();
			String apellido = partesP[2].trim();
			int experiencia = Integer.parseInt(partesP[3].trim());
			String totalLenguajes = "";
			int cantLenguajes= 0;
			for(int i=4;i<partesP.length-2;i++){
				totalLenguajes += partesP[i]+" ";
				cantLenguajes++;
			}
			String pais = partesP[partesP.length-2];
			String ciudad = partesP[partesP.length-1];
			
			Programador p = new Programador(id, nombre, apellido, experiencia, totalLenguajes,cantLenguajes, pais, ciudad);
			programadores.agregarProgramador(p, contador);
			contador++;
		}
		leer.close();
	}
	private static void CrearListas(File txt, String users[], int codigos[], String passwords[],  int ids[]) throws FileNotFoundException{
		int contador = 0;
		Scanner leer = new Scanner(txt);
	
		while(leer.hasNextLine()){
			
			String linea = leer.nextLine();
			String partes[] = linea.split(",");
			
			String nombreId  = partes[0].trim();
			String part[] = nombreId.split("#");
			String user = part[0].trim();
			int codigo = Integer.parseInt(part[1].trim());
			String pass = partes[1].trim();
			int id = Integer.parseInt(partes[2].trim());
			
			users[contador] = user.toLowerCase();
			codigos[contador] = codigo;
			passwords[contador] = pass;
			ids[contador] = id;
			contador++;
		}
		leer.close();
	}
	private static boolean Login(int tamano, String user, String pass, String listaUser[], String listaPassword[]){
		boolean valido = false;
		for(int i = 0; i<tamano;i++){
			if(listaUser[i] != null && user.equals(listaUser[i]) && pass.equals(listaPassword[i])){
				valido = true;
			}
		}
		return valido;
	}
	private static void ImprimirPorDato(String[] lista){
		for(int i=0;i<lista.length;i++){
			if(lista[i] != null && !lista[i].equals("0")){
				System.out.println("-"+lista[i]);
			}
		}
		
	}
	private static void OrdenarProgramadores(int ordenarPor, ListaProgramadores programadores){
		String[] listaStr = new String[10]; 
		int[] listaInt = new int[10];
		switch(ordenarPor){
		case 1://Por Pais
			programadores.getDato("pais",listaStr,listaInt);
			OrdenarStrings(listaStr);
			ImprimirPorDato(listaStr);
			break;
		case 2: //Por Ciudad
			programadores.getDato("ciudad",listaStr,listaInt);
			OrdenarStrings(listaStr);
			ImprimirPorDato(listaStr);
			break;
		case 3: //Por años de experiencia
			programadores.getDato("experiencia",listaStr,listaInt);
			OrdenarInts(listaInt);
			TransformarIntString(listaInt, listaStr);
			ImprimirPorDato(listaStr);
			break;
		case 4: //Por Cantidad de Lenguajes
			programadores.getDato("cantLenguajes",listaStr,listaInt);
			OrdenarLenguajes(listaInt, listaStr);
			ImprimirPorDato(listaStr);
			break;
		case 5: //Por ID
			programadores.getDato("id",listaStr,listaInt);
			OrdenarInts(listaInt);
			TransformarIntString(listaInt, listaStr);
			ImprimirPorDato(listaStr);
			break;
		case 0: //No ordenar
			break;
		}
	}	
	private static void OrdenarLenguajes(int[] listaInt, String[] listaStr) { //Ordenar lenguajes
		for(int i=0; i<listaInt.length;i++){
	    	for (int j = 1; j < listaInt.length; j++) {
	    		if(listaInt[j-1] != 0 && listaInt[j] != 0 && listaInt[j-1] < listaInt[j]){                
	    			int temp1 = listaInt[j-1];
	    			listaInt[j-1] = listaInt[j];
	    			listaInt[j] = temp1;
	    			String temp2 = listaStr[j-1];
	    			listaStr[j-1] = listaStr[j];
	    			listaStr[j] = temp2;
	    		}
			}
		}
	}
	private static void TransformarIntString(int[] listaInt, String[] listaStr) { //Cambiar lista Int a String
		for(int i=0; i<listaInt.length;i++){
			if(listaInt[i] !=0){
				listaStr[i] = String.valueOf(listaInt[i]);
			}
		}
		
	}
	private static void OrdenarStrings(String[] lista){ //Ordenar a-z
		for(int i=0; i<lista.length;i++){
	    	for (int j = 1; j < lista.length; j++) {
	    		if(lista[j-1] !=null && lista[j] != null && lista[j-1].compareTo(lista[j]) > 0){                
			        String temp1 = lista[j-1];
			        lista[j-1] = lista[j];
			        lista[j] = temp1;
	    		}
			}
		}
	}
	private static void OrdenarInts(int[] lista){ //Ordenar mayor a menor numero
		for(int i=0; i<lista.length;i++){
	    	for (int j = 1; j < lista.length; j++) {
	    		if(lista[j-1] != 0 && lista[j] != 0 && lista[j-1] < lista[j]){                
	    			int temp1 = lista[j-1];
			        lista[j-1] = lista[j];
			        lista[j] = temp1;
	    		}
			}
		}
	}
}

