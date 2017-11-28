package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.FullRoom;
import fr.ecp.is1220.projet.part1.Exceptions.noPatientinED;
import fr.ecp.is1220.projet.part1.core.BoxRoom;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.NurseState;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projetc.part2.simulation.EventsType;


//A besoin d'une nurse, d'une waiting Room libre et d'un patient dans la liste "waitingForTriage" avec un statut waiting et un severityLevel L1, L3 ou L3.
// Cet evènement doit etre classé temporellement après un Regist_Urgent (dans eventQueue) pour un meme timeStamp quand on s'attaque à la partie temporelle
public class Regist_NonUrgent extends Regist {
		private int duration;

		public Regist_NonUrgent(double timeStamp, EmergencyDepartment ed, BoxRoom room1, Patient p, Nurse n1) {
			super(timeStamp, ed, room1, p, n1);	
			duration = 5; // mettons 5 minutes -> faire une distribution de proba ?
		}

		@Override
		public void execute(){
			
			try {
				this.nextRoom.newPatient(p1);
			} catch (FullRoom e) {		
				e.printStackTrace();
				return; //si on arrive pas a placer le patient dans la salle, on arrête la méthode ! On ne fait pas la suite
			}
			try {
				this.ed.removePatientWaitingForTriage(p1);
			} catch (noPatientinED e1) {
					System.out.println("ERROR : Regist Didn't work");
					return;
			}
			this.p1.setPatientState(PatientState.INSTALLING);
			this.nurse.setState(NurseState.OCCUPIED);
			p1.calculDTDT(duration);
			p1.calculLOS(duration);
			EndEvent e = new EndEvent(this.timeStamp + duration, this.ed, this.p1); // Mettons que l'installation dans la shock room prend 5 minutes.	
			p1.fillRecord(Integer.toString(p1.getPatientRecord().size()) + " - " + Integer.toString(p1.getId()) +" - Register by nurse : " + Integer.toString(this.nurse.getId()) + " at " + Double.toString(this.timeStamp) + " - Is placed in room : " + this.nextRoom.getId());
			
			this.ed.addEventInEventQueue(e);
			FreeNurse e2 = new FreeNurse(this.timeStamp + duration, this.ed, this.nurse); // La nurse est occupée pendant 5 minutes puis libérée de la meme manière que les patients
			this.ed.addEventInEventQueue(e2);

		}

		@Override
		public EventsType getType() {
			// TODO Auto-generated method stub
			return EventsType.REGISTNONURGENT;
		}


}
