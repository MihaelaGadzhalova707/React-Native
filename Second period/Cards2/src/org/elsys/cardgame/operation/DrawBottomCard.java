package org.elsys.cardgame.operation;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.cardsagain2.Gamenew;
import org.elsys.cardgame.cardsagain2.Operations;

public class DrawBottomCard extends Operations {

	Deck deck;

	public DrawBottomCard(Deck deck) {
		super("draw_bottom_card");
		this.deck = deck;
	}

	@Override
	public void execute() {
		if(Gamenew.current_game == "") throw new CardException("ERROR: No deck");
		if(deck.size() == 0)throw new CardException("ERROR: Not enough cards in deck");
		this.deck.shuffle();
	}
	
}
