package fizzbuzz;

//import java.util.*;
import javax.swing.*;

public class FizzBuzzGame {
	public static int n, counter = 1;
	public static String Input;
	public static boolean FalseInput;
	
	public static void main(String[] args) {
		
		//System.out.println("############################");
		//System.out.println("###     FizzBuzzGame     ###");
		//System.out.println("############################");
		//System.out.println();
		//Scanner scanner = new Scanner(System.in);
		//System.out.print("Bitte Anzahl der Level wählen (1 bis ~): ");
		//Input = scanner.next();
		
		String [] Level = {"Leicht (25)", "Normal (100)", "Schwer (250)"};
		int Choice = JOptionPane.showOptionDialog(null
													, "Bitte Schwierigkeitsgrad wählen"
													, "FizzBuzzGame"
													, JOptionPane.OK_CANCEL_OPTION 
													, JOptionPane.PLAIN_MESSAGE 
													, null
													, Level 
													, Level[0]);
		
		if (Choice == -1) {
			JOptionPane.showMessageDialog(null,"Vielen Dank fürs Spielen!","FizzBuzzGame",JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		
		if (Choice == 1) {
			n = 25;
		}
		if (Choice == 2) {
			n = 100;
		}
		if (Choice == 3) {
			n = 250;
		}
		
		//if (!Input.matches("[0-9]+") || Integer.parseInt(Input) < 1 ) {
		//	do {
		//		System.out.print("Bitte Eingabe korrigieren: ");
		//		Input = scanner.next();
					
		//	} while (!Input.matches("[0-9]+") || Integer.parseInt(Input) < 1); 
		//}
		
		// n = Integer.parseInt(Input); 
		
		JOptionPane.showMessageDialog(null,"Los geht's!","FizzBuzzGame",JOptionPane.INFORMATION_MESSAGE);
				
		for (int i = 1; i <= n; i++) {
			
			String LevelCode = String.valueOf(i); 
			String [] Choices = {LevelCode, "Fizz", "Buzz", "FizzBuzz"};
			int Response = JOptionPane.showOptionDialog(null
														, "Next?"
														, "Bitte auswählen"
														, JOptionPane.OK_CANCEL_OPTION 
														, JOptionPane.PLAIN_MESSAGE 
														, null
														, Choices 
														, Choices[0]);
			
			if (Response == -1) {
				JOptionPane.showMessageDialog(null,"Vielen Dank fürs Spielen!","FizzBuzzGame",JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			
			String UserInput = Choices[Response];
			
			if (!UserInput.equals(Result(i))) {
				JOptionPane.showMessageDialog(null,"Leider verloren!","Level #"+i,JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null,"Korrekte Antwort lautete: "+Result(i),"Level #"+i,JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		}
	} 
	
	public static String Result (int number) {
		
		String n = "";
		if (number % 3 == 0) {
			n += "Fizz";
		}
		if (number % 5 == 0) {
			n += "Buzz";
		}
		if (n.equals("")) {
			n = String.valueOf(number);
		}
		return n;	
	}
}
