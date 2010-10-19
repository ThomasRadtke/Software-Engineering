package minesweeper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Minesweeper {

	public static void main(String[] args) throws Exception{
		
		int n,m;
		String FeldInput;
		BufferedReader spielfeld = new  BufferedReader ( new FileReader("Input.txt"));
		String zeile = spielfeld.readLine();
		String rows = zeile.substring(0,1);
		String cols = zeile.substring(2,3);
		n = Integer.valueOf(rows).intValue();
		m = Integer.valueOf(cols).intValue();
		ArrayList<String> list = new ArrayList<String>();
		while ((FeldInput = spielfeld.readLine()) != null) {
			list.add(FeldInput);
		}
		
		spielfeld.close();
		String[][] Court = new String[n][m];
		
		for (int i = 0; i < n ; i++) {
			for (int j = 0, k = 1; j < m ; j++, k++) {
			Court[i][j] = list.get(i).substring(j,k);
			}
		}		
		
		// Hinweis- und Minen-Array größer als Feld-Array
		// Zur Bestimmunge der Nachbarn via For-Schleife
		int[][] Hint = new int[n + 2][m + 2];
		// Alle möglichen Minenfelder false setzen
		Boolean[][] Mine = new Boolean[n + 2][m + 2];
		for (int i = 0; i < Mine.length; i++) {
			for (int j = 0; j < Mine[0].length; j++) {
				Mine[i][j] = false;
			}
		}
		
		// Alle Felder mit Mine - True setzen
		// i & j = 1 da Hinweis- & Minen-Array groeßer als Feld-Array
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (Court[i - 1][j - 1].equals("*")) {
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
		System.out.println("Field#1");
		// Ausgabe des Ausgansfeldes
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(Court[i][j]);
			}
			// Leerzeile für neue Zeile
			System.out.println();
		}		
		
		System.out.println();
		System.out.println("Lösung Field#1");
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