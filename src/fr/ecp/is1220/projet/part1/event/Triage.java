package fr.ecp.is1220.projet.part1.event;

import java.util.Date;

import fr.ecp.is1220.projet.part1.Exceptions.FullRoom;
import fr.ecp.is1220.projet.part1.Exceptions.noNurseAvailableException;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.NurseState;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;
import fr.ecp.is1220.projet.part1.core.ShockRoom;
import fr.ecp.is1220.projet.part1.core.WaitingRoom;


public class Triage extends Event{
	
	protected Nurse nurse;
	
	/**
	 * Début des actions de triage
	 * Lorsqu'une nurse est libre, récupère le premier patient de la file, le place dans une waiting room ou shock room en fonction de son état
	 */

	public Triage(EmergencyDepartment ed, Patient patient, Date arrivaldate) throws noNurseAvailableException {
		super(arrivaldate, patient);
		
		if (ed.returnFreeHumanResource("nurse") != null){
			this.nurse = (Nurse) ed.returnFreeHumanResource("nurse");
			this.setEndDate(2);
			this.fillrecord();
			nurse.setState(NurseState.OCCUPIED);
			nurse.nextFreeTime(this.endEvent); //(la fonction cette fonction donne à la nurse l'information de quand elle sera à nouveau disponible (il faudra qu'elle sache le gérer par elle même)
			// Changer pour mettre les patients dans les waitingroom et shockroom plutot 
			if (patient.getSeverity() == SeverityLevel.L1 || patient.getSeverity() == SeverityLevel.L2 || patient.getSeverity() == SeverityLevel.L3){
				WaitingRoom wRoom = (WaitingRoom) patient.getPatientEd().returnFreeNonHumanResources("waitingroom");
				try {
					wRoom.newPatient(patient);
				} catch (FullRoom e) {
					System.out.println("The patient there is non free space in the waiting room, the patient ( " + patient.getId() + " ) has to wait a little more before triage");
				}
				
			}else if (patient.getSeverity() == SeverityLevel.L4 || patient.getSeverity() == SeverityLevel.L5){
				ShockRoom wRoom = (ShockRoom) patient.getPatientEd().returnFreeNonHumanResources("shockroom");
				try {
					wRoom.newPatient(patient);
				} catch (FullRoom e) {
					System.out.println("The patient there is non free space in the shock room, the patient ( " + patient.getId() + " ) has to wait a little more before triage");
				}
			}
		}
		else{
			throw new noNurseAvailableException();
		}
	}

	/**
	 * traitement lorsqu'il y a plusiers patients dans la file d'attente.  
	 */
	// Commentaire par rapport à ce qu'il y a juste au dessus. Je pense qu'il est plus logique que ce cas
	//soit traité par la classe Emergency Departement car, chaque instance de la classe Triage est
	//liée à un unique patient.

	@Override
	public String toString() {
		return ("Patient enregistré par " + nurse + " à " + startEvent);
	}
}
