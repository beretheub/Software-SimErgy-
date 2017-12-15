package fr.ecp.is1220.projet.part2.simulationTest;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import lineUI.ui;

public class uiTest {

	public static void main(String[] args) {
		
		ArrayList<String> ar = new ArrayList<>();
		
		try {
			ar = ui.readScenarioFile("test.txt");
		} catch (FileNotFoundException e) {
			System.out.println("oups");
		}
		for(String str : ar){
			System.out.println(str);
		}

	}

}
