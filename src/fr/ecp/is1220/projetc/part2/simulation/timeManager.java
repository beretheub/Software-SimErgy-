package fr.ecp.is1220.projetc.part2.simulation;

import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.event_v2.Event;

public class timeManager {
	
	private EmergencyDepartment ed;
	private ArrayList<Event> eventQueue;
	private EnabledEvents enabledEvents;

	public timeManager(EmergencyDepartment ed) {
		super();
		this.ed = ed;
		eventQueue = new ArrayList<>();
		enabledEvents = new EnabledEvents();
		
		
	}
	
	public void addEventInEventQueue(Event event){
		this.eventQueue.add(event);
		timeManager.sortEventQueue();
	}

	private static void sortEventQueue() {
		
		
	}
	
	

}
