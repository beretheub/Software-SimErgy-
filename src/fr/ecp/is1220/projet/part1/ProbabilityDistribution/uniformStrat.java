package fr.ecp.is1220.projet.part1.ProbabilityDistribution;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;

public class uniformStrat extends DistributionStrategy {

	@Override
	public double getDuree(double[] parameters) {
		if(parameters.length > 1){
			if(parameters[0]< parameters[1]){
				try {
					return Uniform.getSample((int) parameters[0],(int) parameters[1]);
				} catch (ParameterUnifException e) {
					System.out.println("Default Value of uniformStrat given");
					return 90;	
				}
			}else{
				try {
					return Uniform.getSample((int) parameters[1],(int) parameters[0]);
				} catch (ParameterUnifException e) {
					System.out.println("Default Value of uniformStrat given");
					return 90;	
				}
				
			}
		}
		System.out.println("Default Value of uniformStrat given");
		return 90;
		
	}
	
	

}
