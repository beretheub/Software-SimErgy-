package fr.ecp.is1220.projet.part1.core;

import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;
import fr.ecp.is1220.projet.part1.ObserverPattern.Observer;

/** 
 * Classe physician : h�rite de la classe humanresources
 * Param�tres : 
 * 	- Etat(nursestate)
 * 	- Liste des patients trait�s (ArrayList<Patient>)
 * 	- Boite de r�ception des messages (ArrayList<String>)
 */
public class Physician extends HumanResources implements Observer, java.io.Serializable {
	

	private static final long serialVersionUID = -4641842343038708876L;
	private PhysicianState state;
	private ArrayList<Patient> patientsTreated = new ArrayList<>();
	private ArrayList<String> messageBox = new ArrayList<>();

	/** 
	 * Par d�faut, un m�decin cr�� est au travail et disponible
	 * @param ed
	 * @param name
	 * @param surname
	 * @throws WrongIDAttribution
	 */
	public Physician(EmergencyDepartment ed, String name, String surname){
		super(ed, name, surname);
		this.state = PhysicianState.ONDUTY;
		for(HealthServices hs : ed.listOfHealthServices){
			hs.registerObserver(this);
		}
	}
	public Physician(EmergencyDepartment ed, String name, String surname, PhysicianState choice){
		super(ed, name, surname);
		this.setState(choice);
		for(HealthServices hs : ed.listOfHealthServices){
			hs.registerObserver(this);
		}
	}
	/**
	 * Remplace l'�tat du m�decin par celui en param�tre
	 */
	public void setState(PhysicianState choice){
		this.state = choice;
		
	}
	/**
	 * Retourne l'�tat du m�decin
	 */
	public PhysicianState getState(){
		return this.state;
	}
	
	/**
	 * Retourne le type de ressource : m�decin ici
	 */
	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.PHYSICIAN;
	}
	
	/**
	 * Ajoute le patient en param�tre � la liste trait�e par le m�decin
	 */
	public void newPatientTreated(Patient patient){
		patientsTreated.add(patient);
	}
	/**
	 * Retourne la liste de patients trait� par le m�decin
	 */
	ArrayList<Patient> getPatientsTreated(){
		return patientsTreated;
	}
	/**
	 * Ajoute le message en param�tre � la liste des messages re�us
	 */
	public void newMessage(String message){
		messageBox.add(message);
	}
	/**
	 * Retourne la boite de r�ception du m�decin, sous forme d'une ArrayList
	 */
	ArrayList<String> getMessageBox(){
		return messageBox;
		
	}
	/**
	 * Affiche le contenu de la messagerie
	 */
	public void printMessageBox(){
		System.out.println("--- Physician " + this.getName() + " " + this.getSurname() + " (id : " + this.getId() + " ) ---");
		System.out.println("Patient treated : ");
		for(Patient pat : patientsTreated){
			System.out.println("- id:" + pat.getId() + " - severity : " + pat.getSeverity());
		}
		for (int i = 0; i < messageBox.size(); i++) {
			System.out.println("Message " + i + " - " + messageBox.get(i));
		}		 
	}
	
	@Override
	public void update(String message, Patient patient) {
		if(this.patientsTreated.contains(patient)){
			this.messageBox.add(message);
		}
	}
	
	/**
	 * Prescrit un examen � l'issu d'une consultation � un temps donn� en param�tre, et � un patient en param�tre, selon la probabilit� donn�e par l'�nonc�
	 * @param pat
	 * @param timeStamp
	 * @return
	 */
	public Output prescribeExam(Patient pat, double timeStamp) {
		double output = Math.random();
		
		if (output <= 0.35){
			this.newMessage("Prescribe no further test for patient " + Integer.toString(pat.getId()) + " at time " + Double.toString(timeStamp)); 
			return Output.NOTEST;
		}else if (output <= 0.50){
			this.newMessage("Prescribe Radiography test for patient " + Integer.toString(pat.getId()) + " at time " + Double.toString(timeStamp));
			return Output.RADIOGRAPHY;
		}else if (output <= 0.62){
			this.newMessage("Prescribe blood test for patient " + Integer.toString(pat.getId()) + " at time " + Double.toString(timeStamp));
			return Output.BLOODTEST;
		}else if (output <= 0.75){
			this.newMessage("Prescribe scanner for patient " + Integer.toString(pat.getId()) + " at time " + Double.toString(timeStamp));
			return Output.SCAN;
		}else if (output <= 0.95){
				this.newMessage("Prescribe Xray for patient " + Integer.toString(pat.getId()) + " at time " + Double.toString(timeStamp));
			return Output.XRAY;
		}else{
			this.newMessage("Prescribe MRI for patient " + Integer.toString(pat.getId()) + " at time " + Double.toString(timeStamp));
			return Output.MRI;
		}
		
	}

	
	

	
	
	
	
}
