package fr.ecp.is1220.projetc.part2.simulation;

import java.util.ArrayList;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.ResourcesType;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;
import fr.ecp.is1220.projet.part1.event_v2.Event;

public class EnabledEvents {
	
	public ArrayList<EventsType> list;
	
	public EnabledEvents(){
		list = new ArrayList<>();
	}
	

	public static ArrayList<EventsType> updateEnabledEvents(EmergencyDepartment state) {
			ArrayList<EventsType> liste = new ArrayList<>();
			// on commence par ajouter les évènements sans condition
			liste.add(EventsType.ARRL1);
			liste.add(EventsType.ARRL2);
			liste.add(EventsType.ARRL3);
			liste.add(EventsType.ARRL4);
			liste.add(EventsType.ARRL5);
			
			// on gère ensuite les registrations urgentes
			
			if(state.returnFreeHumanResource(ResourcesType.NURSE) != null){
				for ( Patient p : state.getListOfPatientsWaitingForTriage()) {
					if (p.getSeverity() == SeverityLevel.L5 || p.getSeverity() == SeverityLevel.L4){
						if (state.returnFreeNonHumanResources(ResourcesType.SHOCKROOM) != null){
							if (!liste.contains(EventsType.REGISTURGENT)){
								liste.add(EventsType.REGISTURGENT); // L'évent ne doit apparaitre qu'une seule fois dans la liste
							}
						}
							
					}
					
				}
				
			}
			if(state.returnFreeHumanResource(ResourcesType.NURSE) != null){
				for ( Patient p : state.getListOfPatientsWaitingForTriage()) {
					if (p.getSeverity() == SeverityLevel.L1 || p.getSeverity() == SeverityLevel.L2|| p.getSeverity() == SeverityLevel.L3 ){
						if (state.returnFreeNonHumanResources(ResourcesType.BOXROOM) != null){
							if (!liste.contains(EventsType.REGISTNONURGENT)){
								liste.add(EventsType.REGISTNONURGENT); // L'évent ne doit apparaitre qu'une seule fois dans la liste
							}
						}
							
					}
					
				}
				
			}
			
			
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
