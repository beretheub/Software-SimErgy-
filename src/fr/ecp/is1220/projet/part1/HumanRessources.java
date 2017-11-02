package fr.ecp.is1220.projet.part1;

public abstract class HumanRessources implements Ressources {
	int id;
	String name;
	String surname;
	
	
	/**
	 * Return an int number which is the id of the HR.
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	/**
	 * Sets a new id for the HR. Which is the int number taken as parameter.
	 */
	@Override
	public void setId(int id) {
		this.id = id;
		
	}
	/**
	 * Return a string which is the name of the HR.
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	/**
	 * Sets a new name for the HR. Which is the string taken as parameter.
	 */
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	
	/**
	 * Return a string which is the surname of the HR.
	 */
	public String getSurname() {
		// TODO Auto-generated method stub
		return this.surname;
	}
	
	/**
	 * Sets a new surname for the HR. Which is the string taken as parameter.
	 */
	public void setSurname(String surname) {
		// TODO Auto-generated method stub
		this.surname = surname;
	}
	public HumanRessources(int id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	
	}

}
