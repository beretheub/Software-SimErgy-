package fr.ecp.is1220.projet.part1.event;

import fr.ecp.is1220.projet.part1.Strecher;
import fr.ecp.is1220.projet.part1.Transporter;

public class Transportation extends Event {
	protected Transporter transporter; 
	protected Strecher strecher; 
	
	
	@Override
	public String toString() {
		return "Transport effectu� par " + transporter + "sur le brancard " + strecher + ", d�but� � "
				+ startevent + ",termin� � " + endevent ;
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
