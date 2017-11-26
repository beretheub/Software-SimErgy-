package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Uniform;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.XrayService;

public class XRAY extends Exam {

	/*
	 * Fonctionnemet de la visite : 
	 * - temps de duree suit une loi de probabilit� uniforme (15,90)
	 * - verdict : j'ai d�cid� de fa�on arbitraire que ce serait : 35% consultation, 35% sortie de l'hopital, 30% hospitalisation 
	 * 
	 */	

	public XRAY(EmergencyDepartment ed, int timeStamp, XrayService room, Patient p1,Physician phys) throws ParameterUnifException {
		super(timeStamp, ed,(HealthServices)room, p1, phys, calculduree());
	
	}
	
	
	
	private static double calculduree() throws ParameterUnifException {
		return Uniform.getSample(15,90);
	}
}
