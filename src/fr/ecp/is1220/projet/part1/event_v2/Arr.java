package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;

/**
*Dans la suite, on part du principe que l'arriv�e d'un patient dure 3 minutes 
*
* Pour ce qui est de la mod�lisation des arriv�es futures, nous avons choisi de le mod�liser par une loi normale, de param�tres variant selon la priorit�. 
* Selon notre principe, un bless� grave arrive moins fr�quemment, mais aussi de fa�on plus al�atoire (esp�rance et ecart-type plus grands pour le temps de la prochaine arriv�e)
*
**/

public abstract class Arr extends Event {
	
	private static final long serialVersionUID = 6772947033626998173L;

	public Arr(double d, EmergencyDepartment ed) {
		super(d, ed);
	}	
}
