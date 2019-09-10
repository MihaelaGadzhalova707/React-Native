package org.elsys.part1;

public abstract class AbstractBallContainer {
	public abstract boolean add(Ball b);
	public abstract boolean remove(Ball b);
	public abstract double getVolume();
	public abstract int size();
	public abstract void clear();
	public abstract boolean contains(Ball b);
	
}
