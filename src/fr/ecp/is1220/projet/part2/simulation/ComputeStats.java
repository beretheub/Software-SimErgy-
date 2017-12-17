package fr.ecp.is1220.projet.part2.simulation;

import fr.ecp.is1220.projet.part1.Exceptions.DTDTException;
import fr.ecp.is1220.projet.part1.Exceptions.LOSException;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;

public class ComputeStats {
	
	
	/**
	 * Calcul le LOS moyen pour l'ensemble des patients déjà traités.
	 * 
	 * Le deuxième argument est optionnel : calculer cette stat pour une certaine catégorie de patient (SeverityLevel)
	 */
		
	public static void averagelos(EmergencyDepartment ed){
		
		double average = 0;
		int count = 0;
		
		for (Patient pat : ed.listOfEndedPatient){
			
			try {
				average += pat.returnLOS();
				count += 1;
			} catch (LOSException e) {
				
				System.out.println("Error on a patient los computing");
			}
		}
		
		average = average/count;
		
		System.out.println("Average Length of Stay : " + timeManager.formatTime(average) + ". Calculated over " + count + " patients." );
	}
	public static void averagelos(EmergencyDepartment ed, SeverityLevel sev){
		
		double average = 0;
		int count = 0;
		
		for (Patient pat : ed.listOfEndedPatient){
			if(pat.getSeverity() == sev){
				try {
					average += pat.returnLOS();
					count += 1;
				} catch (LOSException e) {

					System.out.println("Error on a patient los computing");
				}
			}
		}
		
		average = average/count;
		
		System.out.println("Average Length of Stay (" + sev + ") : " + timeManager.formatTime(average) + ". Calculated over " + count + " patients." );
	}
		
		
	/**
	 * Calcul le dtdt moyen pour l'ensemble des patients déjà traités
	 */
		
	public static void averagedtdt(EmergencyDepartment ed ){

		double average = 0;
		int count = 0;
		
		for (Patient pat : ed.listOfEndedPatient){
			
		
			try {
				average += pat.returnDTDT();
				count += 1;
			} catch (DTDTException e) {
				
			}
			
		}
		for (Patient pat : ed.listOfPatientsInTheED){
			try {
				average += pat.returnDTDT();
				count += 1;
				
			} catch (DTDTException e) {
				
			}
			
		}
		
		average = average/count;
		
		System.out.println("Average Door to Doctor Time  : " + timeManager.formatTime(average) + ". Calculated over " + count + " patients." );
	}
	public static void averagedtdt(EmergencyDepartment ed, SeverityLevel sev){

		double average = 0;
		int count = 0;
		
		for (Patient pat : ed.listOfEndedPatient){
			
			if(pat.getSeverity() == sev){
				try {
					average += pat.returnDTDT();
					count += 1;
				} catch (DTDTException e) {

				}
			}
			
		}
		for (Patient pat : ed.listOfPatientsInTheED){
			if(pat.getSeverity() == sev){
				try {
					average += pat.returnDTDT();
					count += 1;

				} catch (DTDTException e) {

				}
			}
			
		}
		
		average = average/count;
		
		System.out.println("Average Door to Doctor Time (" + sev + ") : " + timeManager.formatTime(average) + ". Calculated over " + count + " patients." );
	}
}
