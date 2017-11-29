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
import fr.ecp.is1220.projetc.part2.simulation.EventsType;

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
	
	public Visit(double timeStamp, EmergencyDepartment ed, Rooms room, Physician phys, ConsultationService consultation ){
		super(timeStamp, ed);
		this.room=room;
		this.pat=room.getPatientsInside().get(0); // on récupère le patient qui est dans la pièce
		this.physician=phys;
		
	
		this.duree=calculduree();
		
		this.consultation=consultation;
				
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		// this.pat.setPatientState(PatientState.OCCUPIED);
		
		// On s'occupe d'abord de la temporalité des acteurs (on fait en sorte qu'ils soient occupés pendant la consultation
		this.physician.setState(PhysicianState.VISITING);
		this.pat.setPatientState(PatientState.BEEINGVISITED);
		pat.calculDTDT(duree);
		pat.calculLOS(duree);
		 
		pat.fillRecord(Integer.toString(pat.getPatientRecord().size()) + " - " + Integer.toString(pat.getId()) + " - Actually in boxroom "+ room.getName() + " : " + room.getId() + " - Visited by physician : " + Integer.toString(this.physician.getId()) + " at " + Double.toString(this.timeStamp) + " - Verdict : " + this.outputconsultation);
		
		FreePhysician e2 = new FreePhysician((int)(this.timeStamp + duree), this.ed, this.physician); // Médecin occupé pendant le temps de la consultation puis libéré de la meme manière que les patients
		this.ed.addEventInEventQueue(e2);
		
		
		// On actualise les données du médecin
		this.physician.newPatientTreated(this.pat);
		
		this.outputconsultation= this.physician.prescribeExam(this.pat, this.timeStamp);
		
		pat.addcharges(consultation.getCost());
		
		pat.setNexstep(outputconsultation);
		
		// On s'occupe de la gérer la libération du patient et de la room
		EndEvent e = new EndConsultation((int)(this.timeStamp + duree), this.ed, this.pat, this.room);
		this.ed.addEventInEventQueue(e);	
		}
	
	
	private double calculduree(){
		try {
			return Uniform.getSample(5,20);
		} catch (ParameterUnifException e) {
			// n'arrivera jamais
		}
		return 20;
	}

	@Override
	public EventsType getType() {
		// TODO Auto-generated method stub
		return EventsType.VISIT;
	}
}
