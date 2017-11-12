package fr.ecp.is1220.projet.part1.core;

import java.util.ArrayList;

public class EmergencyDepartment {
	private String edName;
	private ArrayList<Resources> edResources;
	/**
	 * Creates a new Emergency department with no resources 
	 * @param edName (String) 
	 */
	public EmergencyDepartment(String edName) {
		super();
		this.edName = edName;
		edResources = new ArrayList<>();
	}
	public String getEdName() {
		return edName;
	}
	public void setEdName(String edName) {
		this.edName = edName;
	}
	public void addResource(Resources res){
		edResources.add(res);
	}
	public void removeResource(Resources res){
		if (edResources.contains(res)){
			edResources.remove(res);
		}
		else{
			//Juste au cas où, normalement
			System.out.println("Error, the ressource which id is : " + res.getId() + " does not belong to this Emergency Departement");
		}
	}
	
	

}
