package fr.ecp.is1220.projet.part1.core;

import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;

/**
 * La classe HumanRessources regroupe l'ensemble ddu personnel dans l'ED. Elle h�rite donc de la classe Ressources
 * Param�tres : 
 * 	- ED (ed)
 * 	- Identifiant (int)
 * 	- Nom et nom de famille (String)
 */

public abstract class HumanResources implements Resources, java.io.Serializable{
	int id;
	String name;
	String surname;
	EmergencyDepartment ed;
	
	
	public EmergencyDepartment getEd() {
		return ed;
	}
	/**
	 * Retourne l'identifiant du salari�
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	
	/**
	 * Retourne le nom du salari�
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	/**
	 * Remplace le nom du salari� par celui en param�tre
	 */
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	
	/**
	 * Retourne le nom de famille du salari�
	 */
	public String getSurname() {
		// TODO Auto-generated method stub
		return this.surname;
	}
	
	/**
	 * Remplace le nom de famille du salari� par celui en param�tre 
	 */
	public void setSurname(String surname) {
		// TODO Auto-generated method stub
		this.surname = surname;
	}
	
	/**
	 * Cr�e un salari� pour l'ED, avec un certain nom et prenom, et l'affecte � l'ED
	 * @param ed
	 * @param name
	 * @param surname
	 * @throws WrongIDAttribution 
	 */
	public HumanResources(EmergencyDepartment ed, String name, String surname){
		super();
		IdGenerator idRoom = IdGenerator.getInstance();
		try {
			this.id = idRoom.generateId(10);
		} catch (WrongIDAttribution e) {
			//n'arrivera jamais
		} //Le prefix des id des HR est 10 
		this.name = name;
		this.surname = surname;
		this.ed = ed;
		ed.addResource(this); // ATTENTION IL FAUT ABSOLUMENT QUE L'ED AI BIEN A TOUT MOMENT LES BONNES RESSOURCES DANS SA LISTE
		                      //IL FAUT QUE LES INFORMATIONS CONCORDENT !
	
	}

}
