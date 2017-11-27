package fr.ecp.is1220.projet.part1.core;

import fr.ecp.is1220.projet.part1.Exceptions.FullEquipment;
import fr.ecp.is1220.projet.part1.Exceptions.FullRoom;

/**
 * La classe englobe tous les équipements. Pour l'instant, seul le stretcher existe, mais cette classe permet d'en ajouter plus facilement.
 * Paramètres : 
 * 	- ED d'appartenance (ed)
 * 	- Nom (String)
 * 	- Identifiant (int)
 * 	- Patient (Patient, par défaut null)
 * 	- Etat (nhrstate, free par défaut)
 */

public abstract class Equipment implements NonHumanResources {
	private EmergencyDepartment ed;
	private String name;
	private int id;
	private Patient patient;
	private NHRState nhrstate;
	
	/**
	 * Returns the ed of the equipment
	 */
	public EmergencyDepartment getEd(){
		return ed;
	}
	
	/**
	 * Retourne le nom d'un équipement
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	/**
	 * Remplace le nom d'un équipement par celui en paramètre
	 */
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;

	}
	/**
	 * Remplace l'état d'un équipement par celui en paramètre
	 */
	public void setNHRState(NHRState state) {
		// TODO Auto-generated method stub
		this.nhrstate = state;
	}
	/**
	 * Retourne l'état d'un équipement
	 */
	public NHRState getNHRState() {
		return nhrstate;
		}
	/**
	 * Retourne le patient affecté à l'équipement
	 */
	public Patient getPatient() {
		return patient;
		}
	
	/**
	 * Retourne l'identifiant de l'équipement
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	/**
	 * Constructeur : crée un équipement, pour un ED donné, et un nom donnée. 
	 * 	Lui génère un identifiant, et l'ajoute en tant que ressource à l'ED 
	 * 
	 */
	public Equipment(EmergencyDepartment ed, String name) {
		super();
		this.name = name;
		IdGenerator idG = IdGenerator.getInstance();
		id = idG.generateId(12);
		this.ed = ed;
		ed.addResource(this);
		this.nhrstate=NHRState.FREE;
	}
	
	/**
	 * Si l'équipement n'est pas déjà utilisé, la fonction lui affecte le patient en paramètre, et le fait donc passer à l'état occupé. 
	 * Dans le cas contraire, une exception est levée
	 */
	public boolean newPatient(Patient patient) throws FullEquipment {
		if (this.nhrstate==NHRState.FREE){
			this.patient=patient;
			this.nhrstate=NHRState.OCCUPIED;
			return true; 
		}
		else{throw new FullEquipment();}
	}
	

}
