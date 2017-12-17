package fr.ecp.is1220.projet.part1.core;
/**
 * Les différents états d'un patient
 */
public enum PatientState implements java.io.Serializable{
	WAITING, BEEINGVISITED, TAKINGEXAM, RELEASED, INSTALLING, ARRIVING , OUT, INTRANSPORT

}
