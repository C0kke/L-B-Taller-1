import java.io.*;
import java.util.*;


public class app {
	public static void main(String[] args) throws IOException {
		
		//scanners y archivos
		Scanner scan = new Scanner(System.in);
		
		File txtCreadores = new File("datos_creadores.txt");
		Scanner leer2 = new Scanner(txtCreadores);
		
		File txtUsuarios = new File("datos_usuarios.txt");
		Scanner leer3 = new Scanner(txtUsuarios);
		
		//Creacion lista IA

		
		File txtIA = new File("datos_ia.txt");
		Scanner leer1 = new Scanner(txtIA);
		
		String nombreIAs[] = new String [10];
		int añoCreacion[] = new int [10];
		int velocidades[] = new int[10];
		String tipos[] = new String [10];
		int tiposInt[] = new int[10];
		String creadores[] = new String[10];
		int cantMejoras[] = new int[10];
		
		//Creacion de listas para user/password
		String users[] = new String [10];
		String passwords[] = new String[10];
		String categorias[] = new String [10];
		
		int contador = 0;
		while(leer3.hasNextLine()){
			String linea3 = leer3.nextLine();
			String partes3[] = linea3.split(",");
			String us = partes3[0].toLowerCase();
			String pass = partes3[1];
			String rol = partes3[2];
			
			users[contador] = us;
			passwords[contador] = pass;
			categorias[contador] = rol;
			contador++;
			
		}
		
		

		//Pantalla Inicio
		System.out.println("***************************************************");
		System.out.println("	WELCOME TO I.A. AGAINST TO HUMANITY		");
		System.out.println("		Press Enter to Start				");
		System.out.println("***************************************************");
		String iniciar = scan.nextLine();
		
		
		while(!iniciar.equals("fin")){
			
			//corromper
			int datosACorromper = (int)(Math.random()*5+1);
			System.out.println("Se han corrompido " + datosACorromper + " datos" );
			System.out.println("");

			int archivoACorromper = (int) (Math.random()*3+1);
			
			switch(archivoACorromper){
				case 1:
					System.out.println("Se corrompe el archivo " + archivoACorromper);
					break;
				case 2:
					System.out.println("Se corrompe el archivo " + archivoACorromper);
					break;
				case 3:
					System.out.println("Se corrompe el archivo " + archivoACorromper);
					break;
			}
			//Verificar existencia del usuario
			System.out.println("User: ");
			String user = scan.nextLine().toLowerCase();
			System.out.println("Password: ");
			String password = scan.nextLine();
			String categoria = "";
			
			boolean valido = Login(10, user, password, users, passwords);
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
					

					
					CrearListas1(txtIA, nombreIAs, añoCreacion, velocidades, tipos, tiposInt, creadores, cantMejoras);
				
					System.out.println("Elija el menu al que desea acceder");
			        System.out.println("Opcion 1) Submenu A.I.");
			        System.out.println("Opcion 2) Submenu Users&Creators");
			            
			            int alt = Integer.parseInt(scan.nextLine());
			            
			            Limitar(1,2,alt);
			            switch(alt){
			                case 1:
				                    System.out.println("Submenu A.I.");
				                    System.out.println("");
	                        		System.out.println(Arrays.toString((nombreIAs)));
				                    System.out.println("Como desea ordenar las IA");
				                    System.out.println("1) por nombre");
				                    System.out.println("2) más reciente primero");
				                    System.out.println("3) velocidad");
				                    System.out.println("4) tipo");
				                    System.out.println("5) creador");
				                    System.out.println("6) cantidad de mejoras");
				                    int orden = Integer.parseInt(scan.nextLine());	
				                    
				                    Limitar(1,6,orden);
				                        
				                        switch(orden){
				                            case 1:
				                                OrdenarMayorAMenorStr(nombreIAs, nombreIAs);
				                        		System.out.println(Arrays.toString(nombreIAs));
				                                break;
				                            case 2:
				                                OrdenarMayorAMenorInt(añoCreacion, nombreIAs);
				                        		System.out.println(Arrays.toString(nombreIAs));
			                                break;
				                            case 3:
				                            	OrdenarMayorAMenorInt(velocidades, nombreIAs);
				                            	System.out.println(Arrays.toString(nombreIAs));
				                            	break;
				                            case 4:
				                            	OrdenarMayorAMenorInt(tiposInt, nombreIAs);
				                            	System.out.println(Arrays.toString(nombreIAs));
				                            	break;
				                            case 5:
				                            	OrdenarMayorAMenorStr(creadores, nombreIAs);
				                            	System.out.println(Arrays.toString(nombreIAs));
				                            	break;
				                            case 6:
				                            	OrdenarMayorAMenorInt(cantMejoras, nombreIAs);
				                            	System.out.println(Arrays.toString(nombreIAs));
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
			                    
			                    Limitar(1,4,alt);
			                    
			                    switch(alt){
			                        case 1:
			                            System.out.println("ver cantidad de usuarios");
			                            System.out.println("");
			                            System.out.println("1) Administrador");
			                            System.out.println("2) Normal");
			                            alt = Integer.parseInt(scan.nextLine());
			                            Limitar(1,2,alt);
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
			                    break;
			            }
				}
			}

			System.out.println("¿Desea finalizar la sesión?");
			logged = scan.nextLine();
			}

			System.out.println("Para finalizar escriba 'fin', si desea continuar, pulse Enter");
			iniciar = scan.nextLine();
			
		}
		scan.close();leer1.close();
		scan.close();leer2.close();
		scan.close();leer3.close();
	}
	private static boolean Login(int tamaño, String user, String pass, String listaUser[], String listaPassword[]){
		
		boolean valido = false;
		
		for(int i = 0; i<tamaño;i++){

			if(user.equals(listaUser[i])){
				if(pass.equals(listaPassword[i])){
					valido = true;
				}
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
	public static int Limitar(int min, int max, int var){
        Scanner scan = new Scanner(System.in);
        
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
	public static void OrdenarMayorAMenorInt(int[] lista, String[] lista2) {
	    int tamaño = lista.length;
	    for (int i = 0; i < tamaño; i++) {
	        for (int j = 1; j < tamaño; j++) {
	        	if(lista[(j-1)]<lista[j]){
	                int aux = lista[j-1];
	                String auxStr = lista2[j-1];
	                lista[j-1] = lista[j];
	                lista2[j-1] = lista2[j];
	                lista[j] = aux;
	                lista2[j] = auxStr;
	            }
	        }
	    }
	}
	private static void CrearListas1(File txt, String listaIas[], int listaAños[], int listaVelocidades[], String listaTipos[], int listaTiposInt[], String listaCreadores[], int listaMejoras[]) throws FileNotFoundException{
		int contador = 0;
		Scanner leer = new Scanner(txt);
		
		while(leer.hasNextLine()){
			String linea = leer.nextLine();
			String partes1[] = linea.split(",");
			String nombreIA = partes1[0].toLowerCase();
			int año = Integer.parseInt(partes1[1]);
			int veloz = Integer.parseInt(partes1[2]);
			String tipo = partes1[3].toLowerCase();
			int tipoInt = 0;
			String creador = partes1[4];
			int Mejora = Integer.valueOf(partes1[5]);
			
			switch(tipo){
			case "simple" :
				tipoInt = 0;
				break;
			case "media":
				tipoInt = 1;
				break;
			case "avanzada":
				tipoInt = 2;
			}
			listaIas[contador] = nombreIA;
			listaAños[contador] = año;
			listaVelocidades[contador] = veloz;
			listaTipos[contador] = tipo;
			listaTiposInt[contador] = tipoInt;
			listaCreadores[contador] = creador;
			listaMejoras[contador] = Mejora;
		contador++;
		}
		leer.close();
	}
}