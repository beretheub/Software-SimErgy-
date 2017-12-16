package fr.ecp.is1220.projet.part1.ProbabilityDistribution;

import java.util.Random;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterExpException;
import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;

public class Uniform extends ProbabilityDistributions implements java.io.Serializable{
	protected double borneinf;
	protected double bornesup;
	
	public Uniform() throws ParameterUnifException {
		super();
		// On échange les valeurs sup et inf si elles ne sont pas dans le bon ordre
		if (borneinf>bornesup){
			double c=bornesup;
			double bornesup=borneinf;
			double borneinf=c;
		}
		// il suffit donc de le vérifier pour la plus faible des deux
		if (borneinf<0){
			throw new ParameterUnifException();
		}
		else {
	this.borneinf = borneinf;
	this.bornesup=bornesup;
		}
	}
	
	public static double getSample(double borneinf, double bornesup) throws ParameterUnifException {
	    Random rand = new Random();
		// il suffit donc de le vérifier pour la plus faible des deux
		if (borneinf<0){
			throw new ParameterUnifException();
		}
	    return borneinf+(bornesup-borneinf)*rand.nextDouble();
	}

	public static double getSample() {
	    Random rand = new Random();
		// Par défaut, loi uniforme sur [0,1]

	    return rand.nextDouble();
	}

}
