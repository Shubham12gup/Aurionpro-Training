package com.aurionpro.test;

import java.util.*;

public class Pig {
	
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

	public static void main(String[] args) {
		int finalScore = 20;
		int score = 0, turns = 1;
		int turnScore = 0;
		int die;
		Scanner sc = new Scanner(System.in);
		System.out.println(ANSI_RED_BACKGROUND+ "TURN " + turns +ANSI_RESET);

		while(score <= finalScore)
		{
			System.out.print("Roll or hold? (r/h): ");
			String status = sc.next();
			char s = status.charAt(0);
			
			if (s == 'r') {
				Random random = new Random();
				die = 1 + random.nextInt(6);
				if (die != 1) {
					System.out.println("Die: "+ die);
					
					turnScore += die;
					score = score + die;
					//System.out.println("Score: "+ score);
				}
				else {
					System.out.println("Die: "+ die);
					turnScore = 0;
					score = 0;
					System.out.println("Turn Over, No Score.\n");
					turns++;
					System.out.println(ANSI_RED_BACKGROUND + "TURN " + turns + ANSI_RESET);
				}
				
			}
			else {
				System.out.println("Score for turn " + turns+ ": " + turnScore);
				turnScore = 0;
				System.out.println("Total Score: " + score + "\n");
				turns++;
				System.out.println(ANSI_RED_BACKGROUND + "TURN " + turns + ANSI_RESET);
			}
			if (score >= finalScore) {
				System.out.println("Total score: " +score+  "\n");
				System.out.println(ANSI_GREEN_BACKGROUND + "You finished in " + turns + " turns!\n" + ANSI_RESET);
				System.out.println("Game Over!");
				break;
			}
		
		}
		sc.close();
	}

}



