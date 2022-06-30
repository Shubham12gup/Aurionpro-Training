package com.aurionpro.test;

import java.util.Scanner;

public class TicTacTest {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

	public static void main(String args[]) {
		boolean b[][] = { { false, false, false }, { false, false, false }, { false, false, false } };
		String a[][] = { { "11", "12", "13" }, { "21", "22", "23" }, { "31", "32", "33" } };
		displayGrid(a);
		boolean win = true;
		int turns = 1;

		while (win && turns <= 9) {
			Scanner sc = new Scanner(System.in);
			int row, col;
			String input;
			if (turns % 2 != 0) {
				turns++;
				System.out.print("Player X enter your move(ROW[1-3]-COLUMN[1-3]): ");
				String inputPosition[] = sc.nextLine().split("");
				row = Integer.parseInt(inputPosition[0])-1;
				col = Integer.parseInt(inputPosition[1])-1;
				input = " X";
			} else {
				turns++;
				System.out.print("Player O enter your move(ROW[1-3]-COLUMN[1-3]): ");
				String inputPosition[] = sc.nextLine().split("");
				row = Integer.parseInt(inputPosition[0])-1;
				col = Integer.parseInt(inputPosition[1])-1;
				input = " O";
			}

			boolean posValue = checkPositionIsFilled(b[row][col]);
			if (posValue == false) {
				assignValue(input, row, col, a, b);
				displayGrid(a);
				win = checkWin(a);
				if (win == false) {
					System.out.println(ANSI_GREEN_BACKGROUND + "CONGRATULATIONS!!! PLAYER" + input + " WINS" + ANSI_RESET);
					break;
				}
				if (turns == 10) {
					System.out.println(ANSI_GREEN_BACKGROUND + "Game Draw, Thankyou for playing" + ANSI_RESET);
					break;
				}

			} else {
				System.out.println(ANSI_RED_BACKGROUND + "OOPS!!! Position is already filled\n" + ANSI_RESET);
				turns--;
			}

		}

	}

	private static boolean checkPositionIsFilled(boolean b) {
		if (b == true)
			return true;
		return false;
	}

	private static void assignValue(String input, int row, int col, String a[][], boolean b[][]) {
		a[row][col] = input;
		b[row][col] = true;
	}

	private static boolean checkWin(String a[][]) {
		for (int i = 0; i < 3; i++) {
			String line = a[i][0] + a[i][1] + a[i][2];
			if (line.equals(" X X X") || line.equals(" O O O"))
				return false;
		}

		for (int i = 0; i < 3; i++) {
			String line = a[0][i] + a[1][i] + a[2][i];
			if (line.equals(" X X X") || line.equals(" O O O"))
				return false;
		}

		String line = a[2][0] + a[1][1] + a[0][2];
		if (line.equals(" X X X") || line.equals(" O O O"))
			return false;

		line = a[0][0] + a[1][1] + a[2][2];
		if (line.equals(" X X X") || line.equals(" O O O"))
			return false;
		return true;
	}

	private static void displayGrid(String a[][]) {
		System.out.println(" " + a[0][0] + " | " + a[0][1] + " | " + a[0][2] + " ");
		System.out.println("---------------");
		System.out.println(" " + a[1][0] + " | " + a[1][1] + " | " + a[1][2] + " ");
		System.out.println("---------------");
		System.out.println(" " + a[2][0] + " | " + a[2][1] + " | " + a[2][2] + " \n");

	}

}
