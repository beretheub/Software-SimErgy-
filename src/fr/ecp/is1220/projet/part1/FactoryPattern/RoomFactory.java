package fr.ecp.is1220.projet.part1.FactoryPattern;

import fr.ecp.is1220.projet.part1.core.Equipment;
import fr.ecp.is1220.projet.part1.core.BoxRoom;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.Rooms;
import fr.ecp.is1220.projet.part1.core.ShockRoom;
import fr.ecp.is1220.projet.part1.core.WaitingRoom;

public class RoomFactory extends AbstractFactory {
	/**
	 * Creates a box Room, waiting room or a shock room by writing the kind of resource you want to create as the first parameter (String)
	 * Then it takes a second parameter String for its name 
	 */
	@Override
	public Rooms getRoom(EmergencyDepartment ed, String resourceType, String name) {
		if (resourceType.equalsIgnoreCase("waitingRoom")){
			return new WaitingRoom(ed, name);
		}
		else if (resourceType.equalsIgnoreCase("boxRoom")){
			return new BoxRoom(ed, name);
		}
		else if (resourceType.equalsIgnoreCase("ShockRoom")){
			return new ShockRoom(ed, name);
		}
		else{
			// On pourrait peut être faire ça avec une exception ?
			System.out.println("The creation of the room didn't work, please enter a valid choice");
			return null;
		}
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
	public HealthServices getHealthService(EmergencyDepartment ed, String resourceType, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Unusable For this factory
	 */
	@Override
	public HumanResources getHumanResource(EmergencyDepartment ed, String resourceType, String name, String surname) {
		// TODO Auto-generated method stub
		return null;
	}

}
