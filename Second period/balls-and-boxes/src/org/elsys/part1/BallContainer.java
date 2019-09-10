package org.elsys.part1;

import java.util.ArrayList;
import java.util.List;

public class BallContainer extends AbstractBallContainer{

	List<Ball> balls = new ArrayList<>();
	public BallContainer() {
	}

	/** 
	 * Adds a ball to the container.
	 * @param b the Ball to be added
	 * @return true if b was successfully added
	 */
	public boolean add(Ball b) {
		return balls.add(b);
	}

	/**
	 * Removes a ball from the container.
	 * @param b the Ball to be removed
	 * @return true if b was present in the collection
	 */
	public boolean remove(Ball b) {
		return balls.remove(b);
	}

	/**
	 * Returns the sum of the volumes of all balls in the container.
	 * @return
	 */
	public double getVolume() {
		double sum = 0.00;
		for(Ball ball : balls)
		{
			sum+=ball.getVolume();
		}
		
		return sum;
	}

	/**
	 * Returns the total count of balls in the container.
	 * @return
	 */
	public int size() {
		return balls.size();
	}

	/**
	 *  Removes all balls from the container.
	 */
	public void clear() {
		balls.clear();
	}

	/**
	 * Checks whether a Ball is present in the container.
	 * @param b the Ball to check
	 * @return true if b is present
	 */
	public boolean contains(Ball b) {
		return balls.contains(b);
	}

}