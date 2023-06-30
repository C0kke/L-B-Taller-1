package cl.ucn.taller3.iavshumanidadIII.dominio;

public class LogisticSupport extends Soldier {
	
	private int  distributedSupplies,supportsTroops;

	public LogisticSupport(int idSoldier, String name, String lastName,
			String nick, String specialism, int soldierValue,
			int distributedSupplies, int supportsTroops) {
		super(idSoldier, name, lastName, nick, specialism, soldierValue);
		this.distributedSupplies = distributedSupplies;
		this.supportsTroops = supportsTroops;
	}

	public int getDistributedSupplies() {
		return distributedSupplies;
	}

	public void setDistributedSupplies(int distributedSupplies) {
		this.distributedSupplies = distributedSupplies;
	}

	public int getSupportsTroops() {
		return supportsTroops;
	}

	public void setSupportsTroops(int supportsTroops) {
		this.supportsTroops = supportsTroops;
	}
	
	
}	
