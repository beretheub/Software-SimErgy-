package fr.ecp.is1220.projet.part1.core;

/** 
 * Classe nurse : h�rite de la classe humanresources
 * Param�tres : 
 * 	- Etat(nursestate)
 * 	- prochaine date � laquelle la nurse est disponible (Date)
 */
public class Nurse extends HumanResources implements java.io.Serializable{

	private static final long serialVersionUID = -2142218620013892675L;
	NurseState state;
	
	
	/**
	 * Retourne l'�tat de la nurse
	 */
	public NurseState getState(){
		return this.state;
	}
	/**
	 * Remplace l'�tat de la nurse par celui en param�tre
	 */
	public void setState(NurseState choice){
		this.state = choice;
		
	}
	/**
	 *Cr�e une infirmi�re
	 *Par d�faut, celle-ci est au travail, et disponible
	 *
	 */
	public Nurse(EmergencyDepartment ed, String name, String surname){
		super(ed, name, surname);
		this.state = NurseState.ONDUTY;
	}
	public Nurse(EmergencyDepartment ed, String name, String surname, NurseState choice){
		super(ed, name, surname);
		this.setState(choice);
	}
	@Override
	public String toString() {
		return "Nurse [state=" + state + ", id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
	
	/**
	 * Retourne le type de la ressource : nurse ici
	 *  */
	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.NURSE;
	}
	
	
	
	

}
