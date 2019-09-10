package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Swap extends AbstractOperation implements Operation {

	public Swap(Calculator calculator) {
		super(calculator, "swap");
	}
	
	@Override
	public void calculate() {
		double value = getCalculator().popValue();
		double value1 = getCalculator().popValue();
		getCalculator().addValue(value);
		getCalculator().addValue(value1);
	}

} 
