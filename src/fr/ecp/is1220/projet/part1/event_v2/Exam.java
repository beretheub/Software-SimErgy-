package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.noPatientinED;
import fr.ecp.is1220.projet.part1.Exceptions.noValidOutputException;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.Output;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Physician;

public abstract class Exam extends Event {

	/**
	 * Les différents examens disponibles : Bloodtest, MRI, XRAY 
	 */	
	private HealthServices exam; 
	private Patient p1;
	private Physician physician;
	private Output output;
	
	public HealthServices getExam() {
		return exam;
	}

	public void setExam(HealthServices exam) {
		this.exam = exam;
	}

	public Patient getPatient() {
		return p1;
	}

	public void setPatient(Patient p1) {
		this.p1 = p1;
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public Output getOutput() {
		return output;
	}

	public void setOutput(Output output) {
		this.output = output;
	}

	public Exam(int timeStamp, EmergencyDepartment ed, HealthServices room, Patient p1, Physician phys) {
		super(timeStamp, ed);
		this.exam=room;
		this.physician=phys;
		this.p1=p1;
		
		

		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() throws noPatientinED {
		// TODO Auto-generated method stub

	}
	
	protected Output calculoutput() {
		double random = Math.random();
		if (random <= 0.35){
			return Output.RELEASE;
		}else if (random <= 0.7){
			return Output.CONSULTATION;
		}else{
			return Output.HOSPITAL;
		}
	}
	
	/**
	 * Puts the patient in the next waiting queue according to the output of the exam
	 * WARNING : the output of the test must have been calculated before
	 * If the patient does not have a valid Output throws exception 
	 * @param patient
	 */
	protected static void directPatient(Patient patient) throws noValidOutputException {
		if(patient.nextstep == Output.CONSULTATION){
			patient.getPatientEd().addPatientWaitingForTriage(patient);
		}else if(patient.nextstep == Output.HOSPITAL || patient.nextstep == Output.RELEASE ){
			patient.getPatientEd().patientOutOfEmergencyDepartment(patient);
		}
		else{
			throw new noValidOutputException();
		}
	}

}
