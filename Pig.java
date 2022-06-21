package com.aurionpro.test;

import java.util.*;

public class Pig {

	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

	public static void main(String[] args) {
		System.out.println("PIG DICE GAME");
		System.out.println("* See how many turns it takes you to get to 20");
		System.out.println("* Turn ends when you hold or roll a 1");
		System.out.println("* If you roll a 1, you lose all points for the turn");
		System.out.println("* If you hold, you save all points for the turn\n");

		int score = 0, turns = 1, turnScore = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println(ANSI_RED_BACKGROUND + "TURN " + turns + ANSI_RESET);

		while (score < 20) {
			System.out.print("Roll or hold? (r/h): ");
			String status = sc.next();
			char s = status.charAt(0);
			int newScore = 0;

			if (s == 'r') {
				Random random = new Random();
				int die = 1 + random.nextInt(6);
				if (die != 1) {
					System.out.println("Die: " + die);

					turnScore = turnScore + die;
					newScore = score + turnScore;
					if (turnScore >= 20 || newScore >= 20) {
						if (newScore >= 20) {
							System.out.println("Total score: " + newScore + "\n");
						} else {
							System.out.println("Total score: " + turnScore + "\n");
						}
						System.out.println(ANSI_GREEN_BACKGROUND + "You finished in " + turns + " turns!\n" + ANSI_RESET);
						System.out.println("Game Over!");
						break;
					}
				} else {
					turnScore = 0;
					System.out.println("Die: " + die);
					System.out.println("Turn Over, No Score.\n");
					turns++;
					System.out.println(ANSI_RED_BACKGROUND + "TURN " + turns + ANSI_RESET);
				}

			} else if (s == 'h') {
				score = score + turnScore;
				if (score >= 20) {
					System.out.println("Total score: " + score + "\n");
					System.out.println(ANSI_GREEN_BACKGROUND + "You finished in " + turns + " turns!\n" + ANSI_RESET);
					System.out.println("Game Over!");
					break;
				} else {
					System.out.println("Score for turn " + turns + ": " + turnScore);
					System.out.println("Total Score: " + score + "\n");
					turns++;
					System.out.println(ANSI_RED_BACKGROUND + "TURN " + turns + ANSI_RESET);
					turnScore = 0;
				}
			}

			else {
				System.out.println("Enter r or h only");
			}

		}
		sc.close();
	}

}
