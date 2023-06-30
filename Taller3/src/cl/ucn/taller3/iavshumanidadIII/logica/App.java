package cl.ucn.taller3.iavshumanidadIII.logica;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import cl.ucn.taller3.iavshumanidadIII.dominio.User;
public class App {
	public static void main(String[] args) throws FileNotFoundException {
		List<User> users = new ArrayList<User>();
		generateUsers(users);
		if(!login(users)){
			System.out.println("Denied access");
		}else{
			System.out.println("Succesful access");
		}
	}
	private static void generateUsers(List<User> users) throws FileNotFoundException{
		Scanner readerUsers = new Scanner(new File("Users.txt"));
		while(readerUsers.hasNextLine()){
			String[] parts = readerUsers.nextLine().split(",");
			String user = parts[0].trim();
			String password = parts[1].trim();
			String country = parts[2].trim();
			User u = new User(user, password, country);
			users.add(u);
		}
		readerUsers.close();
	}
	@SuppressWarnings("resource")
	private static boolean login(List<User> users) {
		
		Scanner login = new Scanner(System.in);
		boolean exists = false;
		System.out.println("Username: \n");
		String user = login.nextLine().toLowerCase(); 
		System.out.println("Password: \n");
		String password = login.nextLine();
		for(int i=0;i< users.size();i++){
			if(user.equals(users.get(i).getUser()) && password.equals(users.get(i).getPassword())){
				exists = true;
			}
		}
		return exists;
	}
}
