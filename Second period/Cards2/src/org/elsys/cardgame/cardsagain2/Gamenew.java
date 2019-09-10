package org.elsys.cardgame.cardsagain2;

import java.util.ArrayList;
import java.util.List;

import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.api.Hand;
import org.elsys.cardgame.api.Operation;

public class Gamenew implements Game{

	public static String current_game = "";
	private Deck deck;
	private Hand hand;
	private List<Operation> operations = new ArrayList<Operation>();
	
	public Gamenew(Deck deck) {
		this.deck = deck;
	}

	@Override
	public Deck getDeck() {
		return this.deck;
	}

	@Override
	public Hand getDealtHand() {
		return this.hand;
	}

	@Override
	public void setDealtHand(Hand hand) {
		this.hand = hand;
	}

	@Override
	public void process(String command) {
		for(Operation operation : operations) {
			if(operation.getName().equals(command)) {
				operation.execute();
			}
		}
	}

	@Override
	public void addOperation(Operation operation) {
		operations.add(operation);
	}	
}
