package com.berrifruiti.cards;

import java.util.List;

public class Card {
	private List<Tab> tabs;
	private int prize;
	
	public Card(List<Tab> t, int p) {
		this.prize = p;
		this.tabs = t;
	}
	
	public List<Tab> getTabs() {
		return tabs;
	}
	
	public int getPrize() {
		return prize;
	}
}
