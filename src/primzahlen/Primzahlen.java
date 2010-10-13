package primzahlen;

public class Primzahlen {

	public static void main(String[] args) {
		
		// 0 und 1 sind keine Primzahlen -> n = 2
		// Primzahlen bis 1000 -> max = 1000
		int n = 2, max = 1000;

		// Solange n kleiner/gleich maxx
		while ( n <= max ) {
			int i = 2;
			boolean p = true;
			// Für alle Vielfachen von i kleiner n gilt...
			while (i*i<=n) {
				// ...wenn n ein Vielfaches von i...
				if (n%i==0)	{
					// ...dann keine Primzahl...
					p = false;
					break;
				}
				// ...nächstes i
				i++;
			}	
			// Wenn n kein Vielfaches von i -> p == true...	
			if (p == true ) {
				// ...dann Ausgabe n als Primzahl...
				System.out.println(n);
			}
		// ...nächste Zahl prüfen	
		n++; 
		}
	}
}