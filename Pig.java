package com.aurionpro.test;

import java.util.Random;
import java.util.Scanner;


public class PigDiceMultiplePlayer {
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Player1 Name: ");
		String player1 = sc.next();
		
		System.out.print("Enter Player2 Name: ");
		String player2 = sc.next();
		
		System.out.println("\nPlayer " +player1);
		int player1Turns = playGame(player1);
		
		System.out.println("\nPlayer " +player2);
		int player2Turns = playGame(player2);
		
		if(player1Turns == player2Turns){
			System.out.println(" Match DRAW!!! ");
		}
		else if(player1Turns < player2Turns) {
			System.out.println("🎉🎉🎉    " +player1+ " WINS 🎉🎉🎉");
		}
		else {
			System.out.println("🎉🎉🎉    " +player2+ " WINS 🎉🎉🎉");
		}
		System.out.println("\n!!! Game Over !!! ");
		
		sc.close();
	}

	private static int playGame(String player) {
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
						System.out.println(ANSI_GREEN_BACKGROUND + player + " finished in " + turns + " turns.\n" + ANSI_RESET);
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
					System.out.println(ANSI_GREEN_BACKGROUND + player + " finished in " + turns + " turns.\n" + ANSI_RESET);
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
		return turns;
	}
}
