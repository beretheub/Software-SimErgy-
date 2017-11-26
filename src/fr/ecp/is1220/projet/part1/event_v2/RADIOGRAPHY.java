package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Uniform;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.Radiography;

public class RADIOGRAPHY extends Exam{
	/**
	 * Fonctionnemet de la visite : 
	 * - temps de duree suit une loi de probabilité uniforme (15,90)
	 * - verdict : j'ai décidé de façon arbitraire que ce serait : 35% consultation, 35% sortie de l'hopital, 30% hospitalisation 
	 * 
	 */	

	public RADIOGRAPHY(EmergencyDepartment ed, int timeStamp, Radiography room, Patient p1,Physician phys) throws ParameterUnifException {
		super(timeStamp, ed,(HealthServices) room, p1, phys, calculduree());
		this.duree=calculduree();
				
		// TODO Auto-generated constructor stub
	}
	
	
	
	private static double calculduree() throws ParameterUnifException {
		return Uniform.getSample(15,90);
	}



	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "radiography";
	}

}
