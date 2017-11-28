package fr.ecp.is1220.projet.part1.core;


import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;

/** Classe patient : représente un patient et toutes ses caractéristiques
 Paramètres : 
 * 	- ED (ed)
 * 	- Identifiant (int)
 * 	- Nom  (String)
 * 	- Assurance (Insurance)
 * 	- Dossier patient (ArrayList<String>)
 * 	- Sévérité de l'atteinte (severity)
 * 	- Etat (PatientState)
 * 	- Prochaine étape (output)
 * 	- Prix à payer (double)
 * 	- Temps passé à l'ED : LOS(double)
 * 	- Porte à Porte: DTDT(double)
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
	public double los;
	public double dtdt;
	

	
	/** 
	*On part du principe que le patient n'a pas d'assurance par défaut
	*O peut aussi créer un patient avec assurance
	*L'ID se génère automatiquement, en commençant par le préfixe 20
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
		this.state = PatientState.WAITING; //ça veut dire qu'il ne fait rien, n'est pas en transport etc...
		this.totalcharge=0;
		this.nextstep = Output.CONSULTATION;
		this.dtdt=0;
		this.los=0;
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
	}
	
	/** 
	 * retourne le dossier du patient
	 */
	public ArrayList<String> getPatientRecord(){
		return patientRecord;
		
	}
	
	/**
	 * Remplit le dossier du patient avec le message en paramètre
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
	 * Retourne l'ED dans lequel le patient est enregistré
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

	/** Remplace le nom du patient par celui en paramètre 
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Remplace l'assurance du patient par celle en paramètre
	 * @param insurance
	 */
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	
	/**
	 * Retourne le niveau de sévérité auquel le patient est atteint (L1 à L5)
	 * @return
	 */
	public SeverityLevel getSeverity() {
		return severity;
	}
	
	/**
	 * Retourne l'entier correspondant au niveau de sévérité du patient (1 à 5)
	 * @return
	 */
	public int getIntSeverity() {
		if (severity==SeverityLevel.L1) { return 1;}
		else if (severity==SeverityLevel.L2) { return 2;}
		else if (severity==SeverityLevel.L3) { return 3;}
		else if (severity==SeverityLevel.L4) { return 4;}
		else {return 5;}
	}
	
	/**
	 * Remplace la sévérité par celle en paramètre
	 */
	public void setSeverity(SeverityLevel severity) {
		this.severity = severity;
	}
	/**
	 * Remplace l'état du patient par celui en paramètre 
	 * @param state
	 */
	public void setPatientState(PatientState state) {
		this.state = state;
	}
	public PatientState getPatientState(){
		return this.state;
	}

		/** Retourne la prochaine étape que va suivre le patient
		 * 
		 * @return
		 */
	public Output getNexstep() {
		return nextstep;
	}

	/**
	 * Fixe la prochaine étape que va suivre le patient à celle donnée en paramètre
	 * @param nextstep
	 */
	public void setNexstep(Output nextstep) {
		this.nextstep = nextstep;
	}

	/** Ajoute à la note du patient la charge en paramètre, après calcul à l'aide de la fonction calculPrixService
	 * 
	 * @param newcharge
	 */
	public void addcharges(double newcharge) {
		this.totalcharge = this.totalcharge+calculPrixService(newcharge);
	}
	
	/** Calcule le prix du service en paramètre en fonction de l'assurance du patient
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
	
	/** Ajoute la durée en paramèle à la durée totale passée dans l'ED
	 */
	public void calculLOS(double duree){
		this.los=this.los+duree;
	}
	/** Ajoute la durée en paramèle à la durée en porte à porte passée dans l'ED
	 */
	public void calculDTDT(double duree){
		this.dtdt=this.dtdt+duree;
	}
	
}
