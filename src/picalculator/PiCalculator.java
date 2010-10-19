package picalculator;

import java.lang.Math;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PiCalculator {

	public static void main(String[] args) {

		JTextField Stellen = new JTextField();
		
		Object[] Message = {"Anzahl Nachkommastellen: ", Stellen};
		
		JOptionPane pane = new JOptionPane( Message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
		pane.createDialog(null,"Genauigkeit wählen").setVisible(true);
		
		String choice = Stellen.getText();
		
		int Precision = Integer.valueOf(choice).intValue();
		
		getPi(Precision);
	}
	
	public static void getPi(int Precision) {
		
		int Counter = 2, i = 1, Converter = 1;
		double Pi, PiCheck = 4, Startwert = 4, Factor = 1, j = 3, CalculatePi = Math.pow(10, Precision);
		boolean PiCalculated = false;
		
		while (!PiCalculated) {
			Converter *= -1;			
			Factor += (i/j) * Converter;
			
			// Näherungswert ermitteln
			Pi = Math.round(Startwert * Factor * CalculatePi) / CalculatePi;
			
			// Wenn Näherungswert gleich vorherigem Durchlauf
			if (Pi == PiCheck) {
				//Kalkulierten Wert ausgeben, Schleife abbrechen
				JOptionPane.showMessageDialog(null,"Auf "+Precision+" Stellen kalkuliert lautet Pi: "+Pi,"Ergebnis",JOptionPane.INFORMATION_MESSAGE);
				PiCalculated = true;
			}
			else {
				PiCheck = Pi;
				Counter++;
				j += 2;
			}
		}
	}		
}