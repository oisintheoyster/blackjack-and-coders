/**
 * 
 */
package laffey.matthew;

import java.util.Scanner;

/**
 * @author Matthew
 *
 */
public class Driver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deck d = new Deck();
		String user_name;
		Player user;
		String AI_name;
		Player AI;
		Boolean user_has_decided_to_terminate_program = false;
		
		boolean wants_to_play_blackjack = getBoolean( in, "Do you want to play some Blackjack? (true/false)");
		if(wants_to_play_blackjack) {
			int user_starting_money = getValidInt(in, "Great, how much money are you bringing to the table tonight (an integer excluding currency symbols)", 0, Integer.MAX_VALUE);
			
			//MAKE NAME INPUT ROBUST
			
			System.out.println("Excellent, Now what should I call you?");
			user_name = in.next();
			
			user = new Player(user_name, user_starting_money, d);

			
			System.out.println("Great! Now who do you want to play against?");
			AI_name = in.next();
			
			AI = new Player(AI_name, Integer.MAX_VALUE, d);
			
			System.out.println("OK, Lets get this started!");
			int round = 1;
			
			while(!user_has_decided_to_terminate_program) {
				
				d = new Deck();
				d.shuffle();
				
				System.out.println("");
				System.out.println("Round: " + round);
				System.out.println("");
				
				int starting_bet = getValidInt(in, "Input Starting Bet: ", 0, user.getMoney());
				user.setBet(starting_bet);
				AI.setBet(starting_bet);
				
				System.out.println("");
				
				System.out.println("Brilliant, Now lets deal out the cards");
				
				System.out.println("");
				
				user.drawNewHand(d);
				AI.drawNewHand(d);
				System.out.println("Your hand: " + user.getHand() + " (Total Value: " + user.getHand().getHandValue() + ")");
				System.out.println(AI.getName() + "'s hand: " + AI.getHand().get(0) + "[Face Down Card]");
				
				System.out.println("");
				
				int raise = getValidInt(in, "Input the amount you'd like to raise (input 0 if checking)", 0, user.getMoney()-user.getBet());
				
				System.out.println("");
				
				user.setBet(starting_bet + raise);
				AI.setBet(starting_bet + raise);
				
				System.out.println("Now let's play the game!");
				
				System.out.println("");
				
				System.out.println("Your current hand is: " + user.getHand() + " (Total Value: " + user.getHand().getHandValue() + ")");
				
				boolean user_wants_to_hit = getBoolean(in, "Enter 'true' to hit and 'false' to stick");
				
				System.out.println("");
				
				int hit_counter = 1;
				
				while (user_wants_to_hit) {
								
					System.out.println("HIT: " + hit_counter);
					user.getHand().hit(d);
					
					System.out.println("");
					
					System.out.println("You drew the " + user.getHand().get(1 + hit_counter));
					System.out.println("Your current hand is: " + user.getHand() + " (Total Value: " + user.getHand().getHandValue() + ")");

					System.out.println("");
					
					if (user.getHand().isValid()) {						
						user_wants_to_hit = getBoolean(in, "Enter 'true' to hit and 'false' to stick");
						System.out.println("");
					}
					else {
						System.out.println("you bust :(");
						break;
					}
					hit_counter ++;
				}
				
				hit_counter = 1;
				
				if (user.getHand().isValid()) {
					while (AI.getHand().getHandValue() <= 16) { 
						
						System.out.println("");
						
						System.out.println("HIT: " + hit_counter);
						AI.getHand().hit(d);
						
						System.out.println("");
						
						System.out.println( AI.getName() + " drew " + AI.getHand().get(1 + hit_counter));
						System.out.println(AI.getName() + "'s current hand is: " + AI.getHand() + " (Total Value: " + AI.getHand().getHandValue() + ")");
						
						hit_counter ++;
					}
				}
				
				System.out.println("");
				System.out.println("Your current hand is: " + user.getHand() + " (Total Value: " + user.getHand().getHandValue() + ")");
				System.out.println(AI.getName() + "'s current hand is: " + AI.getHand() + " (Total Value: " + AI.getHand().getHandValue() + ")");
				
				System.out.println("");
				
				if (!user.getHand().isValid()|| user.getHand().isValid() && AI.getHand().isValid() && user.getHand().getHandValue() < AI.getHand().getHandValue()) {
					System.out.println(AI.getName() + " wins the round");
					System.out.println(AI.getName() + " collects " + user.getBet() + " from you");
					user.setMoney(user.getMoney() - user.getBet());
				}
				else {
					System.out.println(user.getName() + " wins the round");
					System.out.println(user.getName() + " collects $" + user.getBet() + " from " + AI.getName());
					user.setMoney(user.getMoney() + user.getBet());
					System.out.println("You now have $" + user.getMoney());
				}
				
				System.out.println("you now have $" + user.getMoney() + " (total)");
				
				System.out.println("");
				
				if (user.getMoney() == 0) {
					System.out.println("Unfortunately you're broke :(");
					break;
				}
				else if (user.getMoney() >= user_starting_money*4) {
					System.out.println("You have won more than 4 times your starting amount");
					System.out.println("We of the Laffey-Collins Casino congratulate you on your winnings");
					System.out.println("However we cannot continue to sustain your current winning streak (we are a business after all)");
					System.out.println("We hope that you have enjoyed your stay and that you will continue to develop your formidable skills.");
					System.out.println("Goodbye!");
				}
				else {
					user_has_decided_to_terminate_program = !getBoolean(in, "Do you wish to play another round? (true/false)");
					round ++;
					System.out.println("");
				}
			}
			
			System.out.println("");
			
			System.out.println("Good Game!");
			
			System.out.println("");
			
			if (user_starting_money <  user.getMoney()) {
				System.out.println("You won $" + (user.getMoney()-user_starting_money) + " (total) off of " + AI.getName() + "!");
				System.out.println("Don't come back, this establishment can't afford it");
			}
			else if	(user_starting_money >  user.getMoney()) {
				System.out.println("You lost $" + (user_starting_money - user.getMoney()) + "(total) to " + AI.getName() + "!");
				System.out.println("Better luck next time!");	
			}
			else {
				System.out.println("Congrats, you're leaving with the exact same amount that you came in with. Not many can say that!");
			}
		}
		
		else {
			System.out.println("Ok FINE, I didn't want to play with you anyways.");
		}
	}

	

	/**
	 * obtains a valid integer value input from the user in an inclusive range
	 * @param in is the scanner used to parse user input
	 * @param prompt is the prompt printed to the user to prompt them to provide valid input
	 * @param first_number is the lowest number in the inclusive range of the allowed integer inputs
	 * @param last_number is the highest number in the inclusive range of the allowed integer inputs
	 * @return a valid user-inputed int value which exists in the allowed inclusive range
	 */
	
	public static int getValidInt(Scanner in, String prompt, int first_number, int last_number) {
		int input = 69;
		boolean valid = false; 
		while (!valid) {
			System.out.print(prompt);
			if (in.hasNextInt()) {
				input = in.nextInt();
				if (first_number <= input && last_number >= input) {
					valid = true;
				}
				else {
					in.nextLine();
					System.out.println("Could you please provide a valid input, thanks.");
				}
			}
			else {
				in.nextLine();
				System.out.println("Could you please provide a valid input, thanks.");
			}
		}
		return input;
	}
	
	/**
	 * obtains a valid boolean input from the user
	 * @param in is the scanner used to parse user input
	 * @param prompt is the prompt printed to the user to prompt them to provide valid input
	 * @return a valid user-inputed boolean value
	 */
	
	public static boolean getBoolean(Scanner in, String prompt) {
		boolean valid = false; 
		boolean valid_input = true;
		while (!valid) {
			System.out.print(prompt);
			if (in.hasNextBoolean()) {
				valid_input = in.nextBoolean();
				valid = true;
			}
			else {
				in.nextLine();
				System.out.println("Could you please provide a valid input, thanks.");
			}
		}
		return valid_input;
	}
}
