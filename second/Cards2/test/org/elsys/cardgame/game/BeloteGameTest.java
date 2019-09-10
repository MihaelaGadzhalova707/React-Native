package org.elsys.cardgame.game;

import java.util.List;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.factory.DeckFactory;
import org.elsys.cardgame.factory.GameFactory;

public class BeloteGameTest extends AbstractGameTest {

	@Override
	public int deckSize() {
		return 32;
	}

	@Override
	public int handSize() {
		return 8;
	}

	@Override
	public Deck defaultDeck() {
		return DeckFactory.defaultBeloteDeck();
	}

	@Override
	protected Game createGame(List<Card> cards) {
		return GameFactory.createBeloteGame(cards);
	}
}
