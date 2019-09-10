package org.elsys.part1;

public class Ball {

	private double volume;
	private Color color;
	
	public Ball(double volume, Color color) {
		this.volume = volume;
		this.color = color;
	}

	public Ball(double volume) {
		this.volume = volume;
		this.color = Color.WHITE;
		
	}

	public double getVolume() {
		return volume;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		long temp;
		temp = Double.doubleToLongBits(volume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ball other = (Ball) obj;
		if (color != other.color)
			return false;
		if (Double.doubleToLongBits(volume) != Double.doubleToLongBits(other.volume))
			return false;
		return true;
	}
	
}