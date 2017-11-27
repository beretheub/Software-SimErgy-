package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.FullEquipment;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HealthServices;

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
	public HealthServices nextexam; //destination
	
	
	public Transportation(EmergencyDepartment ed, double timeStamp, Transporter transporter, Strecher strecher, Patient pat, HealthServices nextstep ) {
		super(timeStamp, ed);
		this.transporter=transporter;
		this.p1=pat;
		this.strecher=strecher;
		this.nextexam=nextstep;

	}
	
	@Override
	public void execute() {
		try {
			strecher.newPatient(p1);
		} catch (FullEquipment e) {		
			e.printStackTrace();
			return; //Si on ne peut pas placer le patient dans le strecher, on s'arrête
		}

		p1.setPatientState(PatientState.INSTALLING);
		
		p1.fillRecord(Integer.toString(p1.getPatientRecord().size()) + " - " + Integer.toString(p1.getId()) +" - Transporté par " + transporter.getName() + " :" + transporter.getId() + " sur " + strecher.getId() + " at " + Double.toString(this.timeStamp)); 
		EndEvent e = new EndEvent(this.timeStamp + 3, this.ed, p1); // Cet event a pour fonction de mettre a jour l'état du patient pour simuler le temps passé dans l'évent "arrival"
		FreeTransporter e2 = new FreeTransporter(this.timeStamp + 5, this.ed, this.transporter); // le transport dure 5 minutes
		this.ed.addEventInEventQueue(e);
		this.ed.addEventInEventQueue(e2);
		
		this.ed.addPatientWaitingForExam(p1);		
		
	}

	@Override
	public EventsType getType() {
		// TODO Auto-generated method stub
		return EventsType.TRANSPORTATION;
	}

}
