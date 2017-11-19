package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;

/**
*Dans la suite, on part du principe que l'arrivée d'un patient dure 3 minutes  
*
**/

public abstract class Arr extends Event {
	
	
	
	public Arr(int timeStamp, EmergencyDepartment ed) {
		super(timeStamp, ed);
	}	
}
