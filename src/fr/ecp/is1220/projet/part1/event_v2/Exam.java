package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.OutputConsultation;
import fr.ecp.is1220.projet.part1.core.OutputTest;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Physician;

public abstract class Exam extends Event {

	public HealthServices exam; 
	public Patient p1;
	public Physician physician;
	public OutputTest output;
	
	public Exam(int timeStamp, EmergencyDepartment ed, HealthServices room, Patient p1, Physician phys) {
		super(timeStamp, ed);
		this.exam=room;
		this.physician=phys;
		this.p1=p1;
		this.output=calculoutput();
		

		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}
	private OutputTest calculoutput() {
		double random = Math.random();
		if (random <= 0.35){
			output = OutputTest.RELEASE;
		}else if (random <= 0.7){
			output = OutputTest.CONSULTATION;
		}else{
			output = OutputTest.HOSPITAL;
		}
		return output;
	}

}
