/*
* NameOfYourProgram.java
* Author:  Jay Cromwell
* Submission Date:  03/09/2012
*
* Purpose: This is a program that simulates a craps game. it asks the user if they want to play,
* how many chips they want to bet and if they want to bet on even or odd.
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on a programming project created by the Department of 
* Computer Science at the University of Georgia. Any publishing CSCI 1301  |  Page 4 of 10
* of source code for this project is strictly prohibited without written
* consent from the Department of Computer Science.
*/






import java.util.Random;
import java.util.Scanner;
public class EvenOddCraps {
	
	
	
	
	public static void main(String[] args) {
		//initialize variables
		int rollCount = 0;
		int chipCount = 0;
		int chipBet = 0;
	
		String evenOddBet = "";
		int casinoTotal = 1000000;
		String userPlay = "";
		int userWantsToPlay = 1;
		int wonBet = 0;
		int evenOddBetNum = 0;
		String replayBet = "";
		int replayBetNum = 0;
	
		//creating loops so program repeats until terminated
	for(int i = 1; i >= 1; i++)	{
		while(userWantsToPlay == 1){
		Scanner keyboard = new Scanner (System.in);
		System.out.println("Would you like to play even/odd craps (y/n)?");
		userPlay = keyboard.nextLine();
		// seeing if user wants to play
		if(userPlay.charAt(0) == 'y' || userPlay.charAt(0) == 'Y')
		{
		userWantsToPlay = 2;
		rollCount++;
		
		
		}else if (userPlay.charAt(0) == 'n' || userPlay.charAt(0) == 'N')
		{
		userWantsToPlay = 3;
		System.out.println("Goodbye");
		System.out.println("You rolled the die " + rollCount + " times.");
		System.out.println("You won " + chipCount + " chips.");
		System.out.println("The casino has " + casinoTotal + " chips in its bank.");
		System.out.println("Game over!");
		System.exit(1);
		}
	
		}
	
	//seeing how many chips to bet
	
	do{
		Scanner keyboard2 = new Scanner (System.in);
		Scanner input = new Scanner (System.in);
		System.out.println("How many chips would you like to bet?");
		chipBet = keyboard2.nextInt();
		if(chipBet <= 0){
			System.out.println("You must bet atleast 1 chip.");
		}else if(chipBet > 31250){
			System.out.println("Your bet cannot exceed 31250 chips.");
		}
	
	}while(chipBet <= 0 || chipBet > 31250);	
		
		do{
		Scanner keyboard3 = new Scanner (System.in);
		System.out.println("Bet on an even or odd roll (e/o)?");
		evenOddBet = keyboard3.nextLine();
		if (evenOddBet.charAt(0) == 'e' || evenOddBet.charAt(0) == 'E')
		{evenOddBetNum = 4;
		}else if (evenOddBet.charAt(0) == 'o' || evenOddBet.charAt(0) == 'O')
		{evenOddBetNum = 5;
		}
		
		}while(evenOddBetNum == 0);
		
		//creating the die
		int dieRoll;	
		RandomDie rd = new RandomDie();
		dieRoll = rd.getRandomDieRoll();
		System.out.println("You roll a " + dieRoll);
		
		if(dieRoll % 2 == 0 && evenOddBetNum == 4){
		System.out.println("Congrats! You won " + chipBet + " chips.");
		chipCount = chipCount + chipBet;
		casinoTotal = casinoTotal - chipBet;
		wonBet = 1;
		}else if(dieRoll % 2 == 0 && evenOddBetNum == 5){
		System.out.println("Sorry! You lost your original bet of " + chipBet + " chips.");
		chipCount = chipCount - chipBet;
		casinoTotal = casinoTotal + chipBet;
		wonBet = 0;
		}else if(dieRoll % 2 == 1 && evenOddBetNum == 4){
		System.out.println("Sorry! You lost your original bet of " + chipBet + " chips.");
		chipCount = chipCount - chipBet;
		casinoTotal = casinoTotal + chipBet;
		wonBet = 0;
		}else if(dieRoll % 2 == 1 && evenOddBetNum == 5){
		System.out.println("Congrats! You won " + chipBet + " chips.");
		chipCount = chipCount + chipBet;
		casinoTotal = casinoTotal - chipBet;
		wonBet = 1;
		}
		//another die if they choose to bet double or nothing
		String even_odd = "";
		if(evenOddBetNum == 4){
			even_odd = "even";
		}else if(evenOddBetNum == 5){
			even_odd = "odd";
		}
		
		int g = 1;
		
		while(wonBet == 1 && g == 1){
			int dieRoll2;
			RandomDie rd2 = new RandomDie();
			dieRoll2 = rd2.getRandomDieRoll();
		Scanner keyboard4 = new Scanner (System.in);
		System.out.println("Bet double or nothing on another " + even_odd + " roll (y/n)?" );
		replayBet = keyboard4.nextLine();
		
			if(replayBet.charAt(0) == 'y' || replayBet.charAt(0) == 'Y'){
			System.out.println("You roll a " + dieRoll2 + ".");		
			
				if(dieRoll2 % 2 == 0 && evenOddBetNum == 4){
				System.out.println("Congrats! You won " + chipBet*2 + " chips.");
				chipCount = chipCount + chipBet;
				casinoTotal = casinoTotal - chipBet;
				g = 1;
				}else if(dieRoll2 % 2 == 0 && evenOddBetNum == 5){
				System.out.println("Sorry! You lost your original bet of " + chipBet + " chips.");
				chipCount = chipCount - chipBet;
				casinoTotal = casinoTotal + (chipBet*2);
				g = 0;
				}else if(dieRoll2 % 2 == 1 && evenOddBetNum == 4){
				System.out.println("Sorry! You lost your original bet of " + chipBet + " chips.");
				chipCount = chipCount - chipBet;
				casinoTotal = casinoTotal + (chipBet*2);
				g = 0;
				}else if(dieRoll2 % 2 == 1 && evenOddBetNum == 5){
				System.out.println("Congrats! You won " + chipBet*2 + " chips.");
				chipCount = chipCount + chipBet;
				casinoTotal = casinoTotal - chipBet;
				g = 1;
				
			}rollCount++;
		}else if(replayBet.charAt(0) == 'n' || replayBet.charAt(0) == 'N'){
			g = 0;
		}
		}
		//checking to see if casino is bankrupt
		if(casinoTotal <= 0){
			System.out.println("Your winnings bankrupted the casino.");
			System.out.println("Goodbye!");
			System.out.println("\t You rolled the die " + rollCount + " times.");
			System.out.printf("\t You won %,d chips.", chipCount);
			System.out.printf("\t The casino has %,d chips in its bank.", casinoTotal);
			System.out.println("Game Over!");
			System.exit(3);
		}
		
		String play_again = "";
		String won_loss = "";
		int playAgainNum = 0;
		do{
			Scanner keyboard4 = new Scanner (System.in);
			System.out.println("Would you like to continue playing (y/n)?");
			play_again = keyboard4.nextLine();
			if(play_again.charAt(0) == 'y' || play_again.charAt(0) == 'Y'){
				playAgainNum = 1;
				rollCount++;
			}else if(play_again.charAt(0) == 'n' || play_again.charAt(0) == 'N'){
				playAgainNum = 2;
				System.out.println("Goodbye!");
				System.out.println("\t You rolled the die " + rollCount + " times.");
				if(chipCount < 0){
					won_loss = "lost";
					chipCount = chipCount*(-1);
				}else{
					won_loss = "won";
				}
				System.out.printf("\t You " + won_loss + " %,d chips.", chipCount);
				System.out.printf("\n\t The casino has %,d chips in its bank.", casinoTotal);
				System.out.println("\nGame Over!");
				System.exit(9);
			}
			
		}while(playAgainNum == 0);
		
		
	}	
		
	}

}
