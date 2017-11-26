package tests;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterExpException;
import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Exp;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Uniform;

public class ProbabilityExptest {
public static void main(String[] args) throws ParameterExpException, ParameterUnifException {
	for (int i = 1; i <= 100; i++){
	System.out.println(Exp.getSample(10));
	}
}

}
