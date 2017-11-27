package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projetc.part2.simulation.EventsType;

public abstract class Event {
	
	public double timeStamp; // instant d'occurence de l'évènement auquel l'évent se produit
	protected EmergencyDepartment ed;
	
	
	public Event(double d, EmergencyDepartment ed){
		this.timeStamp = d;	
		this.ed = ed;
	}
	
	public abstract void execute();

	public abstract EventsType getType();
	

}
