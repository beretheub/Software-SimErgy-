package fr.ecp.is1220.projet.part1;

public class Patient {
	protected int idPatient;
	protected String name;
	protected Insurance insurance=Insurance.NO;
	
	/** 
	*On part du principe que le patient n'a pas d'assurance par d�faut
	*O peut aussi cr�er un patient avec assurance
	*L'ID se g�nr�re automatiquement, en commen�ant par le pr�fixe 10
	**/
	
	public Patient(String name) {
		super();
		this.name = name;
		IdGenerator idPatient = IdGenerator.getInstance();
	}
	
	public Patient(String name, Insurance insurance) {
		this.insurance=insurance;
		this.name = name;
		IdGenerator idPatient = IdGenerator.getInstance();
	}

	public int getIdPatient() {
		return idPatient;
	}

	public String getName() {
		return name;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	@Override
	public String toString() {
		return "Patient [idPatient=" + idPatient + ", name=" + name + ", insurance=" + insurance + "]";
	}
	
	
}
