package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Rooms;

/**
 * Fonctionnemet de l'enregistrement : 
 * La pièce dépend de la sévérité : schoroom si >3, box room sinon 
 * - regarde si une pièce est libre pour pouvoir y placer le patient
 * - le retire de la liste d'attente
 * - change son état à occupé
 *
 * - planifie la fin de l'événement (on supose que l'installation dure 5 minutes)
 * - change l'état de la nurse à occupé jusqu'à la fin de l'installation 
 * - ajoute l'événement à EventQueue
 * 
 */

public abstract class Regist extends Event {
	Rooms nextRoom; //prochaine pièce qui va accueillir le patient ? 
	Patient p1;
	Nurse nurse;
	
	/**
	 * 
	 * @param timeStamp
	 * @param ed
	 * @param room
	 * @param p
	 * @param nurse
	 */
	public Regist(int timeStamp, EmergencyDepartment ed, Rooms room, Patient p, Nurse nurse) {
		super(timeStamp, ed);
		this.nextRoom = room;
		this.p1 = p;
		this.nurse = nurse;
		
	}
}
