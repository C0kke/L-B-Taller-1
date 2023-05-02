import java.io.*;
import java.util.*;


public class app {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		//Pantalla Inicio
		PantallaInicio();
		String inicio = scan.nextLine();

		//Archivos para TXT de IA's
		File txtIA = new File("datos_ia.txt");
		FileWriter escribirIA = new FileWriter(txtIA, true);
		String nombreIAs[] = new String [100];
		String añoCreacion[] = new String [100];
		String velocidades[] = new String[100];
		String tipos[] = new String [100];
		String tiposInt[] = new String[100];
		String creadores[] = new String[100];
		String cantMejoras[] = new String[100];
		CrearListas1(txtIA, nombreIAs, añoCreacion, velocidades, tipos, tiposInt, creadores, cantMejoras);
		
		//Archivos para TXT de Creadores
		File txtCreadores = new File("datos_creadores.txt");
		FileWriter escribirCreadores = new FileWriter(txtCreadores,true);
		String[] nombresCreadores = new String[100];
		String[] experiencias = new String[100];
		String[] especialidades = new String[100]; 
		String[] edades = new String[100];
		CrearListas2(txtCreadores, nombresCreadores,experiencias, especialidades, edades);
		
		//Archivos para TXT de Usuarios
		File txtUsuarios = new File("datos_usuarios.txt");
		FileWriter escribirUsuarios = new FileWriter(txtUsuarios,true);
		String users[] = new String [100];
		String passwords[] = new String[100];
		String categorias[] = new String [100];
		String creadoresUs[] = new String[100];
		CrearListas3(txtUsuarios, users, passwords, categorias, creadoresUs);
		
		//Verificar existencia del usuario
		System.out.println("LOGIN");
		System.out.println("\nUser: ");
		String user = scan.nextLine().toLowerCase();
		System.out.println("Password: ");
		String password = scan.nextLine();
		String categoria = "";
			
		boolean valido = Login(users.length, user, password, users, passwords);
		categoria = IndicarCategoria(user, users, passwords, password, categorias, categoria);
			
		while(valido == false){
			System.out.println("Credeciales inválidas,");
			System.out.println("\nUser: ");
			user = scan.nextLine().toLowerCase();
			System.out.println("Password: ");
			password = scan.nextLine();
			categoria = "";
				
			valido = Login(users.length, user, password, users, passwords);
			categoria = IndicarCategoria(user, users, passwords, password, categorias, categoria);
		}
		if(valido == true){
			System.out.println("Acceso Correcto");

			//Login correcto, iniciar programa
			while(!inicio.equals("si")){
				if (categoria.equals("normal")){
					//para normal
				}else if (categoria.equals("administrador")){
					//para admin

					System.out.println("\nElija el menu al que desea acceder");
					System.out.println("\nOpcion 1) Submenu A.I.");
					System.out.println("Opcion 2) Submenu Users&Creators");
					int alt = Integer.parseInt(scan.nextLine());
					alt = Limitar(1,2,alt,scan);
		            switch(alt){
		            	//Submenú IA
		                case 1:
		                	System.out.println("SUBMENÚ I.A.");
			                System.out.println("Edición de I.A.'s");
		                	
			                System.out.println("¿Cómo desea ordenarlas?\n");
			                System.out.println("1) Por nombre");
			                System.out.println("2) Más reciente primero");    
			                System.out.println("3) Por velocidad");
			                System.out.println("4) Por tipo");
			                System.out.println("5) Por nombre del creador");
			                System.out.println("6) Por cantidad de mejoras");
			                System.out.println("0) atrás");
			                
			                int orden = Integer.parseInt(scan.nextLine());
			                orden = Limitar(0,6,orden,scan);    
			                if(orden == 0){
				                	break;
				                }
			                switch(orden){
			                //Ordenar las listas
				            case 1:
				            	OrdenarMayorAMenorStr(nombreIAs,añoCreacion,velocidades,tipos,creadores,cantMejoras, tiposInt);
				                PrintListaStr(nombreIAs);
				                break;
				            case 2:
				            	OrdenarMayorAMenorStr(añoCreacion, nombreIAs,velocidades,tipos,creadores,cantMejoras,tiposInt);
				            	PrintListaStr(nombreIAs);
				            	PrintListaStr(añoCreacion);
				            	break;
				            case 3:
				            	OrdenarMayorAMenorStr(velocidades,nombreIAs,tipos,creadores,cantMejoras,añoCreacion,tiposInt);
				            	PrintListaStr(nombreIAs);
				            	PrintListaStr(velocidades);
				            	break;
				            case 4:
				            	OrdenarMayorAMenorStr(tiposInt,nombreIAs,tipos,creadores,cantMejoras,añoCreacion,velocidades);
				                PrintListaStr(nombreIAs);
				                PrintListaStr(tipos);
				                break;
				            case 5:
				            	OrdenarMayorAMenorStr(creadores,nombreIAs,tipos,cantMejoras,añoCreacion,velocidades,tiposInt);
				                PrintListaStr(nombreIAs);
				                PrintListaStr(creadores);
				                break;
				            case 6:
				               	OrdenarMayorAMenorStr(cantMejoras,nombreIAs,tipos,añoCreacion,velocidades,creadores,tiposInt);
				               	PrintListaStr(nombreIAs);
				               	PrintListaStr(cantMejoras);
				               	break;
				               	}
			                //Editar las listas
			                System.out.print("Ingrese el nombre de la I.A. que desea editar: ");
			                String editarIA = scan.nextLine().toLowerCase();
			                int posicion = Buscar(nombreIAs, nombreIAs.length, editarIA);
			                while(posicion == nombreIAs.length){
			                	System.out.println("no se encontró la I.A, intente denuevo");
			                	editarIA = scan.nextLine().toLowerCase();
			                	posicion = Buscar(nombreIAs, nombreIAs.length, editarIA);
			                }	
			                System.out.println("¿Qué desea editar?");
			                System.out.println("1) Nombre: " + nombreIAs[posicion]);
			                System.out.println("2) Año de creaión: " + añoCreacion[posicion]);
			                System.out.println("3) Velocidad de aprendizaje: "+ velocidades[posicion] + " días");
			                System.out.println("4) Tipo de I.A.: " + tipos[posicion]);
			                System.out.println("5) Creador: "+creadores[posicion]);
			                System.out.println("6) Fue mejorada " + cantMejoras[posicion] + " veces");
			                System.out.println("0) Volver atrás");
			                int mod = Integer.parseInt(scan.nextLine());
			                mod = Limitar(0,6,mod,scan);   	
			                if(mod == 0){
			                	break;
			                }
			                switch(mod){
			                case 1:
			                	System.out.println("Ingrese un nuevo nombre :");
			                	String nuevoNombreIA = scan.nextLine();
			                	nombreIAs[posicion] = nuevoNombreIA;
			                	break;
			                case 2:
			                	System.out.println("¿En qué año se creó?");
			                	String nuevoAñoIA = scan.nextLine();
			                	añoCreacion[posicion] = nuevoAñoIA;
			                	break;
			                case 3:
			                	if(velocidades[posicion].equals("¡@IA¿WIN$#")){
			                		System.out.println("¡[0RrVp73Q>!");
			                	}else{
			                		System.out.println("Ingrese nueva velocidad");
			                		String nuevaVelocidadIA = scan.nextLine();
			                		velocidades[posicion] = nuevaVelocidadIA;
			                	}
			                	break;
			                case 4:
			                	System.out.println("Ingrese el tipo de la IA: ");
			                	String nuevoTipoIA = scan.nextLine();
			                	tipos[posicion] = nuevoTipoIA;
			                	break;
			                case 5:
			                	System.out.println("¿Quién creó esta IA?");
			                	String nuevoCreadorIA = scan.nextLine();
			                	creadores[posicion] = nuevoCreadorIA;
			                	break;
			                case 6:
			                	if(cantMejoras[posicion].equals("¡@IA¿WIN$#")){
			                		System.out.println("¡[0RrVp73Q>!");
			                	}else{
			                	System.out.println("¿Cuántas veces ha sido mejorada?");
			                	String nuevaMejoraIA = scan.nextLine();
			                	cantMejoras[posicion] = nuevaMejoraIA;
			                }
			                	break;
			                }
			                break;
			                //Submenú Usuarios y creadores
		                case 2:
		                    System.out.println("Submenu Usuarios y Creadores");
		                    System.out.println("");
		                    System.out.println("Que desea hacer");
		                    System.out.println("1) Ver usuarios");
		                    System.out.println("2) Añadir usuario/creador");
		                    System.out.println("3) Editar usuario/creador");
		                    System.out.println("4) Eliminar usuario/creador");
		                    alt = Integer.parseInt(scan.nextLine());
		                    alt = Limitar(1,4,alt,scan);
		                    
		                    switch(alt){
		                        case 1:
		                            System.out.println("¿Qué tipo de usuario desea ver?: ");
		                            System.out.println("");
		                            System.out.println("1) Administrador");
		                            System.out.println("2) Normal");
		                            alt = Integer.parseInt(scan.nextLine());
		                            alt = Limitar(1,2,alt,scan);
		                            switch(alt){
		                                case 1:
				                            String[] listaAdmin = new String[100];
				                            int tam=0;
				                            int max = DeterminarCantElementos(categorias);
				                            for(int i=0;i<users.length;i++){
				                            	if(categorias[i]!=(null)){
				                            		if(categorias[i].equals("administrador")){
				                            			listaAdmin[tam] = users[i];
				                            			tam++;
				                            		}
				                            	}
				                            }
				                            int porcAdmin = tam * 100 / max; 
				                            PrintListaStr(listaAdmin);  
			                                System.out.println("Los Administradores son el "+ porcAdmin+" % de los usuarios");
			                            	break;
		                                case 2:
		                                	String[] listaUser = new String[100];
		                                	tam=0;
		                                	max = DeterminarCantElementos(categorias);
		                                	for(int i=0;i<users.length;i++){
				                            	if(categorias[i]!=(null)){
				                            		if(categorias[i].equals("normal")){
				                            			listaUser[tam] = users[i];
				                            			tam++;
				                            		}
				                            		max++;
				                            	}
				                            }
				                            int porcUser = tam * 100 / max; 
				                            PrintListaStr(listaUser);  
			                                System.out.println("Los Usuarios nomales son el "+ porcUser+" % de los usuarios");
		                                    break;
		                            }
		                            break;
		                        case 2:
		                        	int tamaño = DeterminarCantElementos(users);
		                            System.out.println("Añadir usuario o creador\n");
		                            System.out.println("¿Desea agregar un (1)usuario o un (2)creador?");
		                            int seleccion = Integer.parseInt(scan.nextLine());
		                            seleccion = Limitar(1, 2, seleccion, scan);
		                            switch(seleccion){
		                            	case 1:
		                            		System.out.println("Ingrese nombre de usuario");
		                            		String NomUsuarioCreado = scan.nextLine();
		                            		users[tamaño+1] = NomUsuarioCreado;
		                            		System.out.println("Ingrese contrasena del usuario");
		                            		String PassUsuarioCreado = scan.nextLine();
		                            		passwords[tamaño+1] = PassUsuarioCreado;
		                            		System.out.println("Ingrese la categoria del usuario");
		                            		String CategoriaUsuarioCreado = scan.nextLine();
		                            		categorias[tamaño+1] = CategoriaUsuarioCreado;
		                            		System.out.println("nombre del creador del usuario");
		                            		String CreadorUsuarioCreado = scan.nextLine();
		                            		creadoresUs[tamaño+1] = CreadorUsuarioCreado;
		                            		System.out.println(users[tamaño+1]+","+passwords[tamaño+1]+","+categorias[tamaño+1]+","+creadoresUs[tamaño+1]);
		                            		break;
		                            	case 2:
		                            		System.out.println("Ingrese nombre del creador");
		                            		String nomCreadorCreado = scan.nextLine();
		                            		nombresCreadores[tamaño+1] = nomCreadorCreado;
		                            		System.out.println("Ingrese días de experiencia del creador");
		                            		String experienciaCreadorCreado = scan.nextLine();
		                            		experiencias[tamaño+1] = experienciaCreadorCreado;
		                            		System.out.println("Ingrese la especialidad del creador");
		                            		String especialidadCreadorCreado = scan.nextLine();
		                            		especialidades[tamaño+1] = especialidadCreadorCreado;
		                            		System.out.println("Ingrese la edad del creador");
		                            		String edadUsuarioCreado = scan.nextLine();
		                            		edades[tamaño+1] = edadUsuarioCreado;
		                            		break;
		                            }
		                            break;
		                       case 3:
		                            System.out.println("Editar usuario o creador\n");
		                            System.out.println("¿Desea editar un (1)usuario o un (2)creador?");
		                            seleccion = Integer.parseInt(scan.nextLine());
		                            seleccion = Limitar(1, 2, seleccion, scan);
		                            switch(seleccion){
	                            	case 1:
	                            		PrintListaStr(users);
	                            		System.out.println("Ingrese nombre de usuario a editar");
	                            		String editarUs = scan.nextLine();
					                	posicion = Buscar(users, users.length, editarUs);
	                            		while(posicion == users.length){
						                	System.out.println("El usuario " + editarUs + " no existe, intente denuevo");
						                	editarUs = scan.nextLine().toLowerCase();
						                }
	                            		System.out.println("¿Qué desea editar?");
	        			                System.out.println("1) Nombre: " + users[posicion]);
	        			                System.out.println("2) Contraseña: " + passwords[posicion]);
	        			                System.out.println("3) Tipo de Usuario: "+ tipos[posicion]);
	        			                System.out.println("4) Creador: " + creadoresUs[posicion]);
	        			                System.out.println("0) Volver atrás");
	        			                mod = Integer.parseInt(scan.nextLine());
						                mod = Limitar(0,4,mod,scan);   	
						                if(mod == 0){
						                	break;
						                }
						                switch(mod){
						                case 1:
						                	if(users[posicion].equals("¡@IA¿WIN$#")){
						                		System.out.println("¡[0RrVp73Q>!");
						                	}else{
						                		System.out.println("Ingrese un nuevo nombre :");
						                		String nuevoNombreUs = scan.nextLine();
						                		users[posicion] = nuevoNombreUs;
						                	}
						                	break;
						                case 2:
						                	System.out.println("Ingrese nueva contraseña");
						                	String nuevaPass = scan.nextLine();
						                	passwords[posicion] = nuevaPass;
						                	break;
						                case 3:
						                	System.out.println("Ingrese el tipo de Usuario: ");
						                	String nuevoTipoUs = scan.nextLine();
						                	tipos[posicion] = nuevoTipoUs;
						                	break;
						                case 4:
						                	System.out.println("¿Quién creó a este Usuario?");
						                	String nuevoCreadorUs = scan.nextLine();
						                	creadoresUs[posicion] = nuevoCreadorUs;
						                	break;
						                }
	        			                break;
	                            	case 2:
	                            		PrintListaStr(creadores);
	                            		System.out.println("Ingrese nombre del Creador a editar");
	                            		String editarCreador = scan.nextLine();
					                	posicion = Buscar(creadores, creadores.length, editarCreador);
	                            		while(posicion == creadores.length){
						                	System.out.println("El Creador " + editarCreador + " no existe, intente denuevo");
						                	editarCreador = scan.nextLine().toLowerCase();
						                }
	                            		System.out.println("¿Qué desea editar?");
	        			                System.out.println("1) Nombre: " + nombresCreadores[posicion]);
	        			                System.out.println("2) Experiencia: " + experiencias[posicion] + " días");
	        			                System.out.println("3) Especialidad: "+ especialidades[posicion]);
	        			                System.out.println("4) Edad: " + edades[posicion]);
	        			                System.out.println("0) Volver atrás");
	        			                mod = Integer.parseInt(scan.nextLine());
						                mod = Limitar(0,4,mod,scan);   	
						                if(mod == 0){
						                	break;
						                }
						                switch(mod){
						                case 1:
						                	if(nombresCreadores[posicion].equals("¡@IA¿WIN$#")){
						                		System.out.println("¡[0RrVp73Q>!");
						                	}else{
						                		System.out.println("Ingrese un nuevo nombre :");
						                		String nuevoNombreCreador = scan.nextLine();
						                		nombresCreadores[posicion] = nuevoNombreCreador;
						                	}
						                	break;
						                case 2:
						                	System.out.println("Ingrese nueva experiencia (dias)");
						                	String nuevaExp = scan.nextLine();
						                	experiencias[posicion] = nuevaExp;
						                	break;
						                case 3:
						                	System.out.println("Ingrese la Especialidad del Creador: ");
						                	String nuevaEspecialidad = scan.nextLine();
						                	especialidades[posicion] = nuevaEspecialidad;
						                	break;
						                case 4:
						                	System.out.println("¿Cuál es la edad?");
						                	String nuevaEdad = scan.nextLine();
						                	edades[posicion] = nuevaEdad;
						                	break;
						                }
						                break;
	                            }
	                            break;
		                        case 4:
		                            System.out.println("eliminar usuario o creador");
		                            System.out.println("");
		                            System.out.println("Usuario a buscar");
		                            
		                            break;
			                    		}
		            		}
				}
				System.out.println("¿Desea finalizar la sesión?");
				inicio = scan.nextLine();
			}
		}
		
		//corromperTXT
		
		int datosACorromper = (int)(Math.random()*5+1);
		int archivoACorromper = (int) (Math.random()*3+1);

		switch(archivoACorromper){
			case 1:
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
					break;
				case 2:
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
					break;
				case 3:
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
				break;
			}
		
		//reescribir txt's
		int b;
		FileWriter borrar1 = new FileWriter(txtIA);
		borrar1.write("");
		borrar1.close();
		for(b = 0;b<nombreIAs.length;b++){
			if(nombreIAs[b] != null){
				if(b>0){escribirIA.write("\n");}
				escribirIA.write(nombreIAs[b] + ",");
				escribirIA.write(String.valueOf(añoCreacion[b]) + ",");
				escribirIA.write(String.valueOf(velocidades[b]) + ",");
				escribirIA.write(tipos[b] + ",");
				escribirIA.write(creadores[b] + ",");
				escribirIA.write((String.valueOf(cantMejoras[b])));
			}
		}
		FileWriter borrar2 = new FileWriter(txtCreadores);
		borrar2.write("");
		borrar2.close();;
		for(b = 0;b<nombresCreadores.length;b++){
			if(nombresCreadores[b] != null){
				if(b>0){escribirCreadores.write("\n");}
				escribirCreadores.write(nombresCreadores[b] + ",");
				escribirCreadores.write(String.valueOf(experiencias[b]) + ",");
				escribirCreadores.write(especialidades[b] + ",");
				escribirCreadores.write(String.valueOf(edades[b]));
			}
		}
		FileWriter borrar3 = new FileWriter(txtUsuarios);
		borrar3.write("");
		borrar3.close();
		for(b = 0;b<users.length;b++){
			if(users[b] != null){
				if(b>0){escribirUsuarios.write("\n");}
				escribirUsuarios.write(users[b] + ",");
				escribirUsuarios.write(passwords[b] + ",");
				escribirUsuarios.write(categorias[b] + ",");
				escribirUsuarios.write(creadoresUs[b]);
			}
		}

		escribirIA.close();
		escribirCreadores.close();
		escribirUsuarios.close();
	}
	private static int DeterminarCantElementos(String[] lista) {
		int tamaño = 0;
		for(int i=0; i<lista.length;i++){
			if(lista[i] != null){
			tamaño++;
			}
		}
		return tamaño;
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
	public static void OrdenarMayorAMenorStr(String[] lista, String[] lista2, String lista3[], String lista4[],String lista5[],String lista6[], String lista7[]) {
	    int tamaño = lista.length;
	    for (int i = 0; i < tamaño; i++) {
	    	for (int j = 1; j < tamaño; j++) {
	        	if(lista[(j-1)] != null && lista[j] != null && (int)(lista[(j-1)].compareTo(lista[j])) < 0){
	                String temp1 = lista[j-1];
	                lista[j-1] = lista[j];
	                lista[j] = temp1;
	                String temp2 = lista2[j-1];
	                lista2[j-1] = lista2[j];
	                lista2[j] = temp2;
	                String temp3 = lista3[j-1];
	                lista3[j-1] = lista3[j];
	                lista3[j] = temp3;
	                String temp4 = lista4[j-1];
	                lista4[j-1] = lista4[j];
	                lista4[j] = temp4;
	                String temp5 = lista5[j-1];
	                lista5[j-1] = lista5[j];
	                lista5[j] = temp5;
	                String temp6 = lista6[j-1];
	                lista6[j-1] = lista6[j];
	                lista6[j] = temp6;
                	String temp7 = lista7[j-1];
                	lista7[j-1] = lista7[j];
                	lista7[j] = temp7;
	            }
	        }
	    }
	}
	private static void CrearListas1(File txt, String listaIas[], String listaAños[], String listaVelocidades[], String listaTipos[], String listaTiposInt[], String listaCreadores[], String listaMejoras[]) throws FileNotFoundException{
		int contador = 0;
		int datosCorruptos = 0;
		Scanner leer = new Scanner(txt);
		
		while(leer.hasNextLine()){
			String linea = leer.nextLine();
			String partes1[] = linea.split(",");
			String nombreIA = partes1[0].trim();
			if(nombreIA.equals("¡@IA¿WIN$#")){
				datosCorruptos++;
			}
			String año = partes1[1].trim();
			if(año.equals("¡@IA¿WIN$#")){
				datosCorruptos++;
			}
			String veloz = partes1[2].trim();
			if(veloz.equals("¡@IA¿WIN$#")){
				datosCorruptos++;
			}
			String tipo = partes1[3].trim();
			if(tipo.equals("¡@IA¿WIN$#")){
				datosCorruptos++;
			}
			int tipoInt = 0;
			String creador = partes1[4].trim();
			if(creador.equals("¡@IA¿WIN$#")){
				datosCorruptos++;
			}
			String mejora = partes1[5].trim();
			if(mejora.equals("¡@IA¿WIN$#")){
				datosCorruptos++;
			}
			switch(tipo){
			case "simple" :
				tipoInt = 1;
				break;
			case "media":
				tipoInt = 2;
				break;
			case "avanzada":
				tipoInt = 3;
				break;
			}
			listaIas[contador] = nombreIA.toLowerCase();
			listaAños[contador] = String.valueOf(año);
			listaVelocidades[contador] = String.valueOf(veloz);
			listaTipos[contador] = tipo.toLowerCase();
			listaTiposInt[contador] = String.valueOf(tipoInt);
			listaCreadores[contador] = creador.toLowerCase();
			listaMejoras[contador] = String.valueOf(mejora);
		contador++;
		}
		leer.close();
		if(datosCorruptos >0){
			System.out.println("Datos afectados de 'datos_ia.txt': " + datosCorruptos + "\n");;
		}
	}
	private static void CrearListas2(File txt, String nombres[],String xps[],  String roles[], String edades[]) throws FileNotFoundException{
		int contador = 0;
		int datosCorruptos = 0;
		Scanner leer = new Scanner(txt);
	
		while(leer.hasNextLine()){
			String linea = leer.nextLine();
			String partes2[] = linea.split(",");
			String nombre = partes2[0].trim();
			if(nombre.equals("¡@IA¿WIN$#")){
				datosCorruptos++;
			}
			String exp = partes2[1].trim();
			if(exp.equals("¡@IA¿WIN$#")){
				datosCorruptos++;
			}
			String rol = partes2[2].trim();
			if(rol.equals("¡@IA¿WIN$#")){
				datosCorruptos++;
			}
			String edad = partes2[3].trim();
			if(edad.equals("¡@IA¿WIN$#")){
				datosCorruptos++;
			}
			nombres[contador] = nombre.toLowerCase();
			xps[contador] = String.valueOf(exp);
			roles[contador] = rol.toLowerCase();
			edades[contador] =  String.valueOf(edad);
			contador++;
		}
		leer.close();
		if(datosCorruptos >0){
			System.out.println("Datos afectados de 'datos_creadores.txt': " + datosCorruptos + "\n");;
		}
	}
	private static void CrearListas3(File txt, String users[],String passwords[],  String categorias[],  String creadores[]) throws FileNotFoundException{
		int contador = 0;
		int datosCorruptos = 0;
		Scanner leer = new Scanner(txt);
	
		while(leer.hasNextLine()){
			String linea = leer.nextLine();
			String partes3[] = linea.split(",");
			String us = partes3[0].trim();
			if(us.equals("¡@IA¿WIN$#")){
				datosCorruptos++;
			}
			String pass = partes3[1].trim();
			if(pass.equals("¡@IA¿WIN$#")){
				datosCorruptos++;
			}
			String rol = partes3[2].trim();
			if(rol.equals("¡@IA¿WIN$#")){
				datosCorruptos++;
			}
			String creator = partes3[3].trim();
			if(creator.equals("¡@IA¿WIN$#")){
				datosCorruptos++;
			}
			users[contador] = us.toLowerCase();
			passwords[contador] = pass;
			categorias[contador] = rol.toLowerCase();
			creadores[contador] = creator.toLowerCase();
			contador++;
		}
		leer.close();
		if(datosCorruptos >0){
			System.out.println("Datos afectados de 'datos_usuarios.txt': " + datosCorruptos + "\n");
		}
	}
	private static void PrintListaStr(String[] lista){
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
		System.out.println(listaFinal);
	}
	private static void Corromper(int posicion, String[] lista){
		while(lista[posicion] == null){
			posicion = (int)(Math.random()*(lista.length-1));
		}
		lista[posicion] = "¡@IA¿WIN$#";
	}
	private static int Buscar(String[] lista, int tamaño, String valor){
		int i;
		for(i=0;i<tamaño;i++) {
			if(lista[i] != null){
				if(lista[i].equals(valor)) {
				break;
				}
			}
		}
		return i;
	}
}