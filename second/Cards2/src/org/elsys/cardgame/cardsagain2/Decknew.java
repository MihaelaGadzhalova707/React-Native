package org.elsys.cardgame.cardsagain2;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Hand;

import java.util.*;
//import java.util.Collections;
import java.util.stream.Collectors;

public class Decknew implements Deck{


	List<Card> cards = new ArrayList<Card>();
	private int size;
	private int handSize;
	
	public Decknew(List<Card> cards, int handSize) {
		this.cards = cards;
		this.handSize = handSize;
	}
	
	public Decknew(int size, int handSize, List<Card> cards) {
		this.size = size;
		this.handSize = handSize;
		for (Card c : cards) {
			this.cards.add(c);
		}
	}


	@Override
	public List<Card> getCards() {
		return this.cards;
	}
	@Override
	public int size() {
		return this.cards.size();
	}
	@Override
	public int handSize() {
		return handSize;
	}
	@Override
	public Card drawTopCard() {
		size--;
		return this.cards.remove(0);
	}
	@Override
	public Card topCard() {
		return this.cards.get(0);
	}
	@Override
	public Card drawBottomCard() {
		size--;
		return this.cards.remove(size() - 1);

	}
	@Override
	public Card bottomCard() {
		return this.cards.get(size() - 1);
	}
	@Override
	public Hand deal() {
		List<Card> handNow = new ArrayList<Card>();
		
		for(int i = 0; i < this.handSize; i++) {
			handNow.add(drawTopCard());
		}
		return new Handnew(this.handSize, handNow);

	}
	@Override
	public void sort() {
		cards.sort(Comparator.comparing(Card::getRank).thenComparing(Card::getSuit));
	}
	@Override
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	
}













