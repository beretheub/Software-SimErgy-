package fr.ecp.is1220.projet.part1.core;
public interface NonHumanResources extends Resources {
	
	/**
	 * Class NonHumanResources : h�rite de la classe Resources
	 * On y retrouve les pi�ces, services et �quipements
	 * @return
	 */
	public String getName();
	public void setName(String name);
	public int getId();

}
