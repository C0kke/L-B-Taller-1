package cl.ucn.taller3.iavshumanidadIII.dominio;

public class Artillery extends Soldier {
	private int destroyedObjectives;
	private String precision;
	public Artillery(int idSoldier, String name, String lastName, String nick,
			String specialism, int soldierValue, int destroyedObjectives,
			String precision) {
		super(idSoldier, name, lastName, nick, specialism, soldierValue);
		this.destroyedObjectives = destroyedObjectives;
		this.precision = precision;
	}
	public int getDestroyedObjectives() {
		return destroyedObjectives;
	}
	public void setDestroyedObjectives(int destroyedObjectives) {
		this.destroyedObjectives = destroyedObjectives;
	}
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	@Override
	public String toString() {
		return "Artillery "+super.toString()
				+ ", destroyedObjectives=" + destroyedObjectives
				+ ", precision=" + precision + "]";
	}
	
}
