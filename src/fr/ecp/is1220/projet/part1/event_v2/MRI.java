package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Uniform;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.MRIservice;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projetc.part2.simulation.EventsType;

public class MRI extends Exam {
	

	/**
	 * Fonctionnemet de la visite : 
	 * - temps de duree suit une loi de probabilité uniforme (15,90)
	 * - verdict : j'ai décidé de façon arbitraire que ce serait : 35% consultation, 35% sortie de l'hopital, 30% hospitalisation 
	 * 
	 */	

	public MRI( EmergencyDepartment ed,double timeStamp, MRIservice room, Patient p1,Physician phys){
		super(timeStamp, ed, (HealthServices) room, p1, phys, calculduree());
				

	}
	
	private static double calculduree(){
		try {
			return Uniform.getSample(15,90);
		} catch (ParameterUnifException e) {
			// n'arrivera jamais
		}
		return 90; 
	}

	@Override
	public EventsType getType() {
		// TODO Auto-generated method stub
		return EventsType.MRI;
	}
}
