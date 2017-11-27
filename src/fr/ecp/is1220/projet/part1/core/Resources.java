package fr.ecp.is1220.projet.part1.core;

public interface Resources {
	int getId(); 
	EmergencyDepartment getEd();
	/**
	 * Return the type of the resource as a String : nurse, physician, transporter, strecher, boxroom
	 * shockroom, waitingroom, or the different health services...
	 * @return
	 */
	ResourcesType getType();

}
