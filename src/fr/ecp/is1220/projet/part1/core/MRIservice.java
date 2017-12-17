package fr.ecp.is1220.projet.part1.core;

import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;

public class MRIservice extends HealthServices implements java.io.Serializable{
	
	private static final long serialVersionUID = 5119071496891567058L;

	/**
	 * Service IRM : hérite de la classe healthservice
	 * Le prix par défaut est fixé à 50, mais il est possible de fixer directement le prix à la création. 
		 
	 * @param ed
	 * @param name
	 * @throws WrongIDAttribution 
	 */
	public MRIservice(EmergencyDepartment ed, String name){
		// default price is 16
		super(ed, name, 50, "uniform");
	}
	public MRIservice(EmergencyDepartment ed, String name, float cost, String choice){
		super(ed, name, cost, choice);
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
