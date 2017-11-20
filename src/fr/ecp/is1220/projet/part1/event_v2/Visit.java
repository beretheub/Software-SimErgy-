package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Uniform;
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
	
	public Visit(int timeStamp, EmergencyDepartment ed, Rooms room, Physician phys) throws ParameterUnifException {
		super(timeStamp, ed);
		this.room=room;
		this.pat=room.getPatientsInside().get(0); // on récupère le patient qui est dans la pièce
		this.physician=phys;
		this.outputconsultation=calculoutput();
		this.duree=calculduree();
				
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		// this.pat.setPatientState(PatientState.OCCUPIED);
		this.physician.setState(PhysicianState.VISITING);
		this.pat.setPatientState(PatientState.BEEINGVISITED);
		EndEvent e = new EndEvent((int)(this.timeStamp + duree), this.ed, this.pat); 
		pat.fillRecord(Integer.toString(pat.getPatientRecord().size()) + " - " + Integer.toString(pat.getId()) + " - Actually in boxroom "+ room.getName() + " : " + room.getId() + " - Visited by physician : " + Integer.toString(this.physician.getId()) + " at " + Integer.toString(this.timeStamp) + " - Verdict : " + this.outputconsultation);
		this.ed.addEventInEventQueue(e);
		FreePhysician e2 = new FreePhysician((int)(this.timeStamp + duree), this.ed, this.physician); // Médecin occupé pendant le temps de la consultation puis libéré de la meme manière que les patients
		this.ed.addEventInEventQueue(e2);
		pat.addcharges(newcharge);
		pat.setNexstep(outputconsultation);
			
		}
	
	
	private Output calculoutput() {
		double output = Math.random();
		if (output <= 0.35){
			outputconsultation = Output.NOTEST;
		}else if (output <= 0.55){
			outputconsultation = Output.RADIOGRAPHY;
		}else if (output <= 0.95){
			outputconsultation = Output.BLOODTEST;
		}else{
			outputconsultation = Output.MRI;
		}
		return outputconsultation;
	}
	
	private double calculduree() throws ParameterUnifException {
		return Uniform.getSample(5,20);
	}
}
