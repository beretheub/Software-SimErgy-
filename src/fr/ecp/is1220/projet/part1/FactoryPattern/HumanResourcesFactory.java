package fr.ecp.is1220.projet.part1.FactoryPattern;

import fr.ecp.is1220.projet.part1.Equipment;
import fr.ecp.is1220.projet.part1.HealthServices;
import fr.ecp.is1220.projet.part1.HumanResources;
import fr.ecp.is1220.projet.part1.Nurse;
import fr.ecp.is1220.projet.part1.Physician;
import fr.ecp.is1220.projet.part1.Rooms;
import fr.ecp.is1220.projet.part1.Transporter;

public class HumanResourcesFactory extends AbstractFactory {
	/**
	 * Creates a Nurse, Physician or a Transporter by writing the kind of resource you want to create as the first parameter (String)
	 * Then it takes a second parameter String for his/her name and a third for the surname 
	 */
	@Override
	HumanResources getHumanResource(String resourceType, String name, String surname) {
		if (resourceType.equalsIgnoreCase("nurse")){
			return new Nurse(name, surname);
		}
		else if (resourceType.equalsIgnoreCase("transporter")){
			return new Transporter(name, surname);
		}
		else if (resourceType.equalsIgnoreCase("physician")){
			return new Physician(name, surname);
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
	Rooms getRoom(String resourceType, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Unusable For this factory
	 */
	@Override
	Equipment getEquipment(String resourceType, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Unusable For this factory
	 */
	@Override
	HealthServices getHealthService(String resourceType, String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
