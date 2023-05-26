package ucn.lyb.taller2.logica;

import java.io.*;
import java.util.Scanner;

import ucn.lyb.taller2.dominio.IA;
import ucn.lyb.taller2.dominio.Programador;
import ucn.lyb.taller2.dominio.Usuario;

public class App {
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		//Archivos para TXT de Usuarios
		File txtUsuarios = new File("Usuarios.txt");
		ListaUsuarios usuarios = new ListaUsuarios(10);
		CrearUsuarios(txtUsuarios, usuarios);
		
		//Archivos para TXT de Programadores
		File txtProgramadores = new File("Programadores.txt");
		ListaProgramadores programadores = new ListaProgramadores(10);
		CrearProgramadores(txtProgramadores, programadores);
		
		//Archivos para TXT de IA´s
		File txtIAs = new File("IA.txt");
		ListaIAs ias = new ListaIAs(10);
		CrearIAs(txtIAs, ias);
		
		//Verificar existencia del usuario
		/*System.out.println("LOGIN");
		System.out.println("\nUser: ");
		String user = scan.nextLine().toLowerCase();
		System.out.println("Password: ");
		String password = scan.nextLine();
		
		boolean valido = Login(users.length, user, password, users, passwords);
		
		*/
				
			
		//while(valido == false){
			//if(user.equals("empanadasconchapalele") && password.equals("suricatarabiosa")){

				//Menu Admin
				/*
				 * empanadasconchapalele
				 * suricatarabiosa
				 */
				
				MenuAdmin(programadores, ias, scan);
				
			/*	break;
			}else{
				System.out.println("Credeciales invalidas,");
				System.out.println("\nUser: ");
				user = scan.nextLine().toLowerCase();
				System.out.println("Password: ");
				password = scan.nextLine();
				
				valido = Login(users.length, user, password, users, passwords);
			}
			System.out.println("Acceso Correcto");
		}*/
		scan.close();
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
	private static void MenuAdmin(ListaProgramadores programadores, ListaIAs ias, Scanner scan) { //Imprimir Menú Admininstrador
		
		System.out.println("HA ACCEDIDO CORRECTAMENTE AL MENÚ ADMINISTRADOR");
		System.out.println("¿Desea ver las ias o los programadores?");
		System.out.println("1)Programadores \n2)IA's");
		int menu = Integer.parseInt(scan.nextLine());
		menu = Limitar(1, 2, menu, scan);
		int sort;
		switch(menu){
			case 1:
				System.out.println(programadores.toString());
				System.out.println("\n¿Cómo desea ordenarlos?");
				System.out.println("1) Por País \n2) Por Ciudad \n3) Por años de experiencia \n"
								   + "4) Por Cantidad de lenguajes \n5) Por ID \n0) No Ordenar");
				sort = Integer.parseInt(scan.nextLine());
				sort = Limitar(0,5,sort, scan);
				
				OrdenarProgramadores(sort, programadores);
				EditarProgramador(scan, programadores);
				
				break;
			case 2:
				/*
		
			
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
				
				System.out.println("\n¿Cómo desea ordenarlas?");
				System.out.println("1) Por Tipo \n2) Por Nombre \n3) Por Precision "
						+ "\n4) Por Pais \n5) Por Nivel de Peligrosidad \n0) No Ordenar");
				sort = Integer.parseInt(scan.nextLine());
				sort = Limitar(0,5,sort, scan);
				OrdenarIAs(sort, ias);
				break;
		}
	}
	private static int Limitar(int minimo, int maximo, int variable, Scanner scan) { //Funcion para limitar las opciones
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
				totalLenguajes += partesP[i]+",";
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
	private static void OrdenarProgramadores(int ordenarPor, ListaProgramadores programadores){

		String[] listaStr = new String[10]; 
		int[] listaInt = new int[10];
		String[] nombres = new String[10];
		String[] apellidos = new String[10];
		int[] ids = new int[10];
		int[] experiencias = new int[10];
		String[] lenguajes = new String[10];
		int[] cantLenguajes = new int[10];
		String[] paises = new String[10];
		String[] ciudades = new String[10];
		
		programadores.getDato("nombre",nombres,listaInt);
		programadores.getDato("apellido",apellidos,listaInt);
		programadores.getDato("pais",paises,listaInt);
		programadores.getDato("ciudad",ciudades,listaInt);
		programadores.getDato("experiencia",listaStr,experiencias);
		programadores.getDato("lenguajes",lenguajes, cantLenguajes);
		programadores.getDato("id",listaStr,ids);
		
		switch(ordenarPor){
		case 1://Por Pais
			OrdenarProgramadoresStr(paises, programadores);
			System.out.println(programadores.toString());
			break;
		case 2: //Por Ciudad
			OrdenarProgramadoresStr(ciudades, programadores);
			System.out.println(programadores.toString());
			break;
		case 3: //Por años de experiencia
			OrdenarProgramadoresInt(experiencias, programadores);
			System.out.println(programadores.toString());
			break;
		case 4: //Por Cantidad de Lenguajes
			OrdenarProgramadoresInt(cantLenguajes, programadores);
			System.out.println(programadores.toString());
			break;
		case 5: //Por ID
			OrdenarProgramadoresInt(ids, programadores);
			System.out.println(programadores.toString());
			break;
		case 0: //No ordenar
			break;
		}
	}
	public static void OrdenarProgramadoresStr(String[] lista, ListaProgramadores listaProgramadores) {
	    int tamano = lista.length;
	    for (int i = 0; i < tamano; i++) {
	    	for (int j = 1; j < tamano; j++) {
	        	if(lista[(j-1)] != null && lista[j] != null && (int)(lista[(j-1)].compareTo(lista[j])) > 0){
	                String temp = lista[j-1];
	                lista[j-1] = lista[j];
	                lista[j] = temp;
	                Programador tempP = listaProgramadores.buscarProgramador(j-1);
	                listaProgramadores.agregarProgramador((listaProgramadores.buscarProgramador(j)), j-1);
	                listaProgramadores.agregarProgramador(tempP, j);
	            }
	        }
	    }
	}
	public static void OrdenarProgramadoresInt(int[] lista, ListaProgramadores listaProgramadores) {
	    int tamano = lista.length;
	    for (int i = 0; i < tamano; i++) {
	    	for (int j = 1; j < tamano; j++) {
	        	if(lista[(j-1)] != 0 && lista[j] != 0 && lista[(j-1)] < lista[j]){	                
	        		int temp = lista[j-1];
	                lista[j-1] = lista[j];
	                lista[j] = temp;
	                Programador tempP = listaProgramadores.buscarProgramador(j-1);
	                listaProgramadores.agregarProgramador((listaProgramadores.buscarProgramador(j)), j-1);
	                listaProgramadores.agregarProgramador(tempP, j);
	            }
	        }
	    }
	}
	public static void EditarProgramador(Scanner scan, ListaProgramadores programadores){
		int pos = (programadores.buscarID(scan));
		System.out.println(programadores.buscarProgramador(pos));
		
		System.out.println("¿Qué operación desea realizar?");
		System.out.println("1) Agregar Lenguaje \n2) Modificar Años de Experiencia \n3) Cambiar Pais "
				+ "\n4) Cambiar Ciudad \n5) Modificar ID \n6) Cambiar Nombre \n7)Cambiar Apellido \n0) Cancelar");
		int edicion = Integer.parseInt(scan.nextLine());
		edicion = Limitar(0,7,edicion,scan);
		boolean existe;
		switch(edicion){
		case 1://Agregar Lenguaje
			System.out.println("¿Que Lenguaje desea agregar?");
			String lenguaje = scan.nextLine();
			String lenguajesProgramador = programadores.buscarProgramador(pos).getLenguajes();
			String lenguajes[] = lenguajesProgramador.split(",");
			existe = false;
			for(int i=0;i<lenguajes.length;i++){
				if((lenguaje.toUpperCase()).equals(lenguajes[i].toUpperCase().trim())){
					existe = true;
					break;
				}
			}
			if(existe == false){
				lenguajesProgramador +=  " "+lenguaje+ ",";
			}
			programadores.buscarProgramador(pos).setLenguajes(lenguajesProgramador);
			System.out.println(programadores.toString());
			break;
		case 2: // Modificar Años de Experiencia
			System.out.println("¿Cuántos años de experiencia tiene?");
			int experiencia = Integer.parseInt(scan.nextLine());
			programadores.buscarProgramador(pos).setAñosExperiencia(experiencia);
			System.out.println(programadores.toString());
			break;
		case 3: //Cambiar Pais
			System.out.println("Escriba el nombre del nuevo Pais");
			String pais = scan.nextLine();
			programadores.buscarProgramador(pos).setPais(pais);
			System.out.println(programadores.toString());
			break;
		case 4: //Cambiar Ciudad
			System.out.println("Escriba el nombre de la nueva Ciudad");
			String ciudad = scan.nextLine();
			programadores.buscarProgramador(pos).setCiudad(ciudad);
			System.out.println(programadores.toString());
			break;
		case 5: //Modificar ID, Falta modificar en usuario
			
			String[] listaStr = new String[10];
			int[] ids = new int[10];
			programadores.getDato("id", listaStr, ids);
			existe = false;
			
			System.out.println("Ingrese nueva ID");
			int id = Integer.parseInt(scan.nextLine());
			for(int i=0;i<ids.length;i++){
				if(id == ids[i]){
					existe = true;
					break;
				}
			}
			while(existe == true){
				System.out.println("ID ya existente, ingrese ID valida");
				existe = false;
				id = Integer.parseInt(scan.nextLine());
				for(int i=0;i<ids.length;i++){
					if(id == ids[i]){
						existe = true;
						break;
					}
				}
			}
			programadores.buscarProgramador(pos).setId(id);
			System.out.println(programadores.toString());
			break;
		case 6: //Cambiar Nombre
			System.out.print("Ingrese nuevo Nombre: ");
			String nombre = scan.nextLine();
			programadores.buscarProgramador(pos).setNombre(nombre);
			System.out.println(programadores.toString());
			break;
		case 7: //Cambiar Apellido
			System.out.println("Ingrese nuevo Apellido");
			String apellido = scan.nextLine();
			programadores.buscarProgramador(pos).setApellido(apellido);
			System.out.println(programadores.toString());
			break;
		case 0: //Cancelar
			break;
		}
	}
	public static void CrearIAs(File txt, ListaIAs ias) throws FileNotFoundException{
		int contador = 0;
		Scanner leer = new Scanner(txt);
		while(leer.hasNextLine()){
			String linea = leer.nextLine();
			String partesIA[] = linea.split(",");
			
			String nombre = partesIA[0].trim();
			String lenguaje = partesIA[1].trim();
			int nivelDeAmenaza = Integer.parseInt(partesIA[2].trim());
			String debilidad = partesIA[3].trim();
			String pais = partesIA[4].trim();
			String precision = partesIA[5].trim();
			String tipo= partesIA[6].trim();
			int creador = Integer.parseInt(partesIA[7].trim());
			
			IA ia = new IA(nombre, lenguaje, nivelDeAmenaza, debilidad, pais, precision, tipo, creador);
			ias.agregarIA(ia, contador);
			contador++;
		}
		leer.close();
	}
	public static void OrdenarIAs(int ordenarPor, ListaIAs ias){
		
		String[] listaStr = new String[10]; 
		int[] listaInt = new int[10];
		String[] nombres = new String[10];
		String[] lenguajes = new String[10];
		int[] amenazas = new int[10];
		String[] debilidades = new String[10];
		String[] paises = new String[10];
		String[] precisiones = new String[10];
		String[] tipos = new String[10];
		int[] idsCreadores = new int[10];
		
		ias.getDato("nombre",nombres,listaInt);
		ias.getDato("lenguajes",lenguajes,listaInt);
		ias.getDato("amenaza",listaStr,amenazas);
		ias.getDato("debilidad",debilidades, listaInt);
		ias.getDato("pais",paises,listaInt);
		ias.getDato("precision",precisiones,listaInt);
		ias.getDato("tipos",tipos,listaInt);
		ias.getDato("id",listaStr,idsCreadores);
		
		switch(ordenarPor){
			case 1://Por Tipos
				OrdenarIAsStr(tipos, ias);
				System.out.println(ias.toString());
				break;
			case 2: //Por Nombres
				OrdenarIAsStr(nombres, ias);
				System.out.println(ias.toString());
				break;
			case 3: //Por Precision
				TransformarPorcentajes(listaInt, precisiones);
				OrdenarIAsInt(listaInt, ias);
				System.out.println(ias.toString());
				break;
			case 4: //Por Pais
				OrdenarIAsStr(paises, ias);
				System.out.println(ias.toString());
				break;
			case 5: //Por Nivel de Peligrosidad
				OrdenarIAsInt(amenazas, ias);
				System.out.println(ias.toString());
				break;
			case 0: //No ordenar
				break;
		}
	}
	public static void OrdenarIAsStr(String[] lista, ListaIAs listaIAs) {
	    int tamano = lista.length;
	    for (int i = 0; i < tamano; i++) {
	    	for (int j = 1; j < tamano; j++) {
	        	if(lista[(j-1)] != null && lista[j] != null && (int)(lista[(j-1)].compareTo(lista[j])) > 0){
	                String temp = lista[j-1];
	                lista[j-1] = lista[j];
	                lista[j] = temp;
	                IA tempIA = listaIAs.buscarIA(j-1);
	                listaIAs.agregarIA((listaIAs.buscarIA(j)), j-1);
	                listaIAs.agregarIA(tempIA, j);
	            }
	        }
	    }
	}
	public static void OrdenarIAsInt(int[] lista, ListaIAs listaIAs) {
	    int tamano = lista.length;
	    for (int i = 0; i < tamano; i++) {
	    	for (int j = 1; j < tamano; j++) {
	        	if(lista[(j-1)] != 0 && lista[j] != 0 && lista[j-1] < lista[j]){
	                int temp = lista[j-1];
	                lista[j-1] = lista[j];
	                lista[j] = temp;
	                IA tempIA = listaIAs.buscarIA(j-1);
	                listaIAs.agregarIA((listaIAs.buscarIA(j)), j-1);
	                listaIAs.agregarIA(tempIA, j);
	            }
	        }
	    }
	}
	private static void CrearUsuarios(File txt,ListaUsuarios usuarios) throws FileNotFoundException{
		int contador = 0;
		Scanner leer = new Scanner(txt);
	
		while(leer.hasNextLine()){
			
			String linea = leer.nextLine();
			String partes[] = linea.split(",");
			
			String nombreId  = partes[0].trim();
			String pass = partes[1].trim();
			int id = Integer.parseInt(partes[2].trim());

			Usuario u = new Usuario(nombreId, pass, id);
			usuarios.agregarUsuario(u, contador);
			contador++;
		}
		leer.close();
	}
	private static void TransformarPorcentajes(int[] listaInt, String[] listaStr){ //Ordenar precisiones en IA's
		for(int i=0;i<listaInt.length;i++){
			if(listaStr[i] != null){
				String[] porcentaje = listaStr[i].split("%");
				listaInt[i] = Integer.parseInt(porcentaje[0]);
			}
		}
	}
}