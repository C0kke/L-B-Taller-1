package cl.ucn.taller3.iavshumanidadIII.dominio;

public class User {
	private String name, user, password, country;

	public User(String name, String user, String password, String country) {
		this.name = name;
		this.user = user;
		this.password = password;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}	
}
