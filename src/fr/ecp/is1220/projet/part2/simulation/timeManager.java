package fr.ecp.is1220.projet.part2.simulation;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.event_v2.Event;

public class timeManager {
	
	
	public double simTime;
	
	
	public timeManager() {
		super();
	}
	
	/**
	 * Begins a simulation for the ED.
	 * Returns a copy of the initial ed entered as a parameter after the simulation
	 * @param Limit, initialED
	 * @return edAfterSimulation
	 */
	
	public EmergencyDepartment startSimulation(int limit, EmergencyDepartment initialED){
		// Initialisation de la simulation
		this.simTime = 0; // on initialise le temps à 0
		EmergencyDepartment simultatedED = initialED;  // On crée une copy de l'ed initial, et on retourne son état final, ça permet de pouvoir faire plusieurs simulation sur le m 
		
		
		EnabledEvents enabledEvents = new EnabledEvents();
		
		
		
		// on crée la liste enabledEventsbis
		
		EnabledEvents enabledEventsBis = new EnabledEvents();
		
		// initialisation de la liste enabledEventBis
		enabledEventsBis.list = EnabledEvents.updateEnabledEvents(simultatedED);
		// initialisation de l'eventQueue 
		EnabledEvents.updateEventQueue(enabledEventsBis, enabledEvents, simultatedED.eventQueue, 0, simultatedED);
		
		while (simTime < limit) {
			if (simultatedED.eventQueue.isEmpty()){
				System.out.println("No more events, simulation is freezed or over before limit");
				break;
			}
			Event e1 = simultatedED.eventQueue.get(0);
			simultatedED.eventQueue.remove(0);	
			e1.execute();
			simTime = e1.timeStamp;
			
			enabledEvents.list.clear();
			for (EventsType e : enabledEventsBis.list){
				enabledEvents.list.add(e);
			}
			
			enabledEvents.removeFirstEventOfType(e1.getType());
			
			enabledEventsBis.list = EnabledEvents.updateEnabledEvents(simultatedED);
			
			EnabledEvents.updateEventQueue(enabledEventsBis, enabledEvents, simultatedED.eventQueue, simTime, simultatedED);	
		}
		
		return simultatedED;
		
		
	}
	
	public static String formatTime(double TimeStamp){
		
		
		int hours = (int) TimeStamp/60;
		int minutes = (int) TimeStamp - hours*60;
		
		return Integer.toString(hours) + "h" + Integer.toString(minutes);
		
	}
	
	

}
