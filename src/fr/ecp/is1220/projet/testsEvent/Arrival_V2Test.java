package fr.ecp.is1220.projet.testsEvent;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterNormException;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L1;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L2;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L5;


public class Arrival_V2Test {

	public static void main(String[] args) {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Bracieux");
		
		
		
		Arr_L1 ev1 = new Arr_L1(ed1);
		System.out.println(ev1.timeStamp);
		
		
		
		Arr_L1 ev4;
		ev4 = new Arr_L1(ed1);
		System.out.println(ev4.timeStamp);
		
		
		
		Arr_L2 ev2;
		ev2 = new Arr_L2(ed1);
		System.out.println(ev2.timeStamp);
		
		Arr_L5 ev3;

		ev3 = new Arr_L5(ed1);
		System.out.println(ev3.timeStamp);
		
 		ev1.execute();
 		ev2.execute();
 		ev3.execute();
 		ev4.execute();
 		

	}

}
