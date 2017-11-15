package fr.ecp.is1220.projet.part1.core;

import java.util.ArrayList;
import java.util.Date;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;
import fr.ecp.is1220.projet.part1.Exceptions.RessourceEDException;
import fr.ecp.is1220.projet.part1.event.Arrival;
import fr.ecp.is1220.projet.part1.event.Chrono;
import fr.ecp.is1220.projet.part1.event.Consultation;
import fr.ecp.is1220.projet.part1.event.Event;
import fr.ecp.is1220.projet.part1.event.Triage;

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
		patientsWaitingForConsultation = new ArrayList<>();
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
			//Juste au cas o�, normalement
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
			//Juste au cas o�, normalement
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
			//Juste au cas o�, normalement
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
		Date patientarrivaltime = (patient.getListOfEvent()).get(0).endEvent; // on r�cup�re la date : c'est celle de la fin de la p�riode d'arriv�e
		Event triage = (Event) new Triage(this, patient, patientarrivaltime);
	}
	
	public void addPatientInWaitingForConsultation(Patient p){
		patientsWaitingForConsultation.add(p);
	}

	public void removePatientInWaitingForConsultation(Patient p){
		if (patientsWaitingForConsultation.contains(p)){
			patientsWaitingForConsultation.remove(p);
		}
		else{
			//Juste au cas o�, normalement
			System.out.println("Error, the patient which id is : " + p.getId() + " is not waiting for consultation");
		}
	}
	public Patient getfirstPatientInWaitingForConsultation(){ // Il faut absolument g�rer le cas ou il n'y a pas de patient dans la liste !
		Patient p = patientsWaitingForConsultation.get(0);
		this.removePatientInWaitingForConsultation(p);
		return (p);
	}
	
	public void consultationpatients() throws ParameterUnifException{
		Patient patient = this.getfirstPatientInWaitingForConsultation();	
		Date patientarrivaltime = (patient.getListOfEvent()).get(1).endEvent; // on r�cup�re la date : c'est celle de la fin du triage
		Event consultation = (Event) new Consultation(this,patient, patientarrivaltime);
	}
	/**
	 * Returns the first HR of the asked type that is available from the list of resources of the ED
	 * @param (String) the type of resource you want : nurse, physician or transporter
	 * 
	 *  if there is no such hr available or if the type entered as parameter is wrong returns null 
	 */
	public HumanResources returnFreeHumanResource(String type) {
		// Je ne fais pas le truc le plus optimis�
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
