package pt.sali.SALI.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

public class Glasgow {
	
	@Id
	private String id;
	private ArrayList<String> olhos;
	private ArrayList<String> verbal;
	private ArrayList<String> motor;
	
	public Glasgow() {
		super();
		this.id = null;
		this.olhos = new ArrayList<>();
		this.verbal = new ArrayList<>();
		this.motor = new ArrayList<>();
	}

	public ArrayList<String> getOlhos() {
		return olhos;
	}

	public void setOlhos(ArrayList<String> olhos) {
		this.olhos = olhos;
	}

	public ArrayList<String> getVerbal() {
		return verbal;
	}

	public void setVerbal(ArrayList<String> verbal) {
		this.verbal = verbal;
	}

	public ArrayList<String> getMotor() {
		return motor;
	}

	public void setMotor(ArrayList<String> motor) {
		this.motor = motor;
	}

	public String getId() {
		return id;
	}
		
}