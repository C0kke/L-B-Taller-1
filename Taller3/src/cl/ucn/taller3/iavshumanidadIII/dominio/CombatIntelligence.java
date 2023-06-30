package cl.ucn.taller3.iavshumanidadIII.dominio;

public class CombatIntelligence extends Soldier {
	private int intelligenceReports, identifiedEnemies;

	public CombatIntelligence(int idSoldier, String name, String lastName,
			String nick, String specialism, int soldierValue,
			int intelligenceReports, int identifiedEnemies) {
		super(idSoldier, name, lastName, nick, specialism, soldierValue);
		this.intelligenceReports = intelligenceReports;
		this.identifiedEnemies = identifiedEnemies;
	}

	public int getIntelligenceReports() {
		return intelligenceReports;
	}

	public void setIntelligenceReports(int intelligenceReports) {
		this.intelligenceReports = intelligenceReports;
	}

	public int getIdentifiedEnemies() {
		return identifiedEnemies;
	}

	public void setIdentifiedEnemies(int identifiedEnemies) {
		this.identifiedEnemies = identifiedEnemies;
	}
	
	
}
