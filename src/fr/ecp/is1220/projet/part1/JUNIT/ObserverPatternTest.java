package fr.ecp.is1220.projet.part1.JUNIT;

import org.junit.Test;

import fr.ecp.is1220.projet.part1.Exceptions.FullRoom;
import fr.ecp.is1220.projet.part1.Exceptions.InvalidNameException;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.FactoryPattern.HealtServiceFactory;
import fr.ecp.is1220.projet.part1.ObserverPattern.Observable;
import fr.ecp.is1220.projet.part1.core.BoxRoom;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.MRIservice;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.Rooms;
import fr.ecp.is1220.projet.part1.core.Strecher;

public class ObserverPatternTest {
	@Test
	public void UpdateTest() {
		/**
		 * Notification d'un message à un médecin
		 */
		// TODO Auto-generated method stub
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
				
		Patient pat1 =new Patient (ed1,"Jo");
		Physician phys1=new Physician(ed1,"Homère","Ortie");
		phys1.newPatientTreated(pat1);
		phys1.update("ce patient va bien", pat1);
		phys1.printMessageBox();

	}	
	
	@Test
	public void UpdateTestpatientnottreated() {
		/**
		 * ne fonctionne pas car le patient ne fait pas partie des patients traités
		 */
		
		// TODO Auto-generated method stub
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
				
		Patient pat1 =new Patient (ed1,"Jo");
		Physician phys1=new Physician(ed1,"Homère","Ortie");
		phys1.update("ce patient va bien", pat1);
		phys1.printMessageBox();

	}
	@Test
	public void ObservableTest() {
		/**
		 * Notification d'un message par un healthservice. Le médecin le reçoit
		 */
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		HealtServiceFactory fact = (HealtServiceFactory) FactoryProducer.getFactory("healthService");
		MRIservice mri = null;
		Physician phys1=new Physician(ed1,"Alfred","Garde");
		Patient pat1 =new Patient (ed1,"Jeff");
		mri = (MRIservice) fact.getHealthService(ed1, "mri", "MRI 1", "norm");
		mri.registerObserver(phys1);
		phys1.newPatientTreated(pat1);
		mri.notifyObservers("ce patient ne va pas bien", pat1);
		phys1.printMessageBox();

	}
	

}
