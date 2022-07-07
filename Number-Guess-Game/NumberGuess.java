package com.aurionpro.model;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_RESET = "\u001B[0m";

	Scanner sc = new Scanner(System.in);
	int turns;
	int guessingNumber = numberGenerator();
	int guess;

	public int getTurns() {
		return turns;
	}

	public int getGuessingNumber() {
		return guessingNumber;
	}

	public int getGuess() {
		return guess;
	}

	public int numberGenerator() {
		Random random = new Random();
		int number = 1 + random.nextInt(100);
		return number;
	}

	public void updateTurns() {
		turns++;
	}
	
	public void enterGuess() {
		System.out.print("\nEnter your guess : ");
		guess = sc.nextInt();
		while (guess < 1 || guess > 100) {
			System.out.println("Enter number between 1-100 only");
			System.out.print("\nEnter your guess : ");
			guess = sc.nextInt();
		}
	}

	public void checkGuessIsLowOrHigh() {
		if (guess == guessingNumber)
			return;
		else if (guess > guessingNumber)
			System.out.println("Sorry, Your guess is too high.");
		else
			System.out.println("Sorry, Your guess is too low.");
	}

	public void printWinOrLossDetail() {
		if (guess == guessingNumber) {
			System.out.println("\nYour guessed number " + guess + " is right.");
			System.out.println("You guessed in " + turns + " turns.");
			System.out.println(ANSI_GREEN_BACKGROUND + "You won :)\n" + ANSI_RESET);
		} else {
			System.out.println("\nYour " + turns + " turns are over");
			System.out.println(ANSI_RED_BACKGROUND + "You loose :(\n" + ANSI_RESET);
		}
	}
	
}
