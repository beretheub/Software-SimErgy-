package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Transporter;
import fr.ecp.is1220.projet.part1.core.TransporterState;
import fr.ecp.is1220.projet.part2.simulation.EventsType;

public class FreeTransporter extends Event {
	Transporter tran;
	public FreeTransporter(double d, EmergencyDepartment ed, Transporter tran) {
		super(d, ed);
		this.tran = tran;
		
	}

	@Override
	public void execute() {
		
		this.tran.setState(TransporterState.ONDUTY);

	}

	@Override
	public EventsType getType() {
		// TODO Auto-generated method stub
		return EventsType.FREETRANSPORTER;
	}


}
