package fr.ecp.is1220.projet.part1.event_v2;

public class Arr_L2 extends Arr {
	
	public Arr_L2() {
		super(Arr_L2.getNextPatientTimeStamp(lastArr));
		lastArr = this.timeStamp;
		
		
	}

	private static int getNextPatientTimeStamp(int lastArr2) {
		return lastArr2 + 6; // Il faudra utiliser la loi de proba pour déterminer le temps d'arrivée du prochain patient
	}
	@Override
	public void execute() {
		

	}

}
