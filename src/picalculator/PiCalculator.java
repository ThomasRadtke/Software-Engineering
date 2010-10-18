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
				fact -= (i/j);
			}
			else {			
				fact += (i/j);
			}
			// Näherungswert ermitteln
			pi = Math.round(konst * fact * calc) / calc;
			
			// Wenn Näherungswert gleich vorherigem Durchlauf
			if (pi == pruef) {
				//Kalkulierten Wert ausgeben, Schleife abbrechen
				System.out.println("Auf fünf Stellen kalkuliert lautet Pi: " +pi);
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