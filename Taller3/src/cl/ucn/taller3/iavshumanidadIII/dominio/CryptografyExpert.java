package cl.ucn.taller3.iavshumanidadIII.dominio;

public class CryptografyExpert extends Programmer {

	private String knowledge, securityExperience, obfuscationAbility;
	private int succesfulImplementations;
	
	public CryptografyExpert(int id, String name, String lastName,
			String specialism, String knowledge, String securityExperience,
			String obfuscationAbility, int succesfulImplementations) {
		super(id, name, lastName, specialism);
		this.knowledge = knowledge;
		this.securityExperience = securityExperience;
		this.obfuscationAbility = obfuscationAbility;
		this.succesfulImplementations = succesfulImplementations;
	}

	public String getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(String knowledge) {
		this.knowledge = knowledge;
	}

	public String getSecurityExperience() {
		return securityExperience;
	}

	public void setSecurityExperience(String securityExperience) {
		this.securityExperience = securityExperience;
	}

	public String getObfuscationAbility() {
		return obfuscationAbility;
	}

	public void setObfuscationAbility(String obfuscationAbility) {
		this.obfuscationAbility = obfuscationAbility;
	}

	public int getSuccesfulImplementations() {
		return succesfulImplementations;
	}

	public void setSuccesfulImplementations(int succesfulImplementations) {
		this.succesfulImplementations = succesfulImplementations;
	}
	
}
