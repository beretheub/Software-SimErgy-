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
	private ArrayList<Event> eventQueue;
	private ArrayList<Patient> patientWaitingForExam;
	private ArrayList<Patient> patientWaitingForTransportation;
	private ArrayList<Patient> listOfEndedPatient;
	
	
	/**
	 * Creates a new Emergency department with no resources 
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
	public void removePatientInTheED(Patient p) throws noPatientinED{
		if (listOfPatientsInTheED.contains(p)){
			listOfPatientsInTheED.remove(p);
		}
		else{
			//Juste au cas où, normalement
			throw new noPatientinED();
		}
	}
	public void printPatientInTheEd(){
		System.out.println("------ List of Patient in the Emergency Departement ------");
		for (Patient patient : listOfPatientsInTheED) {
			System.out.println("id " + patient.getId() + " - name : " + patient.getName());
			
		}
	}
	public void addPatientWaitingForTriage(Patient p){
		patientWaitingForTriage.add(p);
		p.setPatientState(PatientState.WAITING);
	}
	public void removePatientWaitingForTriage(Patient p) throws noPatientinED{
		if (patientWaitingForTriage.contains(p)){
			patientWaitingForTriage.remove(p);
			p.setPatientState(PatientState.INSTALLING);
		}
		else{
			throw new noPatientinED();
		}
	}
		
	public void addPatientWaitingForExam(Patient p1) {
			// TODO Auto-generated method stub
		patientWaitingForExam.add(p1);
		p1.setPatientState(PatientState.WAITING);
		}
	
	public void removePatientWaitingForExam(Patient p) throws noPatientinED{
		if (patientWaitingForExam.contains(p)){
			patientWaitingForExam.remove(p);
			p.setPatientState(PatientState.TAKINGEXAM);
		}
		else{
			throw new noPatientinED();
		}
	}
	public void addPatientWaitingForTransportation(Patient p1) {
		// TODO Auto-generated method stub
	patientWaitingForTransportation.add(p1);
	p1.setPatientState(PatientState.WAITING);
	}

	public void removePatientWaitingForTransportation(Patient p) throws noPatientinED{
		if (patientWaitingForTransportation.contains(p)){
			patientWaitingForTransportation.remove(p);
			p.setPatientState(PatientState.INTRANSPORT);
		}
		else{
			throw new noPatientinED();
		}
		}
	
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
	 * Returns the first HR of the asked type that is available from the list of resources of the ED
	 * @param (String) the type of resource you want : nurse, physician or transporter
	 * 
	 *  if there is no such hr available or if the type entered as parameter is wrong returns null 
	 */
	public HumanResources returnFreeHumanResource(String type) {
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
	/**
	 * Returns the first NHR of the asked type that is available from the list of resources of the ED
	 * @param (String) the type of resource you want : nurse, physician or transporter
	 * 
	 *  if there is no such hr available or if the type entered as parameter is wrong returns null 
	 */
	public Rooms returnFreeNonHumanResources(String Choice) {
		return null;
		
	}

// ------------------------------------------------------ Méthodes d'event
	
	
	public void addEventInEventQueue(Event e) {
		eventQueue.add(e);
		//eventQueue.sort(); Il faut absolument créer une fonction qui réordone temporellement la liste
		//Et utiliser cette méthode à chaque fois que l'on touche à la liste eventQueue
		//A coder quand on s'occupera de la partie 2
		
	}
	

	
	/**public ArrayList<Event> sortEvent(ArrayList<Event> eQ){
	* Comparator<Event> comparator = (e1, e2) -> (getIntSeveritylevel(e1.patient) < getIntSeveritylevel(e2.patient)) ? 1 : ((getIntSeverityLevel(e1.patient) == getIntSeverityLevel(e2.patient) ? 0 : -1)); 
	* eQ.sort(comparator);
	* return eQ;
	* }
	**/

}
