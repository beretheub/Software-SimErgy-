package fr.ecp.is1220.projetc.part2.simulation;

import java.util.ArrayList;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.event_v2.Event;

public class EnabledEvents {
	
	public ArrayList<EventsType> list;
	
	public EnabledEvents(){
		list = new ArrayList<>();
	}
	

	public static ArrayList<EventsType> updateEnabledEvents(EnabledEvents enabledEvents, EmergencyDepartment state) {
			ArrayList<EventsType> liste = new ArrayList<>();
			// on commence par ajouter les évènements sans condition
			liste.add(EventsType.ARRL1);
			liste.add(EventsType.ARRL2);
			liste.add(EventsType.ARRL3);
			liste.add(EventsType.ARRL4);
			liste.add(EventsType.ARRL5);
			
			// on gère ensuite les registrations
			
			if(state.returnFreeNonHumanResources(Choice))
			
			
			return liste;
		
	}

	public static void updateEventQueue(EnabledEvents enabledEventsBis, EnabledEvents enabledEvents, ArrayList<Event> eventQueue) {
		
		
	}

	public void removeFirstEventOfType(EventsType type) {
		for (EventsType eventType : list) {
			if(eventType == type){
				list.remove(eventType);
			}
			
		}
	}

}
