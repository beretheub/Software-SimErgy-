package fr.ecp.is1220.projet.part1;

public class Patient {
	protected int idPatient;
	protected String name;
	protected Insurance insurance=Insurance.NO;
	
	/** 
	*On part du principe que le patient n'a pas d'assurance par défaut
	*O peut aussi créer un patient avec assurance
	*L'ID se génrère automatiquement, en commençant par le préfixe 10
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
