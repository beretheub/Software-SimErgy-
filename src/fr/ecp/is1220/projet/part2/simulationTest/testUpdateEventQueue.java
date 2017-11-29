package fr.ecp.is1220.projet.part2.simulationTest;

import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.event_v2.Event;
import fr.ecp.is1220.projetc.part2.simulation.EnabledEvents;
import fr.ecp.is1220.projetc.part2.simulation.EventsType;

public class testUpdateEventQueue {
	public static void main(String[] args) {
		EnabledEvents A1 = new EnabledEvents();
		EnabledEvents B1 = new EnabledEvents();
		
		ArrayList<EventsType> l1 = new ArrayList<>();
		ArrayList<EventsType> l2 = new ArrayList<>();
		ArrayList<Event> l3 = new ArrayList<>();
		
		l1.add(EventsType.ARRL1);
		l1.add(EventsType.ARRL2);
		l1.add(EventsType.ARRL3);
		l2.add(EventsType.ARRL1);
		l2.add(EventsType.ARRL2);
		l2.add(EventsType.VISIT);
		
		A1.list = l1;
		B1.list = l2;
		
		EnabledEvents.updateEventQueue(A1, B1, l3, 0);
		
	}

}
