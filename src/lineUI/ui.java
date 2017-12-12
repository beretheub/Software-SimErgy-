package lineUI;



import java.util.ArrayList;
import java.util.Scanner;
import fr.ecp.is1220.projet.part1.Exceptions.WrongArgument;
import fr.ecp.is1220.projet.part1.Exceptions.WrongQuery;
import fr.ecp.is1220.projet.part1.Exceptions.WrongResourceType;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.FactoryPattern.RoomFactory;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;

public class ui {
	
	
	private static int numberOfParameter = 10;
	
	
	public static void main(String[] args) {
		
		boolean exit = false;
		ArrayList<EmergencyDepartment> listeED = new ArrayList<>();
	
		System.out.println("----------  Welcome to SimErgy -----------");
		String query = "";	

		while (!exit){
			System.out.println("Please enter yout request (you can try help or exit) :");
			Scanner sc = new Scanner(System.in);
			System.out.print("$ ");
			query = sc.nextLine();
			String[] formatedQuery = formatQuery(query);
			
			if(formatedQuery[0].equalsIgnoreCase("exit")){
				exit = true;
			}else{
				try {
					executeQuery(formatedQuery, listeED);
				} catch (WrongQuery e) {
					System.out.println("Your request isn't appropriate. You can try Help command");
				} catch (WrongArgument e){
					System.out.println("Your arguments aren't appropriate. You can try Help command");
				}
			}
			
			
		}
		
		System.out.println("simulation over");
		
		
		
	}
	
	private static void executeQuery(String[] formatedQuery, ArrayList<EmergencyDepartment> lsED) throws WrongQuery, WrongArgument {
		
		
		RoomFactory roomFact = (RoomFactory) FactoryProducer.getFactory("room");
		
		
		if(formatedQuery[0].equalsIgnoreCase("createEd")){
			if(formatedQuery.length > 1){
				EmergencyDepartment ed = new EmergencyDepartment(formatedQuery[1]);
				lsED.add(ed);
			}else{
				throw new WrongArgument();
			}
		}else if(formatedQuery[0].equalsIgnoreCase("addRoom")){
			
			if(formatedQuery.length > 3){
				for (EmergencyDepartment ed : lsED){
					if(ed.getEdName().equalsIgnoreCase(formatedQuery[1])){
						try {
							roomFact.getRoom(ed, formatedQuery[2], formatedQuery[3]);
						} catch (WrongResourceType e) {
							throw new WrongArgument();
						}
						
					}else{
						throw new WrongArgument();
					}
				}
			}else{
				throw new WrongArgument();
			}
			
		}else{
			throw new WrongQuery();
		}
		
	}

	
	
	
	
	
	public static String[] formatQuery(String query){
		
		String[] ls = new String[numberOfParameter];
		String[] ls1 = new String[numberOfParameter];
		
		ls = query.split(" ", numberOfParameter);
		
		int j = 0;
		for (int i = 0; i < ls.length; i++){
			if (ls[i].length() != 0){
				ls1[j] = ls[i];
				j++;
			}
		}
		
		return ls1;
	}
	
}
