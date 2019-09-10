package org.elsys.gates;

public abstract class NandFactory {

	public static Gate makeNotGate(Wire in, Wire out, String name) {
		NandGate nandgate = new NandGate(in, in, out);
		CompositeGate gate = new CompositeGate(name);
		gate.addGate(nandgate);
		return gate;
	}

	public static Gate makeNotGate(Wire in, Wire out) {
		return makeNotGate(in, out, "NandNot");
	}

	public static Gate makeAndGate(Wire in1, Wire in2, Wire out, String name) {
		Wire in3 = new Wire(name);
		NandGate nandgate1 = new NandGate(in1, in2, in3);
		NandGate nandgate2 = new NandGate(in3, in3, out);
		CompositeGate gate = new CompositeGate(name);
		gate.addGate(nandgate1);
		gate.addGate(nandgate2);
		return gate;
	}

	public static Gate makeAndGate(Wire in1, Wire in2, Wire out) {
		return makeAndGate(in1, in2, out, "NandAnd");
	}

	public static Gate makeOrGate(Wire in1, Wire in2, Wire out, String name) {
		Wire in3 = new Wire("in3");
		Wire in4 = new Wire("in4");
		NandGate nandgate1 = new NandGate(in1, in1, in3);
		NandGate nandgate2 = new NandGate(in2, in2, in4);
		NandGate nandgate3 = new NandGate(in3, in4, out);
		CompositeGate gate = new CompositeGate(name);
		gate.addInput(in1);
		gate.addInput(in2);
		gate.addInput(in3);
		gate.addInput(in4);
		gate.addOutput(out);
		gate.addGate(nandgate1);
		gate.addGate(nandgate2);
		gate.addGate(nandgate3);
		return gate;
	}

	public static Gate makeOrGate(Wire in1, Wire in2, Wire out) {
		return makeOrGate(in1, in2, out, "NandOr");
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out, String name) {
		Wire in3 = new Wire("in3");
		Wire in4 = new Wire("in4");
		Wire in5 = new Wire("in5");
		NandGate nandgate1 = new NandGate(in1, in2, in3);
		NandGate nandgate2 = new NandGate(in1, in3, in4);
		NandGate nandgate3 = new NandGate(in2, in3, in5);
		NandGate nandgate4 = new NandGate(in4, in5, out);
		CompositeGate gate = new CompositeGate(name);	
		gate.addGate(nandgate1);
		gate.addGate(nandgate2);
		gate.addGate(nandgate3);
		gate.addGate(nandgate4);
		return gate;
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out) {
		return makeXorGate(in1, in2, out, "NandXor");
	}

}
