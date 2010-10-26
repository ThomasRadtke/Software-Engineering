package minesweeper;

import java.util.*;

/*
 * Kata Minesweeper PreFinal-Version				22.10.2010
 */

public class Minesweeper {

	public static int n, m;
	public static char[][] Court;
	public static int[][] Result;
	public static String[] Game;
	public static boolean run;

	public static void main(String[] args) throws Exception {

		System.out.println("###       MineSweeper       ###");
		System.out.println("*** max. 100 Zeilen/Spalten ***");
		System.out.println("_______________________________");
		Startgame();
		System.out.println("###############################");
	}

	public static void Startgame() throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Bitte Anzahl der Zeilen eingeben: ");
		int rows = scanner.nextInt();
		while (rows <= 0 || rows > 100) {
			System.out.print("Bitte korrekte Anzahl der Zeilen eingeben: ");
			rows = scanner.nextInt();
		}
		System.out.print("Bitte Anzahl der Spalten eingeben: ");
		int columns = scanner.nextInt();
		while (columns <= 0 || columns > 100) {
			System.out.print("Bitte korrekte Anzahl der Spalten eingeben: ");
			columns = scanner.nextInt();
		}
		
		Game = new String[rows];
		Court = new char[rows][columns];
		for (int i = 0; i < rows; i++) {
			Game[i] = scanner.next();
			if (Game[i].length() != columns) {
				System.out.println("***Fehler bei der Eingabe***");
				System.exit(1);
			}
			if (!Game[i].matches("[*.]+")) {
				System.out.println("***Fehler bei der Eingabe***");
				System.exit(1);
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Court[i][j] = Game[i].charAt(j);
			}
		}

		Result = SolveField(Court, rows, columns);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Output(Result, Court, rows, columns);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public static void Output(int[][] Result, char[][] Court, int rows,
			int columns) {

		// Ausgabe des Spielfeldes
		System.out.println("*** Eingabe: ");
		for (int i = 0; i < rows; i++) {
			String placeholder = "    ";
			for (int j = 0; j < columns; j++) {
				placeholder += Court[i][j];
			}
			System.out.println(placeholder);
		}

		// Ausgabe des Hinweisfeldes...
		System.out.println("*** Hinweise:");
		for (int i = 0; i < rows; i++) {
			String placeholder = "    ";
			for (int j = 0; j < columns; j++) {
				// ...wenn Mine dann "x"...
				if (Court[i][j] == '*') {
					placeholder += "x";
				}
				// ... sonst Wert des Feldes
				else {
					placeholder += Result[i][j];
				}
			}
			System.out.println(placeholder);
		}
	}

	public static int[][] SolveField(char[][] Court, int rows, int columns)
			throws Exception {

		n = rows - 1;
		m = columns - 1;
		int[][] Indicator = new int[rows][columns];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (Court[i][j] == '*') {
					if (i > 0) {
						Indicator[i - 1][j]++;
						if (j > 0) {
							Indicator[i - 1][j - 1]++;
						}
						if (j < m) {
							Indicator[i - 1][j + 1]++;
						}
					}
					if (i < n) {
						Indicator[i + 1][j]++;
						if (j > 0) {
							Indicator[i + 1][j - 1]++;
						}
						if (j < m) {
							Indicator[i + 1][j + 1]++;
						}
					}
					if (j > 0) {
						Indicator[i][j - 1]++;
					}
					if (j < m) {
						Indicator[i][j + 1]++;
					}
				}
			}
		}
		return Indicator;
	}
}