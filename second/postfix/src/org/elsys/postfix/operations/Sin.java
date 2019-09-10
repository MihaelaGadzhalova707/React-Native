package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;
import java.lang.Math;
public class Sin extends UnaryOperation implements Operation {

	public Sin(Calculator calculator) {
		super(calculator, "sin");
	}
	
	@Override
	protected double doCalculate(double value) {
		return Math.sin(value);
	}

}
 