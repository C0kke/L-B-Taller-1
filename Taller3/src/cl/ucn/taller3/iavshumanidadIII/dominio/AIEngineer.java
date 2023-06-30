package cl.ucn.taller3.iavshumanidadIII.dominio;

public class AIEngineer extends Programmer{
	
	private String experience;
	private int implementedAlgorithms;
	
	public AIEngineer(int id, String name, String lastName, String specialism,
			String experience, int implementedAlgorithms) {
		super(id, name, lastName, specialism);
		this.experience = experience;
		this.implementedAlgorithms = implementedAlgorithms;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getImplementedAlgorithms() {
		return implementedAlgorithms;
	}

	public void setImplementedAlgorithms(int implementedAlgorithms) {
		this.implementedAlgorithms = implementedAlgorithms;
	}
}
