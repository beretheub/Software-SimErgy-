package fr.ecp.is1220.projet.part1.core;

public abstract class Equipment implements NonHumanResources {
	private EmergencyDepartment ed;
	private String name;
	private int id;
	
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
	}
	

}
