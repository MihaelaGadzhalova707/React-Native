package org.elsys.postfix.operations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.elsys.postfix.Calculator;

public class CompositeOperation extends AbstractOperation {

	private List<Operation> operations = new ArrayList<Operation>();
	
	public CompositeOperation(Calculator calculator, String token) {
		super(calculator, token);
	}

	@Override
	public void calculate() {
		Iterator<Operation> x = operations.iterator();
		while(x.hasNext()) {
			x.next().calculate();
		}
	}
	
	public void addOperation(Operation op) {
		operations.add(op);
	}

}
