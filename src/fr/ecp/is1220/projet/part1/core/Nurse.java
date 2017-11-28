package fr.ecp.is1220.projet.part1.core;

/** 
 * Classe nurse : hérite de la classe humanresources
 * Paramètres : 
 * 	- Etat(nursestate)
 * 	- prochaine date à laquelle la nurse est disponible (Date)
 */
public class Nurse extends HumanResources{
	NurseState state;
	
	
	/**
	 * Retourne l'état de la nurse
	 */
	public NurseState getState(){
		return this.state;
	}
	/**
	 * Remplace l'état de la nurse par celui en paramètre
	 */
	public void setState(NurseState choice){
		this.state = choice;
		
	}
	/**
	 *Crée une infirmière
	 *Par défaut, celle-ci est au travail, et disponible
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
