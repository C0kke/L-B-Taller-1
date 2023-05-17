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
		
		scan.close();
	}
	private static void CrearListas(File txt, String users[], int codigos[], String passwords[],  int ids[]) throws FileNotFoundException{
		int contador = 0;
		int datosCorruptos = 0;
		Scanner leer = new Scanner(txt);
	
		while(leer.hasNextLine()){
			
			String linea = leer.nextLine();
			String partes[] = linea.split(",");
			
			String us = partes[0].trim();
			String pass = partes3[1].trim();
			String rol = partes3[2].trim();
			String creator = partes3[3].trim();
			users[contador] = us.toLowerCase();
			passwords[contador] = pass;
			contador++;
		}
		leer.close();
		if(datosCorruptos >0){
			System.out.println("Datos afectados de 'datos_usuarios.txt': " + datosCorruptos + "\n");
		}
	}
}
