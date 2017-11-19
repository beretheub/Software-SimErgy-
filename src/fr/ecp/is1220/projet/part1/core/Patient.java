package fr.ecp.is1220.projet.part1.core;


import java.util.ArrayList;


public class Patient {
	private EmergencyDepartment ed;
	private int id;
	private String name;
	private Insurance insurance;
	private ArrayList<String> patientRecord;
	private SeverityLevel severity;
	@SuppressWarnings("unused")
	private PatientState state;

	
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
		patientRecord = new ArrayList<>();
		this.state = PatientState.WAITING; //ça veut dire qu'il ne fait rien, n'est pas en transport etc...
		
	}
	
	public Patient(EmergencyDepartment ed, String name, Insurance insurance) {
		this.ed = ed;
		this.insurance=insurance;
		this.name = name;
		IdGenerator idG = IdGenerator.getInstance();
		id = idG.generateId(20);
		patientRecord = new ArrayList<>();
		this.state = PatientState.WAITING;
	}
	
	public ArrayList<String> getPatientRecord(){
		return patientRecord;
		
	}
	public void fillRecord(String message){
		patientRecord.add(message);
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
	public int getIntSeverity() {
		if (severity==SeverityLevel.L1) { return 1;}
		else if (severity==SeverityLevel.L2) { return 2;}
		else if (severity==SeverityLevel.L3) { return 3;}
		else if (severity==SeverityLevel.L4) { return 4;}
		else {return 5;}
	}

	public void setSeverity(SeverityLevel severity) {
		this.severity = severity;
	}

	public void setPatientState(PatientState state) {
		this.state = state;
	}

	
	
	
	
	
	
	
}
