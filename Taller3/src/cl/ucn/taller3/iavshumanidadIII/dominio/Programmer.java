package cl.ucn.taller3.iavshumanidadIII.dominio;

public class Programmer {
	
	private int idProgrammer;
	private String name, lastName, specialism;
	
	public Programmer(int id, String name, String lastName, String specialism) {
		this.idProgrammer = id;
		this.name = name;
		this.lastName = lastName;
		this.specialism = specialism;
	}
	
	public int getId() {
		return idProgrammer;
	}

	public void setId(int id) {
		this.idProgrammer = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSpecialism() {
		return specialism;
	}

	public void setSpecialism(String specialism) {
		this.specialism = specialism;
	}
}
