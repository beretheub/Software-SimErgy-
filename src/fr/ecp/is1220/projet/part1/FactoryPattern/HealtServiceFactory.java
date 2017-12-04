package fr.ecp.is1220.projet.part1.FactoryPattern;

import fr.ecp.is1220.projet.part1.Exceptions.InvalidNameException;
import fr.ecp.is1220.projet.part1.core.BloodTestService;
import fr.ecp.is1220.projet.part1.core.ConsultationService;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Equipment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.MRIservice;
import fr.ecp.is1220.projet.part1.core.Radiography;
import fr.ecp.is1220.projet.part1.core.Rooms;
import fr.ecp.is1220.projet.part1.core.Scan;
import fr.ecp.is1220.projet.part1.core.XrayService;

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
	 * @throws InvalidNameException 
	 */
	@Override
	public HealthServices getHealthService(EmergencyDepartment ed, String resourceType, String name) throws InvalidNameException {
		if (resourceType.equalsIgnoreCase("Xray")){
			return new XrayService(ed, name);
		}
		else if (resourceType.equalsIgnoreCase("consultation")){
			return new ConsultationService(ed, name);
		}
		else if (resourceType.equalsIgnoreCase("MRI")){
			return new MRIservice(ed, name);
		}else if(resourceType.equalsIgnoreCase("radiography")){
			return new Radiography(ed, name);
		}else if(resourceType.equalsIgnoreCase("scan")){
			return new Scan(ed, name);
		}else if(resourceType.equalsIgnoreCase("bloodtest")){
			return new BloodTestService(ed, name);
		}else{
			throw new InvalidNameException();
		}
	}

}
