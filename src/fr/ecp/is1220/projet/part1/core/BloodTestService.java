 package fr.ecp.is1220.projet.part1.core;

import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;

public class BloodTestService extends HealthServices {

		/**
		 * Bloodtest service : h�rite de la classe heathservice.
		 * Le prix par d�faut est fix� � 50, mais il est possible de fixer directement le prix � la cr�ation. 
		 * @throws WrongIDAttribution 
		 */

		public BloodTestService(EmergencyDepartment ed, String name) throws WrongIDAttribution {
			// Il je fixe le prix par d�faut d'un blood � 50
			super(ed, name, 50);
			// TODO Auto-generated constructor stub
		}
		public BloodTestService(EmergencyDepartment ed, String name, float cost) throws WrongIDAttribution{
		super(ed, name, cost);
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