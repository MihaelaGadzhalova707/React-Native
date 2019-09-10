package org.elsys.cardgame.operation;

import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.api.Hand;
import org.elsys.cardgame.cardsagain2.Gamenew;
import org.elsys.cardgame.cardsagain2.Operations;

public class Deal extends Operations{

	Deck deck;
	Game game;
	public Deal(Deck deck) {
		super("deal");
		this.deck = deck;
	}

	@Override
	public void execute() {
		if(Gamenew.current_game == "") throw new CardException("ERROR: No deck");
		if(deck.size() == 0)throw new CardException("ERROR: Not enough cards in deck");
		Hand hand = this.deck.deal();
		this.game.setDealtHand(hand);
	}
	
	
}
