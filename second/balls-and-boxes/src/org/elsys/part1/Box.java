package org.elsys.part1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box extends BallContainer {

	List<Ball> balls = new ArrayList<>();
	public Box(double capacity) {
	}

	public Iterator<Ball> getBallsFromSmallest() {
		return null;
	}
	
	public boolean add(Ball b) {
		return balls.add(b);
	}

	public boolean remove(Ball b) {
		return balls.remove(b);
	}

	public double getVolume() {
		double sum = 0.00;
		for(Ball ball : balls)
		{
			sum+=ball.getVolume();
		}
		
		return sum;
	}

	public int size() {
		return balls.size();
	}

	public void clear() {
		balls.clear();
	}

	public boolean contains(Ball b) {
		return balls.contains(b);
	}

}