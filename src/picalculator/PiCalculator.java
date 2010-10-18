package picalculator;

import java.lang.Math;

public class PiCalculator {

	public static void main(String[] args) {

		double pi, pruef = 4, konst = 4, fact = 1, j = 3, calc = Math.pow(10, 5);
		int count = 0, i = 1;
		boolean ready = false;
		
		while (!ready) {
			// Jeder zweite Durchlauf Faktor addieren
			if( count % 2 == 0) {
				calc -= (i/j);
			}
			else {			
				calc += (i/j);
			}
			// N�herungswert ermitteln
			pi = Math.round(konst * calc * rund) / rund;
			
			// Wenn N�herungswert gleich vorherigem Durchlauf
			if (pi == pruef) {
				//Kalkulierten Wert ausgeben, Schleife abbrechen
				System.out.println("Auf f�nf Stellen kalkuliert lautet Pi: " +pi);
				ready = true;
			}
			else {
				pruef = pi;
				count++;
				j += 2;
			}
		}
	}		
}