package RoboBattle2;

import java.util.*;
import static java.lang.System.*;


public class RoboBattleMain {
	//Objects and Misc
		static Scanner MyScanner = new Scanner(System.in);//For Strings
		static Scanner MyScanner2 = new Scanner(System.in);//For int
		static Random MyRandom = new Random();
		static int AttackChoice;
		static int RandNum;
		static int PowerCost;
		static int RoundNumber = 1;
		//Player 1
		static String Player1Name = "";
		static int Player1Health = 100;
		static int Player1Power = 100;
		static int Player1Shields = 0;
		static int Player1Powerups = 1;
		//Player 2
		static String Player2Name = "The Computer";
		static int Player2Health = 100;	
		static int Player2Power = 100;
		static int Player2Shields = 0;
		static int Player2Powerups = 1;

	public static void main(String[] args) {
		RoboCommands RC = new RoboCommands();

		//Begin game
		out.println("Welcome to the RoboBattle arena");
		out.println("");
		out.print("What is your name?");
		Player1Name = MyScanner.nextLine();
		out.println("");
		out.println("Hello " + Player1Name + " your opponent is " + Player2Name);
		out.println("");
		out.println("Here are your stats");
		Stats();
		out.println("");
		RC.AttackChoices();
		//Begin while loop	
			while (Player1Health > 0 && Player2Health > 0)
		{
				out.println("");
			out.println("                                                                      Round Number " + RoundNumber++);
			
				//Player 1 attacks		
				out.println("                                                >>>>>>>>>>>>>>>>>>>>>>>" + Player1Name + " Attacks<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				out.println("");
				out.println("Choose your attack: ");
				RC.AttackChoicesSM();
				AttackChoice = MyScanner2.nextInt();
					if (AttackChoice == 1)
					{
						RandNum = MyRandom.nextInt(10)+1;
						PowerCost = 5;
						Player2Health = RC.AtkHealth(RandNum, Player2Health, Player2Shields);
						Player2Shields = RC.AtkShields(RandNum, Player2Shields);
						Player1Power = RC.PowerReduction(PowerCost, Player1Power);
						out.println(Player1Name + " Unleashes a barrage of Machine gun bullets into " + Player2Name + " for " + RandNum + " damage");
					}
				
					else if  (AttackChoice == 2)
					{
						RandNum = MyRandom.nextInt(20)+1;
						PowerCost = 10;
						Player2Health = RC.AtkHealth(RandNum, Player2Health, Player2Shields);
						Player2Shields = RC.AtkShields(RandNum, Player2Shields);
						Player1Power = RC.PowerReduction(PowerCost, Player1Power);
						out.println(Player1Name + " launches a high yield missle at " + Player2Name + " for " + RandNum + " damage");
						
					}
				
					else if (AttackChoice == 3)
					{
						RandNum = MyRandom.nextInt(30)+1;
						PowerCost = 15;
						Player2Health = RC.AtkHealth(RandNum, Player2Health, Player2Shields);
						Player2Shields = RC.AtkShields(RandNum, Player2Shields);
						Player1Power = RC.PowerReduction(PowerCost, Player1Power);
						Player1Health = RC.AtkAOE(RandNum, Player1Health);
						out.println(Player1Name + " calls an orbiting space cannon to scorch " + Player2Name + " for " + RandNum + " damage");
						out.println(Player1Name + " is caught in the blast for " + RandNum/2 + " damage");
					}
					
					else if (AttackChoice == 4 && Player1Powerups == 1)
					{
						RandNum = MyRandom.nextInt(4)+1;
						PowerCost = 20;
						Player1Power = RC.PowerReduction(PowerCost, Player1Power);
						out.println(Player1Name + " has called for help from the home base");
						if (RandNum == 1)
						{
							Player1Health = RC.Atk4_1(Player1Health);
							out.println(Player1Name + " has had their armor completly repaired");
							Player1Powerups = Player1Powerups --;
						}
						
						else if (RandNum == 2)
						{
							Player1Power = RC.Atk4_2(Player1Power);
							out.println(Player1Name + " Receives a surge of power");
							Player1Powerups = Player1Powerups --;
						}
						
						else if (RandNum == 3)
						{
							Player1Shields = RC.Atk4_3(Player1Shields);
							out.println(Player1Name + " is surrounded by a shield of pure energy");
							Player1Powerups = Player1Powerups --;
						}
						
						else if (RandNum == 4)
						{
							Player2Health = RC.Atk4_4(Player2Health);
							out.println(Player1Name + " calls in a drone targeted strike and hits" + Player2Name + " for 30 damage");
							Player1Powerups = Player1Powerups --;
						}
					}
					else
					{
						out.println("Sorry you do not have any Power Ups left");
					}
			
				//player2 attacks
				
				out.println("");
				out.println("                                       >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + Player2Name + " attacks<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				out.println("");
				AttackChoice = MyRandom.nextInt(3)+1;
					if (AttackChoice == 1)
					{
						RandNum = MyRandom.nextInt(10)+1;
						PowerCost = 5;
						Player1Health = RC.AtkHealth(RandNum, Player1Health, Player1Shields);
						Player1Shields = RC.AtkShields(RandNum, Player1Shields);
						Player2Power = RC.PowerReduction(PowerCost, Player2Power);
						out.println(Player2Name + " Unleashes a barrage of Machine gun bullets into " + Player1Name + " for " + RandNum + " damage");
					}
				
					else if  (AttackChoice == 2)
					{
						RandNum = MyRandom.nextInt(20)+1;
						PowerCost = 10;
						Player1Health = RC.AtkHealth(RandNum, Player1Health, Player1Shields);
						Player1Shields = RC.AtkShields(RandNum, Player1Shields);
						Player2Power = RC.PowerReduction(PowerCost, Player2Power);
						out.println(Player2Name + " launches a high yield missle at " + Player1Name + " for " + RandNum + " damage");
					}
				
					else if (AttackChoice == 3)
					{
						RandNum = MyRandom.nextInt(30)+1;
						PowerCost = 15;
						Player1Health = RC.AtkHealth(RandNum, Player1Health, Player1Shields);
						Player1Shields = RC.AtkShields(RandNum, Player1Shields);
						Player2Power = RC.PowerReduction(PowerCost, Player2Power);
						Player2Health = RC.AtkAOE(RandNum, Player2Health);
						out.println(Player2Name + " calls an orbiting space cannon to scorch " + Player1Name + " for " + RandNum + " damage");
						out.println(Player2Name + " is caught in the blast for " + RandNum/2 + " damage");
					}
					
					else if (AttackChoice == 4 && Player1Powerups == 1)
					{
						RandNum = MyRandom.nextInt(4)+1;
						PowerCost = 20;
						Player2Power = RC.PowerReduction(PowerCost, Player2Power);
						out.println(Player2Name + " has called for help from the home base");
						if (RandNum == 1)
						{	
							Player2Health = RC.Atk4_1(Player2Health);
							out.println(Player2Name + " has had their armor completly repaired");
							Player2Powerups = Player2Powerups --;
						}
						
						else if (RandNum == 2)
						{
							Player2Power = RC.Atk4_2(Player2Power);
							out.println(Player2Name + " Receives a surge of power");
							Player2Powerups = Player2Powerups --;
						}
						
						else if (RandNum == 3)
						{
							Player2Shields = RC.Atk4_3(Player2Shields);
							out.println(Player2Name + " is surrounded by a shield of energy");
							Player2Powerups = Player2Powerups --;
						}
						
						else if (RandNum == 4)
						{
							Player1Health = RC.Atk4_4(Player1Health);
							out.println(Player2Name + " calls in a drone targeted strike and hits" + Player1Name + " for 30 damage");
							Player2Powerups = Player2Powerups --;
						}
					}
					else
					{
						out.println("Sorry you do not have any Power Ups left");
					}
						
			
		  


			out.println("");
			Stats();
		}//End While loop
			
			if (Player1Health >0 && Player2Health <=0)
			{
				out.println(Player1Name + " Wins in " + RoundNumber + " s");
			}
			else if (Player2Health >0 && Player1Health <=0)
			{
				out.println(Player2Name + " Wins in " + (RoundNumber-1) + " rounds");
			}
			out.println("");
			out.println("Thanks for playing");
			
			
			
			
			
			
		}

			static public void Stats()
			{
				out.println(Player1Name + " health = " + Player1Health + " Power = " + Player1Power + " shields = " + Player1Shields);
				out.println(Player2Name + " health = " + Player2Health + " Power = " + Player2Power + " shields = " + Player2Shields);
			}

			
	}

