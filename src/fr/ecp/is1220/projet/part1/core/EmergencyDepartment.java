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
	
	/**
	 * Return the first free resource of the type you choose with your arguent (String) btw Nurse, Physician, Transporter
	 * @param type
	 * @return 
	 */
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
	}
	
	// -------------------------------------------------
	
	
	/**
	 * Fonction qui prend le patient le plus urgent (ou avec un certain coef, le patient qui a attendu le plus longtemps.
	 * 
	 */
	public void triage(){
		if(this.isNurseAvailable()){
			
		}
	}
	

}
