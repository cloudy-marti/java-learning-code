package fr.umlv.geom;

public class Circle
{
    private final Point center;
    private final int radius;

    public Circle(Point center, int radius)
    {
        this.center = new Point(center.getX(), center.getY());
        this.radius = radius;
    }

    @Override
    public String toString()
    {
        StringBuilder circleStr = new StringBuilder();

        circleStr.append("C = (");
        circleStr.append(this.center.getX());
        circleStr.append(",");
        circleStr.append(this.center.getY());
        circleStr.append(")\t R = ");
        circleStr.append(this.radius);
        circleStr.append("\t S = ");
        circleStr.append(surface());

        return circleStr.toString();
    }

    public void translate(int dx, int dy)
    {
        this.center.translate(dx, dy);
    }

    public Point getCenter()
    {
        return new Point(center.getX(), center.getY());
    }

    public int getRadius()
    {
        return this.radius;
    }

    public double surface()
    {
        return Math.PI * radius * radius;
    }

    public boolean contains(Point p)
    {
        return p.getDistance(getCenter()) <= getRadius();
    }

    public boolean contains(Point p, Circle... circles)
    {
        for(Circle circle : circles)
        {
            if(circle.contains(p))
            {
                return true;
            }
        }
        return false;
    }
}
