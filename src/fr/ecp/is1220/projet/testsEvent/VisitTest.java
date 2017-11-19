package fr.ecp.is1220.projet.testsEvent;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;
import fr.ecp.is1220.projet.part1.FactoryPattern.AbstractFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.core.BoxRoom;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.ShockRoom;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L1;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L2;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L5;
import fr.ecp.is1220.projet.part1.event_v2.Regist_NonUrgent;
import fr.ecp.is1220.projet.part1.event_v2.Visit;


public class VisitTest {

	public static void main(String[] args) throws ParameterUnifException {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Bracieux");
		Arr_L1 ev1 = new Arr_L1(ed1);
		AbstractFactory nursfac = FactoryProducer.getFactory("humanresource");
 		Nurse n1 = (Nurse) nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
 		Physician phys1 = (Physician) nursfac.getHumanResource(ed1, "physician", "Bérénice", "Heuberger");
 		AbstractFactory roomfac = FactoryProducer.getFactory("room");
 		BoxRoom room2 = (BoxRoom) roomfac.getRoom(ed1, "boxroom", "Room 2");
		
 		System.out.println(ev1.timeStamp);
 		ev1.execute();
 		System.out.println(ev1.timeStamp);
 		Patient p1 = ed1.listOfPatientsInTheED.get(0);
 		Regist_NonUrgent ev2 = new Regist_NonUrgent(ev1.timeStamp, ed1, room2, p1, n1);
 		ev2.execute();
 		System.out.println(ev2.timeStamp);
 		Visit ev3 = new Visit(ev2.timeStamp, ed1, room2, phys1);
 		ev3.execute();
 		System.out.println(ev3.timeStamp);
 		System.out.println(p1.getPatientRecord());
	}

}
