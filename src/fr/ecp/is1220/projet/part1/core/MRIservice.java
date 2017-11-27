package fr.ecp.is1220.projet.part1.core;

import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;

public class MRIservice extends HealthServices {
	
	/**
	 * Service IRM : h�rite de la classe healthservice
	 * Le prix par d�faut est fix� � 50, mais il est possible de fixer directement le prix � la cr�ation. 
		 
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
