 package fr.ecp.is1220.projet.part1.core;

public class BloodTest extends HealthServices {

		/**
		 * Bloodtest service : h�rite de la classe heathservice.
		 * Le prix par d�faut est fix� � 50, mais il est possible de fixer directement le prix � la cr�ation. 
		 */

		public BloodTest(EmergencyDepartment ed, String name) {
			// Il je fixe le prix par d�faut d'un blood � 50
			super(ed, name, 50);
			// TODO Auto-generated constructor stub
		}
		public BloodTest(EmergencyDepartment ed, String name, float cost){
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
