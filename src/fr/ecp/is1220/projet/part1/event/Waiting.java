package fr.ecp.is1220.projet.part1.event;

import fr.ecp.is1220.projet.part1.WaitingRoom;

public class Waiting extends Event {
	protected WaitingRoom waitingroom;

	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Attente de " + startevent + " à " + endevent ;
	}
}
