package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.noValidOutputException;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.Output;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.PhysicianState;

public abstract class Exam extends Event {

	/**
	 * Les différents examens disponibles : Bloodtest, MRI, XRAY 
	 */	
	private HealthServices exam; 
	private Patient p1;
	private Physician physician;
	private Output output;
	public double duree;
	
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

	public Exam(int timeStamp, EmergencyDepartment ed, HealthServices room, Patient p1, Physician phys, Double duree) {
		super(timeStamp, ed);
		this.exam=room;
		this.physician=phys;
		this.p1=p1;
		this.duree = duree;
		
		

		// TODO Auto-generated constructor stub
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
	
	public void execute() {
		
		this.getExam().newPatient(this.getPatient());
		
		// On s'occupe d'abord de la temporatité
		this.getPhysician().setState(PhysicianState.VISITING);
		this.getPatient().setPatientState(PatientState.TAKINGEXAM);
		EndEvent e = new EndEvent((int)(this.timeStamp + duree), this.ed, this.getPatient()); 
		this.ed.addEventInEventQueue(e);
		FreePhysician e2 = new FreePhysician((int)(this.timeStamp + duree), this.ed, this.getPhysician()); // Médecin occupé pendant le temps de la consultation puis libéré de la meme manière que les patients
		this.ed.addEventInEventQueue(e2);
		
		// On effectue le test
		this.setOutput(this.calculoutput());
		this.getPatient().fillRecord(Integer.toString(this.getPatient().getPatientRecord().size()) + " - " + Integer.toString(this.getPatient().getId()) + " - Actually in examroom "+ getExam().getName() + " : " + getExam().getId() + " - Taking exam with " + Integer.toString(this.getPhysician().getId()) + " at " + Double.toString(this.timeStamp) + " - Bilan : " + getOutput() );
		this.getExam().notifyObservers();
		
		//On met à jour les données du patient
		this.getPatient().setNexstep(this.getOutput());
		this.getPatient().addcharges(getExam().getCost());
		
		//On envoie le patient dans la file d'attente suivante
		try {
			Exam.directPatient(this.getPatient());
		} catch (noValidOutputException e1) {
			// si on récupère l'excpation on replace le patient dans patientWaitingForExam
			System.out.println(Integer.toString(this.getPatient().getId()) + "Exam didn't worout well, trying again");
			this.ed.addPatientWaitingForExam(this.getPatient());
		}
		
	}
}
