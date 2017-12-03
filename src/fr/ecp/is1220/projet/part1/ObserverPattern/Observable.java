package fr.ecp.is1220.projet.part1.ObserverPattern;

import fr.ecp.is1220.projet.part1.core.Patient;

public interface Observable {
	public void registerObserver(Observer obs);
	public void deleteObserver(Observer obs);
	public void notifyObservers(String message, Patient patient);
	
}
