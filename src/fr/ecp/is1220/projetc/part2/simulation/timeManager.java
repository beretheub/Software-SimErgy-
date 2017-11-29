package fr.ecp.is1220.projetc.part2.simulation;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.event_v2.Event;

public class timeManager {
	
	private EnabledEvents enabledEvents;
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
		
		
		enabledEvents = new EnabledEvents();
		
		
		
		// on crée la liste enabledEventsbis
		
		EnabledEvents enabledEventsBis = new EnabledEvents();
		
		// initialisation de la liste enabledEventBis
		enabledEventsBis.list = EnabledEvents.updateEnabledEvents(simultatedED);
		// initialisation de l'eventQueue 
		EnabledEvents.updateEventQueue(enabledEventsBis, enabledEvents, simultatedED.eventQueue, 0, simultatedED);
		
		while (simTime < limit) {
			Event e1 = simultatedED.eventQueue.get(0);
			simultatedED.eventQueue.remove(0);	
			e1.execute();
			simTime = e1.timeStamp;
			
			enabledEvents = enabledEventsBis;
			
			enabledEvents.removeFirstEventOfType(e1.getType());
			
			enabledEventsBis.list = EnabledEvents.updateEnabledEvents(simultatedED);
			
			EnabledEvents.updateEventQueue(enabledEventsBis, enabledEventsBis, simultatedED.eventQueue, simTime, simultatedED);	
		}
		
		return simultatedED;
		
		
	}
	
	

}
