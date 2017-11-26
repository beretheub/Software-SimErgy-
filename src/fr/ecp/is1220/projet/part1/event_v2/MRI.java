package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;
import fr.ecp.is1220.projet.part1.Exceptions.noValidOutputException;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Uniform;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.MRIservice;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.PhysicianState;

public class MRI extends Exam {
	public double duree;

	/**
	 * Fonctionnemet de la visite : 
	 * - temps de duree suit une loi de probabilité uniforme (15,90)
	 * - verdict : j'ai décidé de façon arbitraire que ce serait : 35% consultation, 35% sortie de l'hopital, 30% hospitalisation 
	 * 
	 */	

	public MRI( EmergencyDepartment ed,int timeStamp, MRIservice room, Patient p1,Physician phys) throws ParameterUnifException {
		super(timeStamp, ed, (HealthServices) room, p1, phys);
		this.duree=calculduree();
				
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute() {
		this.getExam().newPatient(this.getPatient());
		
		// On s'occupe d'abord de la temporatité
		this.getPhysician().setState(PhysicianState.VISITING);
		this.getPatient().setPatientState(PatientState.TAKINGEXAM);
		EndEvent e = new EndEvent((int)(this.timeStamp + duree), this.ed, this.getPatient()); 
		this.ed.addEventInEventQueue(e);
		FreePhysician e2 = new FreePhysician((int)(this.timeStamp + duree), this.ed, this.getPhysician()); // Médecin occupé pendant le temps de la consultation puis libéré de la meme manière que les patients
		this.ed.addEventInEventQueue(e2);
		
		// On effectue le test
		this.setOutput(this.calculoutput());
		this.getPatient().fillRecord(Integer.toString(this.getPatient().getPatientRecord().size()) + " - " + Integer.toString(this.getPatient().getId()) + " - Actually in examroom "+ getExam().getName() + " : " + getExam().getId() + " - Taking exam with " + Integer.toString(this.getPhysician().getId()) + " at " + Integer.toString(this.timeStamp) + " - Bilan : " + getOutput() );
		this.getExam().notifyObservers();
		
		//On met à jour les données du patient
		this.getPatient().setNexstep(this.getOutput());
		this.getPatient().addcharges(getExam().getCost());
		
		//On envoie le patient dans la file d'attente suivante
		try {
			Exam.directPatient(this.getPatient());
		} catch (noValidOutputException e1) {
			// si on récupère l'excpation on replace le patient dans patientWaitingForExam
			System.out.println(Integer.toString(this.getPatient().getId()) + "Exam didn't worout well, trying again");
			this.ed.addPatientWaitingForExam(this.getPatient());
		}
		
	}
	
	
	private double calculduree() throws ParameterUnifException {
		return Uniform.getSample(15,90);
	}
}
