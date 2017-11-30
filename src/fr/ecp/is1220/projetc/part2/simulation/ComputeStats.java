package fr.ecp.is1220.projetc.part2.simulation;

import fr.ecp.is1220.projet.part1.core.Patient;

public class ComputeStats {
	
	
	/**
	 * Calcul le LOS moyen pour l'ensemble des patients d�j� trait�s
	 */
		
	public static double averagelos(){
		double moy=0;
		for(Patient p1:this.listOfEndedPatient){
			moy=moy+p1.los;
		}
		moy = (double)moy/(((CharSequence) this.listOfEndedPatient).length());
		return moy;
	}
	
	/**
	 * Calcul le dtdt moyen pour l'ensemble des patients d�j� trait�s
	 */
		
	public double static averagedtdt(){
		double moy=0;
		for(Patient p1:this.listOfEndedPatient){
			moy=moy+p1.dtdt;
		}
		moy = (double)moy/(((CharSequence) this.listOfEndedPatient).length());
		return moy;
	}
}
