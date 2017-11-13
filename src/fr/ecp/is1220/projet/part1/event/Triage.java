package fr.ecp.is1220.projet.part1.event;

import java.util.Date;

import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Patient;

public class Triage extends Event{
	
	protected Nurse nurse;
	
	public Triage(Date arrivalDate, Patient patient) {
		super(arrivalDate, patient);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public String toString() {
		return "Patient enregistré par " + nurse + " à " + startEvent;
	}

	@Override
	protected void setEndDate() {
		// TODO Auto-generated method stub
		
	}
}
