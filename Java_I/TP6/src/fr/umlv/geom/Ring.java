package fr.umlv.geom;

public class Ring extends Circle
{
    private final int internalRadius;

    public Ring(Point center, int radius, int internalRadius)
    {
        super(center, radius);

        if(internalRadius >= radius)
        {
            throw new IllegalArgumentException("wrong radius values");
        }

        this.internalRadius = internalRadius;
    }

    @Override
    public String toString()
    {
        StringBuilder ringStr = new StringBuilder();

        ringStr.append(super.toString());
        ringStr.append("\tiR = ");
        ringStr.append(this.internalRadius);

        return ringStr.toString();
    }

    @Override
    public boolean contains(Point p)
    {
        double distance = p.getDistance(getCenter());

        return (distance <= getRadius()) && !(distance <= internalRadius);
    }

    public boolean contains(Point point, Ring... rings)
    {
        for(Ring ring : rings)
        {
            if(ring.contains(point))
            {
                return true;
            }
        }
        return false;
    }
}
