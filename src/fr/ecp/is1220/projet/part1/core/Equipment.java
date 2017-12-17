package fr.ecp.is1220.projet.part1.core;
import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;

/**
 * La classe englobe tous les �quipements. Pour l'instant, seul le stretcher existe, mais cette classe permet d'en ajouter plus facilement.
 * Param�tres : 
 * 	- ED d'appartenance (ed)
 * 	- Nom (String)
 * 	- Identifiant (int)
 * 	- Patient (Patient, par d�faut null)
 * 	- Etat (nhrstate, free par d�faut)
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
	 * Retourne le nom d'un �quipement
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	/**
	 * Remplace le nom d'un �quipement par celui en param�tre
	 */
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;

	}
	/**
	 * Remplace l'�tat d'un �quipement par celui en param�tre
	 */
	public void setNHRState(NHRState state) {
		// TODO Auto-generated method stub
		this.nhrstate = state;
	}
	/**
	 * Retourne l'�tat d'un �quipement
	 */
	public NHRState getNHRState() {
		return nhrstate;
		}
	
	/**
	 * Retourne l'identifiant de l'�quipement
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	/**
	 * Constructeur : cr�e un �quipement, pour un ED donn�, et un nom donn�e. 
	 * 	Lui g�n�re un identifiant, et l'ajoute en tant que ressource � l'ED 
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
