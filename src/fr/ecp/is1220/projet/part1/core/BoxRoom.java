package fr.ecp.is1220.projet.part1.core;

public class BoxRoom extends Rooms implements java.io.Serializable {
	/**
	 * Cr�e une nouvelle pi�ce de type boxroom
	 * La capacit� d'une boxroom est fix�e � 1
	 * @param name
	 */
	public BoxRoom(EmergencyDepartment ed, String name) {
		super(ed, name);
		// TODO Auto-generated constructor stub
		this.setCapacity(1);
		// Un seul patient peut-�tre admis das une boxroom
	}

	/**
	 * Retourne le type de la ressource : boxroom ici
	 *  */
	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.BOXROOM;
	}

	public boolean isFree() {
		if (listOfPatientsInside.size() > 0){
			return false;
		}
		return true;
	}
	
	

}
