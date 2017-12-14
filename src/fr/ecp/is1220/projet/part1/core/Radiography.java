
package fr.ecp.is1220.projet.part1.core;

import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;

public class Radiography extends HealthServices {

	/**
	 * Radiography service : h�rite de la classe heathservice.
	 * Le prix par d�faut est fix� � 50, mais il est possible de fixer directement le prix � la cr�ation.
	 * Par defaut la distribution de probabilit� est uniforme 
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
