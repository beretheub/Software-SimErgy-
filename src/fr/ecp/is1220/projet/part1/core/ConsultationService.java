package fr.ecp.is1220.projet.part1.core;


/*
 * Je ne sais pas si les consultation ont leur place en tant que health service etant donn� que l'on a d�j� la
 * class consultation room dans laquelle est la liste d'attente des patients... Il faut voir
 * comment on organise le code et � quelle class on donnera la fonction d'orienter les patients
 * dans les diff�rents services... Pour ma �a se jouera plutot au niveau de la consultation room
 * du physician et de l'event consultation
 * � mon avis il faudra supprimer cette class...
 * 
 */


public class ConsultationService extends HealthServices {
	/**
	 * Creates a new consultation service. It inherits the attributes of a healtService.
	 * 
	 * The default price of a consultation is 10, bus you can determine a new price for this specifiq consultation service
	 * 
	 */
	
	public ConsultationService(EmergencyDepartment ed, String name) {
		// Il je fixe le prix par d�faut d'une consultation � 10
		super(ed, name, 10);
		// TODO Auto-generated constructor stub
		
	}
	public ConsultationService(EmergencyDepartment ed, String name, float cost) {
		super(ed, name, cost);
		// TODO Auto-generated constructor stub
		
	}


}
