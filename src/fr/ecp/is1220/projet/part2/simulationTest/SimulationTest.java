package fr.ecp.is1220.projet.part2.simulationTest;

import fr.ecp.is1220.projet.part1.FactoryPattern.AbstractFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.core.BloodTestService;
import fr.ecp.is1220.projet.part1.core.BoxRoom;
import fr.ecp.is1220.projet.part1.core.ConsultationService;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.MRIservice;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.Radiography;
import fr.ecp.is1220.projet.part1.core.Scan;
import fr.ecp.is1220.projet.part1.core.ShockRoom;
import fr.ecp.is1220.projet.part1.core.Strecher;
import fr.ecp.is1220.projet.part1.core.Transporter;
import fr.ecp.is1220.projet.part1.core.XrayService;
import fr.ecp.is1220.projet.part2.simulation.timeManager;
import fr.ecp.is1220.projet.part2.simulation.ComputeStats;

public class SimulationTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Bracieux");
		AbstractFactory nursfac = FactoryProducer.getFactory("humanresource");
		
 		Nurse n1 = (Nurse) nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
 		Nurse n2 = (Nurse) nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
 		Nurse n3 = (Nurse) nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
 		Nurse n4 = (Nurse) nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
 		Nurse n5 = (Nurse) nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
 		Nurse n6 = (Nurse) nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
 		
 		Physician phys1 = (Physician) nursfac.getHumanResource(ed1, "physician", "Bérénice", "Heuberger");
 		Physician phys2 = (Physician) nursfac.getHumanResource(ed1, "physician", "Bérénice", "Heuberger");
 		Physician phys3 = (Physician) nursfac.getHumanResource(ed1, "physician", "Bérénice", "Heuberger");
 		Physician phys4 = (Physician) nursfac.getHumanResource(ed1, "physician", "Bérénice", "Heuberger");
 		Physician phys5 = (Physician) nursfac.getHumanResource(ed1, "physician", "Bérénice", "Heuberger");
 		Physician phys6 = (Physician) nursfac.getHumanResource(ed1, "physician", "Bérénice", "Heuberger");
 		Physician phys7 = (Physician) nursfac.getHumanResource(ed1, "physician", "Bérénice", "Heuberger");
 		
 		
 		Transporter t1 =(Transporter) nursfac.getHumanResource(ed1, "transporter", "Alfred", "Sansnom");
 		Transporter t2 =(Transporter) nursfac.getHumanResource(ed1, "transporter", "Alfred", "Sansnom");
 		Transporter t3 =(Transporter) nursfac.getHumanResource(ed1, "transporter", "Alfred", "Sansnom");
 		Transporter t4 =(Transporter) nursfac.getHumanResource(ed1, "transporter", "Alfred", "Sansnom");
 		Transporter t5 =(Transporter) nursfac.getHumanResource(ed1, "transporter", "Alfred", "Sansnom");
 		Transporter t6 =(Transporter) nursfac.getHumanResource(ed1, "transporter", "Alfred", "Sansnom");
 		
 		AbstractFactory roomfac = FactoryProducer.getFactory("room");
 		AbstractFactory equipfac = FactoryProducer.getFactory("equipment");
 		AbstractFactory hservice = FactoryProducer.getFactory("healthservice");
 		
 		BoxRoom room2 = (BoxRoom) roomfac.getRoom(ed1, "boxroom", "Room 2");
 		BoxRoom broom3 = (BoxRoom) roomfac.getRoom(ed1, "boxroom", "Room 2");
 		BoxRoom broom4 = (BoxRoom) roomfac.getRoom(ed1, "boxroom", "Room 2");
 		BoxRoom broom5 = (BoxRoom) roomfac.getRoom(ed1, "boxroom", "Room 2");
 		ShockRoom sroom3 = (ShockRoom) roomfac.getRoom(ed1, "shockroom", "Room 2");
 		ShockRoom sroom4 = (ShockRoom) roomfac.getRoom(ed1, "shockroom", "Room 2");
 		ShockRoom sroom5 = (ShockRoom) roomfac.getRoom(ed1, "shockroom", "Room 2");
 
 		Strecher strecher1 =(Strecher) equipfac.getEquipment(ed1, "strecher", "Strecher 1");
 		Strecher strecher2 =(Strecher) equipfac.getEquipment(ed1, "strecher", "Strecher 1");
 		Strecher strecher3 =(Strecher) equipfac.getEquipment(ed1, "strecher", "Strecher 1");
 		Strecher strecher4 =(Strecher) equipfac.getEquipment(ed1, "strecher", "Strecher 1");
 		Strecher strecher5 =(Strecher) equipfac.getEquipment(ed1, "strecher", "Strecher 1");
 		
 		BloodTestService bloodtest1 =(BloodTestService) hservice.getHealthService(ed1, "bloodtest", "Bloodtest1");
 		MRIservice mri1 =(MRIservice)hservice.getHealthService(ed1, "mri", "MRI1");
 		XrayService xray1 =(XrayService)hservice.getHealthService(ed1, "xray", "XRAY1");
 		ConsultationService consult1=(ConsultationService) hservice.getHealthService(ed1, "consultation", "Consultation 1");
 		Scan scan1=(Scan) hservice.getHealthService(ed1, "scan", "Scan 1");
 		Radiography radio1=(Radiography) hservice.getHealthService(ed1, "radiography", "radio1");
 		
 		timeManager tm = new timeManager();
 		
 		ed1 = tm.startSimulation(500, ed1);
 		System.out.println("Simulation Terminée");
 		ComputeStats.averagedtdt(ed1);
 		ComputeStats.averagelos(ed1);
	}
	
}
