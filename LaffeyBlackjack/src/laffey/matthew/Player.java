package laffey.matthew;

import java.util.ArrayList;

public class Player {

	private ArrayList<Card> hand;
	private int bet;
	private String name;
	private int money;
	
	public Player(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	public void hit(Deck d) {
		hand.add(d.drawACard());
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
	
	public void discardHand() {
		hand.clear();
	}
	
	public void setBet(int bet) {
		this.bet = bet;
	}
	
	public boolean 
	
	

}
