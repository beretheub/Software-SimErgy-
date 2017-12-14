package fr.ecp.is1220.projet.part1.FactoryPattern;

import fr.ecp.is1220.projet.part1.core.Equipment;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.Rooms;
import fr.ecp.is1220.projet.part1.core.Transporter;

public class HumanResourcesFactory extends AbstractFactory {
	/**
	 * Creates a Nurse, Physician or a Transporter by writing the kind of resource you want to create as the first parameter (String)
	 * Then it takes a second parameter String for his/her name and a third for the surname 
	 */
	@Override
	public HumanResources getHumanResource(EmergencyDepartment ed, String resourceType, String name, String surname) {
		if (resourceType.equalsIgnoreCase("nurse")){
			return new Nurse(ed, name, surname);
		}
		else if (resourceType.equalsIgnoreCase("transporter")){
			return new Transporter(ed, name, surname);
		}
		else if (resourceType.equalsIgnoreCase("physician")){
			return new Physician(ed, name, surname);
		}
		else{
			// On pourrait peut être faire ça avec une exception ?
			System.out.println("The creation of a human resource didn't work, please enter a valid choice");
			return null;
		}
		
	}
	
	/**
	 * Unusable For this factory
	 */
	@Override
	public Rooms getRoom(EmergencyDepartment ed, String resourceType, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Unusable For this factory
	 */
	@Override
	public Equipment getEquipment(EmergencyDepartment ed, String resourceType, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Unusable For this factory
	 */
	@Override
	public HealthServices getHealthService(EmergencyDepartment ed, String resourceType, String name,  String strategy) {
		// TODO Auto-generated method stub
		return null;
	}

}
