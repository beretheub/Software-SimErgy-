
package fr.ecp.is1220.projet.part1;

public class Radiography extends HealthServices {

	/**
	 * @param name
	 * @param cost
	 */
	public Radiography(String name) {
		super(name, 15);
		// default price is 15
	}
	public Radiography(String name, float cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

}
