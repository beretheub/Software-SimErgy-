package fr.ecp.is1220.projet.part1.ProbabilityDistribution;

public class DiracStrat extends DistributionStrategy implements java.io.Serializable {

	private static final long serialVersionUID = 163002720183686994L;

	@Override
	public double getDuree(double[] parameters) {
		if(parameters.length > 5){
			return parameters[5];
		}
		System.out.println("Default Value of DiracStrat given");
		return 60;
	}

}
