package fr.ecp.is1220.projet.part1.event;

import java.util.Date;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Uniform;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.NurseState;
import fr.ecp.is1220.projet.part1.core.Output;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.PhysicianState;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;


public class Consultation extends Event {
	protected Physician physician;
	protected Output outputconsultation;
	
	/**
	 * Si un médecin est libre, la consultation peut avoir lieu. Sinon le patient patiente en salle d'attente.  
	 * @throws ParameterUnifException 
	 */
	public Consultation(EmergencyDepartment ed, Patient patient, Date arrivaldate) throws ParameterUnifException {
		super(arrivaldate, patient);
		
		while (ed.returnFreeHumanResource("physician")==null){} 

		this.physician = (Physician) ed.returnFreeHumanResource("physician");
		physician.setState(PhysicianState.VISITING);
		//this.setEndDate(tempsattente); // Je comprends pas comment tu veux le calculer du coup ... 
		// une fois la visite terminée, le médecin est libéré 
		physician.setState(PhysicianState.ONDUTY);

		double duree = Uniform.getSample(5, 20);
			// Temps de consultation uniformément distribué entre 5 et 20
		this.setEndDate(duree);
		this.outputconsultation=this.calculoutput();
		this.fillrecord();
		}
	
	
	private Output calculoutput() {
		double output = Math.random();
		if (output <= 0.35){
			outputconsultation = Output.NOTEST;
		}else if (output <= 0.55){
			outputconsultation = Output.RADIOGRAPHY;
		}else if (output <= 0.95){
			outputconsultation = Output.BLOODTEST;
		}else{
			outputconsultation = Output.MRI;
		}
		return outputconsultation;
	}
	@Override
	public String toString() {
		return "Consultation effectuée par " + physician + ", /n Verdict : " + ", débuté à "
				+ startEvent + ",terminé à " + endEvent ;
	}

}
