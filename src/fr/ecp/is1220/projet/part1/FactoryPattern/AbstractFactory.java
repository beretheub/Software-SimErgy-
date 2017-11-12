package fr.ecp.is1220.projet.part1.FactoryPattern;

import fr.ecp.is1220.projet.part1.Equipment;
import fr.ecp.is1220.projet.part1.HealthServices;
import fr.ecp.is1220.projet.part1.HumanResources;
import fr.ecp.is1220.projet.part1.Rooms;

public abstract class AbstractFactory {
	abstract HumanResources getHumanResource(String resourceType, String name, String surname);
	abstract Rooms getRoom(String resourceType, String name);
	abstract Equipment getEquipment(String resourceType, String name);
	abstract HealthServices getHealthService(String resourceType, String name);

}
