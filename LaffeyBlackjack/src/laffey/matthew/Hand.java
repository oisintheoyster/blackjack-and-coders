package laffey.matthew;

import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> hand = new ArrayList<>();
	
	public Hand() {
		hand.add(new Card());
		hand.add(new Card());
	}
	
	public Hand(Deck d) {
		hand.add(d.drawACard());
		hand.add(d.drawACard());
		
	}
	
	public void hit(Deck d) {
		hand.add(d.drawACard());
	}
	
	public int getHandValue() {
		int handValue = 0;
		for (Card c : hand) {
			if (c.getNumber() > 10) {
				handValue += 10;
			}
			else {
				handValue += c.getNumber();
			}
		}
		return handValue;
	}
	
	public boolean isValid() {
		if (this.getHandValue() > 21) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	public Card get(int i) {
		return hand.get(i);
	}
	
	public String toString() {
		String output = "";
		for (Card c : hand) {
			output += c;
		}
		return output;
	}
}
