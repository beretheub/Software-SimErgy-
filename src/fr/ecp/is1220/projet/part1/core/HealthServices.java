package fr.ecp.is1220.projet.part1.core;

import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;
import fr.ecp.is1220.projet.part1.ObserverPattern.Observable;
import fr.ecp.is1220.projet.part1.ObserverPattern.Observer;

/**
 * La classe healthservice regroupe l'ensemble des service disponibles dans l'ED. Elle h�rite donc de la classe NonHumanressources
 * Param�tres : 
 * 	- ED (ed)
 * 	- Identifiant (int)
 * 	- Nom (String)
 * 	- Cout (double)
 * 	- Liste de patients dans la queue du service (ArrayList<Patient)
 * 	- Liste d'observers (ArrayList<Observer>, cf observer pattern)
 *
 */
public abstract class HealthServices implements Observable, NonHumanResources {
	private EmergencyDepartment ed;
	private int id;
	private String name;
	private ArrayList<Observer> observers;
	private double cost;
	
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
	 * Remplace le nom du service par celui en param�tre
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
	 * Ajoute l'observer en param�tre (ie quelqu'un qui doit �tre inform� des changements) � la liste existante
	 * 
	 * si l'observer est d�j� dans la liste, ne fait rien 
	 */
	@Override
	public void registerObserver(Observer obs) {
		if (!observers.contains(obs)){
			observers.add(obs);
		}
	}
	/**
	 * Supprime l'observer en param�tre de la liste existante
	 * 
	 * si l'observer n'est pas dans la liste, ne fait rien
	 */
	@Override
	public void deleteObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.remove(obs);
	}
	
	/**
	 * Notifie les observer du r�sultat de l'examen
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
	 * Retmplace le prix du service par celui en param�tre 
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}


	/**
	 *  Cr��e un nouveau service, avec g�n�ration automatique de l'identifiant, et le rattache � l'ED en question
	 * @param name
	 * @param cost
	 * @throws WrongIDAttribution 
	 */
	public HealthServices(EmergencyDepartment ed, String name, float cost){
		super();
		this.name = name;
		this.cost = cost;
		observers = new ArrayList<>();
		IdGenerator idG = IdGenerator.getInstance();
		try {
			id = idG.generateId(13);
		} catch (WrongIDAttribution e) {
			// n'arrivera jamais car le 13 est un constante qui marchera forc�ment
			
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
