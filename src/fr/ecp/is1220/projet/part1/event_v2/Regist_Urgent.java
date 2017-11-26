package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.FullRoom;
import fr.ecp.is1220.projet.part1.Exceptions.noPatientinED;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.NurseState;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.ShockRoom;


// A besoin d'une nurse, d'une shockRoom libre et d'un patient dans la liste "waitingForTriage" avec un statut waiting et un severityLevel L4 ou L5.
// Cet évènement doit etre classé avant (dans la liste EventQueue) les events Regist_NonUrgent (pour un meme timeStamp) 
public class Regist_Urgent extends Regist {

	public Regist_Urgent(int timeStamp, EmergencyDepartment ed, ShockRoom room1, Patient p, Nurse n1) {
		super(timeStamp, ed, room1, p, n1);
		
	}

	@Override
	public void execute() {
		
		try {
			this.nextRoom.newPatient(p1);
		} catch (FullRoom e) {		
			e.printStackTrace();
			return; //si on arrive pas a placer le patient dans la salle, on arrête la méthode ! On ne fait pas la suite
		}
		try {
			this.ed.removePatientWaitingForTriage(p1);
		} catch (noPatientinED e1) {
			System.out.println("Error regist didn't work out");
			return;
		}
		this.p1.setPatientState(PatientState.INSTALLING);
		this.nurse.setState(NurseState.OCCUPIED);
		EndEvent e = new EndEvent(this.timeStamp + 5, this.ed, this.p1); // Mettons que l'installation dans la shock room prend 5 minutes.	
		p1.fillRecord(Integer.toString(p1.getPatientRecord().size()) + " - " + Integer.toString(p1.getId()) +" - Register by nurse : " + Integer.toString(this.nurse.getId()) + " at " + Integer.toString(this.timeStamp) + " - Is placed in room : " + this.nextRoom.getId());
		this.ed.addEventInEventQueue(e);
		FreeNurse e2 = new FreeNurse(this.timeStamp + 5, this.ed, this.nurse); // La nurse est occupée pendant 5 minutes puis libérée de la meme manière que les patients
		this.ed.addEventInEventQueue(e2);

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "registurgent";
	}

}
