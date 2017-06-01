package oisin.collins;

public class Player {


	private Hand hand;
	private int bet;
	private String name;
	private int money;
	
	public Player(String name, int money, Deck d) {
		this.name = name;
		this.money = money;
		
	}
	
	public int getBet() {
		return bet;
	}
	
	public void hit(Deck d) {
		hand.hit(d);
	}
	
	public String getName() { 
		return name;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void drawNewHand(Deck d) {
		hand = new Hand(d);
	}
	
	public void setBet(int bet) {
		this.bet = bet;
	}
	
	public Hand getHand() {
		return hand;
	}
}
