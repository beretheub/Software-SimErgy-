package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.noPatientinED;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;

import fr.ecp.is1220.projet.part1.core.Strecher;
import fr.ecp.is1220.projet.part1.core.Transporter;
import fr.ecp.is1220.projetc.part2.simulation.EventsType;

/**
 * Fonctionnemet du transport : 
 * Durée fixe de 5 minutes
 * 
 */

public class Transportation extends Event {
	Transporter transporter;
	Patient p1;
	Strecher strecher;
	private double duree;
	
	
	
	public Transportation(EmergencyDepartment ed, double timeStamp, Transporter transporter, Strecher strecher, Patient pat) {
		super(timeStamp, ed);
		this.transporter=transporter;
		this.p1=pat;
		this.strecher=strecher;
		this.duree = 5;
		

	}
	
	@Override
	public void execute() {
		
		strecher.newPatient();

		p1.setPatientState(PatientState.INSTALLING);
		
		p1.fillRecord(Integer.toString(p1.getPatientRecord().size()) + " - " + Integer.toString(p1.getId()) +" - Transporté par " + transporter.getName() + " :" + transporter.getId() + " sur " + strecher.getId() + " at " + Double.toString(this.timeStamp)); 
		EndEvent e = new EndEvent(this.timeStamp + this.duree, this.ed, p1); // Cet event a pour fonction de mettre a jour l'état du patient pour simuler le temps passé dans l'évent "arrival"
		FreeTransporter e2 = new FreeTransporter(this.timeStamp + this.duree, this.ed, this.transporter); // le transport dure 5 minutes
		FreeStrecher e3 = new FreeStrecher(this.timeStamp + this.duree, this.ed, this.strecher);
		this.ed.addEventInEventQueue(e);
		this.ed.addEventInEventQueue(e2);
		this.ed.addEventInEventQueue(e3);
		
		try {
			this.ed.removePatientWaitingForTransportation(p1);
		} catch (noPatientinED e1) {
			System.out.println("The removal of patient " + Integer.toString(p1.getId())+  " from the waiting for transportation didn't work");
		}
		this.ed.addPatientWaitingForExam(p1);		
		
	}

	@Override
	public EventsType getType() {
		
		return EventsType.TRANSPORTATION;
	}

}
