package fr.ecp.is1220.projet.part1.event;

import fr.ecp.is1220.projet.part1.Nurse;

public class Triage extends Event{
	protected Nurse nurse;

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Patient enregistré par " + nurse + " à " + startevent;
	}
}
