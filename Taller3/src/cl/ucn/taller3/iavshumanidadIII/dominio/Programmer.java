package cl.ucn.taller3.iavshumanidadIII.dominio;

public class Programmer {
	
	private int idProgrammer;
	private String name, lastName, speciality;
	
	public Programmer(int id, String name, String lastName, String speciality) {
		this.idProgrammer = id;
		this.name = name;
		this.lastName = lastName;
		this.speciality = speciality;
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
		return speciality;
	}

	public void setSpecialism(String speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "Programmer [idProgrammer=" + idProgrammer + ", name=" + name
				+ ", lastName=" + lastName + ", specialism=" + speciality + "]";
	}
}
