package cl.ucn.taller3.iavshumanidadIII.logica;
import java.util.*;

import cl.ucn.taller3.iavshumanidadIII.dominio.User;
public class App {
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		while(Login(users) != true){
			Login(users);
		}
	}

	private static boolean Login(List<User> users) {
		
		Scanner login = new Scanner(System.in);
		boolean exists = false;
		System.out.println("Username: \n");
		String user = login.nextLine().toLowerCase(); 
		System.out.println("Password: \n");
		String password = login.nextLine();
		login.close();
		for(int i=0;i< users.size();i++){
			if(user == users.get(i).getUser() && password == users.get(i).getPassword()){
				System.out.println("Acceso Correcto");
				exists = true;
			}else{
				System.out.println("Acceso Denegado");
				exists = false;
			}
		}
		return exists;
	}
}
