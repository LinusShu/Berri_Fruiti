package com.berrifruiti.cards;

public class Tab {
	private Fruits[] symbols;
	
	public Tab(Fruits[] c) {
		if (c.length > 3) 
			System.err.println("Error: Only 3 symbols are allawed on 1 tab!");
		symbols = new Fruits[3];
		
		this.symbols = c;
	}
	
	/**
	 * Method used to get an array representation of the symbol combination on the pull-tab. 
	 * 
	 * @return  Array of Fruits enums.
	 */
	public Fruits[] getSymbols() {
		return this.symbols;
	}
	
	public void setSymbol(int index, Fruits f) {
		symbols[index] = f;
	}

}
