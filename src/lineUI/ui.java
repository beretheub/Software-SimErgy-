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
import fr.ecp.is1220.projet.part1.FactoryPattern.EquipmentFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.FactoryPattern.HealtServiceFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.HumanResourcesFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.RoomFactory;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L1;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L2;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L3;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L4;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L5;
import fr.ecp.is1220.projet.part2.simulation.ComputeStats;
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
				}else if(formatedQuery[0].equalsIgnoreCase("runTest")){
					
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
					
				}else if(formatedQuery[0].equalsIgnoreCase("help")){
					
					ArrayList<String> instructions = new ArrayList<>();
					try {
						instructions = ui.readScenarioFile("help.txt");

						for(String line : instructions){
							System.out.println(line);
						}
					} catch (FileNotFoundException e) {
						System.out.println("File not found");
					}
					System.out.println("\n");
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

	@SuppressWarnings("unused")
	private static void executeQuery(String[] formatedQuery, ArrayList<EmergencyDepartment> lsED) throws WrongQuery, WrongArgument {
		
		
		RoomFactory roomFact = (RoomFactory) FactoryProducer.getFactory("room");
		HealtServiceFactory healthServFact = (HealtServiceFactory) FactoryProducer.getFactory("healthservice");
		HumanResourcesFactory hrFact = (HumanResourcesFactory) FactoryProducer.getFactory("humanresource");
		EquipmentFactory equipFact = (EquipmentFactory) FactoryProducer.getFactory("equipment");
		
		if(formatedQuery[0].equalsIgnoreCase("createEd")){
			if(formatedQuery.length > 1){
				EmergencyDepartment ed = new EmergencyDepartment(formatedQuery[1]);
				lsED.add(ed);
				Arr_L1 ini = new Arr_L1(ed);
				Arr_L2 ini2 = new Arr_L2(ed);
				Arr_L3 ini3 = new Arr_L3(ed);
				Arr_L4 ini4 = new Arr_L4(ed);
				Arr_L5 ini5 = new Arr_L5(ed);
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
			
		}else if(formatedQuery[0].equalsIgnoreCase("addStrecher")){
			if(formatedQuery.length > 2){
				if(lsED.isEmpty()){
					System.out.println("Please create an ed first");
				}else{
					boolean succeded = false;
					for(EmergencyDepartment ed : lsED){
						if(ed.getEdName().equalsIgnoreCase(formatedQuery[1])){
							equipFact.getEquipment(ed, "strecher", formatedQuery[2]);
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
			
		}else if(formatedQuery[0].equalsIgnoreCase("computeStats")){
			if (formatedQuery.length > 1){
				boolean succeded = false;
				
				for(EmergencyDepartment ed : lsED){
					if(ed.getEdName().equals(formatedQuery[1])){
						succeded = true;
						if(formatedQuery.length == 2){
							System.out.println("Statistics for emergency departement : " + ed.getEdName());
							System.out.println("Calculated for any kind of patient");
							ComputeStats.averagedtdt(ed);
							ComputeStats.averagelos(ed);

							
						}else if(formatedQuery.length > 2){
							succeded = false;
							if(formatedQuery[2].equalsIgnoreCase("l1") || formatedQuery[2].equalsIgnoreCase("l2") || formatedQuery[2].equalsIgnoreCase("l3") || formatedQuery[2].equalsIgnoreCase("l4") || formatedQuery[2].equalsIgnoreCase("l5")){
								System.out.println("Statistics for emergency departement : " + ed.getEdName());
								System.out.println("Calculated for patients with " + formatedQuery[2] + " severity");
								SeverityLevel sev = returnSeverity(formatedQuery[2]);
								if(sev != null){
									succeded = true;
									ComputeStats.averagedtdt(ed, sev);
									ComputeStats.averagelos(ed, sev);
								}
							}
						}
					}
				}
				
				if(!succeded){
					throw new WrongArgument();
				}
				
			}else{
				throw new WrongArgument();
			}
			
			
		}else if(formatedQuery[0].equalsIgnoreCase("setL1arrivalDist")){
			if (formatedQuery.length == 4 ){
				double arg;
				try{
					arg = Double.valueOf(formatedQuery[3]);
				}catch(NumberFormatException e){
					throw new WrongArgument();
				}
				try{
					Arr_L1.changeStrat(formatedQuery[2], arg);
				}catch(WrongArgument e){
					throw new WrongArgument();
				}
				
				
			}else if(formatedQuery.length > 4){
				double arg1;
				double arg2;
				try{
					arg1 = Double.valueOf(formatedQuery[3]);
					arg2 = Double.valueOf(formatedQuery[4]);
				}catch(NumberFormatException e){
					throw new WrongArgument();
				}
				try{
					Arr_L1.changeStrat(formatedQuery[2], arg1, arg2);
				}catch(WrongArgument e){
					throw new WrongArgument();
				}
			}else{
				throw new WrongArgument();
			}
			
		}else if(formatedQuery[0].equalsIgnoreCase("setL2arrivalDist")){
			if (formatedQuery.length == 4 ){
				double arg;
				try{
					arg = Double.valueOf(formatedQuery[3]);
				}catch(NumberFormatException e){
					throw new WrongArgument();
				}
				try{
					Arr_L2.changeStrat(formatedQuery[2], arg);
				}catch(WrongArgument e){
					throw new WrongArgument();
				}
				
				
			}else if(formatedQuery.length > 4){
				double arg1;
				double arg2;
				try{
					arg1 = Double.valueOf(formatedQuery[3]);
					arg2 = Double.valueOf(formatedQuery[4]);
				}catch(NumberFormatException e){
					throw new WrongArgument();
				}
				try{
					Arr_L2.changeStrat(formatedQuery[2], arg1, arg2);
				}catch(WrongArgument e){
					throw new WrongArgument();
				}
			}else{
				throw new WrongArgument();
			}
			
		}else if(formatedQuery[0].equalsIgnoreCase("setL3arrivalDist")){
			if (formatedQuery.length == 4 ){
				double arg;
				try{
					arg = Double.valueOf(formatedQuery[3]);
				}catch(NumberFormatException e){
					throw new WrongArgument();
				}
				try{
					Arr_L3.changeStrat(formatedQuery[2], arg);
				}catch(WrongArgument e){
					throw new WrongArgument();
				}
				
				
			}else if(formatedQuery.length > 4){
				double arg1;
				double arg2;
				try{
					arg1 = Double.valueOf(formatedQuery[3]);
					arg2 = Double.valueOf(formatedQuery[4]);
				}catch(NumberFormatException e){
					throw new WrongArgument();
				}
				try{
					Arr_L3.changeStrat(formatedQuery[2], arg1, arg2);
				}catch(WrongArgument e){
					throw new WrongArgument();
				}
			}else{
				throw new WrongArgument();
			}
			
		}else if(formatedQuery[0].equalsIgnoreCase("setL4arrivalDist")){
			if (formatedQuery.length == 4 ){
				double arg;
				try{
					arg = Double.valueOf(formatedQuery[3]);
				}catch(NumberFormatException e){
					throw new WrongArgument();
				}
				try{
					Arr_L4.changeStrat(formatedQuery[2], arg);
				}catch(WrongArgument e){
					throw new WrongArgument();
				}
				
				
			}else if(formatedQuery.length > 4){
				double arg1;
				double arg2;
				try{
					arg1 = Double.valueOf(formatedQuery[3]);
					arg2 = Double.valueOf(formatedQuery[4]);
				}catch(NumberFormatException e){
					throw new WrongArgument();
				}
				try{
					Arr_L4.changeStrat(formatedQuery[2], arg1, arg2);
				}catch(WrongArgument e){
					throw new WrongArgument();
				}
			}else{
				throw new WrongArgument();
			}
			
		}else if(formatedQuery[0].equalsIgnoreCase("setL5arrivalDist")){
			if (formatedQuery.length == 4 ){
				double arg;
				try{
					arg = Double.valueOf(formatedQuery[3]);
				}catch(NumberFormatException e){
					throw new WrongArgument();
				}
				try{
					Arr_L5.changeStrat(formatedQuery[2], arg);
				}catch(WrongArgument e){
					throw new WrongArgument();
				}
				
				
			}else if(formatedQuery.length > 4){
				double arg1;
				double arg2;
				try{
					arg1 = Double.valueOf(formatedQuery[3]);
					arg2 = Double.valueOf(formatedQuery[4]);
				}catch(NumberFormatException e){
					throw new WrongArgument();
				}
				try{
					Arr_L5.changeStrat(formatedQuery[2], arg1, arg2);
				}catch(WrongArgument e){
					throw new WrongArgument();
				}
			}else{
				throw new WrongArgument();
			}
			
		}else{
		
		
			throw new WrongQuery();
		}
		
	}

	
	
	
	
	
	private static SeverityLevel returnSeverity(String string) {
		if(string.equalsIgnoreCase("l1")){
			return SeverityLevel.L1;
		}else if(string.equalsIgnoreCase("l2")){
			return SeverityLevel.L2;
		}else if(string.equalsIgnoreCase("l3")){
			return SeverityLevel.L3;
		}else if(string.equalsIgnoreCase("l4")){
			return SeverityLevel.L4;
		}else if(string.equalsIgnoreCase("l5")){
			return SeverityLevel.L5;
		}
		return null;
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
		int count = 0;
		for(String str : ls1){
			if(str != null){
				count+=1;
			}
		}
		
		String[] ls2 = new String[count];
		for(int i = 0 ; i< count; i++){
			ls2[i] = ls1[i];
		}
		if(count != 0){
			return ls2;
		}else{
			String[] ls3 = new String[1];
			
			return ls3;	
		}
		
		
	}
}

	 
