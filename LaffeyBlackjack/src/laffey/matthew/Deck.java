package laffey.matthew;

public class Deck {

	private Card[] d = new Card[52];
	final static Suit[] SUITS = Suit.values();
	
	public Deck() {
	
		int index_of_card_to_initialize = 0;
		for (Suit s : SUITS) {
			if (s == Suit.NULL) { break;}
			for (int i = 1; i <= 13; i++) {
				d[index_of_card_to_initialize] = new Card(s, i);
				index_of_card_to_initialize ++;
			}
		}
		
		
	}
	
	public Card drawACard(){
		for (int i = 0; i < 52; i++) {
			if (d[i].getSuit().equals(Suit.NULL)) {
				continue;
			}
			else {
				Card x = d[i];
				//System.out.println(d[i]);
				d[i] = new Card();
				//System.out.println(d[i]);
				return x;
			}
		}
		return new Card();
	}
	
	//returns the shuffled deck
	//it makes 10000 random swaps to shuffle the deck
	public void shuffle() {
		for (int i = 0; i < 10000; i++) {
			int x = (int)(Math.random()*52);
			int y = (int)(Math.random()*52);
			Card c = d[x];
			d[x] = d[y];
			d[y] = c;
		}
	}
	
	public String toString() {
		String output = "";
		for (Card c : d) {
			output += c.toString() + ", ";
		}
		return output;
	}
}
