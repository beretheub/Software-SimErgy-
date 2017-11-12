package fr.ecp.is1220.projet.part1.core;

public class Patient {
	protected int id;
	protected String name;
	protected Insurance insurance=Insurance.NO;
	
	/** 
	*On part du principe que le patient n'a pas d'assurance par d�faut
	*O peut aussi cr�er un patient avec assurance
	*L'ID se g�n�re automatiquement, en commen�ant par le pr�fixe 20
	**/
	
	public Patient(String name) {
		super();
		this.name = name;
		IdGenerator idG = IdGenerator.getInstance();
		id = idG.generateId(20);
	}
	
	public Patient(String name, Insurance insurance) {
		this.insurance=insurance;
		this.name = name;
		IdGenerator idG = IdGenerator.getInstance();
		id = idG.generateId(20);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	@Override
	public String toString() {
		return "Patient [idPatient=" + id + ", name=" + name + ", insurance=" + insurance + "]";
	}
	
	
}
