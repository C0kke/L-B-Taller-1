package ucn.lyb.taller2.logica;

import java.io.*;
import java.util.*;

import ucn.lyb.taller2.dominio.Debilidad;
import ucn.lyb.taller2.dominio.IA;
import ucn.lyb.taller2.dominio.Pais;
import ucn.lyb.taller2.dominio.Programador;
import ucn.lyb.taller2.dominio.Usuario;

public class App {
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		String terminar = "no";
		//Archivos para Objeto Usuario
		File txtUsuarios = new File("Usuarios.txt");
		ListaUsuarios usuarios = new ListaUsuarios(10);
		
		//Archivos para Objeto Programador
		File txtProgramadores = new File("Programadores.txt");
		ListaProgramadores programadores = new ListaProgramadores(10);
		
		//Archivos para Objeto IA
		File txtIAs = new File("IA.txt");
		ListaIAs ias = new ListaIAs(10);
		
		//Archivos para Objeto Pais
		File txtPaises = new File("Países.txt");
		ListaPaises paises = new ListaPaises(10);
		
		//Archivos para Objeto Debilidad
		File txtDebilidades = new File("Debilidades.txt");
		ListaDebilidades debilidades = new ListaDebilidades(10);
		
		//Creacion de objetos
		CrearUsuarios(txtUsuarios, usuarios);
		CrearProgramadores(txtProgramadores, programadores);
		CrearIAs(txtIAs, ias);
		CrearPaises(txtPaises, paises);
		CrearDebilidades(txtDebilidades, debilidades);
		
		//Verificar existencia del usuario
		boolean admin = true;
		System.out.println("LOGIN");
		System.out.println("\nUser: ");
		String user = scan.nextLine().toLowerCase();
		System.out.println("Password: ");
		String password = scan.nextLine();
		
		if(user.equals("empanadasconchapalele") && password.equals("suricatarabiosa")){
			admin = true;
		}
		if(admin == true){
			System.out.println("HA ACCEDIDO CORRECTAMENTE AL MENÚ ADMINISTRADOR\n");
				while(!terminar.equals("si")){
					int cerrar = MenuAdmin(programadores, ias, usuarios, paises, debilidades, scan);
					if(cerrar == 0){
						break;
					}else{
						System.out.println("¿Desea finalizar la sesion?");
						System.out.println("'si' para finalizar");
						System.out.println("Cualquier tecla para continuar");
						terminar = scan.nextLine().toLowerCase();
				}
			}
		}else{
			boolean valido = Login(usuarios.getCantidad(), usuarios, user, password);
			while(valido == false){
				System.out.println("Credeciales invalidas,");
				System.out.println("\nUser: ");
				user = scan.nextLine().toLowerCase();
				System.out.println("Password: ");
				password = scan.nextLine();
				
				valido = Login(usuarios.getCantidad(), usuarios, user, password);
			}
			while(!terminar.equals("si")){
		
				//Menu usuarios
				System.out.println("¿Desea finalizar la sesion?");
				System.out.println("'si' para finalizar");
				System.out.println("Cualquier tecla para continuar");
				terminar = scan.nextLine().toLowerCase();
			}
		}
		System.out.println("Adios");
		scan.close();
	}
	private static boolean Login(int tam, ListaUsuarios usuarios, String user, String pass){
		boolean valido = false;
		for(int i = 0; i<tam;i++){
			if((usuarios.buscarUsuario(i).getNombre()).equals(user.toLowerCase()) && (usuarios.buscarUsuario(i).getContraseña()).equals(pass)){
				valido = true;
				break;
			}
		}
		return valido;
	}
	private static int MenuAdmin(ListaProgramadores programadores, ListaIAs ias, ListaUsuarios usuarios, ListaPaises paises, ListaDebilidades debilidades, Scanner scan) { //Imprimir Menú Admininstrador
		
		System.out.println("¿A que menu desea acceder?");
		System.out.println("1) Programadores \n2) IA's\n3) Usuarios\n4) Debilidades\n0) Cerrar Programa");
		int menu = Integer.parseInt(scan.nextLine());
		menu = Limitar(0, 5, menu, scan);
		int sort;
		switch(menu){
			case 1:
				System.out.println("PROGRAMADORES:");
				System.out.println(programadores.toString());
				System.out.println("\n¿Cómo desea ordenarlos?");
				System.out.println("1) Por País \n2) Por Ciudad \n3) Por años de experiencia \n"
								   + "4) Por Cantidad de lenguajes \n5) Por ID \n0) No Ordenar");
				sort = Integer.parseInt(scan.nextLine());
				sort = Limitar(0,5,sort, scan);
				
				OrdenarProgramadores(sort, programadores);
				EditarProgramador(scan, programadores, paises, usuarios);
				
				break;
			case 2:
				System.out.println("INTELIGENCIAS ARTIFICIALES:");
				System.out.println(ias.toString());
				System.out.println("\n¿Cómo desea ordenarlas?");
				System.out.println("1) Por Tipo \n2) Por Nombre \n3) Por Precision "
						+ "\n4) Por Pais \n5) Por Nivel de Peligrosidad \n0) No Ordenar");
				sort = Integer.parseInt(scan.nextLine());
				sort = Limitar(0,5,sort, scan);
				OrdenarIAs(sort, ias);
				System.out.println("Desea crear o editar una IA?");
				System.out.println("1) Crear\n2) Editar");
				int opcionIA = Integer.parseInt(scan.nextLine());
				switch(opcionIA){
				case 1:
					AgregarIA(scan, ias, programadores, debilidades, paises);
					break;
				case 2:
					EditarIAs(scan,ias, programadores, paises, debilidades);
					break;
				}
				break;
			case 3:
				System.out.println("USUARIOS:");
				System.out.println(usuarios.toString());
				System.out.println("EDICION DE USUARIOS");
				EditarUsuarios(scan, usuarios, programadores, paises);
				break;
			case 4:
				System.out.println("DEBILIDADES:");
				System.out.println(debilidades.toString());
				System.out.println("¿Desea Agregar una Debilidad? (si/no)");
				if(scan.nextLine().equals("si")){
					AgregarDebilidad(scan, debilidades);
				}
				System.out.println(debilidades.toString());
				break;
				/*
		
			• Crear una IA, programador, País: se podrán crear Una IA, Programador y País con los datos
			necesarios para cada uno
			• Dar estadísticas por países:
			o Porcentaje de IA y programadores por países según el total o
			Porcentaje de IA y programadores por Ciudad según el total
				 */
			case 0:
				break;
		}
		return menu;
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
	public static void EditarProgramador(Scanner scan, ListaProgramadores programadores, ListaPaises paises, ListaUsuarios usuarios){
		System.out.println("Ingrese el ID del programador con el que desee trabajar");
		int id = Integer.parseInt(scan.nextLine());
		int pos = (programadores.buscarID(id));
		while(pos == -1){
			System.out.println("No se encontró el Programador");
			id = Integer.parseInt(scan.nextLine());
			pos = (programadores.buscarID(id));
		}
		System.out.println(programadores.buscarProgramador(pos));
		
		System.out.println("¿Qué operación desea realizar?");
		System.out.println("1) Agregar Lenguaje \n2) Modificar Años de Experiencia \n3) Cambiar Pais "
				+ "\n4) Cambiar Ciudad \n5) Modificar ID \n6) Cambiar Nombre \n7) Cambiar Apellido \n0) Cancelar");
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
			existe = false;
			while(existe != true){
				for(int a=0;a<paises.getCantidad();a++){
					if(pais.equals(paises.buscarPais(a).getNombre())){
						existe = true;
						break;
					}
				}
				if(existe != true){
					System.out.println("Pais no existente en nuestra base de datos, intente denuevo");
					System.out.println("Escriba el nombre del nuevo Pais");
					pais = scan.nextLine();
				}
			}
			
			programadores.buscarProgramador(pos).setPais(pais);
			System.out.println(programadores.toString());
			break;
			
		case 4: //Cambiar Ciudad
			System.out.println("Escriba el nombre de la nueva Ciudad");
			String ciudad = scan.nextLine().toLowerCase();
			existe = false;
			while(existe != true){
				for(int a=0;a<paises.getCantidad();a++){
					String regiones = paises.buscarPais(a).getRegiones();
					String[] cadaCiudad = regiones.split(",");
					for(int b=0;b<cadaCiudad.length;b++){
						if((cadaCiudad[b].toLowerCase().trim()).equals(ciudad)){
							existe = true;
							break;
						}
					}
				}
				if(existe != true){
					System.out.println("Ciudad no existente en nuestra base de datos, intente denuevo");
					System.out.println("Escriba el nombre de la nueva Ciudad");
					ciudad = scan.nextLine().toLowerCase();
				}
			}
			programadores.buscarProgramador(pos).setCiudad(ciudad);
			System.out.println(programadores.toString());
			break;
			
		case 5: //Modificar ID
			
			String[] listaStr = new String[10];
			int[] ids = new int[10];
			programadores.getDato("id", listaStr, ids);
			existe = true;
			id = programadores.buscarProgramador(pos).getId();
			int nuevaId = 0;
			while(existe == true){
				existe = false;
				System.out.println("Ingrese nueva ID");
				nuevaId = Integer.parseInt(scan.nextLine());
				for(int i=0;i<ids.length;i++){
					if(nuevaId == ids[i]){
						existe = true;
						break;
					}
				}
				if(existe == true){
					System.out.println("ID ya existente, ingrese ID valida");
				}
			}
			for(int a = 0;a<usuarios.getCantidad();a++){
				if(id == usuarios.buscarUsuario(a).getId()){
					usuarios.buscarUsuario(a).setId(nuevaId);
				}
			}
			programadores.buscarProgramador(pos).setId(nuevaId);
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
	public static void EditarIAs(Scanner scan, ListaIAs ias, ListaProgramadores programadores, ListaPaises paises, ListaDebilidades debilidades){
		System.out.println("Ingrese el Nombre de la IA con la que desee trabajar");
		String nombre = scan.nextLine().toUpperCase();
		int pos = (ias.buscarNombreIA( nombre));
		while(pos == -1){
			System.out.println("No se encontró la IA");
			nombre = scan.nextLine().toUpperCase();
			pos = (ias.buscarNombreIA(nombre));
		}
		System.out.println(ias.buscarIA(pos));
		
		System.out.println("¿Qué operación desea realizar?");
		System.out.println("1) Cambiar Nombre \n2) Modificar Nivel de Peligrosidad \n3) Modificar debilidad "
				+ "\n4) Ajustar precision \n5) Cambiar Pais ID \n6) Cambiar ID del Programador \n0) Cancelar");
		int edicion = Integer.parseInt(scan.nextLine());
		edicion = Limitar(0,6,edicion,scan);
		boolean existe;
		switch(edicion){
		case 1: //Cambiar Nombre
			System.out.print("Ingrese nuevo Nombre: ");
			nombre = scan.nextLine();
			ias.buscarIA(pos).setNombre(nombre);
			System.out.println(ias.toString());
			break;
		case 2: // Modificar Nivel de Peligrosidad
			System.out.println("¿Cuál es su Nivel de Peligrosidad?");
			int amenaza = Integer.parseInt(scan.nextLine());
			ias.buscarIA(pos).setNivelDeAmenaza(amenaza);
			System.out.println(ias.toString());
			break;
		case 3: //Modificar Debilidad
			System.out.print("Ingrese La Debilidad: ");
			String debilidad = scan.nextLine().toLowerCase();
			existe = false;
			if(debilidad.equals("desconocida"))
			{
				existe = true;
			}
			boolean nivelValido = false;
			while(existe != true){
				for(int a=0;a<10;a++){
					if(debilidades.buscarDebilidad(a) != null && debilidad.equals(debilidades.buscarDebilidad(a).getDebilidad().toLowerCase())){
						existe = true;
						if(debilidades.buscarDebilidad(a).getNivelMaximo()>= ias.buscarIA(pos).getNivelDeAmenaza()){
							nivelValido = true;
						}
						break;
					}
				}
				if(existe != true){
					System.out.println("Debilidad no existente en nuestra base de datos, intente denuevo");
					System.out.println("Ingrese La Debilidad");
					debilidad = scan.nextLine().toLowerCase();
				}
				if(nivelValido != true){
					System.out.println("Nivel de amenaza mayor ");
					existe = false;
					System.out.println("Ingrese La Debilidad");
					debilidad = scan.nextLine().toLowerCase();
				}
			}
			ias.buscarIA(pos).setDebilidad(debilidad);
			System.out.println(ias.toString());
			break;
		case 4: //Ajustar Precisión
			System.out.print("Ingrese La Precision(%): ");
			int precision = Integer.parseInt(scan.nextLine());
			precision = Limitar(0,100,precision,scan);
			String precisionPorc = String.valueOf(precision)+"%";
			ias.buscarIA(pos).setPrecision(precisionPorc);
			System.out.println(ias.toString());
			break;
		case 5: //Cambiar Pais
			System.out.println("Escriba el nombre del nuevo Pais");
			String pais = scan.nextLine();
			existe = false;
			while(existe != true){
				for(int a=0;a<10;a++){
					if(paises.buscarPais(a) != null && pais.equals(paises.buscarPais(a).getNombre())){
						existe = true;
						break;
					}
				}
				if(existe != true){
					System.out.println("Pais no existente en nuestra base de datos, intente denuevo");
					System.out.println("Escriba el nombre del nuevo Pais");
					pais = scan.nextLine();
				}
			}
			
			ias.buscarIA(pos).setPais(pais);
			System.out.println(ias.toString());
			break;
		case 6://Modificar ID, Falta modificar en usuario
			String[] listaStr = new String[10];
			int[] ids = new int[10];
			existe = false;
			
			System.out.println("Ingrese nueva ID");
			int id = Integer.parseInt(scan.nextLine());
			programadores.getDato("id", listaStr, ids);
			
			for(int i=0;i<ids.length;i++){
				if(id == ids[i]){
					existe = true;
					break;
				}
			}
			while(existe != true){
				System.out.println("ID no existe, ingrese ID valida");
				id = Integer.parseInt(scan.nextLine());
				for(int i=0;i<ids.length;i++){
					if(id == ids[i]){
						existe = true;
						break;
					}
				}
			}
			ias.buscarIA(pos).setIdCreador(id);
			System.out.println(ias.toString());
			break;
			
		case 0: //Cancelar
			break;
		}
	}
	public static void AgregarIA(Scanner scan, ListaIAs ias, ListaProgramadores programadores, ListaDebilidades debilidades, ListaPaises paises){
		boolean existe = false;
		System.out.print("Ingrese nombre de la IA:");
		String nombreIA = scan.nextLine();
		System.out.print("Ingrese el lenguaje de programacion de la IA:");
		String lenguajeIA = scan.nextLine();
		System.out.print("Ingrese el nivel de amenaza de la IA:");
		int amenazaIA = Integer.parseInt(scan.nextLine());
		Limitar(1,5,amenazaIA, scan);
		String debilidadIA = "";
		while(existe != true){
			System.out.print("Ingrese la debilidad de la IA:");
			debilidadIA = scan.nextLine();
			for(int i=0;i<debilidades.getCantidad();i++){
				if(debilidadIA.equals(debilidades.buscarDebilidad(i).getDebilidad())){
					existe = true;
					break;
				}
			}
		}
		System.out.print("Ingrese el pais de la IA:");
		String paisIA = scan.nextLine();
		System.out.print("Ingrese la precision de la IA:");
		String precisionIA = scan.nextLine();
		String[] precision = precisionIA.split("%");
		int precisionInt = Integer.parseInt(precision[0]);
		Limitar(0, 100, precisionInt, scan);
		System.out.print("Ingrese el tipo de la IA:");
		int idIA = 0;
		String tipoIA = scan.nextLine();
		existe = false;
		while(existe != true){
			System.out.print("Ingrese el codigo del programador de la IA:");
			idIA = Integer.parseInt(scan.nextLine());
			for(int i=0;i<programadores.getCantidad();i++){
				if(idIA == programadores.buscarProgramador(i).getId()){
					existe = true;
					break;
				}
			}
		}
		IA ia = new IA(nombreIA, lenguajeIA, amenazaIA, debilidadIA, paisIA, precisionIA, tipoIA, idIA);
		int posicion = ias.getCantidad();
		ias.agregarIA(ia, posicion);
		System.out.println(ias.toString());
	}
	private static void CrearUsuarios(File txt,ListaUsuarios usuarios) throws FileNotFoundException{
		int contador = 0;
		Scanner leer = new Scanner(txt);
	
		while(leer.hasNextLine()){
			
			String linea = leer.nextLine();
			String partes[] = linea.split(",");
			
			String nombreCod[]  = partes[0].split("#");
			String user = nombreCod[0];
			int cod = Integer.parseInt(nombreCod[1]);
			String pass = partes[1].trim();
			int id = Integer.parseInt(partes[2].trim());

			Usuario u = new Usuario(user, cod, pass, id);
			usuarios.agregarUsuario(u, contador);
			contador++;
		}
		leer.close();
	}
	private static void EditarUsuarios(Scanner scan, ListaUsuarios usuarios, ListaProgramadores programadores, ListaPaises paises){
		System.out.println("Ingrese el Nombre del Usuario a Editar (Sin #");
		String nombre = scan.nextLine().toUpperCase();
		int pos = (usuarios.buscarNombre(nombre));
		while(pos == -1){
			System.out.println("No se encontró el Usuario");
			nombre = scan.nextLine().toUpperCase();
			pos = (usuarios.buscarNombre(nombre));
		}
		System.out.println(usuarios.buscarUsuario(pos));
		
		System.out.println("¿Que dato desea editar?");
		System.out.println("1) Cambiar Nombre \n2) Cambiar Contraseña \n3) Editar ID Programador\n0) Cancelar");
		int edicion = Integer.parseInt(scan.nextLine());
		edicion = Limitar(0,3,edicion,scan);
		
		boolean existe;
		switch(edicion){
		case 1: //Cambiar Nombre
			System.out.print("Ingrese nuevo Nombre: ");
			nombre = scan.nextLine();
			usuarios.buscarUsuario(pos).setNombre(nombre);
			System.out.println(usuarios.toString());
			break;
		case 2: // Cambiar Contraseña
			System.out.println("Ingrese Nueva Contraseña");
			String contraseña = scan.nextLine();
			usuarios.buscarUsuario(pos).setContraseña(contraseña);
			System.out.println(usuarios.toString());
			break;
		case 3: //Modificar ID
			existe = true;
			int id = usuarios.buscarUsuario(pos).getId();
			int nuevaId = 0;
			while(existe == true){
				existe = false;
				System.out.println("Ingrese nueva ID");
				nuevaId = Integer.parseInt(scan.nextLine());
				for(int i=0;i<usuarios.getCantidad();i++){
					if(nuevaId == usuarios.buscarUsuario(i).getId()){
						existe = true;
						break;
					}
				}
				for(int b = 0;b<programadores.getCantidad();b++){
					if(nuevaId == programadores.buscarProgramador(b).getId()){
						existe = true;
						break;
					}
				}
				if(existe == true){
					System.out.println("ID ya existente, ingrese ID valida");
				}
			}
			for(int a = 0; a<programadores.getCantidad();a++){
				if(id == programadores.buscarProgramador(a).getId()){
					programadores.buscarProgramador(a).setId(nuevaId);
				}
			}
			usuarios.buscarUsuario(pos).setId(nuevaId);
			System.out.println(usuarios.toString());
			System.out.println(programadores.toString());
			
			break;
		case 0: //Cancelar
			break;
		}
	}
	private static void CrearPaises(File txt, ListaPaises paises) throws FileNotFoundException {
		int contador = 0;
		Scanner leer = new Scanner(txt);
		while(leer.hasNextLine()){
			String linea = leer.nextLine();
			String partes[] = linea.split(",");
			
			String nombrePais = partes[0].trim();
			String regiones = "";
			for(int i=1;i<partes.length;i++){
				if(i != 1){
					regiones += ", ";
				}
				regiones += partes[i].trim();
			}
			
			Pais pais = new Pais(nombrePais, regiones);
			paises.agregarPais(pais, contador);
			contador++;
		}
		leer.close();
	}
	private static void CrearDebilidades(File txtDebilidades, ListaDebilidades debilidades) throws FileNotFoundException {
		int contador = 0;
		Scanner leer = new Scanner(txtDebilidades);
		while(leer.hasNextLine()){
			String linea = leer.nextLine();
			String partes[] = linea.split(",");
			
			String nombreDebilidad= partes[0].trim();
			int nivelMax = Integer.parseInt(partes[1].trim());
			
			Debilidad debilidad = new Debilidad(nombreDebilidad, nivelMax);
			debilidades.agregarDebilidad(debilidad, contador);
			contador++;
		}
		leer.close();
	}
	private static void AgregarDebilidad(Scanner scan, ListaDebilidades debilidades){
		System.out.print("Ingrese la debilidad: ");
		String nombreDebilidad = scan.nextLine();
		System.out.print("Ingrese el nivel de amenaza maximo: ");
		int nivelMaximo = Integer.parseInt(scan.nextLine());
		Debilidad deb = new Debilidad(nombreDebilidad, nivelMaximo);
		int posicion = debilidades.getCantidad();
		debilidades.agregarDebilidad(deb, posicion);
		
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