package tests;

import fr.ecp.is1220.projet.part1.FactoryPattern.AbstractFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Rooms;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L5;
import fr.ecp.is1220.projet.part1.event_v2.Regist_Urgent;

public class Triagetest_v2 {

	public static void main(String[] args) {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Grenoble");
		
		Arr_L5 ev3 = new Arr_L5(ed1);
 		
 		ev3.execute();
 		
 		
 		AbstractFactory nursfac = FactoryProducer.getFactory("humanresource");

 		HumanResources n1 = nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
 		
 		AbstractFactory roomfac = FactoryProducer.getFactory("room");
 		
 		Rooms room1 = roomfac.getRoom(ed1, "shockroom", "Room 1");
 		
 		Patient p1 = ed1.listOfPatientsInTheED.get(0);
 		
 		Regist_Urgent ev4 = new Regist_Urgent(18, ed1, room1, p1, (Nurse) n1);
 		
 		System.out.println(ev4.timeStamp);
 		ev4.execute();
 		
 		
 		
 		
 		
 		

	}

}
