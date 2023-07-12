package cl.ucn.taller3.iavshumanidadIII.dominio;

import java.util.LinkedList;
import java.util.List;

public class Battle {
	private String userName;
	private LinkedList<String> team;
	private String aiName;
	private String result;
	private int score;
	
	public Battle(String userName, List<String> team, String aIName, String result, int score) {
		this.userName = userName;
		this.team = (LinkedList<String>) team;
		this.aiName = aIName;
		this.result = result;
		this.score = score;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LinkedList<String> getTeam() {
		return team;
	}

	public void setTeam(LinkedList<String> team) {
		this.team = team;
	}

	public String getAiName() {
		return aiName;
	}

	public void setAiName(String aiName) {
		this.aiName = aiName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Battle: "+ userName + " V/S " + aiName
				+ ", result:" + result;
	}	
	
}
