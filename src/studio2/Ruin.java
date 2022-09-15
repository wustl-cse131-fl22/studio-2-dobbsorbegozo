package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in); 
		
		System.out.println("Start Amount?"); 
		double startAmount= in.nextDouble(); 
		System.out.println("Win Chance?"); 
		double winChance = in.nextDouble(); 
		System.out.println("Win Limit?"); 
		double winLimit = in.nextDouble(); 
		

		
		double cash= startAmount;
		int numPlays = 0;
		int numRuins = 0;
		
		System.out.println("How many simulations?");
		int totalSimulations = in.nextInt();
		
		for (int simNum = 1; simNum <= totalSimulations; simNum++)
		{
			System.out.println("Simulation #: " + simNum);
			while (cash < winLimit && cash>0)
			{
				double random= Math.random(); 
				if (random< winChance)
				{ cash++;
					
				}
				else
				{
					cash--; 
					 
				}
				numPlays++;
				
			}	
			System.out.println("Number of plays: " + numPlays);
			if (cash == winLimit)
			{
				System.out.println("Successful day");
			}
			else if (cash == 0)
			{
				System.out.println("Ruinous day");
				numRuins++;
			}
			cash = startAmount;
			numPlays = 0;
		}
		double ruinRate = (double) numRuins / totalSimulations;
		System.out.println("Ruin Rate: " + ruinRate);
		
		double a = (1-winChance) / winChance;
		double expectedRuin;
		
		
		if (winChance == 0.5)
		{
			expectedRuin = (double) 1 - (startAmount / winLimit);
		}
		else
		{
			expectedRuin = (double) ((Math.pow(a, startAmount) - Math.pow(a, winLimit)) / (1 - Math.pow(a, winLimit)));
		}
		System.out.println("Expected Ruin Rate: " + expectedRuin);
	}

}
