package fr.ecp.is1220.projet.part1.event;

import java.io.*;

import fr.ecp.is1220.projet.part1.core.Patient;

public class Leaving extends Event {

	
	@Override
	public String toString() {
		return "Départ à " + startevent; 
	}
	
	public String printrecord(Patient patient) throws IOException {
		String fileName = "Fiche_"+patient.getName();
		String returnValue = "";
		File file = null;
		FileInputStream fis = null;
		try { 
			file = new File(fileName);
			fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			String str = new String(data, "UTF-8");
			}	
		catch (FileNotFoundException e) { 
			e.printStackTrace();
			} 
		finally { 
			if (fis != null) { 
				try { fis.close();} 
				catch (IOException e) {// Ignore issues
				}		
				if (file != null) { 
					try { file.close();}
					catch (IOException e) { // Ignore issues during closing
					}
				} 
		return returnValue;
			}
		}
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
