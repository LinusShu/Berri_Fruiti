package com.berrifruiti.cards;

import java.util.List;

public class Card {
	private List<Fruits[]> tabs;
	private int prize;
	
	public Card(List<Fruits[]> t, int p) {
		this.prize = p;
		this.tabs = t;
	}
	
	public List<Fruits[]> getTabs() {
		return tabs;
	}
	
	public int getPrize() {
		return prize;
	}
}
