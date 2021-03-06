package org.elsys.cardgame.operation;

import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.cardsagain2.Gamenew;
import org.elsys.cardgame.cardsagain2.Operations;

public class Sort extends Operations{

	Deck deck;

	public Sort(Deck deck) {
		super("sort");
		this.deck = deck;
	}

	@Override
	public void execute() {
		if(Gamenew.current_game == "") throw new CardException("ERROR: No deck");
		this.deck.sort();
	}
	
}
