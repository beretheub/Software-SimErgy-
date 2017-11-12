package fr.ecp.is1220.projet.part1.event;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import fr.ecp.is1220.projet.part1.core.Patient;

public abstract class Event {
	public Date startevent = Calendar.getInstance().getTime();
	public Date endevent;
	public Patient patient; 
	public ArrayList<Patient> fileattente = new ArrayList<>(); 
	

	/**
	 * L'événement s'éxécute sur le patient 
	 */
	public abstract void execute();
	
	/**
	 * Le patient rejoint la file d'attente
	 */
	public void fileattente (Patient p) {
		if (fileattente.isEmpty()){
			this.execute();
		}
		else { 
			fileattente.add(patient);
			
			
		}
	}
	
	/**
	 * La fiche patient est remplie
	 */
	public void fillrecord(){
		patient.listOfEvent.add(this);
	}
	
	public abstract String toString();
	}
	
	
}
