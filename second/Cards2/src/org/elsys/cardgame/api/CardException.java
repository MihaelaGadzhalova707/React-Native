package org.elsys.cardgame.api;

public class CardException extends RuntimeException {

	/**
	 * 
	 */
	
	String error;
	
	public CardException(String error) {
		this.error = error;
	}
	
	public String getError() {
		return this.error;
	}

	private static final long serialVersionUID = 8822513014262189134L;

}
