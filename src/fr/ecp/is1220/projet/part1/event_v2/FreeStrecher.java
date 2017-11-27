package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Strecher;
import fr.ecp.is1220.projetc.part2.simulation.EventsType;

public class FreeStrecher extends Event {
	
	private Strecher strecher;
	
	
	public FreeStrecher(double timeStamp, EmergencyDepartment ed, Strecher strecher) {
		super(timeStamp, ed);
		this.strecher = strecher;
		
	}

	
	
	
	@Override
	public void execute() {
		this.strecher.patientLeaving();
	}

	@Override
	public EventsType getType() {
		// TODO Auto-generated method stub
		return EventsType.FREESTRECHER;
	}

}
