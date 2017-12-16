package fr.ecp.is1220.projet.part1.core;

public class Strecher extends Equipment implements java.io.Serializable {
	private StrecherState state;
	
	/**
	 * Creates a strecher with a uniq id : 12...
	 * @param name
	 */
	
	public Strecher(EmergencyDepartment ed, String name) {
		super(ed, name);
		this.state = StrecherState.EMPTY;
	}

	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.STRECHER;
	}
	public void newPatient(){
		this.state = StrecherState.FULL;
		
	}
	public void patientLeaving(){
		this.state = StrecherState.EMPTY;
	}
	
	public boolean isFree() {
		if (this.state == StrecherState.FULL ){
			return false;
		}
		return true;
	}
	

}
