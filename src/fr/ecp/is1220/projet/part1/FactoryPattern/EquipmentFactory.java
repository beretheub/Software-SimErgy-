package fr.ecp.is1220.projet.part1.FactoryPattern;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Equipment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.Rooms;
import fr.ecp.is1220.projet.part1.core.Strecher;

public class EquipmentFactory extends AbstractFactory {
	/**
	 * Unusable For this factory
	 */
	@Override
	public HumanResources getHumanResource(EmergencyDepartment ed, String resourceType, String name, String surname) {
		// TODO Auto-generated method stub
		return null;
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
	 * Creates an equipment for the ed entered as parameter. 
	 * You can choose to create : a strecher. Enter tour choice as the second parameter
	 * give a name to your equipement as third parameter
	 */
	
	@Override
	public Equipment getEquipment(EmergencyDepartment ed, String resourceType, String name) {
		if (resourceType.equalsIgnoreCase("strecher")){
			return new Strecher(ed, name);
		}else{
			// On pourrait peut être faire ça avec une exception ?
			System.out.println("The creation of a human resource didn't work, please enter a valid choice");
			return null;
		}
	}
	/**
	 * Unusable For this factory
	 */
	@Override
	public HealthServices getHealthService(EmergencyDepartment ed, String resourceType, String name, String strategy) {
		// TODO Auto-generated method stub
		return null;
	}

}
