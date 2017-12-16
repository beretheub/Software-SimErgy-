package fr.ecp.is1220.projet.part1.ProbabilityDistribution;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterNormException;

public class NormStrategy extends DistributionStrategy implements java.io.Serializable {

	@Override
	public double getDuree(double[] parameters) {
		if(parameters.length > 4){
			try {
				return Norm.getSample(parameters[3], parameters[4]);
			} catch (ParameterNormException e) {
				System.out.println("Default Value of NormStrat given");
				return 60;
			}
		}
		System.out.println("Default Value of NormStrat given");
		return 60;
	}

}
