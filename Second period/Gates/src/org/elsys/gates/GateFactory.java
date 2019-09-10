package org.elsys.gates;

public abstract class GateFactory {

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out, String name) {
		CompositeGate xorGate = new CompositeGate(name);

		xorGate.addInput(in1);
		xorGate.addInput(in2);
		xorGate.addOutput(out);

		Wire a = new Wire("xorA");
		Wire b = new Wire("xorB");
		Wire c = new Wire("xorC");

		Gate orGate = new OrGate(in1, in2, a);
		Gate andGate1 = new AndGate(in1, in2, b);
		Gate notGate = new InverterGate(b, c);
		Gate andGate2 = new AndGate(a, c, out);

		xorGate.addGate(orGate);
		xorGate.addGate(andGate1);
		xorGate.addGate(notGate);
		xorGate.addGate(andGate2);

		return xorGate;
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out) {
		return makeXorGate(in1, in2, out, "XorGate");
	}

	public static Gate makeHalfAdder(Wire a, Wire b, Wire s, Wire c, String name) {
		CompositeGate gate = new CompositeGate(name);
		XorGate xor = new XorGate(a,b,s);
		AndGate and = new AndGate(a,b,c);
		gate.addInput(a);
		gate.addInput(b);
		gate.addOutput(s);
		gate.addOutput(c);
		gate.addGate(xor);
		gate.addGate(and);
		return gate;
	}

	public static Gate makeHalfAdder(Wire a, Wire b, Wire s, Wire c) {
		return makeHalfAdder(a, b, s, c, "HalfAdder");
	}

	public static Gate makeFullAdder(Wire a, Wire b, Wire cIn, Wire sum, Wire cOut, String name) {
		CompositeGate gate = new CompositeGate(name);
		Wire connect = new Wire("connect");
		Wire firstConnection = new Wire("firstConnection");
		Wire secondConnection = new Wire("secondConnection");
		gate.addGate(makeHalfAdder(a,b,connect,firstConnection));
		gate.addGate(makeHalfAdder(connect,cIn,sum,secondConnection));
		OrGate output = new OrGate(firstConnection, secondConnection, cOut);
		gate.addGate(output);
		gate.addInput(a);
		gate.addInput(b);
		gate.addInput(cIn);
		gate.addOutput(sum);
		gate.addOutput(cOut);
		return gate;
	}

	public static Gate makeFullAdder(Wire a, Wire b, Wire cIn, Wire sum, Wire cOut) {
		return makeFullAdder(a, b, cIn, sum, cOut, "FullAdder");
	}

	public static Gate makeRippleCarryAdder(Wire a[], Wire b[], Wire cIn, Wire sum[], Wire cOut) {
		assert a.length == b.length;
		assert a.length == sum.length;
		int count = a.length;
		CompositeGate gate = new CompositeGate("RippleCarryAdder");
		Wire[] cout = new Wire[count + 1];
		for(int i = 1; i < count; i++) {
			cout[i] = new Wire("Cout" + i);
		}
		gate.addInput(cout[0] = cIn);
		gate.addInput(cout[cout.length - 1] = cOut);

		for(int k = 0; k < count; k++) {
			gate.addInput(a[k]);
			gate.addInput(b[k]);
			gate.addOutput(sum[k]);
			gate.addGate(makeFullAdder(a[k],b[k],cout[k],sum[k],cout[k+1]));
		}
		return gate;
	}
}
