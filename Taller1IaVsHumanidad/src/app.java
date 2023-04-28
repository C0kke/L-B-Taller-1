import java.io.*;
import java.util.*;


public class app {
	public static void main(String[] args) throws IOException {
		
		//scanners y archivos
		Scanner scan = new Scanner(System.in);
		
		File txtIA = new File("datos_ia.txt");
		Scanner leer1 = new Scanner(txtIA);
		
		File txtCreadores = new File("datos_creadores.txt");
		Scanner leer2 = new Scanner(txtCreadores);
		
		File txtUsuarios = new File("datos_usuarios.txt");
		Scanner leer3 = new Scanner(txtUsuarios);
		
		//Pantalla Inicio
		String iniciar = "WELCOME TO I.A. AGAINST TO HUMANITY";
		System.out.println(iniciar);
		System.out.println("Press Enter to Start");
		iniciar = scan.nextLine();
		
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
				if (categoria.equals("normal")){
					
				}else if (categoria.equals("administrador")){
					
				}
			}
			
			System.out.println("Para finalizar sesi�n escriba 'fin', si desea continuar, pulse Enter");
			iniciar = scan.nextLine();
			
		}	
		scan.close();leer3.close();
	}
	private static boolean Login(int tama�o, String user, String pass, String listaUser[], String listaPassword[]){
		
		boolean valido = false;
		
		for(int i = 0; i<tama�o;i++){

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
}