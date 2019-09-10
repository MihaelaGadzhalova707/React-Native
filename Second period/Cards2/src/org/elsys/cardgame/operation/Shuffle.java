package org.elsys.cardgame.operation;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.cardsagain2.Gamenew;
import org.elsys.cardgame.cardsagain2.Operations;

public class Shuffle extends Operations{

	Deck deck;

	public Shuffle(Deck deck) {
		super("shuffle");
		this.deck = deck;
	}

	@Override
	public void execute() {
		if(Gamenew.current_game == "") throw new CardException("ERROR: No deck");
		this.deck.shuffle();
	}
	
}
