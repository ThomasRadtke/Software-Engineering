package minesweeper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

/*
 * Kata Minesweeper PreFinal-Version				22.10.2010
 */

public class Minesweeper {

	// Oft verwendete Variablen deklarieren
	public static int n, m;
	public static String[][] Court;
	public static ArrayList<String> GameList;
	public static String InputRow;

	public static void main(String[] args) throws Exception {
		// Zähler für Anzahl der Spiele...
		int Counter = 0;
		// .txt-Datei einlesen
		LineNumberReader GameCourt = new LineNumberReader(new FileReader(
				"Input.txt"));
		// Alle Zeilen der Datei einlesen
		while ((InputRow = GameCourt.readLine()) != null) {
			// Wenn Zeile mit Ziffer beginnt...
			if (Character.isDigit(InputRow.charAt(0))) {
				// Zähler erhöhen...
				Counter++;
				// Spiel Überschrift setzen...
				System.out.println("*** Field#" + Counter);
				System.out.println();
				/* Zeile in welcher das Spiel beginnt an...
				 * Methode SolveField() übergeben
				 */
				SolveField(GameCourt.getLineNumber());
			}
		}
	}

	public static void SolveField(int FieldPosition) throws Exception {

		// Ausgangsdatei öffnen...
		BufferedReader GameCourt = new BufferedReader(new FileReader(
				"Input.txt"));
		// Zeilen anderer Spiele überspringen...
		for (int i = 1; i < FieldPosition; i++) {
			InputRow = GameCourt.readLine();
		}
		// Spieldaten einlesen...
		InputRow = GameCourt.readLine();
		// Anzahl Spalten / Zeilen auslesen...
		//String Rows = InputRow.substring(0, 1);
		//String Columns = InputRow.substring(2, 3);
		String[] FieldSize = InputRow.split(" ");
		String Rows = FieldSize[0].trim();
		String Columns = FieldSize[1].trim();
		n = Integer.valueOf(Rows).intValue();
		m = Integer.valueOf(Columns).intValue();

		// falls Spielfeld leer - Abbruch, nächstes Spielfeld...
		if (n == 0 || m == 0) {
			System.out.println();
		} else {
			// Zeilen des Spiels einlesen, in Liste speichern...	
			GameList = new ArrayList<String>();
			while ((InputRow = GameCourt.readLine()) != null) {
				GameList.add(InputRow);
			}

			GameCourt.close();
			// Spielfeld als Array setzen, Zeilen & Spalten = n & m
			String[][] Court = new String[n][m];

			// Spielfeld mit Daten aus der Liste befüllen...
			for (int i = 0; i < n; i++) {
				for (int j = 0, k = 1; j < m; j++, k++) {
					Court[i][j] = GameList.get(i).substring(j, k);
				}
			}

			// Hinweis- und Minen-Array größer als Spielfeld-Array
			// Zur Bestimmung der Nachbarn via For-Schleife
			int[][] Indicator = new int[n + 2][m + 2];
			// Alle möglichen Minenfelder false setzen
			Boolean[][] MineField = new Boolean[n + 2][m + 2];
			for (int i = 0; i < MineField.length; i++) {
				for (int j = 0; j < MineField[0].length; j++) {
					MineField[i][j] = false;
				}
			}

			// Alle Felder mit Mine - True setzen
			// i & j = 1 da Hinweis- & Minen-Array größer als Feld-Array
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (Court[i - 1][j - 1].equals("*")) {
						MineField[i][j] = true;
					}
				}
			}
			
			// Bestimmung der Hinweiswerte je Nachbarfeld...
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					// Feldnachbarn bestimmen...
					for (int k = i - 1; k <= i + 1; k++) {
						for (int l = j - 1; l <= j + 1; l++) {
							// Wenn auf umliegenden Feld Mine dann +1
							if (MineField[k][l]) {
								Indicator[i][j]++;
							}
						}
					}
				}
			}
			// Ausgabe des Spielfeldes
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(Court[i][j]);
				}
				// Leerzeile für neue Zeile
				System.out.println();
			}

			// Ausgabe des Hinweisfeldes...
			System.out.println();
			System.out.println("*** Hinweise:");
			System.out.println();
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					// ...wenn Mine dann "x"...
					if (MineField[i][j]) {
						System.out.print("x");
					}
					// ... sonst Wert des Feldes
					else {
						System.out.print(Indicator[i][j]);
					}
				}
				// Leerzeile für neue Zeile
				System.out.println();
			}
			// Füllzeile für neues Spiel
			System.out.println("------------------");
		}
	}
}