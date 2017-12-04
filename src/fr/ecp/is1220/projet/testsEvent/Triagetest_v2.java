package fr.ecp.is1220.projet.testsEvent;

import org.junit.Test;

import fr.ecp.is1220.projet.part1.Exceptions.NoPatientinED;
import fr.ecp.is1220.projet.part1.Exceptions.WrongResourceType;
import fr.ecp.is1220.projet.part1.FactoryPattern.AbstractFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.core.BoxRoom;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Rooms;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;
import fr.ecp.is1220.projet.part1.core.ShockRoom;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L2;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L5;
import fr.ecp.is1220.projet.part1.event_v2.Regist_NonUrgent;
import fr.ecp.is1220.projet.part1.event_v2.Regist_Urgent;

public class Triagetest_v2 {
	@Test
	public void testExam() throws NoPatientinED, WrongResourceType {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Grenoble");
		
		Arr_L5 ev3 = new Arr_L5(ed1);
 		ev3.execute();
 		
 		Arr_L2 ev2 = new Arr_L2(ed1);
 		ev2.execute();
 		
 		
 		AbstractFactory nursfac = FactoryProducer.getFactory("humanresource");

 		HumanResources n1 = nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
 		
 		AbstractFactory roomfac = FactoryProducer.getFactory("room");
 		
 		ShockRoom room1 = (ShockRoom) roomfac.getRoom(ed1, "shockroom", "Room 1");
 		BoxRoom room2 = (BoxRoom) roomfac.getRoom(ed1, "boxroom", "Room 2");
 		
 		Patient p1 = ed1.listOfPatientsInTheED.get(0);
 		Patient p2 = ed1.listOfPatientsInTheED.get(1);
 		
 		if (p1.getSeverity()==SeverityLevel.L5 | p1.getSeverity()==SeverityLevel.L4){
 			Regist_Urgent ev4 = new Regist_Urgent(18, ed1, room1, p1, (Nurse) n1);
 			ev4.execute();
 	 		System.out.println(ev4.timeStamp);
 		}
 		else {
 			Regist_NonUrgent ev4 = new Regist_NonUrgent(18, ed1, room2, p1, (Nurse) n1);
 			ev4.execute();
 	 		System.out.println(ev4.timeStamp);
 		}
 		
 		if (p1.getSeverity()==SeverityLevel.L5 | p1.getSeverity()==SeverityLevel.L4){
 			Regist_Urgent ev4 = new Regist_Urgent(18, ed1, room1, p2, (Nurse) n1);
 			ev4.execute();
 	 		System.out.println(ev4.timeStamp);
 		}
 		else {
 			Regist_NonUrgent ev4 = new Regist_NonUrgent(18, ed1, room2, p2, (Nurse) n1);
 			ev4.execute();
 	 		System.out.println(ev4.timeStamp);
 		}
	}

}
