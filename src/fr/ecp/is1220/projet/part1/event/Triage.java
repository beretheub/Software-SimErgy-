package fr.ecp.is1220.projet.part1.event;

import java.util.Date;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Patient;

public class Triage extends Event{
	
	protected Nurse nurse;
	
	/**
	 * D�but des actions de ttraige
	 * Lorsqu'une nurse est libre, r�cup�re le premier patient de la file d'attente, le supprime de la file d'attente, et le traite
	 */
	public Triage(EmergencyDepartment ed, Date endEvent) {
		super(endEvent, patient);
		Chrono chrono = new Chrono();
		chrono.start(); // d�marrage du chrono
		while (ed.isNurseAvailable()==false){
			wait();
		}
		notify();
		chrono.stop(); // arr�t
		this.setEndDate(chrono.getDureeSec());
		this.fillrecord();

		}

	/**
	 * traitement lorsqu'il y a plusiers patients dans la file d'attente 
	 */
	

	@Override
	public String toString() {
		return "Patient enregistr� par " + nurse + " � " + startEvent;
	}

	@Override
	protected void setEndDate(chrono) {
		// Disons que l'arriv�e du patient � l'hopital dure 1 minutes
		int year = this.getStartDate().getYear();
		int month = this.getStartDate().getMonth();
		int date = this.getStartDate().getDate();
		int hrs = this.getStartDate().getHours();
		int min = this.getStartDate().getMinutes()+chrono/60 ;
		
		this.endEvent = new Date(year, month, date, hrs, min);
		
	}
}
