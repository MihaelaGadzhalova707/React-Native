package org.elsys.gates;
import java.util.*;
import org.elsys.gates.*;


public class Main {
	
	public static void intToWires(int val, Wire[] w) {
		for (int i = 0; i < w.length; ++i) {
			int bit = 1 << i;
			w[i].setSignal((bit & val) != 0);
		}
	}
	
	public static int wiresToInt(Wire[] w) {
		int result = 0;
		for (int i = 0; i < w.length; ++i) {
			if (w[i].getSignal()) {
				int bit = 1 << i;
				result = result | bit;
			}
		}
		return result;
	} 
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Wire[] a = new Wire[8];
		Wire[] b = new Wire[8];
		Wire[] sum = new Wire[8];
		Wire cIn = new Wire("cIn");
		Wire cOut = new Wire("cOut");
		
		int first = scan.nextInt();
		int second = scan.nextInt();
		
		for(int i = 0; i < 8; i++) {
			a[i] = new Wire("A" + i);
			b[i] = new Wire("B" + i);
			sum[i] = new Wire("Sum" + i);
		}
		GateFactory.makeRippleCarryAdder(a,b,cIn,sum,cOut);
		
		intToWires(first,a);
		intToWires(second,b);
		System.out.println(wiresToInt(sum));
		
		scan.close();
	}
	
}
