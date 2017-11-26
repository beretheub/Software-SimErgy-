package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.NurseState;
import fr.ecp.is1220.projet.part1.core.Transporter;
import fr.ecp.is1220.projet.part1.core.TransporterState;

public class FreeTransporter extends Event {
	Transporter tran;
	public FreeTransporter(int timeStamp, EmergencyDepartment ed, Transporter tran) {
		super(timeStamp, ed);
		this.tran = tran;
		
	}

	@Override
	public void execute() {
		
		this.tran.setState(TransporterState.ONDUTY);

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "freetransporter";
	}


}
