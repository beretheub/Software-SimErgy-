package fr.ecp.is1220.projet.part1.event;


import java.util.Calendar;
import java.util.Date;

import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;

public class Arrival extends Event {
	protected SeverityLevel severity;
	protected Date arrivaldate = Calendar.getInstance().getTime();

	
	/**
	 * Si une nurse est libre, le patient est pris en charge. Sinon il patiente en salle d'attente. 
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	public Arrival(Patient P, Date arrivaldate) {
		super();
		this.severity = severity;
		this.arrivaldate = arrivaldate;
	}

	@Override
	public String toString() {
		return "Arrived at" + startevent + ", Niveau de gravité = "+ severity;
	}




}
