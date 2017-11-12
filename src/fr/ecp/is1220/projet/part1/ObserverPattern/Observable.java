package fr.ecp.is1220.projet.part1.ObserverPattern;

public interface Observable {
	public void registerObserver(Observer obs);
	public void deleteObserver(Observer obs);
	public void notifyObservers();
	
}