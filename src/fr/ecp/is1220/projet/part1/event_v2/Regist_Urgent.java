package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.FullRoom;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.NurseState;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.Rooms;
import fr.ecp.is1220.projet.part1.core.ShockRoom;

// A besoin d'une nurse, d'une shockRoom libre et d'un patient dans la liste "waitingForTriage" avec un statut waiting et un severityLevel L4 ou L5.
public class Regist_Urgent extends Regist {

	public Regist_Urgent(int timeStamp, EmergencyDepartment ed, Rooms room1, Patient p, Nurse n1) {
		super(timeStamp, ed, room1, p, n1);
		
	}

	@Override
	public void execute() {
		
		try {
			this.nextRoom.newPatient(p1);
		} catch (FullRoom e) {		
			e.printStackTrace();
			return; //si on arrive pas a placer le patient dans la salle, on arr�te la m�thode ! On ne fait pas la suite
		}
		this.ed.removePatientWaitingForTriage(p1);
		this.p1.setPatientState(PatientState.OCCUPIED);
		this.nurse.setState(NurseState.OCCUPIED);
		EndEvent e = new EndEvent(this.timeStamp + 5, this.ed, this.p1); // Mettons que l'installation dans la shock room prend 5 minutes.	
		p1.fillRecord(Integer.toString(p1.getPatientRecord().size()) + " - " + Integer.toString(p1.getId()) +" - Register by " + this.nurse + " at " + Integer.toString(this.timeStamp) + " - Is placed in room : " + this.nextRoom.getId());
		this.ed.addEventInEventQueue(e);
		FreeNurse e2 = new FreeNurse(this.timeStamp + 5, this.ed, this.nurse); // La nurse est occup�e pendant 5 minutes puis lib�r�e de la meme mani�re que les patients
		this.ed.addEventInEventQueue(e2);

	}

}
