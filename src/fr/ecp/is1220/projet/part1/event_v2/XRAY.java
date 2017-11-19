package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.FullRoom;
import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Uniform;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.Output;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.PhysicianState;
import fr.ecp.is1220.projet.part1.core.Rooms;

public class XRAY extends Exam {
	public double duree;

	/**
	 * Fonctionnemet de la visite : 
	 * - temps de duree suit une loi de probabilité uniforme (15,90)
	 * - verdict : j'ai décidé de façon arbitraire que ce serait : 35% consultation, 35% sortie de l'hopital, 30% hospitalisation 
	 * 
	 */	

	public XRAY(int timeStamp, EmergencyDepartment ed, HealthServices room, Patient p1,Physician phys) throws ParameterUnifException {
		super(timeStamp, ed, room, p1, phys);
		this.duree=calculduree();
				
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute() {
		this.exam.newPatient(p1);
		
		this.physician.setState(PhysicianState.VISITING);
		this.p1.setPatientState(PatientState.TAKINGEXAM);
		EndEvent e = new EndEvent((int)(this.timeStamp + duree), this.ed, this.p1); 
		p1.fillRecord(Integer.toString(p1.getPatientRecord().size()) + " - " + Integer.toString(p1.getId()) + " - Actually in examroom "+ exam.getName() + " : " + exam.getId() + " - Taking exam with " + Integer.toString(this.physician.getId()) + " at " + Integer.toString(this.timeStamp) + " - Bilan : " + output );
		this.ed.addEventInEventQueue(e);
		FreePhysician e2 = new FreePhysician((int)(this.timeStamp + duree), this.ed, this.physician); // Médecin occupé pendant le temps de la consultation puis libéré de la meme manière que les patients
		this.ed.addEventInEventQueue(e2);
		exam.notifyObservers();
			// Le résultat du test est envoyé au médecin
			// Fonction à compléter dans HealthService
		
		p1.setNexstep(output);
	}
	
	
	private double calculduree() throws ParameterUnifException {
		return Uniform.getSample(15,90);
	}
}
