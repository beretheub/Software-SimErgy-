package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;

public abstract class Event {
	
	public int timeStamp; // instant d'occurence de l'évènement auquel l'évent se produit
	protected EmergencyDepartment ed;
	
	
	public Event(int timeStamp, EmergencyDepartment ed){
		this.timeStamp = timeStamp;	
		this.ed = ed;
	}
	
	public abstract void execute();
	

}
