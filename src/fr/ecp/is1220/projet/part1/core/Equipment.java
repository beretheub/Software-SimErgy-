package fr.ecp.is1220.projet.part1.core;
import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;

/**
 * La classe englobe tous les équipements. Pour l'instant, seul le stretcher existe, mais cette classe permet d'en ajouter plus facilement.
 * Paramètres : 
 * 	- ED d'appartenance (ed)
 * 	- Nom (String)
 * 	- Identifiant (int)
 * 	- Patient (Patient, par défaut null)
 * 	- Etat (nhrstate, free par défaut)
 */

public abstract class Equipment implements NonHumanResources, java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4419268524718046806L;
	private EmergencyDepartment ed;
	private String name;
	private int id;
	
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
	 * @throws WrongIDAttribution 
	 * 
	 */
	public Equipment(EmergencyDepartment ed, String name){
		super();
		this.name = name;
		IdGenerator idG = IdGenerator.getInstance();
		try {
			id = idG.generateId(12);
		} catch (WrongIDAttribution e) {
			//n'arrivera jamais 
		}
		this.ed = ed;
		ed.addResource(this);
		this.nhrstate=NHRState.FREE;
	}


}
