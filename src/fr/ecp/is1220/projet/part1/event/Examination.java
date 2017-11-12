package fr.ecp.is1220.projet.part1.event;

import fr.ecp.is1220.projet.part1.core.BoxRoom;
import fr.ecp.is1220.projet.part1.core.Physician;

public class Examination extends Event {
	protected Physician physician; 
	protected BoxRoom boxroom;
	protected String outputexamination; 
	
	@Override
	public String toString() {
		return "Examen effectué par " + physician + ", /n Verdict : " + outputexamination + ", débuté à "
				+ startevent + ",terminé à " + endevent ;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
