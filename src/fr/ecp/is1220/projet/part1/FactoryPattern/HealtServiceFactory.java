package fr.ecp.is1220.projet.part1.FactoryPattern;

import fr.ecp.is1220.projet.part1.BloodTest;
import fr.ecp.is1220.projet.part1.ConsultationService;
import fr.ecp.is1220.projet.part1.Equipment;
import fr.ecp.is1220.projet.part1.HealthServices;
import fr.ecp.is1220.projet.part1.HumanResources;
import fr.ecp.is1220.projet.part1.MRI;
import fr.ecp.is1220.projet.part1.Radiography;
import fr.ecp.is1220.projet.part1.Rooms;
import fr.ecp.is1220.projet.part1.Scan;
import fr.ecp.is1220.projet.part1.Xray;

public class HealtServiceFactory extends AbstractFactory {
	/**
	 * Unusable For this factory
	 */
	@Override
	HumanResources getHumanResource(String resourceType, String name, String surname) {
		// TODO Auto-generated method stub
		return null;
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
	 * Creates a Healt serice (Xray, ConsultationService, MRI, radiography, scan, bloodTest) by writing the kind of resource you want to create as the first parameter (String)
	 * Then it takes a second parameter String for its name 
	 */
	@Override
	HealthServices getHealthService(String resourceType, String name) {
		if (resourceType.equalsIgnoreCase("Xray")){
			return new Xray(name);
		}
		else if (resourceType.equalsIgnoreCase("consultation")){
			return new ConsultationService(name);
		}
		else if (resourceType.equalsIgnoreCase("MRI")){
			return new MRI(name);
		}else if(resourceType.equalsIgnoreCase("radiography")){
			return new Radiography(name);
		}else if(resourceType.equalsIgnoreCase("scan")){
			return new Scan(name);
		}else if(resourceType.equalsIgnoreCase("bloodtest")){
			return new BloodTest(name);
		}else{
			// On pourrait peut être faire ça avec une exception ?
			System.out.println("The creation of the health service didn't work, please enter a valid choice");
			return null;
		}
	}

}
