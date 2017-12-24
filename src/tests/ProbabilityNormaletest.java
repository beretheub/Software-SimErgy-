package tests;

import java.util.Random;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterExpException;
import fr.ecp.is1220.projet.part1.Exceptions.ParameterNormException;
import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Exp;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Norm;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.Uniform;

public class ProbabilityNormaletest {
public static void main(String[] args) throws ParameterExpException, ParameterUnifException {
	for (int i = 1; i <= 100; i++){
	//System.out.println(Exp.getSample(1));
		Random rand = new Random();
		try {
			System.out.println(Norm.getSample(10,4));
		} catch (ParameterNormException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

}
