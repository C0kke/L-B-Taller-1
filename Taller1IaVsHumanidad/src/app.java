import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class app {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		//Archivos para TXT de IA's
		File txtIA = new File("datos_ia.txt");
		Scanner leer1 = new Scanner(txtIA);
		String nombreIAs[] = new String [10];
		String añoCreacion[] = new String [10];
		String velocidades[] = new String[10];
		String tipos[] = new String [10];
		String tiposInt[] = new String[10];
		String creadores[] = new String[10];
		String cantMejoras[] = new String[10];
		
		//Archivos para TXT de Creadores
		File txtCreadores = new File("datos_creadores.txt");
		Scanner leer2 = new Scanner(txtCreadores);
		String[] nombresCreadores = new String[10];
		String[] experiencias = new String[10];
		String[] especialidades = new String[10]; 
		String[] edades = new String[10];
		
		//Archivos para TXT de Usuarios
		File txtUsuarios = new File("datos_usuarios.txt");
		Scanner leer3 = new Scanner(txtUsuarios);
		String users[] = new String [10];
		String passwords[] = new String[10];
		String categorias[] = new String [10];
		String creadoresUs[] = new String[10];
		
		//Pantalla Inicio
		PantallaInicio();
		String iniciar = scan.nextLine();

		while(!iniciar.equals("fin")){
			
			//Creacion de todas las listas
			CrearListas1(txtIA, nombreIAs, añoCreacion, velocidades, tipos, tiposInt, creadores, cantMejoras);
			FileWriter escribirIA = new FileWriter(txtIA, true);
			CrearListas2(txtCreadores, nombresCreadores,experiencias, especialidades, edades);
			FileWriter escribirCreadores = new FileWriter(txtCreadores,true);
			CrearListas3(txtUsuarios, users, passwords, categorias, creadoresUs);
			FileWriter escribirUsuarios = new FileWriter(txtUsuarios,true);
			
			//corromper
			int datosACorromper = (int)(Math.random()*5+1);
			int archivoACorromper = (int) (Math.random()*3+1);

			switch(archivoACorromper){
				case 1:
					FileWriter borrar1 = new FileWriter(txtIA);
					borrar1.write("");
					borrar1.close();
					System.out.println("Se corrompieron " + datosACorromper + " archivos de 'datos_ia.txt'");
					
					for(int k = 0; k < datosACorromper;k++){
						int listaCorrupta = (int)(Math.random()*6+1);
						int posCorrupta = (int)(Math.random()*(cantMejoras.length-1));
						switch(listaCorrupta){
						case 1:
							Corromper(posCorrupta, nombreIAs);
							break;
						case 2:
							Corromper(posCorrupta, añoCreacion);
							break;
						case 3:
							Corromper(posCorrupta, velocidades);
							break;
						case 4:
							Corromper(posCorrupta, tipos);
							break;
						case 5:
							Corromper(posCorrupta, creadores);
							break;
						case 6:
							Corromper(posCorrupta, cantMejoras);
							break;
						}
					}
					for(int b = 0;b<nombreIAs.length;b++){
						if(nombreIAs[b] != null){
							if(b>0){escribirIA.write("\n");}
							escribirIA.write(nombreIAs[b] + ",");
							escribirIA.write(String.valueOf(añoCreacion[b]) + ",");
							escribirIA.write(String.valueOf(velocidades[b]) + ",");
							escribirIA.write(tipos[b] + ",");
							escribirIA.write(creadores[b] + ",");
							escribirIA.write((String.valueOf(cantMejoras[b])) + ",");
						}
					}
					escribirIA.close();
					break;
				case 2:
					FileWriter borrar2 = new FileWriter(txtCreadores);
					borrar2.write("");
					borrar2.close();
					System.out.println("Se corrompieron " + datosACorromper + " archivos de 'datos_creadores.txt'");
					for(int k = 0; k < datosACorromper;k++){
						int listaCorrupta = (int)(Math.random()*4+1);
						int posCorrupta = (int)(Math.random()*(nombresCreadores.length-1));
						switch(listaCorrupta){
						case 1:
							Corromper(posCorrupta, nombresCreadores);
							break;
						case 2:
							Corromper(posCorrupta, experiencias);
							break;
						case 3:
							Corromper(posCorrupta, especialidades);
							break;
						case 4:
							Corromper(posCorrupta, edades);
							break;
						}
					}
					for(int b = 0;b<nombresCreadores.length;b++){
						if(nombresCreadores[b] != null){
							if(b>0){escribirCreadores.write("\n");}
							escribirCreadores.write(nombresCreadores[b] + ",");
							escribirCreadores.write(String.valueOf(experiencias[b]) + ",");
							escribirCreadores.write(especialidades[b] + ",");
							escribirCreadores.write(String.valueOf(edades[b]) + ",");
						}
					}
					escribirCreadores.close();
					break;
				case 3:
					FileWriter borrar3 = new FileWriter(txtUsuarios);
					borrar3.write("");
					borrar3.close();
					System.out.println("Se corrompieron " + datosACorromper + " archivos de 'datos_usuarios.txt'");
					for(int k = 0; k < datosACorromper;k++){
						int listaCorrupta = (int)(Math.random()*4+1);
						int posCorrupta = (int)(Math.random()*(users.length-1));
						switch(listaCorrupta){
						case 1:
							Corromper(posCorrupta, users);
							break;
						case 2:
							Corromper(posCorrupta, passwords);
							break;
						case 3:
							Corromper(posCorrupta, categorias);
							break;
						case 4:
							Corromper(posCorrupta, creadoresUs);
							break;
						}
					}
					for(int b = 0;b<users.length;b++){
						if(users[b] != null){
							if(b>0){escribirUsuarios.write("\n");}
							escribirUsuarios.write(users[b] + ",");
							escribirUsuarios.write(passwords[b] + ",");
							escribirUsuarios.write(categorias[b] + ",");
							escribirUsuarios.write(creadoresUs[b] + ",");
						}
					}
					escribirUsuarios.close();
					break;
			}
			//Verificar existencia del usuario
			System.out.println("\nLOGIN");
			System.out.println("\nUser: ");
			String user = scan.nextLine().toLowerCase();
			System.out.println("Password: ");
			String password = scan.nextLine();
			String categoria = "";
			
			boolean valido = Login(users.length, user, password, users, passwords);
			categoria = IndicarCategoria(user, users, passwords, password, categorias, categoria);
			
			if(valido == false){
				System.out.println("Acceso Denegado");
			}else{
				System.out.println("Acceso Correcto");

				//Login correcto, iniciar programa
				
				String logged = "";
				while(!logged.equals("si")){
					
					if (categoria.equals("normal")){
						
					}else if (categoria.equals("administrador")){
						
						System.out.println("\nElija el menu al que desea acceder");
						System.out.println("\nOpcion 1) Submenu A.I.");
						System.out.println("Opcion 2) Submenu Users&Creators");
			        
						int alt = Integer.parseInt(scan.nextLine());
						
						alt = Limitar(1,2,alt,scan);
						
			            switch(alt){
			                case 1:
			                	System.out.println("SUBMENÚ I.A.\n");
			                	System.out.println(PrintListaStr(nombreIAs));
				                System.out.println("\n¿Cómo desea ordenar las IA?\n");
				                System.out.println("1) Por nombre");
				                System.out.println("2) Más reciente primero");
				                System.out.println("3) Por velocidad");
				                System.out.println("4) Por tipo");
				                System.out.println("5) Por nombre del creador");
				                System.out.println("6) Por cantidad de mejoras");
				                int orden = Integer.parseInt(scan.nextLine());
				                orden = Limitar(1,6,orden,scan);
				                switch(orden){
				                case 1:
				                	OrdenarMayorAMenorStr(nombreIAs, nombreIAs);
				                	System.out.println(PrintListaStr(nombreIAs));
				                    break;
				                case 2:
				                	OrdenarMayorAMenorStr(añoCreacion, nombreIAs);
				                	System.out.println(PrintListaStr(nombreIAs));
				                	System.out.println(PrintListaStr(añoCreacion));
				                	break;
				                case 3:
				                	OrdenarMayorAMenorStr(velocidades, nombreIAs);
				                	System.out.println(PrintListaStr(nombreIAs));
				                	System.out.println(PrintListaStr(velocidades));
				                	break;
				                case 4:
				                	OrdenarMayorAMenorStr(tiposInt, nombreIAs);
				                	System.out.println(PrintListaStr(nombreIAs));
				                	System.out.println(PrintListaStr(tiposInt));
				                    break;
				                case 5:
				                	OrdenarMayorAMenorStr(creadores, nombreIAs);
				                	System.out.println(PrintListaStr(nombreIAs));
				                	System.out.println(PrintListaStr(creadores));
				                	break;
				                case 6:
				                	OrdenarMayorAMenorStr(cantMejoras, nombreIAs);
				                	System.out.println(PrintListaStr(nombreIAs));
				                	System.out.println(PrintListaStr(cantMejoras));
				                	break;
				                	}
				                break;
			                case 2:
			                    System.out.println("Submenu Users&Creators");
			                    System.out.println("");
			                    System.out.println("Que desea hacer");
			                    System.out.println("1) ver usuarios");
			                    System.out.println("2) anadir usuario o creador");
			                    System.out.println("3) editar usuario o creador");
			                    System.out.println("4) eliminar usuario o creador");
			                    alt = Integer.parseInt(scan.nextLine());
			                    alt = Limitar(1,4,alt,scan);
			                    
			                    switch(alt){
			                        case 1:
			                            System.out.println("ver cantidad de usuarios");
			                            System.out.println("");
			                            System.out.println("1) Administrador");
			                            System.out.println("2) Normal");
			                            alt = Integer.parseInt(scan.nextLine());
			                            alt = Limitar(1,2,alt,scan);
			                            switch(alt){
			                                case 1:
			                                    System.out.println("Administradores = (total), (%)");  
			                                    break;
			                                case 2:
			                                    System.out.println("Usuarios Normales = (total), (%)");
			                                    break;
			                            }
			                            break;
			                        case 2:
			                            System.out.println("Anadir usuario o creador");
			                            System.out.println("");
			                            System.out.println("Ingrese nombre de usuario");
			                            String NomUsuarioCreado = scan.nextLine();
			                            System.out.println("Ingrese contrasena del usuario");
			                            String PassUsuarioCreado = scan.nextLine();
			                            System.out.println("Ingrese la categoria del usuario");
			                            String CategoriaUsuarioCreado = scan.nextLine();
			                            System.out.println("nombre del creador del usuario");
			                            String CreadorUsuarioCreado = scan.nextLine();
			                            System.out.println(NomUsuarioCreado + ", " + PassUsuarioCreado + ", " +  CategoriaUsuarioCreado + ", " + CreadorUsuarioCreado);
			                            break;
			                        case 3:
			                            System.out.println("editar usuario o creador");
			                            System.out.println("Usuario a buscar");
			                            String NomUsuarioBuscado = scan.nextLine();
			                            
			                            break;
			                        case 4:
			                            System.out.println("eliminar usuario o creador");
			                            System.out.println("");
			                            System.out.println("Usuario a buscar");
			                            NomUsuarioBuscado = scan.nextLine().toLowerCase();
			                            
			                            break;
			                    		}
			            		}
					}

					
					CrearListas1(txtIA, nombreIAs, añoCreacion, velocidades, tipos, tiposInt, creadores, cantMejoras);
					CrearListas2(txtCreadores, nombresCreadores,experiencias, especialidades, edades);
					CrearListas3(txtUsuarios, users, passwords, categorias, creadoresUs);
					
					System.out.println("¿Desea finalizar la sesión?");
					logged = scan.nextLine();
				}
			}

			System.out.println("Sesion finalizada, escriba 'fin' para terminar el programa");
			iniciar = scan.nextLine();
			
		}
		scan.close();leer1.close();
		scan.close();leer2.close();
		scan.close();leer3.close();
	}
	private static void PantallaInicio(){
		System.out.println("**************************************************");
		System.out.println("*            I.A. AGAINST TO HUMANITY	   	 *");
		System.out.println("*     Presiona cualquier tecla para comenzar	 *");
		System.out.println("**************************************************");
	}
	private static boolean Login(int tamaño, String user, String pass, String listaUser[], String listaPassword[]){
		
		boolean valido = false;
		for(int i = 0; i<tamaño;i++){
			if(listaUser[i] != null && user.equals(listaUser[i]) && pass.equals(listaPassword[i])){
				valido = true;
			}
		}
		return valido;
	}
	private static String IndicarCategoria(String user, String listaUser[], String listaPassword[], String password, String lista[], String var){
		for(int i = 0; i<10;i++){
			if(user.equals(listaUser[i])){
				if(password.equals(listaPassword[i])){
					 var = lista[i];
					}
				}
			}
		return var;
	}	
	public static int Limitar(int min, int max, int var, Scanner scan){
        while(var < min || var > max){
            System.out.println("Ingrese una opcion valida");
            var = Integer.parseInt(scan.nextLine());
        }
        return var;
	}
	public static void OrdenarMayorAMenorStr(String[] lista, String[] lista2) {
	    int tamaño = lista.length;
	    for (int i = 0; i < tamaño; i++) {
	    	for (int j = 1; j < tamaño; j++) {
	        	if(lista[(j-1)] != null && lista[j] != null && (int)(lista[(j-1)].compareTo(lista[j])) < 0){
	                String aux = lista[j-1];
	                lista[j-1] = lista[j];
	                lista[j] = aux;
	                if(!lista.equals(lista2)){
	                	String auxStr = lista2[j-1];
	                	lista2[j-1] = lista2[j];
	                	lista2[j] = auxStr;
	                }
	            }
	        }
	    }
	}
	private static void CrearListas1(File txt, String listaIas[], String listaAños[], String listaVelocidades[], String listaTipos[], String listaTiposInt[], String listaCreadores[], String listaMejoras[]) throws FileNotFoundException{
		int contador = 0;
		Scanner leer = new Scanner(txt);
		while(leer.hasNextLine()){
			String linea = leer.nextLine();
			String partes1[] = linea.split(",");
			String nombreIA = partes1[0].toLowerCase().trim();
			String año = partes1[1].trim();
			String veloz = partes1[2].trim();
			String tipo = partes1[3].toLowerCase().trim();
			int tipoInt = 0;
			String creador = partes1[4].trim();
			String mejora = partes1[5].trim();
			
			switch(tipo){
			case "simple" :
				tipoInt = 1;
				break;
			case "media":
				tipoInt = 2;
				break;
			case "avanzada":
				tipoInt = 3;
			}
			listaIas[contador] = nombreIA;
			listaAños[contador] = String.valueOf(año);
			listaVelocidades[contador] = String.valueOf(veloz);
			listaTipos[contador] = tipo;
			listaTiposInt[contador] = String.valueOf(tipoInt);
			listaCreadores[contador] = creador;
			listaMejoras[contador] = String.valueOf(mejora);
		contador++;
		}
		leer.close();
	}
	private static void CrearListas2(File txt, String nombres[],String xps[],  String roles[], String edades[]) throws FileNotFoundException{
		int contador = 0;
		Scanner leer = new Scanner(txt);
	
		while(leer.hasNextLine()){
			String linea = leer.nextLine();
			String partes3[] = linea.split(",");
			String nombre = partes3[0].toLowerCase().trim();
			String exp = partes3[1].trim();
			String rol = partes3[2].trim();
			String edad = partes3[3].trim();
			
			nombres[contador] = nombre;
			xps[contador] = exp;
			roles[contador] = rol;
			edades[contador] =  String.valueOf(edad);
			contador++;
		}
		leer.close();
	}
	private static void CrearListas3(File txt, String users[],String passwords[],  String categorias[],  String creadores[]) throws FileNotFoundException{
		int contador = 0;
		Scanner leer = new Scanner(txt);
	
		while(leer.hasNextLine()){
			String linea = leer.nextLine();
			String partes3[] = linea.split(",");
			String us = partes3[0].toLowerCase().trim();
			String pass = partes3[1].trim();
			String rol = partes3[2].trim();
			String creator = partes3[3].trim();
			
			users[contador] = us;
			passwords[contador] = pass;
			categorias[contador] = rol;
			creadores[contador] = creator;
			contador++;
		}
		leer.close();
	}
	private static String PrintListaStr(String[] lista){
		String listaFinal = "[";
		for(int i = 0; i<lista.length;i++){
			if(lista[i] != null){
				if(i>0){
					listaFinal += ", ";
				}
				listaFinal += lista[i]; 
			}
		}
		listaFinal +="]";
		return listaFinal;
	}
	private static void Corromper(int posicion, String[] lista){
		while(lista[posicion] == null){
			posicion = (int)(Math.random()*(lista.length-1));
		}
		lista[posicion] = "¡@IA¿WIN$#";
	}
}