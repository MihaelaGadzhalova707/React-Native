package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Literal extends AbstractOperation {

	private double value;
	
	public Literal(Calculator calculator, double value) {
		super(calculator, "literal");
		this.value = value;
	}
	@Override
	public void calculate() {
		getCalculator().addValue(this.value);
	}

}
