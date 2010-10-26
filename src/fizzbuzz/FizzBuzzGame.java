package fizzbuzz;

import java.util.*;
import javax.swing.*;

public class FizzBuzzGame {
	public static int n, counter = 1;
	public static String Input;
	public static boolean FalseInput;
	
	public static void main(String[] args) {
		
		System.out.println("############################");
		System.out.println("###     FizzBuzzGame     ###");
		System.out.println("############################");
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Bitte Anzahl der Level wählen (1 bis ~): ");
		Input = scanner.next();
		
		if (!Input.matches("[0-9]+") || Integer.parseInt(Input) < 1 ) {
			do {
				System.out.print("Bitte Eingabe korrigieren: ");
				Input = scanner.next();
					
			} while (!Input.matches("[0-9]+") || Integer.parseInt(Input) < 1); 
		}
		
		n = Integer.parseInt(Input); 
		System.out.println();
		System.out.println("###      Los geht's!      #");
		System.out.println();
		
		for (int i = 1; i <= n; i++) {
			
			//String UserInput = JOptionPane.showInputDialog(null, i+" - Fizz - Buzz - FizzBuzz", "Bitte ihre Lösung auswählen", JOptionPane.QUESTION_MESSAGE);
			String UserInput = JOptionPane.showInputDialog(null, "Next?", "Bitte ihre Lösung auswählen", JOptionPane.QUESTION_MESSAGE);
			if (UserInput.equals(Result(i))) {
				JOptionPane.showMessageDialog(null,"Richtig!","Die Antwort war korrekt",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null,"Level #"+i,"Leider verloren!",JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null,"Level #"+i,"Korrekte Antwort lautete:"+Result(i),JOptionPane.INFORMATION_MESSAGE);
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
