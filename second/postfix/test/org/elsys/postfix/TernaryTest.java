package org.elsys.postfix;

import java.util.EmptyStackException;

import org.junit.Test;

public class TernaryTest extends CalculatorAbstractTest {

	@Test(expected = EmptyStackException.class)
	public void testWithNotEnoughValuesInStack() {
		input("11");
		input("\\*-\\*");
		inputCtrlC();
		runCalculator();
	}

	@Test
	public void test() {
		input("10");
		input("10");
		input("10");
		input("\\*-\\*");
		//input("\\*");
		inputCtrlC();
		runCalculator();
		assertCalculatorLastValue(-1000);
		assertCalculatorStackSize(1);
	}
}
 