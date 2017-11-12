package fr.ecp.is1220.projet.part1.core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import fr.ecp.is1220.projet.part1.event.Arrival;
import fr.ecp.is1220.projet.part1.event.Event;

public class Patient {
	private int id;
	private String name;
	private Insurance insurance;
	private ArrayList<Event> listOfEvent;
	private Date PatientArrivalTime;
	
	/** 
	*On part du principe que le patient n'a pas d'assurance par d�faut
	*O peut aussi cr�er un patient avec assurance
	*L'ID se g�n�re automatiquement, en commen�ant par le pr�fixe 20
	**/
	
	public Patient(String name) {
		super();
		this.name = name;
		IdGenerator idG = IdGenerator.getInstance();
		id = idG.generateId(20);
		this.insurance = Insurance.NO;
		listOfEvent = new ArrayList<>();
	}
	
	public Patient(String name, Insurance insurance) {
		this.insurance=insurance;
		this.name = name;
		IdGenerator idG = IdGenerator.getInstance();
		id = idG.generateId(20);
		listOfEvent = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	@Override
	public String toString() {
		return "Patient [idPatient=" + id + ", name=" + name + ", insurance=" + insurance + "]";
	}
	
	
	
	//------------------------------------------
	
	
	public void arrives(){
		Event arrival = new Arrival()
	}
	
	
	
	
	
	
}
