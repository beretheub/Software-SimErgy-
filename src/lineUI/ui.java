package lineUI;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import fr.ecp.is1220.projet.part2.simulation.timeManager;

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
				}else if(formatedQuery[0].equalsIgnoreCase("importScenario")){
					
					if(formatedQuery.length > 1){
						ArrayList<String> instructions = new ArrayList<>();
						try {
							instructions = ui.readScenarioFile(formatedQuery[1]);
							
							for(String line : instructions){
								System.out.println("$ " + line);
								String[] formatedLine = ui.formatQuery(line);
								try {
									if(formatedLine.length > 0){
										ui.executeQuery(formatedLine, listeED);
									}
								} catch (WrongQuery e) {
									System.out.println("Your request isn't appropriate.");
									
								} catch (WrongArgument e) {
									System.out.println("Your request isn't appropriate.");
								}
							}
						} catch (FileNotFoundException e) {
							System.out.println("File not found");
						}
					}else{
						System.out.println("Your request isn't appropriate. You can try Help command");
					}
					
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
	
	public static ArrayList<String> readScenarioFile(String string) throws FileNotFoundException {
		FileReader file = null;
		BufferedReader buffer = null;
		String returnValue = "";
		
		
		try {
			file = new FileReader(string);
			buffer = new BufferedReader(file);
			String line = "";
			
			while((line = buffer.readLine()) != null){
				returnValue += line + "\n"; 
			}
		} catch (IOException e) {
			throw new FileNotFoundException();
		}finally{
			if(buffer!=null){
				
				try {
					buffer.close();
				} catch (IOException e) {}
			}
			if(file != null){
				try {
					file.close();
				} catch (IOException e) {}
			}
		}
			
		ArrayList<String> listOfCommands = new ArrayList<>();
		
		String[] ls = returnValue.split("\n");
		
		for(String str : ls){
			listOfCommands.add(str);
		}
		
		return listOfCommands;
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
			
		}else if(ui.addHSrequest(formatedQuery[0])){
			String whichHS = formatedQuery[0].substring(3);
			if(formatedQuery.length > 3){
				if(lsED.isEmpty()){
					System.out.println("Please create an ed first");
				}else{
					boolean succeded = false;
					for(EmergencyDepartment ed : lsED){
						if(ed.getEdName().equalsIgnoreCase(formatedQuery[1])){
							try {
								healthServFact.getHealthService(ed, whichHS, formatedQuery[2], formatedQuery[3]);
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
			
		}else if(ui.addHRrequest(formatedQuery[0])){
			String whichHR = formatedQuery[0].substring(3);
			if(formatedQuery.length > 3){
				if(lsED.isEmpty()){
					System.out.println("Please create an ed first");
				}else{
					boolean succeded = false;
					for(EmergencyDepartment ed : lsED){
						if(ed.getEdName().equalsIgnoreCase(formatedQuery[1])){
							hrFact.getHumanResource(ed, whichHR, formatedQuery[1], formatedQuery[2]);
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
			
		}else if(formatedQuery[0].equalsIgnoreCase("executeSimulation")){
			if(formatedQuery.length > 2){
				int time = 0;
				try{
					time = Integer.parseInt(formatedQuery[2]);
				}catch(NumberFormatException e){
					throw new WrongArgument();
				}
				
				boolean succeded = false;
				
				for(EmergencyDepartment ed : lsED){
					if(ed.getEdName().equals(formatedQuery[1])){
						timeManager tm = new timeManager();
						tm.startSimulation(time,ed);
						succeded = true;
						break;
					}
				}
				
				if(!succeded){
					throw new WrongArgument();
				}
				
			}else{
				throw new WrongArgument();
			}
			
		}else if(formatedQuery[0].equalsIgnoreCase("printedstate")){
			if (formatedQuery.length > 1){
				boolean succeded = false;
				
				for(EmergencyDepartment ed : lsED){
					if(ed.getEdName().equals(formatedQuery[1])){
						ed.displayState();
						succeded = true;
						break;
					}
				}
				
				if(!succeded){
					throw new WrongArgument();
				}
			}else{
				throw new WrongArgument();
			}
			
			
		}else{
		
		
			throw new WrongQuery();
		}
		
	}

	
	
	
	
	
	private static boolean addHRrequest(String string) {
		if(string.equalsIgnoreCase("addnurse")){
			return true;
		}else if(string.equalsIgnoreCase("addphysician")){
			return true;
		}else if(string.equalsIgnoreCase("addtransporter")){
			return true;
		}
		return false;
	}

	private static boolean addHSrequest(String string) {
		if(string.equalsIgnoreCase("addmri")){
			return true;
		}else if(string.equalsIgnoreCase("addradiography")){
			return true;
		}else if(string.equalsIgnoreCase("addxray")){
			return true;
		}else if(string.equalsIgnoreCase("addscan")){
			return true;
		}else if(string.equalsIgnoreCase("addbloodtest")){
			return true;
		}else if(string.equalsIgnoreCase("addconsultation")){
			return true;
		}
		return false;
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

	 
