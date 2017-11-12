package fr.ecp.is1220.projet.part1.FactoryPattern;

public class FactoryProducer {
	/**
	 * Creates a factory for the type of resource you want to create !
	 * Choose between :
	 * - humanResource
	 * - equipment
	 * - room
	 * - heathService
	 */
	public static AbstractFactory getFactory(String choice) {
		// TODO Auto-generated constructor stub
		if(choice.equalsIgnoreCase("humanResource")){
			return new HumanResourcesFactory();
		}else if(choice.equalsIgnoreCase("equipment")){
			return new EquipmentFactory();
		}else if(choice.equalsIgnoreCase("room")){
			return new RoomFactory();
		}else if(choice.equalsIgnoreCase("healtservice")){
			return new HealtServiceFactory();
		}else{
			// On peut peut être faire avec les exceptions ici
			System.out.println("The factory wasn't created, please enter a valid choice");
			return null;
		}
	}

}
