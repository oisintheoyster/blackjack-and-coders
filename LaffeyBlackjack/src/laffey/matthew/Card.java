package laffey.matthew;

public class Card {

	private Suit s;
	private int number;
	
	public Card() {
		this.s = Suit.NULL;
		this.number = 0;
	}
	
	public Card(Suit s, int number) {
		this.s = s;
		this.number = number;
	}
	
	public void setSuit(Suit s) {
		this.s = s;
	}
	
	public Suit getSuit() {
		return this.s;
	}
	
	public void setNumber(int n) {
		number = n;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String toString() {
		switch (s) {
		case HEARTS:
			return "[" + number + " of Hearts]";
		case SPADES:
			return "[" + number + " of Spades]";
		case CLUBS:
			return "[" + number + " of Clubs]";
		case DIAMONDS:
			return "[" + number + " of Diamonds]";
		default:
			return "[This Card is blank]";
		}
	}

}
