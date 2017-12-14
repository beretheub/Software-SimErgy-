
package fr.ecp.is1220.projet.part1.core;

import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;

public class Radiography extends HealthServices {

	/**
	 * Radiography service : hérite de la classe heathservice.
	 * Le prix par défaut est fixé à 50, mais il est possible de fixer directement le prix à la création.
	 * Par defaut la distribution de probabilité est uniforme 
	 * @throws WrongIDAttribution 
	 */
	public Radiography(EmergencyDepartment ed, String name){
		super(ed, name, 50, "uniform");
		// default price is 15
	}
	public Radiography(EmergencyDepartment ed, String name, float cost, String choice){
		super(ed, name, cost, choice);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Retourne le type de la ressource : Radiography ici
	 *  */
	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.RADIOGRAPHY;
	}

}
