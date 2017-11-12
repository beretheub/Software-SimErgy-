package fr.ecp.is1220.projet.part1.event;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

import fr.ecp.is1220.projet.part1.core.Patient;

public abstract class Event {
	protected Date startevent;
	protected Date endevent;
	protected Patient patient; 
	protected ArrayList<Patient> fileattente = new ArrayList<>(); 
	
	/**
	 * L'événement s'éxécute sur le patient 
	 */
	public abstract void execute();
	
	/**
	 * Le patient rejoint la file d'attente
	 */
	public void fileattente (Patient p) {
		if (fileattente.isEmpty()){
			this.execute();
		}
		else { 
			fileattente.add(patient);
			
			
		}
	}
	/**
	 * La fiche patient est remplie
	 */
	public void fillrecord(){
		File file = new File ("Fiche_"+patient.getName());
		// creates a FileWriter Object
		FileWriter writer = new FileWriter(file);
		// Writes the content to the file
		writer.write(this.toString());
		writer.flush();
		writer.close();
	}
	public abstract String toString();
	}
	
	
}
