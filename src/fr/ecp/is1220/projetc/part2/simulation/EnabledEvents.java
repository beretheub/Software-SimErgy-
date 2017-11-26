package fr.ecp.is1220.projetc.part2.simulation;

import java.util.ArrayList;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.event_v2.Event;

public class EnabledEvents {
	
	private ArrayList<Event> list;
	
	public EnabledEvents(){
		list = new ArrayList<>();
	}

	public static EnabledEvents updateEnabledEvents(EnabledEvents enabledEvents, EmergencyDepartment state) {
		
		return null;
	}

	public static void updateEventQueue(EnabledEvents enabledEventsBis, EnabledEvents enabledEvents, ArrayList<Event> eventQueue) {
		
		
	}

	public void removeFirstEventOfType(String type) {
		for (Event event : list) {
			if(event.getType() == type){
				list.remove(event);
			}
			
		}
	}

}
