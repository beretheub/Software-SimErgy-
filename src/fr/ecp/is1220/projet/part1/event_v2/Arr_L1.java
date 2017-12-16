package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterNormException;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Norm;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;
import fr.ecp.is1220.projet.part2.simulation.EventsType;
import fr.ecp.is1220.projet.part2.simulation.timeManager;


public class Arr_L1 extends Arr implements java.io.Serializable {
	private static double lastArr = 0;
	
	public Arr_L1(EmergencyDepartment ed){
		super(Arr_L1.getNextPatientTimeStamp(lastArr), ed);
		lastArr = this.timeStamp;	
	}
	
	/**
	 * Nous d�cidons que le temps de la prochaine arriv�e suit une loi normale de param�tre (5,2)
	 * 
	 */
	private static double getNextPatientTimeStamp(double lastArr2){
		try {
			return lastArr2 + Math.abs(Norm.getSample(15, 10));
		} catch (ParameterNormException e) {
			return lastArr2 + 5; //retourne un valeur par d�faut (sachant que ce cas n'arrivera jamais)
		} 
	}

	@Override
	public void execute() {
		Patient p1 = new Patient(this.ed, "Random name");
		p1.setSeverity(SeverityLevel.L1);
		p1.setArrivalTime(timeStamp);
		p1.addEvent(this);
		//Le patient est en train d'arriver 
		p1.setPatientState(PatientState.ARRIVING);
		p1.fillRecord(Integer.toString(p1.getPatientRecord().size()) + " - " + Integer.toString(p1.getId()) +" - Arrived in " + p1.getPatientEd().getEdName() + " at " + timeManager.formatTime(timeStamp)); 
		EndEvent e = new EndEvent(this.timeStamp + 3, this.ed, p1); // Cet event a pour fonction de mettre a jour l'�tat du patient pour simuler le temps pass� dans l'�vent "arrival"
		this.ed.addEventInEventQueue(e);
		this.ed.addPatientInED(p1);
		this.ed.addPatientWaitingForTriage(p1);
	
		
	}

	@Override
	public EventsType getType() {
		// TODO Auto-generated method stub
		return EventsType.ARRL1;
	}

}
