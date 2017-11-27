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
	private ArrayList<Patient> waitingQueue;
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
	 */
	@Override
	public void registerObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.add(obs);

	}
	/**
	 * Supprime l'observer en param�tre de la liste existante
	 */
	@Override
	public void deleteObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.remove(obs);
	}
	
	/**
	 * Agit sur les observer ... � compl�ter 
	 */
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		// A modifier une fois que l'on aura la structure compl�te mise en place !
		for (Observer obs : observers) {
			obs.update();
		}
	}
	
	/**
	 *Ajoute le patient en param�tre � la liste d'attente
	 *@param patient
	 */
	public void newPatient(Patient pat){
		waitingQueue.add(pat);
	}
	
	/**
	 * Retoure la liste d'attente pour ce service
	 * @return ArrayList<Patient>
	 */
	public ArrayList<Patient> getQueue(){
		return waitingQueue;
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
	 * Affiche une vue de la file d'attente
	 */
	public void printQueue(){
	// Peut �tre � changer si on passe � une interface graphique ?
		for (Patient patient : waitingQueue) {
			System.out.println("In the line for -- " + this.getName());
			System.out.println(waitingQueue.indexOf(patient) + 1 + " -- name : " + patient.getName() + " -- id : " + patient.getId());
			
		}
		
		
	}
	/**
	 *  Cr��e un nouveau service, avec g�n�ration automatique de l'identifiant, et le rattache � l'ED en question
	 * @param name
	 * @param cost
	 * @throws WrongIDAttribution 
	 */
	public HealthServices(EmergencyDepartment ed, String name, float cost) throws WrongIDAttribution {
		super();
		this.name = name;
		this.cost = cost;
		waitingQueue = new ArrayList<>();
		observers = new ArrayList<>();
		IdGenerator idG = IdGenerator.getInstance();
		id = idG.generateId(13);
		this.ed = ed;
		ed.addResource(this);
	}
}
