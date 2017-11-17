package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Rooms;

public abstract class Regist extends Event {
	Rooms nextRoom;
	Patient p1;
	Nurse nurse;
	
	public Regist(int timeStamp, EmergencyDepartment ed, Rooms room, Patient p, Nurse nurse) {
		super(timeStamp, ed);
		this.nextRoom = room;
		this.p1 = p;
		this.nurse = nurse;
		
	}
}
