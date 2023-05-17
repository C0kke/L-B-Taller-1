package ucn.lyb.taller2.logica;

import java.io.*;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		//Archivos para TXT de Usuarios
		File txtUsuarios = new File("Usuarios.txt");
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
		
		scan.close();
		escribirUsuarios.close();
	}
	private static void CrearListas3(File txt, String users[],String passwords[],  String categorias[],  String creadores[]) throws FileNotFoundException{
		int contador = 0;
		int datosCorruptos = 0;
		Scanner leer = new Scanner(txt);
	
		while(leer.hasNextLine()){
			String linea = leer.nextLine();
			String partes3[] = linea.split(",");
			String us = partes3[0].trim();
			if(us.equals("�@IA�WIN$#")){
				datosCorruptos++;
			}
			String pass = partes3[1].trim();
			if(pass.equals("�@IA�WIN$#")){
				datosCorruptos++;
			}
			String rol = partes3[2].trim();
			if(rol.equals("�@IA�WIN$#")){
				datosCorruptos++;
			}
			String creator = partes3[3].trim();
			if(creator.equals("�@IA�WIN$#")){
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
}
