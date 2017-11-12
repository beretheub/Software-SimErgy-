package fr.ecp.is1220.projet.part1.core;

public class BloodTest extends HealthServices {

		/**
		 * Creates a new Blood test service. It inherits the attributes of a healtService.
		 * 
		 * The default price of an Blood test is 12, bus you can determine a new price for this specific blood test service
		 * 
		 */
		
		public BloodTest(EmergencyDepartment ed, String name) {
			// Il je fixe le prix par défaut d'un blood à 12
			super(ed, name, 12);
			// TODO Auto-generated constructor stub
		}
		public BloodTest(EmergencyDepartment ed, String name, float cost){
		super(ed, name, cost);
		// TODO Auto-generated constructor stub
	}

}
