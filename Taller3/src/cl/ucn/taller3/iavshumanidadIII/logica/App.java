package cl.ucn.taller3.iavshumanidadIII.logica;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import cl.ucn.taller3.iavshumanidadIII.dominio.AI;
import cl.ucn.taller3.iavshumanidadIII.dominio.AIEngineer;
import cl.ucn.taller3.iavshumanidadIII.dominio.CryptografyExpert;
import cl.ucn.taller3.iavshumanidadIII.dominio.Programmer;
import cl.ucn.taller3.iavshumanidadIII.dominio.Soldier;
import cl.ucn.taller3.iavshumanidadIII.dominio.ThreatAnalyst;
import cl.ucn.taller3.iavshumanidadIII.dominio.User;

public class App {
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		FileWriter writerPlayers = new FileWriter("stats-players.txt", true);
		Sistema sistema = new SistemaImpl();
		
		List<User> users = new LinkedList<User>();
		List<Soldier> soldiers = new LinkedList<Soldier>();
		List<AI> ais = new LinkedList<AI>();
		List<Programmer> programmers = new LinkedList<Programmer>();
		
		sistema.Reading(users, soldiers, ais, programmers);
		String user = login(scan, sistema, users);
		
		String category = "";
		for(User player : users){
			if(user.equals(player.getUser())){
				category = player.getType();
			}
		}
		if(category.equals("jugador")){ //Menu Jugador
			List<String> team = new ArrayList<String>();
			int teamValue = 0;
			
			System.out.println("Welcome to menu "+user+"\nChoose an option: ");
			System.out.println("1) Watch Soldiers Gallery\n2) Watch Programmers Gallery\n3) Create Team\n4) Battle Record\n5) Change Profile\n6) Watch Top\n7) Fight vs AI\n0) Exit");
			int option = Integer.parseInt(scan.nextLine());
			while(option != 0){
				option = limits(0, 7, option, scan);
				PlayerMenu(option,user, users,soldiers, ais, programmers,team, teamValue, scan, writerPlayers);
				System.out.println(("¿Do you want do anything else?"));
				System.out.println("1) Watch Soldiers Gallery\n2) Watch Programmers Gallery\n3) Create Team\n4) Battle Record\n5) Change Profile\n6) Watch Top\n7) Fight vs AI\n0) Exit");
				option = Integer.parseInt(scan.nextLine());
			}
		}else if(category.equals("admin")){//Menu Admin
			
			System.out.println("Succesful access\nChoose an option: ");	
			System.out.println("1) Watch Data\n2) Change Data\n3) Watch Stats\n4) Simulation\n0) Exit");
			int option = Integer.parseInt(scan.nextLine());
			while(option != 0){
				option = limits(0, 4, option, scan);
				AdminMenu(option, users,soldiers, ais, programmers, scan);
				System.out.println(("¿Do you want do anything else?"));
				System.out.println("1) Watch Data\n2) Change Data\n3) Watch Stats\n4) Simulation\n0) Exit");
				option = Integer.parseInt(scan.nextLine());
			}
			
		}
		saveChanges();
		scan.close();
	}
	private static String login(Scanner scan, Sistema sistema, List<User> users){
		System.out.println("Username: ");
		String user = scan.nextLine().toLowerCase().trim(); 
		System.out.println("\nPassword: ");
		String password = scan.nextLine().toLowerCase().trim();
		while(!sistema.Login(users, user, password)){
			System.out.println("Denied access, retry\n");
			System.out.println("Username: ");
			user = scan.nextLine().toLowerCase().trim(); 
			System.out.println("\nPassword: ");
			password = scan.nextLine().toLowerCase().trim();
		}
		return user;
	}
	private static void PlayerMenu(int option, String user, List<User> users,List<Soldier> soldiers, List<AI> ais, List<Programmer> programmers, List<String> team, int teamValue, Scanner scan, FileWriter writer) throws IOException {
		
		switch(option){
		case 1: // Watch soldiers gallery
			for(Soldier s : soldiers){
				System.out.println(s.toString());
			}
			break;
		case 2:// Watch programmers gallery
			for(Programmer p : programmers){
				System.out.println(p.toString());
			}
			break;
		case 3:// Create a team
			if(team.size()!= 0){
				System.out.println("Team has been created yet");
			}else{
				boolean exists;
				for(int i = 0;i<2;i++){
					exists = false;
					System.out.println("Input the NAME of de Proggrammer "+ (i+1));
					String progName = scan.nextLine().toLowerCase();
					for(Programmer p : programmers){
						if(progName.equals(p.getName().toLowerCase())){
							exists = true;
							team.add(progName);
						}
					}
					if(!exists){
						System.out.println("Programmer doesn't exists");
						i -= 1;
					}
				}
				for(int j=0;j<3;j++){
					exists = false;
					System.out.println("Input the Nick of de Soldier "+ (j+1));
					String soldNick = scan.nextLine().toLowerCase();
					for(Soldier s : soldiers){
						if(soldNick.equals(s.getNick().toLowerCase())){
							exists = true;
							team.add(soldNick);
						}
					}
					if(!exists){
						System.out.println("Soldier doesn't exists");
						j -= 1;
					}
				}
				
			}
			System.out.println(team.toString());
			break;
		case 4://Registro de batallas: Se debe mostrar un historial que muestre contra que IA combatiste y el resultado de esta batalla, además de un porcentaje de victorias en la parte superior.
			break;
		case 5: //Cambiar Perfil
			int pos = 0;
			for(User u : users){
				if(!user.equals(u.getUser().toLowerCase())){
					pos +=1 ;
				}else{
					break;
				}
			}
			System.out.println(users.get(pos).toString());
			System.out.println("Do you want change the username? (y/n)");
			if(scan.nextLine().equals("y")){
				System.out.println("Input the new username: ");
				users.get(pos).setUser(scan.nextLine());
			}
			System.out.println("Do you want change the password? (y/n)");
			if(scan.nextLine().equals("y")){
				System.out.println("Input the new password: ");
				users.get(pos).setPassword(scan.nextLine());
			}
			System.out.println("Do you want change the Country? (y/n)");
			if(scan.nextLine().equals("y")){
				System.out.println("Input the new country: ");
				users.get(pos).setCountry(scan.nextLine());
			}
			System.out.println("New user: "+users.get(pos).toString());
			break;
		case 6: // Ver top: Aquí podrás ver un top con los jugadores más puntos [Este deberá tener la opción de ser top mundial y Top nacional]
			System.out.println("Do you want watch the Nacional(1) or Mundial(2) top?");
			int top = Integer.parseInt(scan.nextLine());
			String country;
			top = limits(1, 2, top, scan);
			switch(top){
			case 1:
				break;
			case 2:
				break;
			}
			break;
		case 7: // pelear contra una ia
			if(team.size()==0){
				System.out.println("There's no team created");
			}else{
				teamValue = calculateValue(team, programmers, soldiers, teamValue);
				System.out.println("Your team: "+team.toString()+"\nPower: "+ teamValue);
				int posAI = (int)(Math.random()*(ais.size()-1));
				int hpAI = addHPAI(ais, posAI);
				System.out.println("Enemy A.I.: "+ ais.get(posAI).getName()+ " Vida: "+ hpAI);
				String result;
				int points = 0;
				if(teamValue > hpAI){
					result = "Victory";
					points += 3;
					System.out.println(result);
				}else if(teamValue == hpAI){
					result =  "Tie";
					points -= 3;
					System.out.println(result);
				}else{
					result =  "Defeat";
					System.out.println(result);
				}
				writer.write(user+", "+ais.get(posAI).getName()+", "+result+", "+points);
			}
			break;
		case 0:
			break;
		}
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
				order(countries);
				
				for(String country : countries){
					System.out.println(country);
					for(User user : users){
						if(country.equals(user.getCountry())){
							System.out.println(user.toString());
						}
					}
				}
				break;
			case 2://Soldados por especialidad
				List<String> specialities = new LinkedList<String>() ;
				
				for(Soldier s : soldiers){
					if(!specialities.contains(s.getSpecialism())){specialities.add(s.getSpecialism());}
				}
				order(specialities);
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
				order(specialitiesP);
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
	private static void order(List<String> list){
		for (int i = 0; i < list.size(); i++) {
	    	for (int j = 1; j < list.size(); j++) {
	        	if(list.get(j).compareTo(list.get(j-1))<0){
	        		String aux = list.get(j-1);
	                list.set(j-1, list.get(j));
	                list.set(j, aux);
	            }
	        }
	    }
	}
	private static int calculateValue(List<String> team, List<Programmer> programmers, List<Soldier> soldiers, int teamValue){
		for(String member :team){
			for(Programmer p : programmers){
				if(p.getName().toLowerCase().equals(member)){
					switch(p.getSpecialism().toLowerCase()){
					case "ingeniero de ia":
						AIEngineer pe = (AIEngineer) p;
						teamValue += addValue(pe.getExperience().toLowerCase(), teamValue);
						break;
					case "analista de amenazas":
						ThreatAnalyst pa = (ThreatAnalyst) p;
						teamValue += addValue(pa.getCapacity().toLowerCase(), teamValue);
						break;
					case "experto en criptografía":
						int cryptoValue = 0;
						CryptografyExpert pc = (CryptografyExpert) p;
						cryptoValue += addValue(pc.getObfuscationAbility().toLowerCase(), cryptoValue);
						cryptoValue += addValue(pc.getSecurityExperience().toLowerCase(), cryptoValue);					
						teamValue += cryptoValue;
						break;
					}
				}
			}
			for(Soldier s : soldiers){
				if(s.getNick().toLowerCase().equals(member)){
					teamValue += s.getSoldierValue();			
				}
			}
		}
		return teamValue;
	}
	private static int addValue(String level, int value){
		switch(level.trim()){
		case "avanzado":
			value = 450;
			break;
		case "intermedio":
			value = 300;
			break;
		case "bajo":
			value = 150;
			break;	
		}
		return value;
	}
	private static int addHPAI(List<AI> ais, int vsAI){
		int hpAI = ais.get(vsAI).getHp();
		switch(ais.get(vsAI).getClas().trim()){
		case "S+":
			hpAI += 2994;
			break;
		case "S":
			hpAI += 1994;
			break;
		case "A":
			hpAI += 994;
			break;
		case "B":
			hpAI += 452;
			break;
		case "C":
			hpAI += 226;
			break;
		case "D":
			break;
		}
		return hpAI;
	}
	private static void saveChanges(){
		
	}
}
