package lineUI;



import java.util.ArrayList;
import java.util.Scanner;

import fr.ecp.is1220.projet.part1.Exceptions.InvalidNameException;
import fr.ecp.is1220.projet.part1.Exceptions.WrongArgument;
import fr.ecp.is1220.projet.part1.Exceptions.WrongQuery;
import fr.ecp.is1220.projet.part1.Exceptions.WrongResourceType;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.FactoryPattern.HealtServiceFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.HumanResourcesFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.RoomFactory;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;

public class ui {
	
	
	private static int numberOfParameter = 10;
	
	
	@SuppressWarnings("resource")
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
			if(formatedQuery[0] != null){
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
			
		}
		
		System.out.println("simulation over");
		
		
		
	}
	
	private static void executeQuery(String[] formatedQuery, ArrayList<EmergencyDepartment> lsED) throws WrongQuery, WrongArgument {
		
		RoomFactory roomFact = (RoomFactory) FactoryProducer.getFactory("room");
		HealtServiceFactory healthServFact = (HealtServiceFactory) FactoryProducer.getFactory("healthservice");
		HumanResourcesFactory hrFact = (HumanResourcesFactory) FactoryProducer.getFactory("humanresource");
		
		
		if(formatedQuery[0].equalsIgnoreCase("createEd")){
			if(formatedQuery.length > 1){
				EmergencyDepartment ed = new EmergencyDepartment(formatedQuery[1]);
				lsED.add(ed);
			}else{
				throw new WrongArgument();
			}
		}else if(formatedQuery[0].equalsIgnoreCase("addRoom")){
			if(formatedQuery.length > 3){
				if(lsED.isEmpty()){
					System.out.println("Please create an ed first");
				}else{
					boolean succeded = false;
					for(EmergencyDepartment ed : lsED){
						if(ed.getEdName().equalsIgnoreCase(formatedQuery[1])){
							try {
								roomFact.getRoom(ed, formatedQuery[2], formatedQuery[3]);
								succeded = true;
								break;
							} catch (WrongResourceType e) {
								throw new WrongArgument();
							}

						}
					}
					if (!succeded){
						throw new WrongArgument();
					}
				}
			}else{
				throw new WrongArgument();
			}
			
		}else if(formatedQuery[0].equalsIgnoreCase("addMRI")){
			if(formatedQuery.length > 3){
				if(lsED.isEmpty()){
					System.out.println("Please create an ed first");
				}else{
					boolean succeded = false;
					for(EmergencyDepartment ed : lsED){
						if(ed.getEdName().equalsIgnoreCase(formatedQuery[1])){
							try {
								healthServFact.getHealthService(ed, "mri", formatedQuery[2], formatedQuery[3]);
								succeded = true;
								break;
							} catch (InvalidNameException e) {
								throw new WrongArgument();
							}

						}
					}
					if (!succeded){
						throw new WrongArgument();
					}
				}
				
			}else{
				throw new WrongArgument();
			}
			
		}else if(formatedQuery[0].equalsIgnoreCase("addradioservice")){
			if(formatedQuery.length > 3){
				if(lsED.isEmpty()){
					System.out.println("Please create an ed first");
				}else{
					boolean succeded = false;
					for(EmergencyDepartment ed : lsED){
						if(ed.getEdName().equalsIgnoreCase(formatedQuery[1])){
							try {
								healthServFact.getHealthService(ed, "radiography", formatedQuery[2], formatedQuery[3]);
								succeded = true;
								break;
							} catch (InvalidNameException e) {
								throw new WrongArgument();
							}

						}
					}
					if (!succeded){
						throw new WrongArgument();
					}
				}
				
			}else{
				throw new WrongArgument();
			}
			
		}else if(formatedQuery[0].equalsIgnoreCase("addbloodtest")){
			if(formatedQuery.length > 3){
				if(lsED.isEmpty()){
					System.out.println("Please create an ed first");
				}else{
					boolean succeded = false;
					for(EmergencyDepartment ed : lsED){
						if(ed.getEdName().equalsIgnoreCase(formatedQuery[1])){
							try {
								healthServFact.getHealthService(ed, "bloodtest", formatedQuery[2], formatedQuery[3]);
								succeded = true;
								break;
							} catch (InvalidNameException e) {
								throw new WrongArgument();
							}

						}
					}
					if (!succeded){
						throw new WrongArgument();
					}
				}
				
			}else{
				throw new WrongArgument();
			}
			
		}else if(formatedQuery[0].equalsIgnoreCase("addxray")){
			if(formatedQuery.length > 3){
				if(lsED.isEmpty()){
					System.out.println("Please create an ed first");
				}else{
					boolean succeded = false;
					for(EmergencyDepartment ed : lsED){
						if(ed.getEdName().equalsIgnoreCase(formatedQuery[1])){
							try {
								healthServFact.getHealthService(ed, "xray", formatedQuery[2], formatedQuery[3]);
								succeded = true;
								break;
							} catch (InvalidNameException e) {
								throw new WrongArgument();
							}

						}
					}
					if (!succeded){
						throw new WrongArgument();
					}
				}
				
			}else{
				throw new WrongArgument();
			}
			
		}else if(formatedQuery[0].equalsIgnoreCase("addscan")){
			if(formatedQuery.length > 3){
				if(lsED.isEmpty()){
					System.out.println("Please create an ed first");
				}else{
					boolean succeded = false;
					for(EmergencyDepartment ed : lsED){
						if(ed.getEdName().equalsIgnoreCase(formatedQuery[1])){
							try {
								healthServFact.getHealthService(ed, "scan", formatedQuery[2], formatedQuery[3]);
								succeded = true;
								break;
							} catch (InvalidNameException e) {
								throw new WrongArgument();
							}

						}
					}
					if (!succeded){
						throw new WrongArgument();
					}
				}
				
			}else{
				throw new WrongArgument();
			}
			
		}else if(formatedQuery[0].equalsIgnoreCase("addconsultationservice")){
			if(formatedQuery.length > 3){
				if(lsED.isEmpty()){
					System.out.println("Please create an ed first");
				}else{
					boolean succeded = false;
					for(EmergencyDepartment ed : lsED){
						if(ed.getEdName().equalsIgnoreCase(formatedQuery[1])){
							try {
								healthServFact.getHealthService(ed, "consultation", formatedQuery[2], formatedQuery[3]);
								succeded = true;
								break;
							} catch (InvalidNameException e) {
								throw new WrongArgument();
							}

						}
					}
					if (!succeded){
						throw new WrongArgument();
					}
				}
				
			}else{
				throw new WrongArgument();
			}
			
		}else if(formatedQuery[0].equalsIgnoreCase("addNurse")){
			if(formatedQuery.length > 3){
				if(lsED.isEmpty()){
					System.out.println("Please create an ed first");
				}else{
					boolean succeded = false;
					for(EmergencyDepartment ed : lsED){
						if(ed.getEdName().equalsIgnoreCase(formatedQuery[1])){
							hrFact.getHumanResource(ed, "nurse", formatedQuery[1], formatedQuery[2]);
							succeded = true;
							break;
						}
					}
					if (!succeded){
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
