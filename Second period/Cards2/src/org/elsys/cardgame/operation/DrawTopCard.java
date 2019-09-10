package org.elsys.cardgame.operation;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.api.Suit;
import org.elsys.cardgame.cardsagain2.Gamenew;
import org.elsys.cardgame.cardsagain2.Operations;

public class DrawTopCard extends Operations{

	Deck deck;
	
	public DrawTopCard(Deck deck) {
		super("draw_top_card");
		this.deck = deck;
	}

	@Override
	public void execute() {
		if(Gamenew.current_game == "") throw new CardException("ERROR: No deck");
		
		Card card = deck.drawTopCard();
		String suit = card.getSuit().getSymbol();
		String rank = card.getRank().getSymbol();
		System.out.println(suit + rank);
	}
	
}
