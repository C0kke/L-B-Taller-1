package cl.ucn.taller3.iavshumanidadIII.logica;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.*;

import cl.ucn.taller3.iavshumanidadIII.dominio.AI;
import cl.ucn.taller3.iavshumanidadIII.dominio.AIEngineer;
import cl.ucn.taller3.iavshumanidadIII.dominio.Artillery;
import cl.ucn.taller3.iavshumanidadIII.dominio.CombatIntelligence;
import cl.ucn.taller3.iavshumanidadIII.dominio.CryptografyExpert;
import cl.ucn.taller3.iavshumanidadIII.dominio.Infantry;
import cl.ucn.taller3.iavshumanidadIII.dominio.LogisticSupport;
import cl.ucn.taller3.iavshumanidadIII.dominio.Programmer;
import cl.ucn.taller3.iavshumanidadIII.dominio.Soldier;
import cl.ucn.taller3.iavshumanidadIII.dominio.SpecialOperations;
import cl.ucn.taller3.iavshumanidadIII.dominio.ThreatAnalyst;
import cl.ucn.taller3.iavshumanidadIII.dominio.User;

public class App {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		
		List<User> users = new LinkedList<User>();
		List<Soldier> soldiers = new LinkedList<Soldier>();
		List<AI> ais = new LinkedList<AI>();
		List<Programmer> programmers = new LinkedList<Programmer>();
		generateUsers(users);
		generateSoldiers(soldiers);
		generateAI(ais);
		generateProgrammers(programmers);
		
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
			AdminMenu(option, users,soldiers, ais, programmers, scan);
			
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
	private static void generateSoldiers(List<Soldier> soldiers) throws FileNotFoundException{
		Scanner readerSoldiers = new Scanner(new File("stats-soldiers.txt"));
		while(readerSoldiers.hasNextLine()){
			String[] parts = readerSoldiers.nextLine().split(",");
			int idSoldier = Integer.parseInt(parts[0].trim());
			String name = parts[1].trim();
			String lastName = parts[2].trim();
			String nick = parts[3].trim();
			String speciality = parts[4].trim().toLowerCase();
			int soldierValue = Integer.parseInt(parts[5].trim());
			Soldier s;
			switch(speciality){
			case "infantería":
				int completedMissions = Integer.parseInt(parts[6].trim());
				String weapon = parts[7].trim();
				s = new Infantry(idSoldier, name, lastName, nick, speciality, soldierValue, completedMissions, weapon); 
				soldiers.add(s);
				break;
			case "artillería":
				int destroyedObjectives = Integer.parseInt(parts[6].trim());
				String precision = parts[7].trim();
				s = new Artillery(idSoldier, name, lastName, nick, speciality, soldierValue, destroyedObjectives, precision); 
				soldiers.add(s);
				break;
			case "inteligencia de combate":
				int intelligenceReports = Integer.parseInt(parts[6].trim());
				int identifiedEnemies = Integer.parseInt(parts[7].trim());
				s = new CombatIntelligence(idSoldier, name, lastName, nick, speciality, soldierValue, intelligenceReports, identifiedEnemies); 
				soldiers.add(s);
				break;
			case "operaciones especiales":
				int hiddenMissions = Integer.parseInt(parts[6].trim());
				int totalMissions = Integer.parseInt(parts[7].trim());
				int obtainedResources = Integer.parseInt(parts[8].trim());
				s = new SpecialOperations(idSoldier, name, lastName, nick, speciality, soldierValue, hiddenMissions, totalMissions, obtainedResources); 
				soldiers.add(s);
				break;
			case "apoyo logístico":
				int distributedSupplies = Integer.parseInt(parts[6].trim());
				int supportsTroops = Integer.parseInt(parts[7].trim());
				s = new LogisticSupport(idSoldier, name, lastName, nick, speciality, soldierValue, distributedSupplies, supportsTroops); 
				soldiers.add(s);
				break;
			}
		}
		readerSoldiers.close();
	}
	private static void generateAI(List<AI> ais) throws FileNotFoundException{
		Scanner readerAI = new Scanner(new File("IA.txt"));
		while(readerAI.hasNextLine()){
			String[] parts = readerAI.nextLine().split(",");
			String name = parts[0].trim();
			String clas = parts[1].trim(); //No deja escribir class, por lo que se dejó en clas
			int hp = Integer.parseInt(parts[2].trim());
			AI ia = new AI(name, clas, hp);
			ais.add(ia);
		}
		readerAI.close();
	}
	private static void generateProgrammers(List<Programmer> programmers) throws FileNotFoundException{
		Scanner readerProgrammers = new Scanner(new File("stats-programmers.txt"));
		while(readerProgrammers.hasNextLine()){
			String[] parts = readerProgrammers.nextLine().split(",");
			int idProgrammer = Integer.parseInt(parts[0].trim());
			String name = parts[1].trim();
			String lastName = parts[2].trim();
			String speciality = parts[3].trim().toLowerCase();
			Programmer p;
			switch(speciality){
			case "ingeniero de ia":
				String experience = parts[4].trim();
				int implementedAlgorithms = Integer.parseInt(parts[5].trim());
				p = new AIEngineer(idProgrammer, name, lastName, speciality, experience, implementedAlgorithms);
				programmers.add(p);
				break;
			case "analista de amenazas":
				String capacity = parts[4].trim();
				int detectedThreats = Integer.parseInt(parts[5].trim());
				p = new ThreatAnalyst(idProgrammer, name, lastName, speciality, capacity, detectedThreats);
				programmers.add(p);
				break;
			case "experto en criptografía":
				String knowledge = parts[4].trim();
				String securityExperience = parts[5].trim();
				int succesfulImplementations = Integer.parseInt(parts[6].trim());
				String obfuscationAbility = parts[7].trim();
				p = new CryptografyExpert(idProgrammer, name, lastName, speciality, knowledge, securityExperience, obfuscationAbility, succesfulImplementations); 
				programmers.add(p);
				break;
			}
		}
		readerProgrammers.close();
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
