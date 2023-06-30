package cl.ucn.taller3.iavshumanidadIII.dominio;

public class User {
	private String user, password, country;

	public User(String user, String password, String country) {
		
		this.user = user;
		this.password = password;
		this.country = country;
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
