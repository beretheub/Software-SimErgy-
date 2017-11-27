package fr.ecp.is1220.projet.part1.core;

import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;

public class MRIservice extends HealthServices {
	
	/**
	 * Service IRM : hérite de la classe healthservice
	 * Le prix par défaut est fixé à 50, mais il est possible de fixer directement le prix à la création. 
		 
	 * @param ed
	 * @param name
	 * @throws WrongIDAttribution 
	 */
	public MRIservice(EmergencyDepartment ed, String name) throws WrongIDAttribution{
		// default price is 16
		super(ed, name, 50);
	}
	public MRIservice(EmergencyDepartment ed, String name, float cost) throws WrongIDAttribution {
		super(ed, name, cost);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Retourne le type de la ressource : MRIService ici
	 *  */
	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.MRI;
	}

}
