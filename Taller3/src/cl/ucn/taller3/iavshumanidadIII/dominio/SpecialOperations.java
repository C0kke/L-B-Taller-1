package cl.ucn.taller3.iavshumanidadIII.dominio;

public class SpecialOperations extends Soldier {
	
	private int  hiddenMissions,totalMissions, obtainedResources;

	public SpecialOperations(int idSoldier, String name, String lastName,
			String nick, String specialism, int soldierValue,
			int hiddenMissions, int totalMissions, int obtainedResources) {
		super(idSoldier, name, lastName, nick, specialism, soldierValue);
		this.hiddenMissions = hiddenMissions;
		this.totalMissions = totalMissions;
		this.obtainedResources = obtainedResources;
	}

	public int getHiddenMissions() {
		return hiddenMissions;
	}

	public void setHiddenMissions(int hiddenMissions) {
		this.hiddenMissions = hiddenMissions;
	}

	public int getTotalMissions() {
		return totalMissions;
	}

	public void setTotalMissions(int totalMissions) {
		this.totalMissions = totalMissions;
	}

	public int getObtainedResources() {
		return obtainedResources;
	}

	public void setObtainedResources(int obtainedResources) {
		this.obtainedResources = obtainedResources;
	}
	
	
}
