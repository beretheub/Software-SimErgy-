package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterNormException;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Norm;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;
import fr.ecp.is1220.projet.part2.simulation.EventsType;

public class Arr_L2 extends Arr {
	private static double lastArr = 0;
	public Arr_L2(EmergencyDepartment ed){
		super(Arr_L2.getNextPatientTimeStamp(lastArr), ed);
		lastArr = this.timeStamp;
		
		
	}
	/**
	 * Nous décidons que le temps de la prochaine arrivée suit une loi normale de paramètre (6,2)
	 * @throws ParameterNormException 
	 */
	private static double getNextPatientTimeStamp(double lastArr2) {
		try {
			return lastArr2 + Math.abs(Norm.getSample(15, 11));
		} catch (ParameterNormException e) {
			return lastArr2 + 6;
		} 
	}
	@Override
	public void execute() {
		Patient p1 = new Patient(this.ed, "Random name");
		p1.setSeverity(SeverityLevel.L2);
		p1.setArrivalTime(timeStamp);
		p1.setPatientState(PatientState.ARRIVING);
		p1.fillRecord(Integer.toString(p1.getPatientRecord().size()) + " - " + Integer.toString(p1.getId()) +" - Arrived in " + p1.getPatientEd().getEdName() + " at " + Double.toString(this.timeStamp)); 
		EndEvent e = new EndEvent(this.timeStamp + 3, this.ed, p1); // Cet event a pour fonction de mettre a jour l'état du patient pour simuler le temps passé dans l'évent "arrival"
		this.ed.addEventInEventQueue(e);
		this.ed.addPatientInED(p1);
		this.ed.addPatientWaitingForTriage(p1);

	}

	@Override
	public EventsType getType() {
		// TODO Auto-generated method stub
		return EventsType.ARRL2;
	}

}
