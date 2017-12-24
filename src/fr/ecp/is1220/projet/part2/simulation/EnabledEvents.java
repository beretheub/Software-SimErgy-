package fr.ecp.is1220.projet.part2.simulation;

import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.core.BloodTestService;
import fr.ecp.is1220.projet.part1.core.BoxRoom;
import fr.ecp.is1220.projet.part1.core.ConsultationService;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.MRIservice;
import fr.ecp.is1220.projet.part1.core.Output;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.Radiography;
import fr.ecp.is1220.projet.part1.core.ResourcesType;
import fr.ecp.is1220.projet.part1.core.Rooms;
import fr.ecp.is1220.projet.part1.core.Scan;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;
import fr.ecp.is1220.projet.part1.core.ShockRoom;
import fr.ecp.is1220.projet.part1.core.Strecher;
import fr.ecp.is1220.projet.part1.core.Transporter;
import fr.ecp.is1220.projet.part1.core.XrayService;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L1;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L2;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L3;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L4;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L5;
import fr.ecp.is1220.projet.part1.event_v2.Bloodtest;
import fr.ecp.is1220.projet.part1.event_v2.Event;
import fr.ecp.is1220.projet.part1.event_v2.MRI;
import fr.ecp.is1220.projet.part1.event_v2.RADIOGRAPHY;
import fr.ecp.is1220.projet.part1.event_v2.Regist_NonUrgent;
import fr.ecp.is1220.projet.part1.event_v2.Regist_Urgent;
import fr.ecp.is1220.projet.part1.event_v2.SCAN;
import fr.ecp.is1220.projet.part1.event_v2.Transportation;
import fr.ecp.is1220.projet.part1.event_v2.Visit;
import fr.ecp.is1220.projet.part1.event_v2.XRAY;

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
					if ((p.getSeverity() == SeverityLevel.L5 || p.getSeverity() == SeverityLevel.L4) && p.getPatientState() == PatientState.WAITING){
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
					if ((p.getSeverity() == SeverityLevel.L1 || p.getSeverity() == SeverityLevel.L2|| p.getSeverity() == SeverityLevel.L3) && p.getPatientState() == PatientState.WAITING){
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
			if (state.ArePatientWaitingForConsultation()){
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
			}else{
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
			}else{
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
			}else{
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
			}else{
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

	public static void updateEventQueue(EnabledEvents enabledEventsBis, EnabledEvents enabledEvents, ArrayList<Event> eventQueue, double timestamp, EmergencyDepartment state) {
		ArrayList<EventsType> newlyEnabledEvents = new ArrayList<>();
		ArrayList<EventsType> newlyDesabledEvents = new ArrayList<>();
		
		for (EventsType ev : enabledEventsBis.list){
			if (!enabledEvents.list.contains(ev)){
				newlyEnabledEvents.add(ev);
			}
		}
		for (EventsType ev : enabledEvents.list){
			if (!enabledEventsBis.list.contains(ev)){
				newlyDesabledEvents.add(ev);
			}
		}
		
		ArrayList<Event> deleteEvent = new ArrayList<>();
		
		for (EventsType evt : newlyDesabledEvents){
			for (Event ev : eventQueue){
				if (ev.getType() == evt){
					deleteEvent.add(ev);
				}
			}
		}
		for (Event ev : deleteEvent){
			eventQueue.remove(ev);
		}
		
		
		
		for (EventsType evT : newlyEnabledEvents){
			
			Event e = null;
			
			if (evT == EventsType.ARRL1){ 
				e = new Arr_L1(state);
				
			}else if(evT == EventsType.ARRL2){ 
				e = new Arr_L2(state);
				
			}else if(evT == EventsType.ARRL4){ 
				e = new Arr_L4(state);
				
			}else if(evT == EventsType.ARRL3){ 
				e = new Arr_L3(state);
				
			}else if(evT == EventsType.ARRL5){ 
				e = new Arr_L5(state);
				
			}else if(evT == EventsType.REGISTNONURGENT){
				Patient patient = null;
				
				for (Patient pat : state.getListOfPatientsWaitingForTriage()){
					if ((pat.getSeverity() == SeverityLevel.L1 || pat.getSeverity() == SeverityLevel.L2 ||pat.getSeverity() == SeverityLevel.L3) && pat.getPatientState() == PatientState.WAITING){
						patient = pat;
						break;
					}
				}
				
				
				e = new Regist_NonUrgent(timestamp, state,(BoxRoom) state.returnFreeNonHumanResources(ResourcesType.BOXROOM), patient , (Nurse) state.returnFreeHumanResource(ResourcesType.NURSE));
			}else if(evT == EventsType.REGISTURGENT){
				Patient patient = null;
				
				for (Patient pat : state.getListOfPatientsWaitingForTriage()){
					if ((pat.getSeverity() == SeverityLevel.L4 || pat.getSeverity() == SeverityLevel.L5) && pat.getPatientState() == PatientState.WAITING){
						patient = pat;
						break;
					}
				}
				
				
				e = new Regist_Urgent(timestamp, state,(ShockRoom) state.returnFreeNonHumanResources(ResourcesType.SHOCKROOM), patient , (Nurse) state.returnFreeHumanResource(ResourcesType.NURSE));
			}else if(evT == EventsType.VISIT){
				
				Rooms room = null;
				
				if(state.getOccupiedRoom(ResourcesType.SHOCKROOM) != null){
					room = state.getOccupiedRoom(ResourcesType.SHOCKROOM);
				}else{
					room = state.getOccupiedRoom(ResourcesType.BOXROOM);
				}
				
				e = new Visit(timestamp, state, room, (Physician) state.returnFreeHumanResource(ResourcesType.PHYSICIAN), (ConsultationService) state.returnHealthService(ResourcesType.CONSULTATIONSERVICE));
				
			}else if(evT == EventsType.TRANSPORTATION){
				Patient patient = null;
				
				for (Patient pat : state.getListOfPatientWaitingForTransporation()){
					if ((pat.getSeverity() == SeverityLevel.L4 || pat.getSeverity() == SeverityLevel.L5 )&& pat.getPatientState() == PatientState.WAITING){
						patient = pat;
						break;
					}
				}
				if (patient == null){// SI on a pas trouvé de patient proritaire, on prend le un autre patient pas prioritaire
					for (Patient pat : state.getListOfPatientWaitingForTransporation()){
						if (pat.getPatientState() == PatientState.WAITING){
							patient = pat;
							break;
						}
					}
				}
				
				
				
				e = new Transportation(state, timestamp,(Transporter) state.returnFreeHumanResource(ResourcesType.TRANSPORTER),(Strecher) state.returnFreeNonHumanResources(ResourcesType.STRECHER), patient);
			
			}else if(evT == EventsType.MRI){
				
				Patient patient = null;
				
				for (Patient pat : state.getListOfPatientWaitingForExam()){
					if ((pat.getSeverity() == SeverityLevel.L4 || pat.getSeverity() == SeverityLevel.L5) && pat.getPatientState() == PatientState.WAITING && pat.nextstep == Output.MRI){
						patient = pat;
						break;
					}
				}
				if (patient == null){// SI on a pas trouvé de patient proritaire, on prend le un autre patient pas prioritaire
					for (Patient pat : state.getListOfPatientWaitingForExam()){
						if (pat.getPatientState() == PatientState.WAITING && pat.nextstep == Output.MRI){
							patient = pat;
							break;
						}
					}
				}
				
				
				e = new MRI(state, timestamp, (MRIservice) state.returnHealthService(ResourcesType.MRI), patient, (Physician) state.returnFreeHumanResource(ResourcesType.PHYSICIAN));
				
			}else if(evT == EventsType.BLOODTEST){
				
				Patient patient = null;
				
				for (Patient pat : state.getListOfPatientWaitingForExam()){
					if ((pat.getSeverity() == SeverityLevel.L4 || pat.getSeverity() == SeverityLevel.L5) && pat.getPatientState() == PatientState.WAITING && pat.nextstep == Output.BLOODTEST){
						patient = pat;
						break;
					}
				}
				if (patient == null){// SI on a pas trouvé de patient proritaire, on prend le un autre patient pas prioritaire
					for (Patient pat : state.getListOfPatientWaitingForExam()){
						if (pat.getPatientState() == PatientState.WAITING && pat.nextstep == Output.BLOODTEST){
							patient = pat;
							break;
						}
					}
				}
				
				
				e = new Bloodtest(state, timestamp, (BloodTestService) state.returnHealthService(ResourcesType.BLOODTEST), patient, (Physician) state.returnFreeHumanResource(ResourcesType.PHYSICIAN));
				
			}else if(evT == EventsType.XRAY){
				
				Patient patient = null;
				
				for (Patient pat : state.getListOfPatientWaitingForExam()){
					if ((pat.getSeverity() == SeverityLevel.L4 || pat.getSeverity() == SeverityLevel.L5) && pat.getPatientState() == PatientState.WAITING && pat.nextstep == Output.XRAY){
						patient = pat;
						break;
					}
				}
				if (patient == null){// SI on a pas trouvé de patient proritaire, on prend le un autre patient pas prioritaire
					for (Patient pat : state.getListOfPatientWaitingForExam()){
						if (pat.getPatientState() == PatientState.WAITING && pat.nextstep == Output.XRAY){
							patient = pat;
							break;
						}
					}
				}
				
				
				e = new XRAY(state, timestamp, (XrayService) state.returnHealthService(ResourcesType.XRAY), patient, (Physician) state.returnFreeHumanResource(ResourcesType.PHYSICIAN));
				
			}else if(evT == EventsType.SCAN){
				
				Patient patient = null;
				
				for (Patient pat : state.getListOfPatientWaitingForExam()){
					if ((pat.getSeverity() == SeverityLevel.L4 || pat.getSeverity() == SeverityLevel.L5) && pat.getPatientState() == PatientState.WAITING && pat.nextstep == Output.SCAN){
						patient = pat;
						break;
					}
				}
				if (patient == null){// SI on a pas trouvé de patient proritaire, on prend le un autre patient pas prioritaire
					for (Patient pat : state.getListOfPatientWaitingForExam()){
						if (pat.getPatientState() == PatientState.WAITING && pat.nextstep == Output.SCAN){
							patient = pat;
							break;
						}
					}
				}
				
				
				e = new SCAN(state, timestamp, (Scan) state.returnHealthService(ResourcesType.SCAN), patient, (Physician) state.returnFreeHumanResource(ResourcesType.PHYSICIAN));
				
			}else if(evT == EventsType.RADIOGRAPHY){
				
				Patient patient = null;
				
				for (Patient pat : state.getListOfPatientWaitingForExam()){
					if ((pat.getSeverity() == SeverityLevel.L4 || pat.getSeverity() == SeverityLevel.L5) && pat.getPatientState() == PatientState.WAITING && pat.nextstep == Output.RADIOGRAPHY){
						patient = pat;
						break;
					}
				}
				if (patient == null){// SI on a pas trouvé de patient proritaire, on prend le un autre patient pas prioritaire
					for (Patient pat : state.getListOfPatientWaitingForExam()){
						if (pat.getPatientState() == PatientState.WAITING && pat.nextstep == Output.RADIOGRAPHY){
							patient = pat;
							break;
						}
					}
				}
				
				
				e = new RADIOGRAPHY(state, timestamp, (Radiography) state.returnHealthService(ResourcesType.RADIOGRAPHY), patient, (Physician) state.returnFreeHumanResource(ResourcesType.PHYSICIAN));
				
			}
			
			if(e != null){
				state.addEventInEventQueue(e);
			}
			
			
			
		}
		
		
	}

	
	
	
	
	
	public void removeFirstEventOfType(EventsType type) {
		for (EventsType eventType : list) {
			if(eventType == type){
				list.remove(eventType);
				break;
			}
			
		}
	}

}
