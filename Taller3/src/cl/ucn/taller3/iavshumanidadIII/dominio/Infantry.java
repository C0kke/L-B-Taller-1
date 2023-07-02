package cl.ucn.taller3.iavshumanidadIII.dominio;

public class Infantry extends Soldier {
	
	private int completedMissions;
	private String weapen;
	public Infantry(int idSoldier, String name, String lastName, String nick,
			String specialism, int soldierValue, int completedMissions,
			String weapen) {
		super(idSoldier, name, lastName, nick, specialism, soldierValue);
		this.completedMissions = completedMissions;
		this.weapen = weapen;
	}
	public int getCompletedMissions() {
		return completedMissions;
	}
	public void setCompletedMissions(int acomplisheMissions) {
		this.completedMissions = acomplisheMissions;
	}
	public String getWeapon() {
		return weapen;
	}
	public void setWeapon(String weapen) {
		this.weapen = weapen;
	}
	@Override
	public String toString() {
		return "Infantry "+super.toString()+"completedMissions=" + completedMissions + ", weapen="
				+ weapen + "]";
	}
	
}
