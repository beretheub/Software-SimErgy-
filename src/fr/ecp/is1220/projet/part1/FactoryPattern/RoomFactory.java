package fr.ecp.is1220.projet.part1.FactoryPattern;

import fr.ecp.is1220.projet.part1.BoxRoom;
import fr.ecp.is1220.projet.part1.Equipment;
import fr.ecp.is1220.projet.part1.HealthServices;
import fr.ecp.is1220.projet.part1.HumanResources;
import fr.ecp.is1220.projet.part1.Rooms;
import fr.ecp.is1220.projet.part1.ShockRoom;
import fr.ecp.is1220.projet.part1.WaitingRoom;

public class RoomFactory extends AbstractFactory {
	/**
	 * Creates a box Room, waiting room or a shock room by writing the kind of resource you want to create as the first parameter (String)
	 * Then it takes a second parameter String for its name 
	 */
	@Override
	Rooms getRoom(String resourceType, String name) {
		if (resourceType.equalsIgnoreCase("waitingRoom")){
			return new WaitingRoom(name);
		}
		else if (resourceType.equalsIgnoreCase("boxRoom")){
			return new BoxRoom(name);
		}
		else if (resourceType.equalsIgnoreCase("ShockRoom")){
			return new ShockRoom(name);
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
	/**
	 * Unusable For this factory
	 */
	@Override
	HumanResources getHumanResource(String resourceType, String name, String surname) {
		// TODO Auto-generated method stub
		return null;
	}

}
