package fr.ecp.is1220.projet.part1.core;

import java.util.ArrayList;

public class EmergencyDepartment {
	private String edName;
	private ArrayList<Resources> edResources;
	private ArrayList<Patient> listOfPatientsInTheED;
	private ArrayList<Patient> patientsWaitingForTriage;
	
	/**
	 * Creates a new Emergency department with no resources 
	 * @param edName (String) 
	 */
	public EmergencyDepartment(String edName) {
		super();
		this.edName = edName;
		edResources = new ArrayList<>();
	}
	public String getEdName() {
		return edName;
	}
	public void setEdName(String edName) {
		this.edName = edName;
	}
	public void addResource(Resources res){
		edResources.add(res);
	}
	public void removeResource(Resources res){
		if (edResources.contains(res)){
			edResources.remove(res);
		}
		else{
			//Juste au cas où, normalement
			System.out.println("Error, the ressource which id is : " + res.getId() + " does not belong to this Emergency Departement");
		}
	}
	public void addPatientInED(Patient p){
		listOfPatientsInTheED.add(p);
	}
	public void removePatientInTheED(Patient p){
		if (listOfPatientsInTheED.contains(p)){
			listOfPatientsInTheED.remove(p);
		}
		else{
			//Juste au cas où, normalement
			System.out.println("Error, the patient which id is : " + p.getId() + " is not in this Emergency Departement");
		}
	}
	public void addPatientInWaitingForTriage(Patient p){
		patientsWaitingForTriage.add(p);
	}
	public void removePatientInWaitingForTriage(Patient p){
		if (patientsWaitingForTriage.contains(p)){
			patientsWaitingForTriage.remove(p);
		}
		else{
			//Juste au cas où, normalement
			System.out.println("Error, the patient which id is : " + p.getId() + " is not waiting for triage");
		}
	}
	
	

}
