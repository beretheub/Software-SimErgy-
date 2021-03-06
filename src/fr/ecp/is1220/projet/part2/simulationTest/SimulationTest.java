package fr.ecp.is1220.projet.part2.simulationTest;

import fr.ecp.is1220.projet.part1.Exceptions.InvalidNameException;
import fr.ecp.is1220.projet.part1.Exceptions.WrongArgument;
import fr.ecp.is1220.projet.part1.Exceptions.WrongResourceType;
import fr.ecp.is1220.projet.part1.FactoryPattern.AbstractFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.core.BloodTestService;
import fr.ecp.is1220.projet.part1.core.BoxRoom;
import fr.ecp.is1220.projet.part1.core.ConsultationService;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.MRIservice;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.Radiography;
import fr.ecp.is1220.projet.part1.core.Scan;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;
import fr.ecp.is1220.projet.part1.core.ShockRoom;
import fr.ecp.is1220.projet.part1.core.Strecher;
import fr.ecp.is1220.projet.part1.core.Transporter;
import fr.ecp.is1220.projet.part1.core.XrayService;
import fr.ecp.is1220.projet.part2.simulation.timeManager;
import fr.ecp.is1220.projet.part2.simulation.ComputeStats;

public class SimulationTest {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InvalidNameException {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Bracieux");
		AbstractFactory nursfac = FactoryProducer.getFactory("humanresource");
		
 		try {
			Nurse n1 = (Nurse) nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
			Nurse n2 = (Nurse) nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
	 		Nurse n3 = (Nurse) nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
	 		Nurse n4 = (Nurse) nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
	 		Nurse n5 = (Nurse) nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
	 		Nurse n6 = (Nurse) nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
	 		
	 		Physician phys1 = (Physician) nursfac.getHumanResource(ed1, "physician", "B�r�nice", "Heuberger");
	 		Physician phys2 = (Physician) nursfac.getHumanResource(ed1, "physician", "B�r�nice", "Heuberger");
	 		Physician phys3 = (Physician) nursfac.getHumanResource(ed1, "physician", "B�r�nice", "Heuberger");
	 		Physician phys4 = (Physician) nursfac.getHumanResource(ed1, "physician", "B�r�nice", "Heuberger");
	 		Physician phys5 = (Physician) nursfac.getHumanResource(ed1, "physician", "B�r�nice", "Heuberger");
	 		Physician phys6 = (Physician) nursfac.getHumanResource(ed1, "physician", "B�r�nice", "Heuberger");
	 		Physician phys7 = (Physician) nursfac.getHumanResource(ed1, "physician", "B�r�nice", "Heuberger");
	 		
	 		Transporter t1 =(Transporter) nursfac.getHumanResource(ed1, "transporter", "Alfred", "Sansnom");
	 		Transporter t2 =(Transporter) nursfac.getHumanResource(ed1, "transporter", "Alfred", "Sansnom");
	 		Transporter t3 =(Transporter) nursfac.getHumanResource(ed1, "transporter", "Alfred", "Sansnom");
	 		Transporter t4 =(Transporter) nursfac.getHumanResource(ed1, "transporter", "Alfred", "Sansnom");
	 		Transporter t5 =(Transporter) nursfac.getHumanResource(ed1, "transporter", "Alfred", "Sansnom");
	 		Transporter t6 =(Transporter) nursfac.getHumanResource(ed1, "transporter", "Alfred", "Sansnom");
		} catch (WrongArgument e1) {
			
			e1.printStackTrace();
		}
 		
 		
 		
 		
 		
 		
 		
 		AbstractFactory roomfac = FactoryProducer.getFactory("room");
 		AbstractFactory equipfac = FactoryProducer.getFactory("equipment");
 		AbstractFactory hservice = FactoryProducer.getFactory("healthservice");
 		try{
 			BoxRoom room2 = (BoxRoom) roomfac.getRoom(ed1, "boxroom", "Room 2");
 			BoxRoom broom3 = (BoxRoom) roomfac.getRoom(ed1, "boxroom", "Room 2");
 			BoxRoom broom4 = (BoxRoom) roomfac.getRoom(ed1, "boxroom", "Room 2");
 			BoxRoom broom5 = (BoxRoom) roomfac.getRoom(ed1, "boxroom", "Room 2");
 			ShockRoom sroom3 = (ShockRoom) roomfac.getRoom(ed1, "shockroom", "Room 2");
 			ShockRoom sroom4 = (ShockRoom) roomfac.getRoom(ed1, "shockroom", "Room 2");
 			ShockRoom sroom5 = (ShockRoom) roomfac.getRoom(ed1, "shockroom", "Room 2");
 		}catch(WrongResourceType e){
 			
 		}
 
 		Strecher strecher1 =(Strecher) equipfac.getEquipment(ed1, "strecher", "Strecher 1");
 		Strecher strecher2 =(Strecher) equipfac.getEquipment(ed1, "strecher", "Strecher 1");
 		Strecher strecher3 =(Strecher) equipfac.getEquipment(ed1, "strecher", "Strecher 1");
 		Strecher strecher4 =(Strecher) equipfac.getEquipment(ed1, "strecher", "Strecher 1");
 		Strecher strecher5 =(Strecher) equipfac.getEquipment(ed1, "strecher", "Strecher 1");
 		
 		BloodTestService bloodtest1 =(BloodTestService) hservice.getHealthService(ed1, "bloodtest", "Bloodtest1", "uniform");
 		MRIservice mri1 =(MRIservice)hservice.getHealthService(ed1, "mri", "MRI1", "uniform");
 		XrayService xray1 =(XrayService)hservice.getHealthService(ed1, "xray", "XRAY1", "uniform");
 		ConsultationService consult1=(ConsultationService) hservice.getHealthService(ed1, "consultation", "Consultation 1", "uniform");
 		Scan scan1=(Scan) hservice.getHealthService(ed1, "scan", "Scan 1", "uniform");
 		Radiography radio1=(Radiography) hservice.getHealthService(ed1, "radiography", "radio1", "uniform");
 		
 		timeManager tm = new timeManager();
 		
 		ed1 = tm.startSimulation(500, ed1);
 		System.out.print("Simulation Termin�e : ");
 		System.out.println(timeManager.formatTime(500));
 		ComputeStats.averagedtdt(ed1);
 		ComputeStats.averagelos(ed1);
 		ComputeStats.averagedtdt(ed1, SeverityLevel.L5);
 		ComputeStats.averagelos(ed1, SeverityLevel.L5);
 		ed1.displayState();
 		for (Patient pat : ed1.listOfEndedPatient){
 			pat.printPatientPath();
 		}
	}
}
