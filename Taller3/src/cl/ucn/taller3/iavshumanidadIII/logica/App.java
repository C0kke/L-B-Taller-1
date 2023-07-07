package cl.ucn.taller3.iavshumanidadIII.logica;
import java.io.FileNotFoundException;
import java.util.*;

import cl.ucn.taller3.iavshumanidadIII.dominio.AI;
import cl.ucn.taller3.iavshumanidadIII.dominio.Programmer;
import cl.ucn.taller3.iavshumanidadIII.dominio.Soldier;
import cl.ucn.taller3.iavshumanidadIII.dominio.User;

public class App {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(System.in);
		Sistema sistema = new SistemaImpl();
		
		List<User> users = new LinkedList<User>();
		List<Soldier> soldiers = new LinkedList<Soldier>();
		List<AI> ais = new LinkedList<AI>();
		List<Programmer> programmers = new LinkedList<Programmer>();
		
		System.out.println("Username: ");
		String user = scan.nextLine().toLowerCase(); 
		System.out.println("\nPassword: ");
		String password = scan.nextLine().toLowerCase();
		
		sistema.LecturaArchivosYLogin(users, soldiers, ais, programmers, user, password);
		
		while(!sistema.LecturaArchivosYLogin(users, soldiers, ais, programmers, user, password)){
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
			AdminMenu(option, users,soldiers, ais, programmers, scan);
			
		}
		scan.close();
	}

	private static void AdminMenu(int option, List<User> users, List<Soldier> soldiers, List<AI> ais, List<Programmer> programmers, Scanner scan){
		switch(option){
		case 1://Ver datos
			System.out.println("How you want to watch the data?: ");
			System.out.println("1) Players by Country\n2) Soldiers by Speciality\n3) AI's by Classes\n4) Programmers by Speciality\n0) Back");
			int watchFor = Integer.parseInt(scan.nextLine());
			watchFor = limits(0, 4, watchFor, scan);
			switch(watchFor){
			case 1: //jugadores por pais
				List<String> countries = new LinkedList<String>() ;
				
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
			case 2://Soldados por especialidad
				List<String> specialities = new LinkedList<String>() ;
				
				for(Soldier s : soldiers){
					if(!specialities.contains(s.getSpecialism())){specialities.add(s.getSpecialism());}
				}
				for (int i = 0; i < specialities.size(); i++) {
			    	for (int j = 1; j < specialities.size(); j++) {
			        	if(specialities.get(j).compareTo(specialities.get(j-1))<0){
			        		String aux = specialities.get(j-1);
			        		specialities.set(j-1, specialities.get(j));
			        		specialities.set(j, aux);
			            }
			        }
			    }
				for(String speciality : specialities){
					System.out.println("SPECIALITY: "+speciality);
					for(Soldier s : soldiers){
						if(speciality.equals(s.getSpecialism())){
							System.out.println(s.toString());
						}
					}
				}
				break;
			case 3://IA por clase
				List<String> classes = new LinkedList<String>() ;
				classes.add("S+");classes.add("S");classes.add("A");classes.add("B");classes.add("C");classes.add("D");
				for(String clas : classes){
					System.out.println("CLASS: "+clas);
					for(AI ai : ais){
						if(clas.equals(ai.getClas())){
							System.out.println(ai.toString());
						}
					}
				}
				break;
			case 4://Programadores por especialidad
				List<String> specialitiesP = new LinkedList<String>();
				for(Programmer p : programmers){
					if(!specialitiesP.contains(p.getSpecialism())){specialitiesP.add(p.getSpecialism());}
				}
				for (int i = 0; i < specialitiesP.size(); i++) {
			    	for (int j = 1; j < specialitiesP.size(); j++) {
			        	if(specialitiesP.get(j).compareTo(specialitiesP.get(j-1))<0){
			        		String aux = specialitiesP.get(j-1);
			        		specialitiesP.set(j-1, specialitiesP.get(j));
			        		specialitiesP.set(j, aux);
			            }
			        }
			    }
				for(String speciality : specialitiesP){
					System.out.println("SPECIALITY: "+speciality);
					for(Programmer p : programmers){
						if(speciality.equals(p.getSpecialism())){
							System.out.println(p.toString());
						}
					}
				}
				break;
			case 0:
				break;
			}
			
			break;
		case 2://Cambiar Datos
			break;
		case 3://Ver Estadisticas
			break;
		case 4://Simulacion (opcional)
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
