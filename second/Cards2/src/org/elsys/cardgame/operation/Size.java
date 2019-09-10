package org.elsys.cardgame.operation;

import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.cardsagain2.Gamenew;
import org.elsys.cardgame.cardsagain2.Operations;

public class Size extends Operations{
	Deck deck;

	public Size(Deck deck) {
		super("size");
		this.deck = deck;
	}

	@Override
	public void execute() {
		if(Gamenew.current_game == "") throw new CardException("ERROR: No deck");
		System.out.println(this.deck.size());
	}
	
	
}
