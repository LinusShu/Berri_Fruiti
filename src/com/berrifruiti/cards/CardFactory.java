package com.berrifruiti.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardFactory {
	private List<Card> cards;
	private int totalwin;
	private int[] win_counts;
	private Random rng;
	/**
	 * CardFactory constructor
	 * 
	 * @param cardcount		the number of times the player plays/ the number of cards the player bought.
	 */
	public CardFactory(int cardcount) {
		cards = new ArrayList<Card>(cardcount);
		int totalwin = 0;
		rng = new Random();
		
		//initialize win counts array
		win_counts = new int[6];
		for (int i=0; i<6; i++) {
			win_counts[i] = 0;
		}
		
		//create the cards
		for (int i=0; i<cardcount; i++) {
			createCards();
		}
	}
	
	/**
	 * @return the list of the card bought
	 */
	public List<Card> getCards() {
		return cards;
	}
	
	/**
	 * @return the total payout on all cards.
	 */
	public int getTotalWin() {
		return totalwin;
	}
	
	/**
	 * This is the main method used to create a card. It will create/assemble a card 
	 * according to the probabilities of winning.
	 */
	public void createCards() {
		Card newCard = null;
		List<Fruits[]> tabs = new ArrayList<Fruits[]>(5);
		//randomly generated number used to determine the prize.
		int num = rng.nextInt(50000)+1; 
		//randomly generated number used to determine the position of the winning tab on the card. 
		final int pos = rng.nextInt(5);
		//randomly generated number used to determine the chance for near misses.
		final int nearmiss = rng.nextInt(100)+1; 
		boolean goAgain = true;
		
		while (goAgain) {
			//3 Cherries
			if (num > 0 && num < 5 && win_counts[0] < 5) {
				createWinTab(0);
				goAgain = false;
			}
		}
		
	}
	
	/**
	 * This method will create 1 of the 5 winning tabs.
	 * 
	 * @param type
	 * @return
	 */
	private Tab createWinTab(int type) {
		Tab t = null;
		//used to determine which 2 other fruits to use in the "1 cherry and 2 others the same" win.
		int n = rng.nextInt(5)+1; 

		switch (type) {
			//3 Cherries
			case 0: 
				t = new Tab(new Fruits[] {Fruits.CHERRY, Fruits.CHERRY, Fruits.CHERRY});
				break;
			//3 Bananas
			case 1:
				t = new Tab(new Fruits[] {Fruits.BANANA, Fruits.BANANA, Fruits.BANANA});
				break;
			//3 Pears
			case 2:
				t = new Tab(new Fruits[] {Fruits.PEAR, Fruits.PEAR, Fruits.PEAR});
				break;
			case 3:
			//3 Blueberries
				t = new Tab(new Fruits[] {Fruits.BLUEBERRY, Fruits.BLUEBERRY, Fruits.BLUEBERRY});
				break;
			//3 Apples
			case 4:
				t = new Tab(new Fruits[] {Fruits.APPLE, Fruits.APPLE, Fruits.APPLE});
				break;
			//1 Cherry & 2 others of the same
			case 5:
				//assign 1 cherry to a random slot on the tab
				t.setSymbol(rng.nextInt(3), Fruits.CHERRY);
				//assign 2 others of the same to the remaining slots on the tab
				for (int i=0; i<t.getSymbols().length; i++) {
					if (t.getSymbols()[i] == null)
						t.setSymbol(i, Fruits.toFruit(n));
				}
			default:
				break;
				
		}
	
		
		return t;
	}
}