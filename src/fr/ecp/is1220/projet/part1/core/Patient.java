package fr.ecp.is1220.projet.part1.core;


import java.util.ArrayList;
import java.util.Date;

import fr.ecp.is1220.projet.part1.event.Arrival;
import fr.ecp.is1220.projet.part1.event.Event;

public class Patient {
	private EmergencyDepartment ed;
	private int id;
	private String name;
	private Insurance insurance;
	private ArrayList<Event> listOfEvent;
	private SeverityLevel severity;

	
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
	
	public ArrayList<Event> getListOfEvent(){
		return listOfEvent;
	}
	public void addEvent(Event event){
		listOfEvent.add(event);
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
	
	
	@SuppressWarnings("deprecation")
	public void arrives(){
		
		Date PatientArrivalTime = new Date();
		// A titre d'exemple. Pour l'instant. Après il faudra gérer la  
		PatientArrivalTime.setTime(Date.parse( "Sat, 12 Aug 1995 13:30:00 GMT"));
		Event arrival = (Event) new Arrival(this, PatientArrivalTime);
	}

	
	
	
	
	
	
	
}
