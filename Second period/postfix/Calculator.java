package org.elsys.postfix;

import org.elsys.postfix.operations.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Calculator {

	private Map<String, Operation> operations = new HashMap<>();

	private List<Double> stack = new LinkedList<>();

	private InputStream in;

	private PrintStream out;
	
	public Calculator(InputStream in, PrintStream out) {
		this.in = in;
		this.out = out;
		addOperation(new Negate(this));
		addOperation(new Duplicate(this));
		addOperation(new Sin(this));
		addOperation(new Cos(this));
		addOperation(new Plus(this));
		addOperation(new Minus(this));
		addOperation(new Division(this));
		addOperation(new Multiplication(this));
		addOperation(new Ternary(this));
		addOperation(new Swap(this));
		addOperation(new Rotate(this));
	}

	public void run() {
		String input;
		try (Scanner scanner = new Scanner(in)) {
			while (scanner.hasNext()) {
				out.print(stack.size() + ": ");
				input = scanner.next();
				if (isDouble(input)) {
					stack.add(Double.valueOf(input));
				} else if (input.charAt(0) == '\\' && !(input.equals("\\*-\\*"))) {
							define_new_operation(input.substring(1), scanner);
						
				} else {
					Operation operation = getOperation(input);
					if (operation != null) {
						try {
                            operation.calculate();
                        }
                        catch(IndexOutOfBoundsException e)
                        {
                            throw new EmptyStackException();
                        }
					} else {
						throw new UnsupportedOperationException();
					}
				}
			}
			scanner.close();
		}
	}
	private static boolean isDouble(String input) {
		try {
			Double.valueOf(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public void addOperation(Operation operation) {

		operations.put(operation.getToken(), operation);
	}

	public Operation getOperation(String token) {
		return operations.get(token);
	}

	public Double popValue() {
		int lastIndex = stack.size() - 1;
		Double value = stack.get(lastIndex);
		stack.remove(lastIndex);
		return value;
	}

	Double lastValue() {

		return stack.get(stack.size() - 1);
	}

	public void addValue(double value) {
		out.println(value);
		stack.add(value);
	}

	int stackSize() {
		return stack.size();
	}
	
	void define_new_operation (String operation_name, Scanner scanner) {
		CompositeOperation compose = new CompositeOperation(this,operation_name);
		while(scanner.hasNext()) {
			String input = scanner.next();
			if(!(input.equals("def"))) {
				if(isDouble(input)) {
					double literal = Double.valueOf(input);
					compose.addOperation(new Literal(this,literal));
				}else {
					compose.addOperation(getOperation(input));
				}
			} else break;
		}
		addOperation(compose);
	}
}

