package ucn.lyb.taller2.logica;

import java.io.*;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		//Archivos para TXT de Usuarios
		File txtUsuarios = new File("Usuarios.txt");
		String users[] = new String [100];
		int codigos[] = new int[100];
		String passwords[] = new String[100];
		int ids[] = new int[100];
		CrearListas(txtUsuarios, users, codigos, passwords, ids);
		
		//Verificar existencia del usuario
		System.out.println("LOGIN");
		System.out.println("\nUser: ");
		String user = scan.nextLine().toLowerCase();
		System.out.println("Password: ");
		String password = scan.nextLine();
		
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
		scan.close();
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
}

