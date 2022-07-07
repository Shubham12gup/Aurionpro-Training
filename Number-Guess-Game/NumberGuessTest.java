package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.NumberGuess;

public class NumberGuessTest {

	public static void main(String[] args) {

		System.out.println("NUMBER GUESS GAME");
		System.out.println("**Enter number between 1-100 only");
		System.out.println("**You have 6 turns to guess the number\n");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 1 to start or 0 to exit game: ");
		int start;
		start = sc.nextInt();

		while (start == 1) {
			startGame();
			System.out.print("Enter 1 to start or 0 to exit game: ");
			start = sc.nextInt();
		}
	}

	public static void startGame() {
		NumberGuess ng = new NumberGuess();
		System.out.println("Number : " + ng.getGuessingNumber());

		while (ng.getTurns() < 6 && ng.getGuess() != ng.getGuessingNumber()) {
			ng.enterGuess();
			ng.updateTurns();
			ng.checkGuessIsLowOrHigh();
		}
		ng.printWinOrLossDetail();
	}
}
