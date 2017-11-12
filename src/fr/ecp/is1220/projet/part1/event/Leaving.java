package fr.ecp.is1220.projet.part1.event;

import java.io.*;

import fr.ecp.is1220.projet.part1.core.Patient;

public class Leaving extends Event {

	
	@Override
	public String toString() {
		return "Départ à " + startevent; 
	}
	
	public void printrecord(Patient patient) {
		for (Event e:patient.listOfEvent){
			e.toString();
		}		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
