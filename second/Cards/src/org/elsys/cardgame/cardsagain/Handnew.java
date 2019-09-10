package org.elsys.cardgame.cardsagain;

import java.util.ArrayList;
import java.util.List;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Hand;

public class Handnew implements Hand{

	List<Card> hands  = new ArrayList<Card>();
	private int size;
	
	public Handnew (int size, List<Card> hands) {
		this.hands = hands;
		this.size = size;
	}

	@Override
	public List<Card> getCards() {
		return this.hands;
	}

	@Override
	public int size() {
		return size;
	}

}
