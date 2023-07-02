package cl.ucn.taller3.iavshumanidadIII.dominio;

public class ThreatAnalyst extends Programmer {
	
	private String capacity;
	private int detectedThreats;
	
	public ThreatAnalyst(int id, String name, String lastName,
			String specialism, String capacity, int detectedThreats) {
		super(id, name, lastName, specialism);
		this.capacity = capacity;
		this.detectedThreats = detectedThreats;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public int getDetectedThreats() {
		return detectedThreats;
	}

	public void setDetectedThreats(int detectedThreats) {
		this.detectedThreats = detectedThreats;
	}

	@Override
	public String toString() {
		return "ThreatAnalyst "+super.toString()+", capacity=" + capacity + ", detectedThreats="
				+ detectedThreats + "]";
	}
	
}
