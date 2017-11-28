package fr.ecp.is1220.projet.part1.core;

import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;

/*
 * Je ne sais pas si les consultation ont leur place en tant que health service etant donné que l'on a déjà la
 * class consultation room dans laquelle est la liste d'attente des patients... Il faut voir
 * comment on organise le code et à quelle class on donnera la fonction d'orienter les patients
 * dans les différents services... Pour ma ça se jouera plutot au niveau de la consultation room
 * du physician et de l'event consultation
 * à mon avis il faudra supprimer cette class...
 * 
 */


public class ConsultationService extends HealthServices {
	
	/**
	 * Consultationservice : hérite de la classe heathservice.
	 * Le prix par défaut est fixé à 30, mais il est possible de fixer directement le prix à la création. 
	 * @throws WrongIDAttribution 
	 */
	
	public ConsultationService(EmergencyDepartment ed, String name){
		// le prix par défaut d'une consultation est fixé à 30
		super(ed, name, 30);
		// TODO Auto-generated constructor stub
		
	}
	public ConsultationService(EmergencyDepartment ed, String name, float cost){
		super(ed, name, cost);
		// TODO Auto-generated constructor stub
		
	}
	
	/**
	 * Retourne le type de la ressource : consultation ici
	 *  */
	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.CONSULTATIONSERVICE;
	}


}
