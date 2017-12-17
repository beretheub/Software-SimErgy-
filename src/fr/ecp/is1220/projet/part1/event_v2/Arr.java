package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;

/**
*Dans la suite, on part du principe que l'arrivée d'un patient dure 3 minutes 
*
* Pour ce qui est de la modélisation des arrivées futures, nous avons choisi de le modéliser par une loi normale, de paramètres variant selon la priorité. 
* Selon notre principe, un blessé grave arrive moins fréquemment, mais aussi de façon plus aléatoire (espérance et ecart-type plus grands pour le temps de la prochaine arrivée)
*
**/

public abstract class Arr extends Event {
	
	private static final long serialVersionUID = 6772947033626998173L;

	public Arr(double d, EmergencyDepartment ed) {
		super(d, ed);
	}	
}
