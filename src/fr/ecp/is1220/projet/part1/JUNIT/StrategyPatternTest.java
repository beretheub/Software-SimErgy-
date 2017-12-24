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

public class StrategyPatternTest {
	@Test
	public void StrategyNormTest() {
		/**
		 * Strat�gie Norm
		 */
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		HealtServiceFactory fact = (HealtServiceFactory) FactoryProducer.getFactory("healthService");
		Physician phys1=new Physician(ed1,"Alfred","Garde");
		Patient pat1 =new Patient (ed1,"Jeff");
		
		MRIservice mri1 = (MRIservice) fact.getHealthService(ed1, "mri", "MRI 1", "norm");
		System.out.println((mri1.getStrat()));
	
	}
	
	@Test
	public void StrategyUniformTest() {
		/**
		 * Strat�gie Uniform
		 */
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		HealtServiceFactory fact = (HealtServiceFactory) FactoryProducer.getFactory("healthService");
		Physician phys1=new Physician(ed1,"Alfred","Garde");
		Patient pat1 =new Patient (ed1,"Jeff");
		
		MRIservice mri1 = (MRIservice) fact.getHealthService(ed1, "mri", "MRI 1", "uniform");
		System.out.println((mri1.getStrat()));
	
	}
	
	@Test
	public void StrategyDiracTest() {
		/**
		 * Strat�gie Dirac
		 */
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		HealtServiceFactory fact = (HealtServiceFactory) FactoryProducer.getFactory("healthService");
		Physician phys1=new Physician(ed1,"Alfred","Garde");
		Patient pat1 =new Patient (ed1,"Jeff");
		
		MRIservice mri1 = (MRIservice) fact.getHealthService(ed1, "mri", "MRI 1", "dirac");
		System.out.println((mri1.getStrat()));
	
	}
	
	@Test
	public void StrategyExpTest() {
		/**
		 * Strat�gie Exp
		 */
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		HealtServiceFactory fact = (HealtServiceFactory) FactoryProducer.getFactory("healthService");
		Physician phys1=new Physician(ed1,"Alfred","Garde");
		Patient pat1 =new Patient (ed1,"Jeff");
		
		MRIservice mri1 = (MRIservice) fact.getHealthService(ed1, "mri", "MRI 1", "exp");
		System.out.println((mri1.getStrat()));
	
	}
	
	@Test
	public void StrategyNullTest() {
		/**
		 * On v�rifie que la strat�gie mise par d�faut est uniform
		 */
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		HealtServiceFactory fact = (HealtServiceFactory) FactoryProducer.getFactory("healthService");
		Physician phys1=new Physician(ed1,"Alfred","Garde");
		Patient pat1 =new Patient (ed1,"Jeff");
		
		MRIservice mri1 = (MRIservice) fact.getHealthService(ed1, "mri", "MRI 1", " ");
		System.out.println((mri1.getStrat()));
	
	}
}
