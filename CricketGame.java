package com.aurionpro.test;

import java.util.*;

public class CricketGame {

	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

	public static void main(String[] args) {

		System.out.println("Welcome to Book Cricket Game!!!");
		System.out.println("Rules for the game: ");
		System.out.println("**Assume a book of 300 pages");
		System.out.println("1. Player1 opens the book to read a page number(example 87)()Randomly Generated");
		System.out.println("2. If the page number is 87->(87%7) (%7 results in score between 0-6) = 3 should be added to the score");
		System.out.println("3. Player1 continues and keeps adding to the score until page number results in a 0 score");
		System.out.println("4. Player2 starts the game and tries to beat the score of player1");
		System.out.println("5. In case of a tie, check the number of turns(player with less number of turns winner)");
		System.out.println("6. Show the winner of the game\n");

		System.out.print("Enter 1 to start the game and 0 for exit : ");

		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		if (start == 1) {
			System.out.print("Enter Player 1 Name : ");
			String player1 = sc.next();

			System.out.print("Enter Player 2 Name : ");
			String player2 = sc.next();

			System.out.println("Player : " + player1);

			int point = 1, score1 = 0, turns = 1;
			while (point != 0) {
				System.out.print("Enter 1 to Open Book : ");
				int open = sc.nextInt();

				Random random = new Random();
				int number = random.nextInt(301);
				point = number % 7;
				if (point != 0) {
					turns += 1;
					score1 += point;
					System.out.println("Page Number : " + number + "\t Point : " + point + "\t Score : " + score1);
				} else {
					System.out.println("Page Number : " + number + "\t Point : " + point + "\t Score : " + score1);
					System.out.println(ANSI_RED_BACKGROUND + "!!!\t\t OOPS \t\t !!!" + ANSI_RESET);
					System.out.println(player1 + " Total Score : " + score1);
					System.out.println(player1 + " Takes " + turns + " Rounds");
				}

			}

			System.out.println(player2 + " needs " + (score1 + 1) + " score in " + turns + " rounds to win match.\n");
			System.out.println("Player : " + player2);

			int score2 = 0;
			while (turns > 0) {
				point = 1;
				System.out.print("Enter 1 to Open Book : ");
				int open = sc.nextInt();

				Random random = new Random();
				int number = random.nextInt(301);
				point = number % 7;
				if (point != 0) {
					// turns += 1;
					score2 += point;
					System.out.println("Page Number : " + number + "\t Point : " + point + "\t Score : " + score2
							+ "\t Rounds Left : " + (turns - 1));

					if (score2 > score1) {
						System.out.println("\n" + ANSI_GREEN_BACKGROUND + player2 + " Win Match !!!" + ANSI_RESET);
						break;
					}
					if (turns == 0 && score2 < score1) {
						System.out.println("\n" + ANSI_GREEN_BACKGROUND + player1 + " Win Match !!!" + ANSI_RESET);
					}
					if (turns == 0 && score2 == score1) {
						System.out.println("\n" + ANSI_GREEN_BACKGROUND + " Match Ties !!!" + ANSI_RESET);
						break;
					}
					turns--;
				} else {
					System.out.println("Page Number : " + number + "\t Point : " + point + "\t Score : " + score2
							+ "\t Rounds Left : " + (turns - 1));
					System.out.println(ANSI_RED_BACKGROUND + "!!!\t\t OOPS \t\t !!!" + ANSI_RESET);
					System.out.println("\n" + ANSI_GREEN_BACKGROUND + player1 + " Win Match !!!" + ANSI_RESET);
					break;
				}

			}

		}

	}

}
