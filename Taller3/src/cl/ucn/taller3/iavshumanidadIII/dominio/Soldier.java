package cl.ucn.taller3.iavshumanidadIII.dominio;

public class Soldier {
	
	private String name, lastName, nick, specialism;
	private int idSoldier, soldierValue;
	public Soldier(int idSoldier,String name , String lastName, String nick,String speciality, int soldierValue) {
		this.name = name;
		this.lastName = lastName;
		this.nick = nick;
		this.specialism = speciality;
		this.idSoldier = idSoldier;
		this.soldierValue = soldierValue;
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getSpecialism() {
		return specialism;
	}
	public void setSpecialism(String specialism) {
		this.specialism = specialism;
	}
	public int getIdSoldier() {
		return idSoldier;
	}
	public void setIdSoldier(int idSoldier) {
		this.idSoldier = idSoldier;
	}
	public int getSoldierValue() {
		return soldierValue;
	}
	public void setSoldierValue(int soldierValue) {
		this.soldierValue = soldierValue;
	}
	@Override
	public String toString() {
		return "Soldier [name=" + name + ", lastName=" + lastName + ", nick="
				+ nick + ", specialism=" + specialism + ", idSoldier="
				+ idSoldier + ", soldierValue=" + soldierValue;
	}
	
}
