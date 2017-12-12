package fr.ecp.is1220.projet.part1.ProbabilityDistribution;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;

public class uniformStrat extends DistributionStrategy {

	@Override
	public double getDuree(double borneInf, double BorneSup ) {
		try {
			return Uniform.getSample(15,90);
		} catch (ParameterUnifException e) {
			return 90;
		}
		
	}
	
	

}
