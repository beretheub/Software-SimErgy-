package fr.ecp.is1220.projet.part1.core;

import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.Exceptions.RessourceEDException;
import fr.ecp.is1220.projet.part1.event.Arrival;
import fr.ecp.is1220.projet.part1.event.Event;

public class EmergencyDepartment {
	private String edName;
	private ArrayList<Resources> edResources;
	private ArrayList<Patient> listOfPatientsInTheED;
	private ArrayList<Patient> patientsWaitingForTriage;
	private ArrayList<Patient> patientsWaitingForConsultation;
	
	/**
	 * Creates a new Emergency department with no resources 
	 * @param edName (String) 
	 */
	public EmergencyDepartment(String edName) {
		super();
		this.edName = edName;
		edResources = new ArrayList<>();
		listOfPatientsInTheED = new ArrayList<>();
		patientsWaitingForTriage = new ArrayList<>();
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
	public void removeResource(Resources res) throws RessourceEDException{
		if (edResources.contains(res)){
			edResources.remove(res);
		}
		else{
			//Juste au cas où, normalement
			throw new RessourceEDException(); 
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
	public void printPatientInTheEd(){
		System.out.println("------ List of Patient in the Emergency Departement ------");
		for (Patient patient : listOfPatientsInTheED) {
			System.out.println("id " + patient.getId() + " - name : " + patient.getName());
			
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
	

	public Patient getfirstPatientInWaitingForTriage(){
		Patient p = patientsWaitingForTriage.get(0);
		this.removePatientInWaitingForTriage(p);
		return (p);
	}
	
	public void triagepatients(){
		Patient patient = this.getfirstPatientInWaitingForTriage();	
		Event triage = (Event) new Triage(patient, PatientArrivalTime);
	}
	
	public void addPatientInWaitingForConsultation(Patient p){
		patientsWaitingForConsultation.add(p);
	}

	public void removePatientInWaitingForConsultation(Patient p){
		if (patientsWaitingForConsultation.contains(p)){
			patientsWaitingForConsultation.remove(p);
		}
		else{
			//Juste au cas où, normalement
			System.out.println("Error, the patient which id is : " + p.getId() + " is not waiting for consultation");
		}
	}
	public Patient getfirstPatientInWaitingForConsultation(){
		Patient p = patientsWaitingForConsultation.get(0);
		this.removePatientInWaitingForConsultation(p);
		return (p);
	}
	
	public void consultationpatients(){
		Patient patient = this.getfirstPatientInWaitingForConsultation();	
		Event triage = (Event) new Consultation(patient, PatientArrivalTime);
	}
	
	private HumanResources returnFreeHumanResource(String type) {
		// Je ne fais pas le truc le plus optimisé
			for (Resources resources : edResources) {
				if (resources.getType() == type && type.equalsIgnoreCase("nurse")){
					Nurse resources1 = (Nurse) resources;
					if (resources1.getState() == NurseState.ONDUTY){
						return (HumanResources) resources;
						}
					}else if (resources.getType() == type && type.equalsIgnoreCase("physician")){
						Physician resources1 = (Physician) resources;
						if (resources1.getState() == PhysicianState.ONDUTY){
							return (HumanResources) resources;
						}
					}else if (resources.getType() == type && type.equalsIgnoreCase("transporter")){
						Transporter resources1 = (Transporter) resources;
						if (resources1.getState() == TransporterState.ONDUTY){
							return (HumanResources) resources;
						}
					}else{
						return null;
					}
			}
			return null;
		}
}
