package fr.ecp.is1220.projet.part1.core;

import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;
import fr.ecp.is1220.projet.part1.ObserverPattern.Observable;
import fr.ecp.is1220.projet.part1.ObserverPattern.Observer;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.DiracStrat;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.DistributionStrategy;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.ExpStrat;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.NormStrategy;
import fr.ecp.is1220.projet.part1.ProbabilityDistribution.uniformStrat;

/**
 * La classe healthservice regroupe l'ensemble des service disponibles dans l'ED. Elle hérite donc de la classe NonHumanressources
 * Paramètres : 
 * 	- ED (ed)
 * 	- Identifiant (int)
 * 	- Nom (String)
 * 	- Cout (double)
 * 	- Liste de patients dans la queue du service (ArrayList<Patient)
 * 	- Liste d'observers (ArrayList<Observer>, cf observer pattern)
 *
 */
public abstract class HealthServices implements Observable, NonHumanResources, java.io.Serializable {
	
	private static final long serialVersionUID = -3111084927568792374L;
	private EmergencyDepartment ed;
	private int id;
	private String name;
	private ArrayList<Observer> observers;
	private double cost;
	private double[] parameters;
	private DistributionStrategy strat;
	
	public DistributionStrategy getStrat(){
		return strat;
	}
	/**
	 *  sets the distribution strategy, if the choice isn't recognized : sets a uniform strategy by deflault
	 *  (choices are : uniform, exp, norm, dirac)
	 */
	public void SetStrat (String choice){
		if(choice.equalsIgnoreCase("exp")){
			strat = new ExpStrat();
		}else if(choice.equalsIgnoreCase("norm")){
			strat = new NormStrategy();
		}else if(choice.equalsIgnoreCase("dirac")){
			strat = new DiracStrat();
		}else{
			strat = new uniformStrat();
			if(!choice.equalsIgnoreCase("uniform")){
				System.out.println("Wrong distribution, the distribution was setted by default as uniform.");
			}
		}
		
	}
	
	/**
	 * Retourne l'ED auquel le service appartient
	 */
	public EmergencyDepartment getEd(){
		return ed;
	}
	/**
	 * Retourne le nom du service
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
	/**
	 * Remplace le nom du service par celui en paramètre
	 */
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;

	}
	/**
	 * Retourne l'identifiant du service 
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	/**
	 * Ajoute l'observer en paramètre (ie quelqu'un qui doit être informé des changements) à la liste existante
	 * 
	 * si l'observer est déjà dans la liste, ne fait rien 
	 */
	@Override
	public void registerObserver(Observer obs) {
		if (!observers.contains(obs)){
			observers.add(obs);
		}
	}
	/**
	 * Supprime l'observer en paramètre de la liste existante
	 * 
	 * si l'observer n'est pas dans la liste, ne fait rien
	 */
	@Override
	public void deleteObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.remove(obs);
	}
	
	/**
	 * Notifie les observer du résultat de l'examen
	 */
	@Override
	public void notifyObservers(String message, Patient patient) {
		for (Observer obs : observers) {
			obs.update(message, patient);
		}
	}

	/**
	 * Retoure le prix de ce service
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Retmplace le prix du service par celui en paramètre 
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}


	/**
	 *  Créée un nouveau service, avec génération automatique de l'identifiant, et le rattache à l'ED en question
	 * @param name
	 * @param cost
	 * @throws WrongIDAttribution 
	 */
	public HealthServices(EmergencyDepartment ed, String name, float cost, String strat){
		super();
		this.name = name;
		this.cost = cost;
		observers = new ArrayList<>();
		IdGenerator idG = IdGenerator.getInstance();
		this.SetStrat(strat);
		
		// On initialise la liste des paramètres de stats
		
		parameters = new double[10];
		// Les deux premiers arguments de la liste sont ceux de la distribution uniforme
		parameters[0] = 30;
		parameters[1] = 90;
		// Le 3e argument pour la distribition exponentielle
		parameters[2] = 1/60;
		// Les 4 et 5eme pour la distribution normale 
		parameters[3] = 60;
		parameters[4] = 20;
		// Le 6eme pour la distribution dirac
		parameters[5] = 60;
		
		
		
		try {
			id = idG.generateId(13);
		} catch (WrongIDAttribution e) {
			// n'arrivera jamais car le 13 est un constante qui marchera forcément
			
		}
		this.ed = ed;
		ed.addHealthServices(this);
		for (Resources res : ed.edResources){
			if (res.getType() == ResourcesType.PHYSICIAN){
				this.registerObserver((Observer) res);
			}
			
		}
	}
}
