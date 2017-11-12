package fr.ecp.is1220.projet.part1.event;
import java.io.*;

import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;

public class Arrival extends Event {
	protected SeverityLevel severity;
	
	/**
	 * Si une nurse est libre, le patient est pris en charge. Sinon il patiente en salle d'attente. 
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Arrived at" + startevent + ", Niveau de gravité = "+ severity;
	}
	
	/**
	 * Crée le fichier client qui le suivra pendant son périple à l'hôpital. A chaque étape (event), il est rempli. 
	 */
	public void createrecord(Patient patient) throws IOException {
		File file = new File ("Fiche_"+patient.getName());
		// creates the file
		file.createNewFile();
		
	}
}
