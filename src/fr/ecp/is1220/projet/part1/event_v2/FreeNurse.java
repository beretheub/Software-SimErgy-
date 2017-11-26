package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.NurseState;

public class FreeNurse extends Event {
	Nurse nurse;
	public FreeNurse(int timeStamp, EmergencyDepartment ed, Nurse nurse) {
		super(timeStamp, ed);
		this.nurse = nurse;
		
	}

	@Override
	public void execute() {
		
		this.nurse.setState(NurseState.ONDUTY);

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "freenurse";
	}


}
