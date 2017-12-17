package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Uniform;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.XrayService;
import fr.ecp.is1220.projet.part2.simulation.EventsType;

public class XRAY extends Exam implements java.io.Serializable {

	/*
	 * Fonctionnemet de la visite : 
	 * - temps de duree suit une loi de probabilité uniforme (15,90)
	 * - verdict : j'ai décidé de façon arbitraire que ce serait : 35% consultation, 35% sortie de l'hopital, 30% hospitalisation 
	 * 
	 */	


	private static final long serialVersionUID = -1112723213522904128L;



	public XRAY(EmergencyDepartment ed, double timeStamp, XrayService room, Patient p1,Physician phys){
		super(timeStamp, ed,(HealthServices)room, p1, phys, calculduree());
	
	}
	
	
	
	private static double calculduree(){
		try {
			return Uniform.getSample(15,90);
		} catch (ParameterUnifException e) {
			return 90;
		}
	}



	@Override
	public EventsType getType() {
		// TODO Auto-generated method stub
		return EventsType.XRAY;
	}
}
