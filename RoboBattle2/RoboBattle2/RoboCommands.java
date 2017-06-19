package RoboBattle2;

import  static java.lang.System.out;

public class RoboCommands {
	//Misc
	
			 int RandNum;//Variable for random value returned Attacks 1-3
			 int NewHealth;//Variable for health value returned Attacks 1 and attack 4 choice 4
			 int NewPower;//Variable for power value returned Attacks 1-3
			 int NewShields;//Variable for shields returned Attacks 1-3
			 int AOENewHealth;//Variable for health returned on attack 3 /Calling player damage
			 int aHealth;//Variable for Health returned Attack 4 choice 1
			 int aPower;//Variable for Health returned Attack 4 choice 2
			 int aShields;//Variable for Health returned Attack 4 choice 3
	// Begin attacks		
			//Attack 3 Area of effect damage to attacking player
			public  int AtkAOE (int RandNum, int PlayerHealth)
			{
				AOENewHealth = PlayerHealth - (RandNum/2);
				
				return AOENewHealth;
			}
		
			//Power Decrease
			public  int PowerReduction(int PowerCost , int PlayerPower) 
			{
				NewPower = PlayerPower - PowerCost;
				return NewPower;
			}
			
			
			//Player Attacks 1-3
			public  int AtkHealth(int RandNum ,int PlayerHealth ,int PlayerShields)//Attack 1-3 / Health damage
			{	
				if (PlayerShields >0) {NewHealth = PlayerHealth - (RandNum/2);}
					
				else {NewHealth = PlayerHealth - RandNum;}
				
				return NewHealth;
			}
			public  int AtkShields(int RandNum, int PlayerShields)// Attack 1-3 / Shield damage
			{
				if (PlayerShields >0) {NewShields = PlayerShields - (RandNum/2);}
				
				return NewShields; 
			}

			
			// player attack 4
			public  int Atk4_1(int PlayerHealth)//Power up #1 Full Health
			{
				aHealth = 100 - PlayerHealth;
				NewHealth = PlayerHealth + aHealth;
				return NewHealth;
			}
			
			public  int Atk4_2(int PlayerPower)//Power up #2 full power
			{
				aPower = 100 - PlayerPower;
				NewPower = PlayerPower + aPower;
				return NewPower;
			}
			
			public  int Atk4_3(int PlayerShields)//Power up #3 full shields
			{
				aShields = 100 - PlayerShields;
				NewShields = PlayerShields + aShields;
				return NewShields;
			}
			
			public  int Atk4_4(int PlayerHealth)//Power up #4 drone strike for 30 dmg
			{
				NewHealth = PlayerHealth - 30;
				return NewHealth;
			}
	//End attacks		
			public  void AttackChoices() //full display of attack choices
			{
			out.println("Each player has 3 levels of attacks, use the number keys 1-4 to select your weapon");
			out.println("Weapon 1: Machine gun - Damage (1-10) Power usage (5)");
			out.println("Weapon 2: Missile Launcher - Damage (1-20) Power usage (10)");
			out.println("Weapon 3: Orbting Space Cannon - Damage (1-30) Half Damage to player Power usage (15)");
			out.println("Weapon 4: Random Power Up Full Health, Full Shields, Full Power or Drone Attack Power usage (25), can only be used once");
			}
		
		public  void AttackChoicesSM()//Quick display of attack choices to be displayed each round.
			{
			out.print("Weapon 1: Machine Gun 1 - 10 Dmg | Weapon 2: Missle Launcher 1 - 20 Dmg |" + " Weapon 3: Space Cannon 1-30 Dmg Half to user | Weapon 4: Random powerup 1 time only");
			}
}
