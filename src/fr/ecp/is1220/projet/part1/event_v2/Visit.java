package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Uniform;
import fr.ecp.is1220.projet.part1.core.ConsultationService;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Output;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.PhysicianState;
import fr.ecp.is1220.projet.part1.core.Rooms;

public class Visit extends Event {
	
	/**
	 * Fonctionnement visite : 
	 * 
	 */	

	Rooms room; 
	Patient pat;
	Physician physician;
	Output outputconsultation;
	double duree;
	ConsultationService consultation;
	
	public Visit(int timeStamp, EmergencyDepartment ed, Rooms room, Physician phys, ConsultationService consultation ) throws ParameterUnifException {
		super(timeStamp, ed);
		this.room=room;
		this.pat=room.getPatientsInside().get(0); // on r�cup�re le patient qui est dans la pi�ce
		this.physician=phys;
		
		this.duree=calculduree();
		this.consultation=consultation;
				
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		// this.pat.setPatientState(PatientState.OCCUPIED);
		
		// On s'occupe d'abord de la temporalit� des acteurs (on fait en sorte qu'ils soient occup�s pendant la consultation
		this.physician.setState(PhysicianState.VISITING);
		this.pat.setPatientState(PatientState.BEEINGVISITED);
		EndEvent e = new EndEvent((int)(this.timeStamp + duree), this.ed, this.pat); 
		pat.fillRecord(Integer.toString(pat.getPatientRecord().size()) + " - " + Integer.toString(pat.getId()) + " - Actually in boxroom "+ room.getName() + " : " + room.getId() + " - Visited by physician : " + Integer.toString(this.physician.getId()) + " at " + Integer.toString(this.timeStamp) + " - Verdict : " + this.outputconsultation);
		this.ed.addEventInEventQueue(e);
		FreePhysician e2 = new FreePhysician((int)(this.timeStamp + duree), this.ed, this.physician); // M�decin occup� pendant le temps de la consultation puis lib�r� de la meme mani�re que les patients
		this.ed.addEventInEventQueue(e2);
		
		
		// On actualise les donn�es du m�decin
		this.physician.newPatientTreated(this.pat);
		
		this.outputconsultation= this.physician.prescribeExam(this.pat, this.timeStamp);
		
		pat.addcharges(consultation.getCost());
		
		pat.setNexstep(outputconsultation);
			
		}
	
	
	private double calculduree() throws ParameterUnifException {
		return Uniform.getSample(5,20);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "visit";
	}
}
