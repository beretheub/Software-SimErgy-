package fr.ecp.is1220.projet.part2.simulationTest;

import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.FactoryPattern.AbstractFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.core.BoxRoom;
import fr.ecp.is1220.projet.part1.core.ConsultationService;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.ShockRoom;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L1;
import fr.ecp.is1220.projet.part1.event_v2.Regist_NonUrgent;
import fr.ecp.is1220.projet.part2.simulation.EnabledEvents;
import fr.ecp.is1220.projet.part2.simulation.EventsType;


public class testEnabledEvents {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Grenoble");
		
		
 		
 		Arr_L1 ev1 = new Arr_L1(ed1);
 		ev1.execute();
 		Arr_L1 ev5 = new Arr_L1(ed1);
 		ev5.execute();
 		
 		AbstractFactory hrfact = FactoryProducer.getFactory("humanresource");
 		

 		Nurse n1 = (Nurse) hrfact.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
 		Nurse n2 = (Nurse) hrfact.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
 		HumanResources p1 = hrfact.getHumanResource(ed1, "physician", "Benoit", "Charmettant");
 		
 		AbstractFactory roomfac = FactoryProducer.getFactory("room");
 		AbstractFactory Servicefac = FactoryProducer.getFactory("healthService");
 		
 		ConsultationService consultS = (ConsultationService) Servicefac.getHealthService(ed1, "consultation", "Consultation 1");
 		ShockRoom room1 = (ShockRoom) roomfac.getRoom(ed1, "shockroom", "Room 1");
 		BoxRoom room2 = (BoxRoom) roomfac.getRoom(ed1, "boxroom", "Room 2");
 		BoxRoom broom2 = (BoxRoom) roomfac.getRoom(ed1, "boxroom", "Room 2");
 		Patient pat1 = ed1.getListOfPatientsWaitingForTriage().get(0);
 		
 		Regist_NonUrgent ev2 = new Regist_NonUrgent(1, ed1, room2, pat1, n1);
 		ev2.execute();
 		
 		ArrayList<EventsType> liste = new ArrayList<>();
 		liste = EnabledEvents.updateEnabledEvents(ed1);
 		System.out.println(liste);
	}

}
