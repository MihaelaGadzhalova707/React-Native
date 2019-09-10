package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;
import java.lang.Math;
public class Cos extends UnaryOperation implements Operation {

	public Cos(Calculator calculator) {
		super(calculator, "cos"); 
	}
	
	@Override
	protected double doCalculate(double value) {
		return Math.cos(value);
	}

}
