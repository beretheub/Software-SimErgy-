package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.PhysicianState;
import fr.ecp.is1220.projet.part2.simulation.EventsType;

public class FreePhysician extends Event implements java.io.Serializable {
	
	private static final long serialVersionUID = -7873816751438286267L;
	Physician physician;
	
	public FreePhysician(int timeStamp, EmergencyDepartment ed, Physician physician) {
		super(timeStamp, ed);
		this.physician = physician;
		
	}

	@Override
	public void execute() {
		
		this.physician.setState(PhysicianState.ONDUTY);

	}

	@Override
	public EventsType getType() {
		// TODO Auto-generated method stub
		return EventsType.FREEPHYSICIAN;
	}


}
