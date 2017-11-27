package fr.ecp.is1220.projet.part2.simulationTest;

import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.FactoryPattern.AbstractFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.core.BoxRoom;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.ShockRoom;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L1;
import fr.ecp.is1220.projetc.part2.simulation.EnabledEvents;
import fr.ecp.is1220.projetc.part2.simulation.EventsType;


public class testEnabledEvents {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Grenoble");
		
		
 		
 		Arr_L1 ev2 = new Arr_L1(ed1);
 		ev2.execute();
 		
 		AbstractFactory nursfac = FactoryProducer.getFactory("humanresource");

 		HumanResources n1 = nursfac.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
 		
 		AbstractFactory roomfac = FactoryProducer.getFactory("room");
 		
 		ShockRoom room1 = (ShockRoom) roomfac.getRoom(ed1, "shockroom", "Room 1");
 		BoxRoom room2 = (BoxRoom) roomfac.getRoom(ed1, "boxroom", "Room 2");
 		
 		
 		ArrayList<EventsType> liste = new ArrayList<>();
 		liste = EnabledEvents.updateEnabledEvents(ed1);
 		System.out.println(liste);
	}

}
