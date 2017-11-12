package fr.ecp.is1220.projet.part1.core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import fr.ecp.is1220.projet.part1.event.Arrival;
import fr.ecp.is1220.projet.part1.event.Event;

public class Patient {
	private EmergencyDepartment ed;
	private int id;
	private String name;
	private Insurance insurance;
<<<<<<< HEAD
	public ArrayList<Event> listOfEvent;
	private Date PatientArrivalTime;
=======
	private ArrayList<Event> listOfEvent;
	private int PatientArrivalTime;
	private SeverityLevel severity;
>>>>>>> dcff7a5e35908d83a645f57c4fb61036aafc3c86
	
	/** 
	*On part du principe que le patient n'a pas d'assurance par défaut
	*O peut aussi créer un patient avec assurance
	*L'ID se génère automatiquement, en commençant par le préfixe 20
	**/
	
	public Patient(EmergencyDepartment ed, String name) {
		super();
		this.ed = ed;
		this.name = name;
		IdGenerator idG = IdGenerator.getInstance();
		id = idG.generateId(20);
		this.insurance = Insurance.NO;
		listOfEvent = new ArrayList<>();
		
	}
	
	public Patient(EmergencyDepartment ed, String name, Insurance insurance) {
		this.ed = ed;
		this.insurance=insurance;
		this.name = name;
		IdGenerator idG = IdGenerator.getInstance();
		id = idG.generateId(20);
		listOfEvent = new ArrayList<>();
	}
	
	public EmergencyDepartment getPatientEd(){
		return ed;
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
	
	public SeverityLevel getSeverity() {
		return severity;
	}

	public void setSeverity(SeverityLevel severity) {
		this.severity = severity;
	}
	
	
	//------------------------------------------
	
	
	public void arrives(){
<<<<<<< HEAD
		Event arrival = new Arrival();
=======
		// First we generate an arrivale time randomly - à préciser par la suite ! Pour l'instant 
		// il arrive uniformément entre la minute 0 et la minute 100
		PatientArrivalTime = (int) Math.random()*100;
		Event arrival = new Arrival(PatientArrivalTime, this);
		listOfEvent.add(arrival); // On ajoute l'évent arrival à la liste des event subis par le patient
>>>>>>> dcff7a5e35908d83a645f57c4fb61036aafc3c86
	}

	
	
	
	
	
	
	
}
