 package fr.ecp.is1220.projet.part1.core;

import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;

public class BloodTestService extends HealthServices implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8622187017670813222L;

	/**
	 * Bloodtest service : hérite de la classe heathservice.
	 * Le prix par défaut est fixé à 50, mais il est possible de fixer directement le prix à la création. 
	 * @throws WrongIDAttribution 
	 */

	public BloodTestService(EmergencyDepartment ed, String name){
		// Il je fixe le prix par défaut d'un blood à 50
		super(ed, name, 50, "uniform");
		// TODO Auto-generated constructor stub
	}
	public BloodTestService(EmergencyDepartment ed, String name, float cost, String strat){
		super(ed, name, cost, strat);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retourne le type de la ressource : bloodtest ici
	 *  */
	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.BLOODTEST;
	}

}
