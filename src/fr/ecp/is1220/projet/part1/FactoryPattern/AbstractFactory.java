package fr.ecp.is1220.projet.part1.FactoryPattern;

import fr.ecp.is1220.projet.part1.Exceptions.InvalidNameException;
import fr.ecp.is1220.projet.part1.Exceptions.WrongArgument;
import fr.ecp.is1220.projet.part1.Exceptions.WrongResourceType;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Equipment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.Rooms;

public abstract class AbstractFactory {
	public HumanResources getHumanResource(EmergencyDepartment ed, String resourceType, String name, String surname) throws WrongArgument {
		return null;
	}
	public Rooms getRoom(EmergencyDepartment ed, String resourceType, String name) throws WrongResourceType {
		return null;
	}
	public Equipment getEquipment (EmergencyDepartment ed, String resourceType, String name) {
		return null;
	}
	public HealthServices getHealthService(EmergencyDepartment ed, String resourceType, String name, String Strategy) throws InvalidNameException {
		return null;
	}

}
