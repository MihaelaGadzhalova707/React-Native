package org.elsys.cardgame.cardsagain2;

import org.elsys.cardgame.api.Operation;

public abstract class Operations implements Operation{

	String name;

	public Operations(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public abstract void execute();
	
}
