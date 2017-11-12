package fr.ecp.is1220.projet.part1.FactoryPattern;

public class FactoryProducer {
	/**
	 * Creates a factory for the type of resource you want to create !
	 */
	public static AbstractFactory getFactory(String choice) {
		// TODO Auto-generated constructor stub
		if(choice.equalsIgnoreCase("humanRessource")){
			return new HumanResourcesFactory();
		}else{
			// On peut peut être faire avec les exceptions ici
			System.out.println("The factory wasn't created, please enter a valid choice");
			return null;
		}
	}

}
