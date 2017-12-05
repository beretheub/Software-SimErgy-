package fr.ecp.is1220.projet.part1.core;

import java.util.ArrayList;
import fr.ecp.is1220.projet.part1.Exceptions.RessourceEDException;
import fr.ecp.is1220.projet.part1.Exceptions.NoPatientinED;
import fr.ecp.is1220.projet.part1.event_v2.Event;


public class EmergencyDepartment {
	private String edName;
	public ArrayList<Resources> edResources;
	public ArrayList<Patient> listOfPatientsInTheED;
	private ArrayList<Patient> patientWaitingForTriage;
	public ArrayList<Event> eventQueue;
	private ArrayList<Patient> patientWaitingForExam;
	private ArrayList<Patient> patientWaitingForTransportation;
	public ArrayList<Patient> listOfEndedPatient;
	public ArrayList<HealthServices> listOfHealthServices;
	
	
	/**
	 * ED : Emergency Department 
	 * C'est le coeur du syst�me, qui permet de g�rer toutes les listes de patients, pr�sents dans l'ED, ou dans une file d'attente pr�cise, ainsi que l'ensemble des ressources. 
	 * Param�tres : 
	 * 	- Nom (string)
	 * 	- Liste de ressources (ArrayList<Resources> : Rooms, HumaRessources, Equipment, ...)
	 * 	- Liste de patients pr�sents dans le service d'urgences (ArrayList<Patient>)
	 * 	- Listes de patients dans la queue pour l'enregistrement, le transport, ou l'examen (ArrayList<Patient>)
	 * 	- Liste d'�v�nements en attente d'�tre r�alis�s (ArrayList<Event>)
	 *  - Liste de patients sortis de l'ED (ArrayList<Patient>)
	 */
	
	/**
	 * Constructeur : cr�e un ED, sans ressources � l'�tat initial
	 * @param edName (String) 
	 */
	public EmergencyDepartment(String edName) {
		super();
		this.edName = edName;
		edResources = new ArrayList<>();
		listOfPatientsInTheED = new ArrayList<>();
		eventQueue = new ArrayList<>();
		patientWaitingForTriage = new ArrayList<>();
		patientWaitingForExam = new ArrayList<>();
		patientWaitingForTransportation = new ArrayList<>();
		listOfEndedPatient = new ArrayList<>();
		listOfHealthServices = new ArrayList<>();
	}
	
	/**
	 * Retourne le nom de l'ED
	 */
	public String getEdName() {
		return edName;
	}
	
	/**
	 * Remplace le nom de l'ED par celui en param�tre
	 */
	public void setEdName(String edName) {
		this.edName = edName;
	}
	
	/**
	 * Ajoute la ressource en param�tre � la liste de ressources que comprend l'ED
	 */
	public void addResource(Resources res){
		edResources.add(res);
	}
	
	/**
	 * Supprime la ressource en param�tre de la liste de ressources que comprend l'ED
	 * Si elle n'y est pas, l�ve une exception
	 */
	public void removeResource(Resources res) throws RessourceEDException{
		if (edResources.contains(res)){
			edResources.remove(res);
		}
		else{
			//Juste au cas o�, normalement
			throw new RessourceEDException(); 
		}
	}
	
	/**
	 * Ajoute le patient en param�tre � la liste de patients que comprend l'ED
	 */
	public void addPatientInED(Patient p){
		listOfPatientsInTheED.add(p);
	}
	
	/**
	 * Supprime le patient en param�tre de la liste de patients que comprend l'ED
	 * Si il n'y est pas, l�ve une exception
	 */
	public void removePatientInTheED(Patient p) throws NoPatientinED{
		if (listOfPatientsInTheED.contains(p)){
			listOfPatientsInTheED.remove(p);
		}
		else{
			//Juste au cas o�, normalement
			throw new NoPatientinED();
		}
	}
	
	/**
	 * Affiche la liste des patients pr�sents dans l'ED
	 */
	public void printPatientInTheEd(){
		System.out.println("------ List of Patient in the Emergency Departement ------");
		for (Patient patient : listOfPatientsInTheED) {
			System.out.println("id " + patient.getId() + " - name : " + patient.getName());
			
		}
	}
	
	/**
	 * Ajoute le patient en param�tre � la file d'attente enregistrement
	 */
	public void addPatientWaitingForTriage(Patient p){
		patientWaitingForTriage.add(p);
		
	}
	
	/**
	 * Supprime le patient en param�tre de la file d'attente enregistrement
	 * Si il n'y est pas, l�ve une exception
	 */
	public void removePatientWaitingForTriage(Patient p) throws NoPatientinED{
		if (patientWaitingForTriage.contains(p)){
			patientWaitingForTriage.remove(p);
			
		}
		else{
			throw new NoPatientinED();
		}
	}
	
	/**
	 * Ajoute le patient en param�tre � la file d'attente examen
	 */
	public void addPatientWaitingForExam(Patient p1) {
			// TODO Auto-generated method stub
		patientWaitingForExam.add(p1);
		
		}
	
	/**
	 * Supprime le patient en param�tre de la file d'attente examen
	 * Si il n'y est pas, l�ve une exception
	 */
	public void removePatientWaitingForExam(Patient p) throws NoPatientinED{
		if (patientWaitingForExam.contains(p)){
			patientWaitingForExam.remove(p);
			
		}
		else{
			throw new NoPatientinED();
		}
	}
	
	/**
	 * Ajoute le patient en param�tre � la file d'attente transport
	 */
	public void addPatientWaitingForTransportation(Patient p1) {
		// TODO Auto-generated method stub
	patientWaitingForTransportation.add(p1);
	
	}

	/**
	 * Supprime le patient en param�tre de la file d'attente transport
	 * Si il n'y est pas, l�ve une exception
	 */
	public void removePatientWaitingForTransportation(Patient p) throws NoPatientinED{
		if (patientWaitingForTransportation.contains(p)){
			patientWaitingForTransportation.remove(p);
			
		}
		else{
			throw new NoPatientinED();
		}
		}
	
	/**
	 * Supprime le patient en param�tre de l'ED
	 * Si il n'y est pas, l�ve une exception
	 */
	public void patientOutOfEmergencyDepartment(Patient patient) {
		listOfEndedPatient.add(patient);
		
		try {
			this.removePatientInTheED(patient);
		} catch (NoPatientinED e) {
			System.out.println(Integer.toString(patient.getId()) + " : is already out of the ED");
			return;
		}
		
	}
		
		
	
	
	/**
	 * Returns the first HR of the asked type that is available from the list of resources of the ED
	 * @param (String) the type of resource you want : nurse, physician or transporter
	 * 
	 *  if there is no such hr available or if the type entered as parameter is wrong returns null 
	 */
	public HumanResources returnFreeHumanResource(ResourcesType type) {
		// Je ne fais pas le truc le plus optimis� 
			for (Resources resources : edResources) {
				if (resources.getType() == type && type == ResourcesType.NURSE){
					Nurse resources1 = (Nurse) resources;
					if (resources1.getState() == NurseState.ONDUTY){
						return (HumanResources) resources;
						}
					}else if (resources.getType() == type && type == ResourcesType.PHYSICIAN){
						Physician resources1 = (Physician) resources;
						if (resources1.getState() == PhysicianState.ONDUTY){
							return (HumanResources) resources;
						}
					}else if (resources.getType() == type && type == ResourcesType.TRANSPORTER){
						Transporter resources1 = (Transporter) resources;
						if (resources1.getState() == TransporterState.ONDUTY){
							return (HumanResources) resources;
						}
					}
			}
			return null;
		}
	/**
	 * Returns the first NHR of the asked type that is available from the list of resources of the ED
	 * @param (String) the type of resource you want : nurse, physician or transporter
	 * 
	 *  if there is no such hr available or if the type entered as parameter is wrong returns null 
	 */
	public NonHumanResources returnFreeNonHumanResources(ResourcesType type) {
		for (Resources resources : edResources) {
			if (resources.getType() == type && type == ResourcesType.BOXROOM){
				BoxRoom resources1 = (BoxRoom) resources;
				if (resources1.isFree()){
					return (NonHumanResources) resources;
					}
				}else if (resources.getType() == type && type == ResourcesType.SHOCKROOM){
					ShockRoom resources1 = (ShockRoom) resources;
					if (resources1.isFree()){
						return (NonHumanResources) resources;
					}
				}else if (resources.getType() == type && type == ResourcesType.STRECHER){
					Strecher resources1 = (Strecher) resources;
					if (resources1.isFree()){
						return (NonHumanResources) resources;
					}
				}
		}
		return null;
		
	}
	/**
	 * Displays the state of the  Emergency Departement
	 * 
	 */
	public void displayState(){
		System.out.println("----- ED : " + this.getEdName() + " : state -----");
		System.out.println("- " +  this.listOfPatientsInTheED.size() + " patients in the ed");
		System.out.println("- " + this.listOfEndedPatient.size() + " patients out of the ed");
		System.out.println("-- Patient waiting for triange and visit -- ");
		for (Patient pat : patientWaitingForTriage){
			pat.printPatientPath();
		}
		System.out.println("-- Patient waiting for exam -- ");
		for (Patient pat : patientWaitingForExam){
			pat.printPatientPath();
		}
		System.out.println("-- Physisician in the ed -- ");
		for (Resources phy : edResources){
			if(phy.getType() == ResourcesType.PHYSICIAN){
				Physician phy1 = (Physician) phy;
				phy1.printMessageBox();
			}
		}
		
		
	}
 
// ------------------------------------------------------ M�thodes d'event
	
	/**
	 * Adds an event in the event Queue
	 * Then sorts the event queue
	 * @param event 
	 */
	public void addEventInEventQueue(Event e) {
		eventQueue.add(e);
		EmergencyDepartment.sortEventQueue(eventQueue);
		
	}
	/**
	 * Sorts the event queue by crescent order of time stamp 
	 */
	public static void sortEventQueue(ArrayList<Event> eventQueue2) {
	
	for (int i = eventQueue2.size() - 1; i >= 0; i--) {
		for (int j = 0; j < i; j++) {
			if(eventQueue2.get(j+1).timeStamp < eventQueue2.get(j).timeStamp){
				Event e = eventQueue2.get(j);
				Event e2 = eventQueue2.get(j+1);
				eventQueue2.remove(j);
				eventQueue2.remove(j);
				
				eventQueue2.add(j, e2);
				eventQueue2.add(j+1, e);
			}
			
		}
		
	}
	
}

	public ArrayList<Patient> getListOfPatientsWaitingForTriage() {
		
		return patientWaitingForTriage;
	}

	public void addHealthServices(HealthServices healthServices) {
		this.listOfHealthServices.add(healthServices);
		
	}
	/**
	 * Return a room that is occupied by a patient (waiting for a transporter)
	 * @param type of room
	 * @return room occupied
	 */
	public Rooms getOccupiedRoom(ResourcesType type) {
		for (Resources resources : edResources) {
			if (resources.getType() == type && type == ResourcesType.BOXROOM){
				BoxRoom resources1 = (BoxRoom) resources;
				if (!resources1.isFree()){
					if(resources1.getPatientsInside().get(0).getPatientState() == PatientState.WAITING){
						return (Rooms) resources;
					}
				}
			}else if (resources.getType() == type && type == ResourcesType.SHOCKROOM){
				ShockRoom resources1 = (ShockRoom) resources;
				if (!resources1.isFree()){
					if(resources1.getPatientsInside().get(0).getPatientState() == PatientState.WAITING){
						return (Rooms) resources;
					}
				}
			}
		}
		return null;
	}
	/**
	 * Return the health service of choice 
	 * 
	 */
	public HealthServices returnHealthService(ResourcesType choice) {
		for (HealthServices hr : listOfHealthServices) {
			if (hr.getType() == choice){
				return hr;
			}
		}
		return null;
	}
	/**
	 * Returns the list of patient waiting for transportation (Arraylist<Patient>)
	 * @return
	 */
	public ArrayList<Patient> getListOfPatientWaitingForTransporation() {
		return patientWaitingForTransportation;
	}
	/**
	 * Return the list of patient waiting for exam (Arraylist<Patient>)
	 * @return
	 */
	public ArrayList<Patient> getListOfPatientWaitingForExam() {
		return patientWaitingForExam;
	}
	

}
