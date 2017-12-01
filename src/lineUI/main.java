package lineUI;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
	
		System.out.println("-----  Welcome to SimErgy -------");
		String query = "";	

		while (!query.equalsIgnoreCase("exit")){
			System.out.println("Please enter yout request (you can try help or exit) :");
			Scanner sc = new Scanner(System.in);
			System.out.print("$ ");
			query = sc.nextLine();

		}
		
	}
	

}
