package ucn.lyb.taller2.logica;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

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
		int[] idProg = new int[100];
		String[] nombresProg = new String[100];
		String[] apellidosProg = new String[100]; 
		int[] añosExp = new int[100];
		String[] lenguajes = new String[100];
		String[] paises = new String[100];
		String[] ciudades = new String[100];
		ListasProgramadores(txtProgramadores, idProg, nombresProg,apellidosProg, añosExp, lenguajes,paises,ciudades);
		System.out.println(Arrays.toString(lenguajes));
		//Verificar existencia del usuario
		System.out.println("LOGIN");
		System.out.println("\nUser: ");
		String user = scan.nextLine().toLowerCase();
		System.out.println("Password: ");
		String password = scan.nextLine();
		
		if(user.equals("empanadasconchapalele") && password.equals("suricatarabiosa")){
			System.out.println("ADMIN");
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
	private static void ListasProgramadores(File txt,int idProg[], String[] nombresProg, String[] apellidosProg, int[] añosExp,String[] lenguajes, String[] paises, String[] ciudades) throws FileNotFoundException{
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
			for(int i=4;i<partesP.length-2;i++){
				totalLenguajes += partesP[i]+" ";
			}
			String pais = partesP[partesP.length-2];
			String ciudad = partesP[partesP.length-1];
			
			idProg[contador] = id;
			nombresProg[contador] = nombre;
			apellidosProg[contador] = apellido;
			añosExp[contador] = experiencia;
			lenguajes[contador] = totalLenguajes;
			paises[contador] = pais;
			ciudades[contador] = ciudad;
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
}

