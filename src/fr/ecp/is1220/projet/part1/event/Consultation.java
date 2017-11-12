package fr.ecp.is1220.projet.part1.event;

import fr.ecp.is1220.projet.part1.core.Physician;


public class Consultation extends Event {
	protected Physician physician;
	protected String outputconsultation;
	
	/**
	 * Si un médecin est libre, la consultation peut avoir lieu. Sinon le patient patiente en salle d'attente.  
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "Consultation effectuée par " + physician + ", /n Verdict : " + ", débuté à "
				+ startevent + ",terminé à " + endevent ;
	}
}
