package fr.ecp.is1220.projet.part1.event;

import java.util.Date;

import fr.ecp.is1220.projet.part1.Exceptions.noNurseAvailableException;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.NurseState;
import fr.ecp.is1220.projet.part1.core.Patient;


public class Triage extends Event{
	
	protected Nurse nurse;
	
	/**
	 * D�but des actions de triage
	 * Lorsqu'une nurse est libre, r�cup�re le premier patient de la file d'attente, le supprime de la file d'attente, et le traite
	 */

	public Triage(EmergencyDepartment ed, Patient patient, Date arrivaldate) throws noNurseAvailableException {
		super(arrivaldate, patient);
		
		if (ed.returnFreeHumanResource("nurse") != null){
			this.nurse = (Nurse) ed.returnFreeHumanResource("nurse");
			this.setEndDate(2);
			this.fillrecord();
			nurse.setState(NurseState.OCCUPIED);
			nurse.nextFreeTime(this.endEvent); //(la fonction cette fonction donne � la nurse l'information de quand elle sera � nouveau disponible (il faudra qu'elle sache le g�rer par elle m�me)
			// Changer pour mettre les patients dans les waitingroom et shockroom plutot 
			ed.addPatientInWaitingForConsultation(patient);
		}
		else{
			throw new noNurseAvailableException();
		}
	}

	/**
	 * traitement lorsqu'il y a plusiers patients dans la file d'attente.  
	 */
	// Commentaire par rapport � ce qu'il y a juste au dessus. Je pense qu'il est plus logique que ce cas
	//soit trait� par la classe Emergency Departement car, chaque instance de la classe Triage est
	//li�e � un unique patient.

	@Override
	public String toString() {
		return ("Patient enregistr� par " + nurse + " � " + startEvent);
	}
}
