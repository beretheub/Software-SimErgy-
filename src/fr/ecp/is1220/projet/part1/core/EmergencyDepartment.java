package fr.ecp.is1220.projet.part1.core;

import java.util.ArrayList;
import fr.ecp.is1220.projet.part1.Exceptions.RessourceEDException;
import fr.ecp.is1220.projet.part1.Exceptions.noPatientinED;
import fr.ecp.is1220.projet.part1.event_v2.Event;


public class EmergencyDepartment {
	private String edName;
	private ArrayList<Resources> edResources;
	public ArrayList<Patient> listOfPatientsInTheED;
	private ArrayList<Patient> patientWaitingForTriage;
	public ArrayList<Event> eventQueue;
	private ArrayList<Patient> patientWaitingForExam;
	private ArrayList<Patient> patientWaitingForTransportation;
	public ArrayList<Patient> listOfEndedPatient;
	private ArrayList<HealthServices> listOfHealthServices;
	
	
	/**
	 * ED : Emergency Department 
	 * C'est le coeur du système, qui permet de gérer toutes les listes de patients, présents dans l'ED, ou dans une file d'attente précise, ainsi que l'ensemble des ressources. 
	 * Paramètres : 
	 * 	- Nom (string)
	 * 	- Liste de ressources (ArrayList<Resources> : Rooms, HumaRessources, Equipment, ...)
	 * 	- Liste de patients présents dans le service d'urgences (ArrayList<Patient>)
	 * 	- Listes de patients dans la queue pour l'enregistrement, le transport, ou l'examen (ArrayList<Patient>)
	 * 	- Liste d'événements en attente d'être réalisés (ArrayList<Event>)
	 *  - Liste de patients sortis de l'ED (ArrayList<Patient>)
	 */
	
	/**
	 * Constructeur : crée un ED, sans ressources à l'état initial
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
	 * Remplace le nom de l'ED par celui en paramètre
	 */
	public void setEdName(String edName) {
		this.edName = edName;
	}
	
	/**
	 * Ajoute la ressource en paramètre à la liste de ressources que comprend l'ED
	 */
	public void addResource(Resources res){
		edResources.add(res);
	}
	
	/**
	 * Supprime la ressource en paramètre de la liste de ressources que comprend l'ED
	 * Si elle n'y est pas, lève une exception
	 */
	public void removeResource(Resources res) throws RessourceEDException{
		if (edResources.contains(res)){
			edResources.remove(res);
		}
		else{
			//Juste au cas où, normalement
			throw new RessourceEDException(); 
		}
	}
	
	/**
	 * Ajoute le patient en paramètre à la liste de patients que comprend l'ED
	 */
	public void addPatientInED(Patient p){
		listOfPatientsInTheED.add(p);
	}
	
	/**
	 * Supprime le patient en paramètre de la liste de patients que comprend l'ED
	 * Si il n'y est pas, lève une exception
	 */
	public void removePatientInTheED(Patient p) throws noPatientinED{
		if (listOfPatientsInTheED.contains(p)){
			listOfPatientsInTheED.remove(p);
		}
		else{
			//Juste au cas où, normalement
			throw new noPatientinED();
		}
	}
	
	/**
	 * Affiche la liste des patients présents dans l'ED
	 */
	public void printPatientInTheEd(){
		System.out.println("------ List of Patient in the Emergency Departement ------");
		for (Patient patient : listOfPatientsInTheED) {
			System.out.println("id " + patient.getId() + " - name : " + patient.getName());
			
		}
	}
	
	/**
	 * Ajoute le patient en paramètre à la file d'attente enregistrement
	 */
	public void addPatientWaitingForTriage(Patient p){
		patientWaitingForTriage.add(p);
		
	}
	
	/**
	 * Supprime le patient en paramètre de la file d'attente enregistrement
	 * Si il n'y est pas, lève une exception
	 */
	public void removePatientWaitingForTriage(Patient p) throws noPatientinED{
		if (patientWaitingForTriage.contains(p)){
			patientWaitingForTriage.remove(p);
			
		}
		else{
			throw new noPatientinED();
		}
	}
	
	/**
	 * Ajoute le patient en paramètre à la file d'attente examen
	 */
	public void addPatientWaitingForExam(Patient p1) {
			// TODO Auto-generated method stub
		patientWaitingForExam.add(p1);
		
		}
	
	/**
	 * Supprime le patient en paramètre de la file d'attente examen
	 * Si il n'y est pas, lève une exception
	 */
	public void removePatientWaitingForExam(Patient p) throws noPatientinED{
		if (patientWaitingForExam.contains(p)){
			patientWaitingForExam.remove(p);
			
		}
		else{
			throw new noPatientinED();
		}
	}
	
	/**
	 * Ajoute le patient en paramètre à la file d'attente transport
	 */
	public void addPatientWaitingForTransportation(Patient p1) {
		// TODO Auto-generated method stub
	patientWaitingForTransportation.add(p1);
	
	}

	/**
	 * Supprime le patient en paramètre de la file d'attente transport
	 * Si il n'y est pas, lève une exception
	 */
	public void removePatientWaitingForTransportation(Patient p) throws noPatientinED{
		if (patientWaitingForTransportation.contains(p)){
			patientWaitingForTransportation.remove(p);
			
		}
		else{
			throw new noPatientinED();
		}
		}
	
	/**
	 * Supprime le patient en paramètre de l'ED
	 * Si il n'y est pas, lève une exception
	 */
	public void patientOutOfEmergencyDepartment(Patient patient) {
		listOfEndedPatient.add(patient);
		
		try {
			this.removePatientInTheED(patient);
		} catch (noPatientinED e) {
			System.out.println(Integer.toString(patient.getId()) + " : is already out of the ED");
			return;
		}
		
	}
		
		
	/**
	 * Calcul le LOS moyen pour l'ensemble des patients déjà traités
	 */
		
	double averagelos(){
		double moy=0;
		for(Patient p1:this.listOfEndedPatient){
			moy=moy+p1.los;
		}
		moy = (double)moy/(((CharSequence) this.listOfEndedPatient).length());
		return moy;
	}
	
	/**
	 * Calcul le dtdt moyen pour l'ensemble des patients déjà traités
	 */
		
	double averagedtdt(){
		double moy=0;
		for(Patient p1:this.listOfEndedPatient){
			moy=moy+p1.dtdt;
		}
		moy = (double)moy/(((CharSequence) this.listOfEndedPatient).length());
		return moy;
	}
	
	/**
	 * Returns the first HR of the asked type that is available from the list of resources of the ED
	 * @param (String) the type of resource you want : nurse, physician or transporter
	 * 
	 *  if there is no such hr available or if the type entered as parameter is wrong returns null 
	 */
	public HumanResources returnFreeHumanResource(ResourcesType type) {
		// Je ne fais pas le truc le plus optimisé 
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

// ------------------------------------------------------ Méthodes d'event
	
	
	public void addEventInEventQueue(Event e) {
		eventQueue.add(e);
		EmergencyDepartment.sortEventQueue(eventQueue);
		
	}
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

	public HealthServices returnHealthService(ResourcesType choice) {
		for (HealthServices hr : listOfHealthServices) {
			if (hr.getType() == choice){
				return hr;
			}
		}
		return null;
	}

	public ArrayList<Patient> getListOfPatientWaitingForTransporation() {
		return patientWaitingForTransportation;
	}

	public ArrayList<Patient> getListOfPatientWaitingForExam() {
		return patientWaitingForExam;
	}
	

}
