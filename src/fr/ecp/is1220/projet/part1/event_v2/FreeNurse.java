package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.NurseState;
import fr.ecp.is1220.projet.part2.simulation.EventsType;

public class FreeNurse extends Event {
	Nurse nurse;
	public FreeNurse(double d, EmergencyDepartment ed, Nurse nurse) {
		super(d, ed);
		this.nurse = nurse;
		
	}

	@Override
	public void execute() {
		
		this.nurse.setState(NurseState.ONDUTY);

	}

	@Override
	public EventsType getType() {
		// TODO Auto-generated method stub
		return EventsType.FREENURSE;
	}


}
