package fr.ecp.is1220.projet.part1.ObserverPattern;

import fr.ecp.is1220.projet.part1.core.Patient;

public interface Observer {
	void update(String message, Patient patient);

}
