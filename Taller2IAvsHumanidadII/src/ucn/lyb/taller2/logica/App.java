package ucn.lyb.taller2.logica;

import java.io.*;
import java.util.Scanner;

import ucn.lyb.taller2.dominio.Programador;

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
		ListaProgramadores programadores = new ListaProgramadores(10);
		CrearProgramadores(txtProgramadores, programadores);
		
		
		//Verificar existencia del usuario
		System.out.println("LOGIN");
		System.out.println("\nUser: ");
		String user = scan.nextLine().toLowerCase();
		System.out.println("Password: ");
		String password = scan.nextLine();
		
		//Menu Admin
		/*
		 * empanadasconchapalele
		 * suricatarabiosa
		 */
		if(user.equals("empanadasconchapalele") && password.equals("suricatarabiosa")){
			System.out.println("HA ACCEDIDO CORRECTAMENTE AL MEN� ADMINISTRADOR");
			System.out.println("\nProgramadores:");
			System.out.println("\n�C�mo desea ordenarlos?");
			System.out.println("1) Por Pa�s");
			System.out.println("2) Por Ciudad");
			System.out.println("3) Por a�os de experiencia");
			System.out.println("4) Por Cantidad de lenguajes");
			System.out.println("5) Por ID");
			System.out.println("0) No Ordenar");
			int sort = Integer.parseInt(scan.nextLine());
			sort = Limitar(0,5,sort, scan);
			
			/*� Ver todos los programadores, y dentro de esto implementar un filtro, que pueda seleccionar
			a los programadores por:
				o Pa�s o Ciudad o A�os experiencia
				o Cantidad de lenguajes que conoce o Por ID(Se ordenan los
				programadores de mayor a menor seg�n su ID)
				� Ver todos las IA, y dentro de esto implementar un filtro, que pueda seleccionar a las IA por:
				o Tipo
				o Nombre (Ordenar en orden alfab�tico) o Precisi�n o Pa�s o Nivel
				de peligrosidad
				� Editar datos Programador: En esta ventana se podr�n editar los datos del programador,
				(Agregar lenguaje, a�os de experiencia, modifica pa�s, ciudad, id, nombre, apellido), tener
				en cuenta que si se cambia el id no se puede repetir con otra ya existente. Adem�s de tener
				que modificarlo en los datos de usuario.
				� Editar datos IA: En esta ventana se podr�n editar los datos de la IA, (Nombre, nivel de
				peligrosidad, debilidad, precisi�n, Pa�s, Id creador)
				� Editar datos de Usuario: Se pueden modificar todos los datos de usuario (Nombre usuario,
				contrase�a, id). Tener en cuenta que no se puede repetir el id en otro usuario.
				� Crear y visualizar debilidades: Aqu� se deben visualizar todas las debilidades y dar la
				posibilidad de agregar una nueva con sus respectivos datos
				� Crear una IA, programador, Pa�s: se podr�n crear Una IA, Programador y Pa�s con los datos
				necesarios para cada uno
				� Dar estad�sticas por pa�ses:
				o Porcentaje de IA y programadores por pa�ses seg�n el total o
				Porcentaje de IA y programadores por Ciudad seg�n el total
			*/
			
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
	private static int Limitar(int minimo, int maximo, int variable, Scanner scan) {
		while(variable < minimo || variable > maximo){
			System.out.println("Ingrese una opcion valida");
	        variable = Integer.parseInt(scan.nextLine());
	    }
	    return variable;
	}
	private static void CrearProgramadores(File txt, ListaProgramadores programadores) throws FileNotFoundException{
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
			
			Programador p = new Programador(id, nombre, apellido, experiencia, totalLenguajes, pais, ciudad);
			programadores.agregarProgramador(p, contador);
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
	private static void ImprimirPorDato(String[] lista){
		for(int i=0;i<lista.length;i++){
			if(lista[i] != null){
				System.out.println("-"+lista[i]);
			}
		}
		
	}
}

