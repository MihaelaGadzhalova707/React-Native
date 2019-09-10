package org.elsys.cardgame.factory;

import java.util.ArrayList;
import java.util.List;


import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.cardsagain2.Decknew;
import org.elsys.cardgame.cardsagain2.Gamenew;
import org.elsys.cardgame.operation.BottomCard;
import org.elsys.cardgame.operation.Deal;
import org.elsys.cardgame.operation.DrawBottomCard;
import org.elsys.cardgame.operation.DrawTopCard;
import org.elsys.cardgame.operation.Shuffle;
import org.elsys.cardgame.operation.Size;
import org.elsys.cardgame.operation.Sort;
import org.elsys.cardgame.operation.TopCard;

public class GameFactory {
	
	public static Game createWarGame(List<Card> cards) {
		Deck war = DeckFactory.defaultWarDeck();
		int cards_number = war.size();
		int hand_size = war.handSize();
		List<Card> cardsToReturn = new ArrayList<>();
		for(int i = 0; i < war.size(); i++) {
			for(int k = 0; k < cards.size(); k++) {
				if(cards.get(k).equals(war.getCards().get(i))) {
					cardsToReturn.add(cards.get(k));
				}
			}
		}
		Deck new_deck;
		Gamenew.current_game = "War";
		if(cards_number != war.size()) {
			throw new CardException("ERROR: Not enough cards for War");
		} else  {
			new_deck = new Decknew(cardsToReturn, hand_size);
		}
		return new Gamenew(new_deck);
	}

	public static Game createSantaseGame(List<Card> cards) {
		
		Deck santase = DeckFactory.defaultSantaseDeck();
		int cards_number = santase.size();
		int hand_size = santase.handSize();
		List<Card> cardsToReturn = new ArrayList<>();
		for(int i = 0; i < santase.size(); i++) {
			for(int k = 0; k < cards.size(); k++) {
				if(cards.get(k).equals(santase.getCards().get(i))) {
					cardsToReturn.add(cards.get(k));
				}
			}
		}
		Deck new_deck = new Decknew(cardsToReturn, hand_size);
		Gamenew.current_game = "Santase";
		if(cards_number > santase.size()) {
			throw new CardException("ERROR: Not enough cards for War");
		}
		return new Gamenew(new_deck);
	}

	public static Game createBeloteGame(List<Card> cards) {
		Deck belote = DeckFactory.defaultBeloteDeck();
		int cards_number = belote.size();
		int hand_size = belote.handSize();
		List<Card> cardsToReturn = new ArrayList<>();
		for(int i = 0; i < belote.size(); i++) {
			for(int k = 0; k < cards.size(); k++) {
				if(cards.get(k).equals(belote.getCards().get(i))) {
					cardsToReturn.add(cards.get(k));
				}
			}
		}
		Deck new_deck = new Decknew(cardsToReturn, hand_size);
		Gamenew.current_game = "Belote";
		if(cards_number > belote.size()) {
			throw new CardException("ERROR: Not enough cards for War");
		}
		return new Gamenew(new_deck);
	}
}
