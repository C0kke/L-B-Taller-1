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
		int contador = 0;
		
		System.out.println(leer3.nextLine());
		
		while(leer3.hasNextLine()){
			String linea3 = leer3.nextLine();
			String partes3[] = linea3.split(",");
			String us = partes3[0].toLowerCase();
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

			RandomAccessFile arch1 =new RandomAccessFile("datos_ia.txt", "rw");
			RandomAccessFile arch2 = new RandomAccessFile("datos_creadores.txt", "rw");
			RandomAccessFile arch3 = new RandomAccessFile("datos_usuarios.txt", "rw");
			
			int archivoACorromper = (int) (Math.random()*3+1);
			int random;
			
			switch(archivoACorromper){
				case 1:
					System.out.println("Se corrompe el archivo " + archivoACorromper);
					long tamaño1 = arch1.length();
					for(int i =0; i<datosACorromper;i++){
						random = (int) (Math.random() * tamaño1);
						arch1.seek(random);
						arch1.writeBytes(", " + "!#IA.Win$#¡" + " ,");;
					}
					arch1.close();
					break;
				case 2:
					System.out.println("Se corrompe el archivo " + archivoACorromper);
					long tamaño2 = arch2.length();
					for(int i =0; i<datosACorromper;i++){
					random = (int) (Math.random() * tamaño2);
						arch2.seek(random);
						arch2.writeBytes(", " + "!#IA.Win$#¡" + " ,");
					}
					arch2.close();
					break;
				case 3:
					System.out.println("Se corrompe el archivo " + archivoACorromper);
					long tamaño3 = arch3.length();
					for(int i =0; i<datosACorromper;i++){
					random = (int) (Math.random() * tamaño3);
					arch3.seek(random);
					arch3.writeBytes(", " + "!#IA.Win$#¡" + " ,");;
					}
					arch3.close();
					break;
			}
					
			//Verificar existencia del usuario
			System.out.println("User: ");
			String user = scan.nextLine().toLowerCase();
			System.out.println("Password: ");
			String password = scan.nextLine();
			
			boolean valido = Login(10, user, password, users, passwords);
			
			if(valido == false){
				System.out.println("Acceso Denegado");
			}else{
				System.out.println("Acceso Correcto");
				
				//Login correcto, iniciar programa
			}
			
			System.out.println("Para finalizar sesión escriba 'fin', si desea continuar, pulse Enter");
			iniciar = scan.nextLine();
			
		}	
		scan.close();leer3.close();
	}
	private static boolean Login(int tamaño, String user, String pass, String listaUser[], String listaPassword[]){
		
		boolean valido = false;
		
		for(int i = 0; i<10;i++){

			if(user.equals(listaUser[i])){
				if(pass.equals(listaPassword[i])){
					valido = true;
				}
			}
		}
		return valido;
	}
}
