package fr.ecp.is1220.projet.part1.FactoryPattern;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Equipment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.Rooms;

public abstract class AbstractFactory {
	public HumanResources getHumanResource(EmergencyDepartment ed, String resourceType, String name, String surname) {
		return null;
	}
	public Rooms getRoom(EmergencyDepartment ed, String resourceType, String name) {
		return null;
	}
	public Equipment getEquipment (EmergencyDepartment ed, String resourceType, String name) {
		return null;
	}
	public HealthServices getHealthService(EmergencyDepartment ed, String resourceType, String name) {
		return null;
	}

}
