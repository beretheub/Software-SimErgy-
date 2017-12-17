package fr.ecp.is1220.projet.part1.ProbabilityDistribution;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterExpException;

public class ExpStrat extends DistributionStrategy implements java.io.Serializable {

	private static final long serialVersionUID = -5318594274230395873L;

	@Override
	public double getDuree(double[] parameters) {
		if (parameters.length > 2){
			try {
				return Exp.getSample(parameters[2]);
			} catch (ParameterExpException e) {
				System.out.println("Default Value of ExpStrat given");
				return 60;
			}
		}
		System.out.println("Default Value of ExpStrat given");
		return 60;
	}

}
