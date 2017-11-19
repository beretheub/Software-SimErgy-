package fr.ecp.is1220.projet.part1.core;

import fr.ecp.is1220.projet.part1.Exceptions.FullEquipment;
import fr.ecp.is1220.projet.part1.Exceptions.FullRoom;

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
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;

	}

	public void setNHRState(NHRState state) {
		// TODO Auto-generated method stub
		this.nhrstate = state;
	}

	public NHRState getNHRState() {
		return nhrstate;
		}
	
	public Patient getPatient() {
		return patient;
		}
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public Equipment(EmergencyDepartment ed, String name) {
		super();
		this.name = name;
		IdGenerator idG = IdGenerator.getInstance();
		id = idG.generateId(12);
		this.ed = ed;
		ed.addResource(this);
		this.nhrstate=NHRState.FREE;
	}
	
	public boolean newPatient(Patient patient) throws FullEquipment {
		if (this.nhrstate==NHRState.FREE){
			this.patient=patient;
			this.nhrstate=NHRState.OCCUPIED;
			return true; 
		}
		else{throw new FullEquipment();}
	}
	

}
