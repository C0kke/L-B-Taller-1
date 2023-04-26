import java.io.*;
import java.util.*;


public class app {
	public static void main(String[] args) throws FileNotFoundException {
		
		//scanners y archivos
		Scanner scan = new Scanner(System.in);
		File arch1 = new File("datos_ia.txt");
		Scanner leer1 = new Scanner(arch1);
		File arch2 = new File("datos_creadores.txt");
		Scanner leer2 = new Scanner(arch2);
		File arch3 = new File("datos_usuarios.txt");
		Scanner leer3 = new Scanner(arch3);
		
		//Pantalla Inicio
		String iniciar = "WELCOME TO I.A. AGAINST TO HUMANITY";
		System.out.println(iniciar);
		System.out.println("Press Enter to Start");
		iniciar = scan.nextLine();
		
		//Creacion de listas para user/password
		String users[] = new String [10];
		String passwords[] = new String[10];
		int contador = 0;
		
		while(leer3.hasNextLine()){
			String linea3 = leer3.nextLine();
			String partes3[] = linea3.split(",");
			String us = partes3[0];
			String pass = partes3[1];
			
			users[contador] = us;
			passwords[contador] = pass;
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
					break;
				case 2:
					break;
				case 3:
					break;
			}
					
			//Verificar existencia del usuario
			System.out.println("User: ");
			String user = scan.nextLine();
			System.out.println("Password: ");
			String password = scan.nextLine();
			
			//tiene error
			int posicion = -1;
			for(int i = 0; i<10;i++){
				if(users[i] == user){
					posicion = i;
				}
			}
			/*
			if(valido == false){
				System.out.println("Acceso Denegado");
			}else{
				System.out.println("Acceso Correcto");
			}
			*/
			System.out.println("Para finalizar sesi�n escriba 'fin', si desea continuar, pulse Enter");
			iniciar = scan.nextLine();
			
		}
	}
}
