package fr.ecp.is1220.projet.part1.ProbabilityDistribution;

import java.util.Random;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterExpException;
import fr.ecp.is1220.projet.part1.Exceptions.ParameterNormException;
import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;

/*
 * On code une loi normale, qui par d�faut est centr�e r�duite.
 */
public class Norm extends ProbabilityDistributions {

	// Loi noramle centr�e r�duite
	public static double getSample(){
		Random rand=new Random();
		return (rand.nextGaussian());
	}
	
	// LOI NORMALE non centr�e r�duite 
	public static double getSample(double esperance, double ecarttype) throws ParameterNormException{
		if (ecarttype<0){
			throw new ParameterNormException();
		}
	     return esperance + ecarttype*Norm.getSample();
	}


}
