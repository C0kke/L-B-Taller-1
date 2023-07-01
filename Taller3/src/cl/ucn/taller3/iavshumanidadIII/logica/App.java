package cl.ucn.taller3.iavshumanidadIII.logica;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.*;

import cl.ucn.taller3.iavshumanidadIII.dominio.User;
public class App {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		
		List<User> users = new ArrayList<User>();
		generateUsers(users);
		System.out.println("Username: ");
		String user = scan.nextLine().toLowerCase(); 
		System.out.println("\nPassword: ");
		String password = scan.nextLine().toLowerCase();
		while(!login(users, user, password)){
			System.out.println("Denied access, retry\n");
			System.out.println("Username: ");
			user = scan.nextLine().toLowerCase(); 
			System.out.println("\nPassword: ");
			password = scan.nextLine().toLowerCase();
		}
		String category = "";
		for(User player : users){
			if(user.equals(player.getUser())){
				category = player.getType();
			}
		}
		if(category.equals("jugador")){
			//Menu Jugador
			System.out.println("Welcome to menu");
		}else if(category.equals("admin")){
			//Menu Admin
			System.out.println("Succesful access");	
			System.out.println("Choose an option: ");
			System.out.println("1) Watch Data\n2) Change Data\n3) Watch Stats\n4) Simulation\n0) Back");
			int option = Integer.parseInt(scan.nextLine());
			option = limits(0, 4, option, scan);
			AdminMenu(option, users, scan);
			
		}
		scan.close();
	}
	private static void generateUsers(List<User> users) throws FileNotFoundException{
		Scanner readerUsers = new Scanner(new File("Users.txt"));
		while(readerUsers.hasNextLine()){
			String[] parts = readerUsers.nextLine().split(",");
			String user = parts[0].trim();
			String password = parts[1].trim();
			String country = parts[2].trim();
			String type = parts[3].trim();
			User u = new User(user, password, country, type);
			users.add(u);
		}
		readerUsers.close();
	}
	private static boolean login(List<User> users, String user, String password) {
		boolean exists = false;
		for(int i=0;i< users.size();i++){
			if(user.equals(users.get(i).getUser().toLowerCase()) && password.equals(users.get(i).getPassword().toLowerCase())){
				exists = true;
				break;
			}
		}
		return exists;
	}
	private static void AdminMenu(int option, List<User> users, Scanner scan){
		switch(option){
		case 1:
			System.out.println("How you want to watch the data?: ");
			System.out.println("1) Players by Country\n2) Soldiers by Speciality\n3) AI's by Classes\n4) Programmers by Speciality\n0) Back");
			int watchFor = Integer.parseInt(scan.nextLine());
			watchFor = limits(0, 4, watchFor, scan);
			switch(watchFor){
			case 1: //jugadores por pais
				List<String> countries = new ArrayList<String>() ;
				
				for(User user : users){
					if(!countries.contains(user.getCountry())){
						countries.add(user.getCountry());
					}
				}
				for (int i = 0; i < countries.size(); i++) {
			    	for (int j = 1; j < countries.size(); j++) {
			        	if(countries.get(j).compareTo(countries.get(j-1))<0){
			        		String aux = countries.get(j-1);
			                countries.set(j-1, countries.get(j));
			                countries.set(j, aux);
			            }
			        }
			    }
				for(String country : countries){
					System.out.println(country);
					for(User user : users){
						if(country.equals(user.getCountry())){
							System.out.println(user.toString());;
						}
					}
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 0:
				break;
			}
			
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 0:
			break;
		}
	}
	private static int limits(int min, int max, int option, Scanner scan) { //Funcion para limitar las opciones
		while(option < min || option > max){
			System.out.println("Ingrese una opcion valida");
			option = Integer.parseInt(scan.nextLine());
	    }
	    return option;
	}
}
