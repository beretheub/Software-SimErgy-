package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterNormException;
import fr.ecp.is1220.projet.part1.Exceptions.WrongArgument;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.DiracStrat;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.DistributionStrategy;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.ExpStrat;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.uniformStrat;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;
import fr.ecp.is1220.projet.part2.simulation.EventsType;
import fr.ecp.is1220.projet.part2.simulation.timeManager;

public class Arr_L3 extends Arr implements java.io.Serializable{

	private static final long serialVersionUID = -1587280495581829660L;
	private static double lastArr = 0;
	private static DistributionStrategy strat;
	private static double[] parameters;
	public Arr_L3(EmergencyDepartment ed){
		
		super(Arr_L3.getNextPatientTimeStamp(lastArr), ed);
		lastArr = this.timeStamp;
		strat = new uniformStrat();
		parameters = new double[10];
		
		// Les deux premiers arguments de la liste sont ceux de la distribution uniforme
		parameters[0] = 13;
		parameters[1] = 27;
		
		// Le 3e argument pour la distribition exponentielle
		parameters[2] = 1/20;
		
		// Les 4 et 5eme pour la distribution normale 
		parameters[3] = 20;
		parameters[4] = 9;
		
		// Le 6eme pour la distribution dirac
		parameters[5] = 20;
		
	}
	
	/**
	 * Nous décidons que le temps de la prochaine arrivée suit une loi normale de paramètre (8,3)
	 * @throws ParameterNormException 
	 */
	private static double getNextPatientTimeStamp(double lastArr2) {
		return strat.getDuree(parameters);
	}

	@Override
	public void execute() {
		Patient p1 = new Patient(this.ed, "Random name");
		p1.setSeverity(SeverityLevel.L3);
		p1.setArrivalTime(timeStamp);
		p1.addEvent(this);
		p1.setPatientState(PatientState.ARRIVING);
		p1.fillRecord(Integer.toString(p1.getPatientRecord().size()) + " - " + Integer.toString(p1.getId()) +" - Arrived in " + p1.getPatientEd().getEdName() + " at " + timeManager.formatTime(timeStamp)); 
		EndEvent e = new EndEvent(this.timeStamp + 3, this.ed, p1); // Cet event a pour fonction de mettre a jour l'état du patient pour simuler le temps passé dans l'évent "arrival"
		this.ed.addEventInEventQueue(e);
		this.ed.addPatientInED(p1);
		this.ed.addPatientWaitingForTriage(p1);
		
		
	}
	
	/**
	 * Changes the type of distribution used to calcul the time of arrival of the next patient
	 * @param choice
	 * @param param
	 * @throws WrongArgument
	 */
	public static void changeStrat(String choice, double param) throws WrongArgument{
		if(choice.equalsIgnoreCase("exp")  && param > 0){
			parameters[2] = param;
			strat = new ExpStrat();
		}else if(choice.equalsIgnoreCase("dirac")  && param > 0){
			parameters[5] = param;
			strat = new DiracStrat();
		}else{
			throw new WrongArgument();
		}
	}
	public static void changeStrat(String choice, double param1, double param2) throws WrongArgument{
		if(choice.equalsIgnoreCase("uniform")  && Math.min(param1, param2) > 0){
			parameters[0] = param1;
			parameters[1] = param2;
			strat = new uniformStrat();
		}else if(choice.equalsIgnoreCase("norm")  && Math.min(param1, param2) > 0){
			parameters[3] = param1;
			parameters[4] = param2;
			strat = new DiracStrat();
		}else{
			throw new WrongArgument();
		}
	}

	@Override
	public EventsType getType() {
		// TODO Auto-generated method stub
		return EventsType.ARRL3;
	}

}
