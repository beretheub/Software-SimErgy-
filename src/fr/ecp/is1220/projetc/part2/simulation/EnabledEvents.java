package fr.ecp.is1220.projetc.part2.simulation;

import java.util.ArrayList;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Output;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.ResourcesType;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;
import fr.ecp.is1220.projet.part1.event_v2.Event;

public class EnabledEvents {
	
	public ArrayList<EventsType> list;
	
	public EnabledEvents(){
		list = new ArrayList<>();
		
	}
	

	public static ArrayList<EventsType> updateEnabledEvents(EmergencyDepartment state) {
			ArrayList<EventsType> liste = new ArrayList<>();
			// on commence par ajouter les évènements sans condition
			liste.add(EventsType.ARRL1);
			liste.add(EventsType.ARRL2);
			liste.add(EventsType.ARRL3);
			liste.add(EventsType.ARRL4);
			liste.add(EventsType.ARRL5);
			
			// on gère ensuite les registrations urgentes
			
			if(state.returnFreeHumanResource(ResourcesType.NURSE) != null){
				for ( Patient p : state.getListOfPatientsWaitingForTriage()) {
					if (p.getSeverity() == SeverityLevel.L5 || p.getSeverity() == SeverityLevel.L4 && p.getPatientState() == PatientState.WAITING){
						if (state.returnFreeNonHumanResources(ResourcesType.SHOCKROOM) != null){
							if (!liste.contains(EventsType.REGISTURGENT)){
								liste.add(EventsType.REGISTURGENT); // L'évent ne doit apparaitre qu'une seule fois dans la liste
								break;
							}
						}
							
					}
					
				}
				
			}
			if(state.returnFreeHumanResource(ResourcesType.NURSE) != null){
				for ( Patient p : state.getListOfPatientsWaitingForTriage()) {
					if (p.getSeverity() == SeverityLevel.L1 || p.getSeverity() == SeverityLevel.L2|| p.getSeverity() == SeverityLevel.L3 && p.getPatientState() == PatientState.WAITING){
						if (state.returnFreeNonHumanResources(ResourcesType.BOXROOM) != null){
							if (!liste.contains(EventsType.REGISTNONURGENT)){
								liste.add(EventsType.REGISTNONURGENT); // L'évent ne doit apparaitre qu'une seule fois dans la liste
								break;
							}
						}
							
					}
					
				}
				
			}
			if (state.getOccupiedRoom(ResourcesType.BOXROOM) != null || state.getOccupiedRoom(ResourcesType.SHOCKROOM) != null){
				if (state.returnFreeHumanResource(ResourcesType.PHYSICIAN) != null){
					if (state.returnHealthService(ResourcesType.CONSULTATIONSERVICE) != null){
						if (!liste.contains(EventsType.VISIT)){
							liste.add(EventsType.VISIT);
						}
					}else{
						System.out.println("Warning : The consultation service is missing ! No patient can go thru the hospital.");
					}
				}
			}
			if (!state.getListOfPatientWaitingForTransporation().isEmpty()){
				if(state.returnFreeNonHumanResources(ResourcesType.STRECHER) != null){
					if(state.returnFreeHumanResource(ResourcesType.TRANSPORTER) != null){
						if (!liste.contains(EventsType.TRANSPORTATION)){
							liste.add(EventsType.TRANSPORTATION);
						}
					}
				}
			}
			
			// On s'attaque aux exams
			if (state.returnHealthService(ResourcesType.MRI) != null){
				if (state.returnFreeHumanResource(ResourcesType.PHYSICIAN) != null){
					for (Patient pat : state.getListOfPatientWaitingForExam()) {
						if (pat.getNexstep() == Output.MRI && pat.getPatientState() == PatientState.WAITING){
							if (!liste.contains(EventsType.MRI)){
								liste.add(EventsType.MRI);
							}
						}
					}
						
					}
			}{
				System.out.println("There is no mri service, some patients will never exit the hopital");
			}
			if (state.returnHealthService(ResourcesType.BLOODTEST) != null){
				if (state.returnFreeHumanResource(ResourcesType.PHYSICIAN) != null){
					for (Patient pat : state.getListOfPatientWaitingForExam()) {
						if (pat.getNexstep() == Output.BLOODTEST && pat.getPatientState() == PatientState.WAITING){
							if (!liste.contains(EventsType.BLOODTEST)){
								liste.add(EventsType.BLOODTEST);
							}
						}
					}
						
					}
			}{
				System.out.println("There is no bloodtest service, some patients will never exit the hopital");
			}
			if (state.returnHealthService(ResourcesType.SCAN) != null){
				if (state.returnFreeHumanResource(ResourcesType.PHYSICIAN) != null){
					for (Patient pat : state.getListOfPatientWaitingForExam()) {
						if (pat.getNexstep() == Output.SCAN && pat.getPatientState() == PatientState.WAITING){
							if (!liste.contains(EventsType.SCAN)){
								liste.add(EventsType.SCAN);
							}
						}
					}
						
					}
			}{
				System.out.println("There is no scan service, some patients will never exit the hopital");
			}
			if (state.returnHealthService(ResourcesType.XRAY) != null){
				if (state.returnFreeHumanResource(ResourcesType.PHYSICIAN) != null){
					for (Patient pat : state.getListOfPatientWaitingForExam()) {
						if (pat.getNexstep() == Output.XRAY && pat.getPatientState() == PatientState.WAITING){
							if (!liste.contains(EventsType.XRAY)){
								liste.add(EventsType.XRAY);
							}
						}
					}
						
					}
			}{
				System.out.println("There is no xray service, some patients will never exit the hopital");
			}
			if (state.returnHealthService(ResourcesType.RADIOGRAPHY) != null){
				if (state.returnFreeHumanResource(ResourcesType.PHYSICIAN) != null){
					for (Patient pat : state.getListOfPatientWaitingForExam()) {
						if (pat.getNexstep() == Output.RADIOGRAPHY && pat.getPatientState() == PatientState.WAITING){
							if (!liste.contains(EventsType.RADIOGRAPHY)){
								liste.add(EventsType.RADIOGRAPHY);
							}
						}
					}
						
					}
			}else{
				System.out.println("There is no radiography service, some patients will never exit the hopital");
			}
			return liste;
		
	}

	public static void updateEventQueue(EnabledEvents enabledEventsBis, EnabledEvents enabledEvents, ArrayList<Event> eventQueue) {
		
		
	}

	public void removeFirstEventOfType(EventsType type) {
		for (EventsType eventType : list) {
			if(eventType == type){
				list.remove(eventType);
			}
			
		}
	}

}
