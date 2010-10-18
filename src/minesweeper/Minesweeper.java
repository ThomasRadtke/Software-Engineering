package minesweeper;

public class Minesweeper {

	public static void main(String[] args) {
		
		int m = 4, n = 4;
		String[][] Feld = new String[n][m];
		// Hinweis- und Minen-Array größer als Feld-Array
		// Zur Bestimmunge der Nachbarn via For-Schleife
		int[][] Hint = new int[n + 2][m + 2];
		Boolean[][] Mine = new Boolean[n + 2][m + 2];

		// Alle möglichen Minenfelder false setzen
		for (int i = 0; i < Mine.length; i++) {
			for (int j = 0; j < Mine[0].length; j++) {
				Mine[i][j] = false;
			}
		}

		Feld[0][0] = "*";
		Feld[0][1] = ".";
		Feld[0][2] = ".";
		Feld[0][3] = ".";
		Feld[1][0] = ".";
		Feld[1][1] = ".";
		Feld[1][2] = ".";
		Feld[1][3] = ".";
		Feld[2][0] = ".";
		Feld[2][1] = "*";
		Feld[2][2] = ".";
		Feld[2][3] = ".";
		Feld[3][0] = ".";
		Feld[3][1] = ".";
		Feld[3][2] = ".";
		Feld[3][3] = ".";

		// Alle Felder mit Mine - True setzen
		// i & j = 1 da Hinweis- & Minen-Array groeßer als Feld-Array
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (Feld[i - 1][j - 1] == "*") {
					Mine[i][j] = true;
				}
			}
		}
		// Bestimmung der Hinweiswerte je Nachbarfeld von Mine	
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// Feldnachbarn bestimmen
				for (int k = i - 1; k <= i + 1; k++) {
					for (int l = j - 1; l <= j + 1; l++) {
						// Wenn auf umliegenden Feld Mine dann +1
						if (Mine[k][l]) {
							Hint[i][j]++;
						}
					}
				}
			}
		}

		// Ausgabe des Hinweisfeldes...
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// ...wenn Mine dann "x"...
				if (Mine[i][j]) {
					System.out.print("x");
				} 
				// ... sonst Wert des Feldes
				else {
					System.out.print(Hint[i][j]);
				}
			}
			// Leerzeile für neue Zeile
			System.out.println();
		}
	}
}	