package fr.ecp.is1220.projet.part1.FactoryPattern;

import fr.ecp.is1220.projet.part1.core.BloodTest;
import fr.ecp.is1220.projet.part1.core.Equipment;
import fr.ecp.is1220.projet.part1.core.ConsultationService;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.MRI;
import fr.ecp.is1220.projet.part1.core.Radiography;
import fr.ecp.is1220.projet.part1.core.Rooms;
import fr.ecp.is1220.projet.part1.core.Scan;
import fr.ecp.is1220.projet.part1.core.Xray;

public class HealtServiceFactory extends AbstractFactory {
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
	 * Unusable For this factory
	 */
	@Override
	public Equipment getEquipment(EmergencyDepartment ed, String resourceType, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Creates a Healt serice (Xray, ConsultationService, MRI, radiography, scan, bloodTest) by writing the kind of resource you want to create as the first parameter (String)
	 * Then it takes a second parameter String for its name 
	 */
	@Override
	public HealthServices getHealthService(EmergencyDepartment ed, String resourceType, String name) {
		if (resourceType.equalsIgnoreCase("Xray")){
			return new Xray(ed, name);
		}
		else if (resourceType.equalsIgnoreCase("consultation")){
			return new ConsultationService(ed, name);
		}
		else if (resourceType.equalsIgnoreCase("MRI")){
			return new MRI(ed, name);
		}else if(resourceType.equalsIgnoreCase("radiography")){
			return new Radiography(ed, name);
		}else if(resourceType.equalsIgnoreCase("scan")){
			return new Scan(ed, name);
		}else if(resourceType.equalsIgnoreCase("bloodtest")){
			return new BloodTest(ed, name);
		}else{
			// On pourrait peut être faire ça avec une exception ?
			System.out.println("The creation of the health service didn't work, please enter a valid choice");
			return null;
		}
	}

}
