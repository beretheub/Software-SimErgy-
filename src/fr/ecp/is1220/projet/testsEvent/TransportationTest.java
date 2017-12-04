package fr.ecp.is1220.projet.testsEvent;

import org.junit.Test;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;
import fr.ecp.is1220.projet.part1.Exceptions.InvalidNameException;
import fr.ecp.is1220.projet.part1.Exceptions.NoPatientinED;
import fr.ecp.is1220.projet.part1.Exceptions.WrongResourceType;
import fr.ecp.is1220.projet.part1.FactoryPattern.AbstractFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.core.BloodTestService;
import fr.ecp.is1220.projet.part1.core.BoxRoom;
import fr.ecp.is1220.projet.part1.core.ConsultationService;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.Strecher;
import fr.ecp.is1220.projet.part1.core.Transporter;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L1;
import fr.ecp.is1220.projet.part1.event_v2.Regist_NonUrgent;
import fr.ecp.is1220.projet.part1.event_v2.Transportation;
import fr.ecp.is1220.projet.part1.event_v2.Visit;


public class TransportationTest {
	@Test
	public void testExam()throws ParameterUnifException, NoPatientinED, WrongResourceType, InvalidNameException {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Bracieux");
		Arr_L1 ev1 = new Arr_L1(ed1);
		AbstractFactory nursfac = FactoryProducer.getFactory("humanresource");
 		Nurse n1 = (Nurse) nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
 		Physician phys1 = (Physician) nursfac.getHumanResource(ed1, "physician", "Bérénice", "Heuberger");
 		Transporter t1 =(Transporter) nursfac.getHumanResource(ed1, "transporter", "Alfred", "Sansnom");
 		AbstractFactory roomfac = FactoryProducer.getFactory("room");
 		AbstractFactory equipfac = FactoryProducer.getFactory("equipment");
 		AbstractFactory hservice = FactoryProducer.getFactory("healtservice");
 		BoxRoom room2 = (BoxRoom) roomfac.getRoom(ed1, "boxroom", "Room 2");
 		Strecher strecher1 =(Strecher) equipfac.getEquipment(ed1, "strecher", "Strecher 1");
 		BloodTestService bloodtest1 =(BloodTestService) hservice.getHealthService(ed1, "bloodtest", "Bloodtest1");
 		ConsultationService consult1=(ConsultationService) hservice.getHealthService(ed1, "consultation", "Consultation 1");
		
 		
 		ev1.execute();
 		
 		Patient p1 = ed1.listOfPatientsInTheED.get(0);
 		Regist_NonUrgent ev2 = new Regist_NonUrgent(ev1.timeStamp, ed1, room2, p1, n1);
 		ev2.execute();
 
 		Visit ev3 = new Visit(ev2.timeStamp, ed1, room2, phys1, consult1);
 		ev3.execute();
 		
 		Transportation ev4= new Transportation(ed1,ev3.timeStamp, t1, strecher1, p1);
 		ev4.execute();
 		System.out.println(ev4.timeStamp);
 		p1.printPatientRecord();
	}

}
