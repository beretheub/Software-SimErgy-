package fr.ecp.is1220.projet.part1.core;
public interface NonHumanResources extends Resources {
	
	/**
	 * Class NonHumanResources : hérite de la classe Resources
	 * On y retrouve les pièces, services et équipements
	 * @return
	 */
	public String getName();
	public void setName(String name);
	public int getId();

}
