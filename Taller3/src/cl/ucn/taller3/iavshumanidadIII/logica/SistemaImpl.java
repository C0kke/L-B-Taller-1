package cl.ucn.taller3.iavshumanidadIII.logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

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

public class SistemaImpl implements Sistema {

	@Override
	public boolean LecturaArchivosYLogin(List<User> users, List<Soldier> soldiers, List<AI> ais, List<Programmer> programmers, String user, String password) throws FileNotFoundException {
		Scanner readerUsers = new Scanner(new File("Users.txt"));
		while(readerUsers.hasNextLine()){
			String[] parts = readerUsers.nextLine().split(",");
			String us = parts[0].trim();
			String pass = parts[1].trim();
			String country = parts[2].trim();
			String type = parts[3].trim();
			User u = new User(us, pass, country, type);
			users.add(u);
		}
		readerUsers.close();
	
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

		Scanner readerAI = new Scanner(new File("IA.txt"));
		while(readerAI.hasNextLine()){
			String[] parts = readerAI.nextLine().split(",");
			String name = parts[0].trim();
			String clas = parts[1].trim();
			int hp = Integer.parseInt(parts[2].trim());
			AI ia = new AI(name, clas, hp);
			ais.add(ia);
		}
		readerAI.close();
	
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
	
		boolean exists = false;
		for(int i=0;i< users.size();i++){
			if(user.equals(users.get(i).getUser().toLowerCase()) && password.equals(users.get(i).getPassword().toLowerCase())){
				exists = true;
				break;
			}
		}
		return exists;
	}
}
