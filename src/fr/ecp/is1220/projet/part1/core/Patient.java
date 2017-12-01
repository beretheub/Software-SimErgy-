package fr.ecp.is1220.projet.part1.core;


import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.Exceptions.DTDTException;
import fr.ecp.is1220.projet.part1.Exceptions.LOSException;
import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;

/** Classe patient : repr�sente un patient et toutes ses caract�ristiques
 Param�tres : 
 * 	- ED (ed)
 * 	- Identifiant (int)
 * 	- Nom  (String)
 * 	- Assurance (Insurance)
 * 	- Dossier patient (ArrayList<String>)
 * 	- S�v�rit� de l'atteinte (severity)
 * 	- Etat (PatientState)
 * 	- Prochaine �tape (output)
 * 	- Prix � payer (double)
 * 	- Temps pass� � l'ED : LOS(double)
 * 	- Porte � Porte: DTDT(double)
 */
public class Patient {
	
	private EmergencyDepartment ed;
	private int id;
	private String name;
	private Insurance insurance;
	private ArrayList<String> patientRecord;
	private SeverityLevel severity;
	private PatientState state;
	public Output nextstep;
	public double totalcharge;
	private double arrivalTime;
	private double firstPhysicianTime;
	private double departureTime;
	

	
	/** 
	*On part du principe que le patient n'a pas d'assurance par d�faut
	*O peut aussi cr�er un patient avec assurance
	*L'ID se g�n�re automatiquement, en commen�ant par le pr�fixe 20
	 * @throws WrongIDAttribution 
	**/
	
	public Patient(EmergencyDepartment ed, String name){
		super();
		this.ed = ed;
		this.name = name;
		IdGenerator idG = IdGenerator.getInstance();
		try {
			id = idG.generateId(20);
		} catch (WrongIDAttribution e) {
			//n'arrivera jamais
		}
		this.insurance = Insurance.NO;
		patientRecord = new ArrayList<>();
		this.state = PatientState.WAITING; //�a veut dire qu'il ne fait rien, n'est pas en transport etc...
		this.totalcharge=0;
		this.nextstep = Output.CONSULTATION;
		this.firstPhysicianTime = -1;  // time par d�faut, si on retrouve �a par la suite c'est que le chiffre n'a pas �t� trait�, il faut g�rer particuli�rement la situation
		this.departureTime = -1;
		this.arrivalTime = -1;
	}
	
	public Patient(EmergencyDepartment ed, String name, Insurance insurance) throws WrongIDAttribution {
		this.ed = ed;
		this.insurance=insurance;
		this.name = name;
		IdGenerator idG = IdGenerator.getInstance();
		id = idG.generateId(20);
		patientRecord = new ArrayList<>();
		this.state = PatientState.WAITING;
		this.totalcharge=0;
		this.nextstep = Output.CONSULTATION;
		this.firstPhysicianTime = -1;
	}
	
	public void setArrivalTime(double time){
		this.arrivalTime = time;
	}
	public void setFirstPhysicianTime(double time){
		if (this.firstPhysicianTime < 0){
			this.firstPhysicianTime = time;
		}
	}
	public void setDepartureTime(double time){
		this.departureTime = time;
	}
	
	/** 
	 * retourne le dossier du patient
	 */
	public ArrayList<String> getPatientRecord(){
		return patientRecord;
		
	}
	
	/**
	 * Remplit le dossier du patient avec le message en param�tre
	 */
	public void fillRecord(String message){

		patientRecord.add(message);
	}
	
	/**
	 * Affiche le dossier du patient a
	 */
	public void printPatientRecord(){
		System.out.println("id : " + Integer.toString(this.getId()) + " ----- Patient Record -----");
		for (String string : patientRecord) {
			System.out.println(string);
		}
	}
	
	/** 
	 * Retourne l'ED dans lequel le patient est enregistr�
	 * 	 
	 */
	public EmergencyDepartment getPatientEd(){
		return ed;
	}
	/** Retourne l'identifiant du patient 
	 * 	 
	 */
	public int getId() {
		return id;
	}

	/**
	 * Retourne le nom du patient
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retourne l'assurance du patient
	 * @return
	 */
	public Insurance getInsurance() {
		return insurance;
	}

	/** Remplace le nom du patient par celui en param�tre 
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Remplace l'assurance du patient par celle en param�tre
	 * @param insurance
	 */
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	
	/**
	 * Retourne le niveau de s�v�rit� auquel le patient est atteint (L1 � L5)
	 * @return
	 */
	public SeverityLevel getSeverity() {
		return severity;
	}
	
	
	
	/**
	 * Remplace la s�v�rit� par celle en param�tre
	 */
	public void setSeverity(SeverityLevel severity) {
		this.severity = severity;
	}
	/**
	 * Remplace l'�tat du patient par celui en param�tre 
	 * @param state
	 */
	public void setPatientState(PatientState state) {
		this.state = state;
	}
	public PatientState getPatientState(){
		return this.state;
	}

		/** Retourne la prochaine �tape que va suivre le patient
		 * 
		 * @return
		 */
	public Output getNexstep() {
		return nextstep;
	}

	/**
	 * Fixe la prochaine �tape que va suivre le patient � celle donn�e en param�tre
	 * @param nextstep
	 */
	public void setNexstep(Output nextstep) {
		this.nextstep = nextstep;
	}

	/** Ajoute � la note du patient la charge en param�tre, apr�s calcul � l'aide de la fonction calculPrixService
	 * 
	 * @param newcharge
	 */
	public void addcharges(double newcharge) {
		this.totalcharge = this.totalcharge+calculPrixService(newcharge);
	}
	
	/** Calcule le prix du service en param�tre en fonction de l'assurance du patient
	 * 
	 * @param coutservice
	 * @return
	 */
	public double calculPrixService(double coutservice) {
		if (this.insurance==Insurance.NO){
			return coutservice;
		}
		else if (this.insurance==Insurance.SILVER){
			return (coutservice/50);
		}
		else {
			return (coutservice*(80/100));
		}
	}
	
	/** 
	 * 
	 */
	public double returnLOS() throws LOSException{
		if(this.departureTime == -1 || this.arrivalTime == -1){
			throw new LOSException();
		}
		if(this.departureTime > this.arrivalTime){
			return this.departureTime - this.arrivalTime;
		}else{
			throw new LOSException();
		}
		
	}
	
	public double returnDTDT() throws DTDTException {
		if(this.arrivalTime == -1 || this.firstPhysicianTime == -1){
			throw new DTDTException();
		}
		if(this.firstPhysicianTime > this.arrivalTime){
			return this.firstPhysicianTime - this.arrivalTime;
		}else{
			throw new DTDTException();
		}
		
	}
	
}
