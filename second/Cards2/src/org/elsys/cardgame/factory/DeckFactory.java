package org.elsys.cardgame.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.api.Suit;
import org.elsys.cardgame.cardsagain2.Cardnew;
import org.elsys.cardgame.cardsagain2.Decknew;
import org.elsys.cardgame.cardsagain2.Gamenew;

public class DeckFactory {

	public static Deck defaultWarDeck() {
		int sizeCards = 52;
		int sizeHand = 26;
		//String game = Gamenew.current_game;
		List<Card> cards = new ArrayList<Card>(sizeCards);


		for(Rank r : Rank.values()) {
			for(Suit s : Suit.values()) {
				cards.add(new Cardnew(r,s)); 
			}
		}
		//Gamenew.current_game = "War";
		return new Decknew(cards,sizeHand);
	}

	public static Deck defaultSantaseDeck() {
		int sizeCards = 24;
		int sizeHand = 6;
		List<Card> cards = new ArrayList<Card>(sizeCards);
		List<Rank> ranks =  Arrays.asList(Rank.values());
		List<Rank> saved = new ArrayList<Rank>();
		List<Card> last = new ArrayList<Card>();

		for(Rank r : Rank.values()) {
			for(Suit s : Suit.values()) {
				cards.add(new Cardnew(r,s));
			}
		}
		for(int i = 0; i < ranks.size(); i++) {
			if(ranks.get(i).equals(Rank.NINE) ||
			   ranks.get(i).equals(Rank.JACK) ||
			   ranks.get(i).equals(Rank.TEN) ||
			   ranks.get(i).equals(Rank.QUEEN) ||
			   ranks.get(i).equals(Rank.KING) ||
			   ranks.get(i).equals(Rank.ACE)) saved.add(ranks.get(i));
		}
		cards.forEach(card -> {
			for(int k = 0; k < saved.size(); k++) {
				if(card.getRank().equals(saved.get(k))) last.add(card);
			}
		});
		//Gamenew.current_game = "Santase";
		 return new Decknew(last,sizeHand);
	}

	public static Deck defaultBeloteDeck() {
		int sizeCards = 32;
		int sizeHand = 8;
		List<Card> cards = new ArrayList<Card>(sizeCards);
		List<Rank> ranks =  Arrays.asList(Rank.values());
		List<Rank> saved = new ArrayList<Rank>();
		List<Card> last = new ArrayList<Card>();

		for(Rank r : Rank.values()) {
			for(Suit s : Suit.values()) {
				cards.add(new Cardnew(r,s));
			}
		}
		for(int i = 0; i < ranks.size(); i++) {
			if(ranks.get(i).equals(Rank.SEVEN) ||
			   ranks.get(i).equals(Rank.EIGHT) ||
			   ranks.get(i).equals(Rank.NINE) ||
			   ranks.get(i).equals(Rank.JACK) ||
			   ranks.get(i).equals(Rank.QUEEN) ||
			   ranks.get(i).equals(Rank.KING) ||
			   ranks.get(i).equals(Rank.TEN) ||
			   ranks.get(i).equals(Rank.ACE)) saved.add(ranks.get(i));
		}
		cards.forEach(card -> {
			for(int k = 0; k < saved.size(); k++) {
				if(card.getRank().equals(saved.get(k))) last.add(card);
			}
		});
		//Gamenew.current_game = "Belote";
		 return new Decknew(last,sizeHand);
	}
}
