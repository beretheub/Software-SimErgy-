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
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.ShockRoom;
import fr.ecp.is1220.projet.part1.core.Strecher;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L1;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L2;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L5;
import fr.ecp.is1220.projet.part1.event_v2.Regist_NonUrgent;
import fr.ecp.is1220.projet.part1.event_v2.Visit;


public class VisitTest {
	@Test
	public void testExam() throws ParameterUnifException, NoPatientinED, WrongResourceType, InvalidNameException {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Bracieux");
		Arr_L1 arrive = new Arr_L1(ed1);
		AbstractFactory nursfac = FactoryProducer.getFactory("humanresource");
 		Nurse n1 = (Nurse) nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
 		Physician phys1 = (Physician) nursfac.getHumanResource(ed1, "physician", "Bérénice", "Heuberger");
 		AbstractFactory roomfac = FactoryProducer.getFactory("room");
 		AbstractFactory hservice = FactoryProducer.getFactory("healtservice");
 		AbstractFactory equipfac = FactoryProducer.getFactory("equipment");
 		BoxRoom room2 = (BoxRoom) roomfac.getRoom(ed1, "boxroom", "Room 2");
 		Strecher strecher1 =(Strecher) equipfac.getEquipment(ed1, "strecher", "Strecher 1");
 		BloodTestService bloodtest1 =(BloodTestService) hservice.getHealthService(ed1, "bloodtest", "Bloodtest1");
 		ConsultationService consult1=(ConsultationService) hservice.getHealthService(ed1, "consultation", "Consultation 1");
 		
 		arrive.execute();
 		
 		Patient p1 = ed1.listOfPatientsInTheED.get(0);
 		Regist_NonUrgent regist = new Regist_NonUrgent(0, ed1, room2, p1, n1);
 		regist.execute();
 		
 		Visit visite = new Visit(regist.timeStamp, ed1, room2, phys1, consult1);
 		
 		System.out.println(visite.timeStamp);
 		p1.printPatientRecord();
	}

}
