package fr.ecp.is1220.projet.part1.ProbabilityDistribution;

import java.util.Random;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterNormException;

/*
 * On code une loi normale, qui par défaut est centrée réduite.
 */
public class Norm extends ProbabilityDistributions implements java.io.Serializable {

	// Loi noramle centrée réduite
	public static double getSample(){
		Random rand=new Random();
		return (rand.nextGaussian());
	}
	
	// LOI NORMALE non centrée réduite 
	public static double getSample(double esperance, double ecarttype) throws ParameterNormException{
		if (ecarttype<0){
			throw new ParameterNormException();
		}
	     return esperance + ecarttype*Norm.getSample();
	}


}
