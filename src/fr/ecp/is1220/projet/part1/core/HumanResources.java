package fr.ecp.is1220.projet.part1.core;

public abstract class HumanResources implements Resources {
	int id;
	String name;
	String surname;
	EmergencyDepartment ed;
	
	
	public EmergencyDepartment getEd() {
		return ed;
	}
	/**
	 * Return an int number which is the id of the HR.
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
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
	public HumanResources(EmergencyDepartment ed, String name, String surname) {
		super();
		IdGenerator idRoom = IdGenerator.getInstance();
		this.id = idRoom.generateId(10); //Le prefix des id des HR est 10 
		this.name = name;
		this.surname = surname;
		this.ed = ed;
		ed.addResource(this); // ATTENTION IL FAUT ABSOLUMENT QUE L'ED AI BIEN A TOUT MOMENT LES BONNES RESSOURCES DANS SA LISTE
		                      //IL FAUT QUE LES INFORMATIONS CONCORDENT !
	
	}

}
