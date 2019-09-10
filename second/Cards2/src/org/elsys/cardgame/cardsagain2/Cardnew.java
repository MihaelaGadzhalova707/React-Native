package org.elsys.cardgame.cardsagain2;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.api.Suit;

public class Cardnew implements Card {
 
	private Suit suit;
	private Rank rank;
	
	
	public Cardnew(Rank rank, Suit suit) {
		this.suit = suit;
		this.rank = rank;
	}
	
	@Override
	public Suit getSuit() {
		return this.suit;
	}

	@Override
	public Rank getRank() {
		return this.rank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cardnew other = (Cardnew) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	


	
}