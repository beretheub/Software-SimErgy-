package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.NurseState;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.PhysicianState;

public class FreePhysician extends Event {
	Physician physician;
	
	public FreePhysician(int timeStamp, EmergencyDepartment ed, Physician physician) {
		super(timeStamp, ed);
		this.physician = physician;
		
	}

	@Override
	public void execute() {
		
		this.physician.setState(PhysicianState.ONDUTY);

	}


}
