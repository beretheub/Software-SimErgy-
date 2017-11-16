package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;


public abstract class Arr extends Event {
	
	protected static int lastArr = 0;
	
	public Arr(int timeStamp, EmergencyDepartment ed) {
		super(timeStamp, ed);
	}	
}
