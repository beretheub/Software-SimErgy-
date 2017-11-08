package fr.ecp.is1220.projet.part1;

public class IdGenerator {
	private int idcompteur = 0;
	private static IdGenerator instance = null;
	
	
	// contructor singleton pattern
	private IdGenerator() {
		super();
	}

	/**
	 * Returns the only instance of IdGenerator, if none creates it.
	 */
	public static IdGenerator getInstance(){
		if (instance == null){
			instance = new IdGenerator();
		}
		return instance;
	}

	/**
	 * Retruns a unique id with a prefix (two first numbers of the id) according to the type of resource.
	 * @param idPrefix, int number (between 00 and 99) which is a prefix for the 00 for HR, 01 for rooms etc...
	 * @return uniqId (int)
	 * 
	 * Prefixes : 
	 * (00 : Human resource)
	 * (01 : room)
	 * (02 : equipment)
	 * (03 : health service)
	 * (10 : Patient)
	 */
	public int generateId(int idPrefix){
		String id = String.valueOf(idcompteur);
		String prefix;
		// Pas fini, il faut travailler ça encore puis changer tous le constructor de HR pour qu'il attribu automatiquement un id
		if (idPrefix >= 0 && idPrefix < 100){
			prefix = String.valueOf(idPrefix);
		}
		else{
			System.out.println("Wrong Prefix : the attribution of an id did not work");
			return -1;
		}
		
		idcompteur += 1;
		return Integer.parseInt(prefix.concat(id));	
	}
	

}
