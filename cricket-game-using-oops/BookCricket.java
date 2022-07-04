package com.aurionpro.model;

import java.util.*;

public class BookCricket {

	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

	static Scanner sc = new Scanner(System.in);

	public void playGame(int playNum, Player play, Player[] player) {
		System.out.println("Player : " + play.getName());
		int point = 1;
		int score = 0;
		int turns = 0;

		while (point != 0) {
			System.out.print("Enter 1 to Open Book : ");
			int open = sc.nextInt();

			if (open == 1) {
				Random random = new Random();
				int number = random.nextInt(301);
				point = number % 7;
				turns += 1;
				play.setTurns(turns);
				if (point != 0) {
					score += point;
					play.setScore(score);
					System.out.println("Page Number : " + number + "\t Point : " + point + "\t Score : "
							+ play.getScore() + "\t Turn : " + play.getTurns());
					if (playNum == 2 && play.getScore() > player[0].getScore()) {
						System.out.println("");
						break;
					}
				} else {
					System.out.println("Page Number : " + number + "\t Point : " + point + "\t Score : "
							+ play.getScore() + "\t Turn : " + play.getTurns());
					System.out.println(ANSI_RED_BACKGROUND + "!!!\t\t OOPS \t\t !!!" + ANSI_RESET);
					printDetails(play);
				}
			}
		}
	}

	public void checkWin(Player player1, Player player2) {
		System.out.println(player1.getName() + " Score : " + player1.getScore());
		System.out.println(player2.getName() + " Score : " + player2.getScore());

		if (player1.getScore() > player2.getScore())
			System.out.println("\n" + ANSI_GREEN_BACKGROUND + player1.getName() + " Win Match !!!" + ANSI_RESET);
		else
			System.out.println("\n" + ANSI_GREEN_BACKGROUND + player2.getName() + " Win Match !!!" + ANSI_RESET);

		if (player1.getScore() == player2.getScore())
			if (player1.getTurns() < player2.getTurns())
				System.out.println("\n" + ANSI_GREEN_BACKGROUND + player1.getName() + " Win Match !!!" + ANSI_RESET);

			else if (player1.getTurns() == player2.getTurns())
				System.out.println("\n" + ANSI_RED_BACKGROUND + "Match Draw !!!" + ANSI_RESET);

			else
				System.out.println("\n" + ANSI_GREEN_BACKGROUND + player2.getName() + " Win Match !!!" + ANSI_RESET);
	}

	private void printDetails(Player play) {
		System.out.println(play.getName() + " Total Score : " + play.getScore());
		System.out.println(play.getName() + " Takes " + play.getTurns() + " Rounds" + "\n");
	}

	public void playerNaming(int playerNumber, Player[] player) {
		System.out.print("Enter Player " + playerNumber + " Name : ");
		String name = sc.next();
		player[playerNumber - 1] = new Player(name);
	}

//	private int pointGenerator() {
//		Random random = new Random();
//		int number = random.nextInt(301);
//		int point = number % 7;		
//	return point;
//}
}
