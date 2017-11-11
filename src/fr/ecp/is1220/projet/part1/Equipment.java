package fr.ecp.is1220.projet.part1;

public abstract class Equipment implements NonHumanRessources {
	
	private String name;
	private int id;
	
	
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

	public Equipment(String name) {
		super();
		this.name = name;
		IdGenerator idG = IdGenerator.getInstance();
		id = idG.generateId(12);
	}
	

}
