package fr.ecp.is1220.projet.part1.event;

import java.util.Date;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.NurseState;
import fr.ecp.is1220.projet.part1.core.Patient;


public class Triage extends Event{
	
	protected Nurse nurse;
	
	/**
	 * Début des actions de triage
	 * Lorsqu'une nurse est libre, récupère le premier patient de la file d'attente, le supprime de la file d'attente, et le traite
	 */

	public Triage(EmergencyDepartment ed, Patient patient, Date arrivaldate) {
		super(arrivaldate, patient);
		
		while (ed.returnFreeHumanResource("nurse")==null){ 
		this.nurse = (Nurse) ed.returnFreeHumanResource("nurse");
		nurse.setState(NurseState.OCCUPIED);
		//this.setEndDate(tempsattente); // Je comprends pas comment tu veux le calculer du coup ... 
		// La nurse est ensuite libérée
		nurse.setState(NurseState.ONDUTY);
		this.fillrecord();
		ed.addPatientInWaitingForConsultation(patient);
		}
	}

	/**
	 * traitement lorsqu'il y a plusiers patients dans la file d'attente 
	 */
	

	@Override
	public String toString() {
		return ("Patient enregistré par " + nurse + " à " + startEvent);
	}

	protected void setEndDate (int tempsattente) {
		// Disons que l'arrivée du patient à l'hopital dure 1 minutes
		int year = this.getStartDate().getYear();
		int month = this.getStartDate().getMonth();
		int date = this.getStartDate().getDate();
		int hrs = this.getStartDate().getHours();
		int min = this.getStartDate().getMinutes()+tempsattente ;
		
		this.endEvent = new Date(year, month, date, hrs, min);
		
	}

	@Override
	protected void setEndDate() {
		// TODO Auto-generated method stub
		
	}

}
