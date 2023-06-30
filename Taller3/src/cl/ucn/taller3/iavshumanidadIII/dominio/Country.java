package cl.ucn.taller3.iavshumanidadIII.dominio;

public class Country {
	
	private String name;
	private int prepopulation, postpopulation, attacks, recluitedPeople;
	
	public Country(String name, int prepopulation, int postpopulation,
			int attacks, int recluitedPeople) {
		this.name = name;
		this.prepopulation = prepopulation;
		this.postpopulation = postpopulation;
		this.attacks = attacks;
		this.recluitedPeople = recluitedPeople;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrepopulation() {
		return prepopulation;
	}

	public void setPrepopulation(int prepopulation) {
		this.prepopulation = prepopulation;
	}

	public int getPostpopulation() {
		return postpopulation;
	}

	public void setPostpopulation(int postpopulation) {
		this.postpopulation = postpopulation;
	}

	public int getAttacks() {
		return attacks;
	}

	public void setAttacks(int attacks) {
		this.attacks = attacks;
	}

	public int getRecluitedPeople() {
		return recluitedPeople;
	}

	public void setRecluitedPeople(int recluitedPeople) {
		this.recluitedPeople = recluitedPeople;
	}

}
