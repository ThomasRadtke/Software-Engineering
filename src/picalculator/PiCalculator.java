package picalculator;

import java.lang.Math;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PiCalculator {

	public static void main(String[] args) {

		JTextField stellen = new JTextField();
		
		Object[] message = {"Anzahl Nachkommastellen: ", stellen};
		
		JOptionPane pane = new JOptionPane( message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
		pane.createDialog(null,"Genauigkeit wählen").setVisible(true);
		
		String choice = stellen.getText();
		
		int choice_stellen = Integer.valueOf(choice).intValue();
		
		getPi(choice_stellen);
	}
	
	public static void getPi(int choice_stellen) {
		
		int counter = 2, i = 1, precision = choice_stellen, converter = 1;
		double pi, pruef_pi = 4, startwert = 4, factor = 1, j = 3, calculate_pi = Math.pow(10, precision);
		boolean ready = false;
		
		while (!ready) {
			converter *= -1;			
			factor += (i/j) * converter;
			
			// Näherungswert ermitteln
			pi = Math.round(startwert * factor * calculate_pi) / calculate_pi;
			
			// Wenn Näherungswert gleich vorherigem Durchlauf
			if (pi == pruef_pi) {
				//Kalkulierten Wert ausgeben, Schleife abbrechen
				JOptionPane.showMessageDialog(null,"Auf "+precision+" Stellen kalkuliert lautet Pi: "+pi,"Ergebnis",JOptionPane.INFORMATION_MESSAGE);
				ready = true;
			}
			else {
				pruef_pi = pi;
				counter++;
				j += 2;
			}
		}
	}		
}