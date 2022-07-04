package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.BookCricket;
import com.aurionpro.model.Player;

public class CricketGameTest {

	public static void main(String[] args) {

		System.out.println("   Welcome to BOOk CRICKET GAME  \n==================================");
		BookCricket bc = new BookCricket();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter 1 to start the game and 0 for exit : ");
		int start = sc.nextInt();

		while (start == 1) {
			Player[] player = new Player[2];
			
			bc.playerNaming(1, player);
			bc.playerNaming(2, player);

			System.out.println("==================================");

//			for (Player play : player)
//				bc.playGame(play);
			
			for(int i=0; i<player.length; i++)
				bc.playGame(i+1, player[i], player);
			
			bc.checkWin(player[0], player[1]);

			System.out.print("Enter 1 to start the game and 0 for exit : ");
			start = sc.nextInt();
		}
		sc.close();
	}
}
