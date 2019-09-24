package fr.umlv.geom;

public class Point
{
	private int x;
	private int y;

	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	@Override
	public String toString()
	{
		return "(" + x + ", " + y + ')';
	}

	/**
	 * Get the distance using Pythagorean theorem
	 */
	public double getDistance(Point point)
	{
		return Math.sqrt(((x - point.getX())*(x - point.getX())) + ((y - point.getY())*(y - point.getY())));
	}

	public boolean equals(Point point)
	{
		return (x == point.getX()) && (y == point.getY());
	}

	public void translate(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
}
