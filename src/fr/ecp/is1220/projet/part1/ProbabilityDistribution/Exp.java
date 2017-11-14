package fr.ecp.is1220.projet.part1.ProbabilityDistribution;

import java.util.Random;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterExpException;

public class Exp extends ProbabilityDistributions {
	protected double lambda;

	public Exp(double lambda) throws ParameterExpException {
		super();
			if (lambda <=0){
				throw new ParameterExpException();
			}
			else {
		this.lambda = lambda;
			}
	}
	
	public static double getSample(double lambda) throws ParameterExpException {
	    Random rand = new Random();
		if (lambda <=0){
			throw new ParameterExpException();
		}
	    return -(1 / lambda) * Math.log( 1 - rand.nextDouble() );
	}


}
