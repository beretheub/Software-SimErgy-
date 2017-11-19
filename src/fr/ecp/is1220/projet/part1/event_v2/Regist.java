package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Rooms;

/**
 * Fonctionnemet de l'enregistrement : 
 * La pi�ce d�pend de la s�v�rit� : schoroom si >3, box room sinon 
 * - regarde si une pi�ce est libre pour pouvoir y placer le patient
 * - le retire de la liste d'attente
 * - change son �tat � occup�
 *
 * - planifie la fin de l'�v�nement (on supose que l'installation dure 5 minutes)
 * - change l'�tat de la nurse � occup� jusqu'� la fin de l'installation 
 * - ajoute l'�v�nement � EventQueue
 * 
 */

public abstract class Regist extends Event {
	Rooms nextRoom; //prochaine pi�ce qui va accueillir le patient ? 
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
