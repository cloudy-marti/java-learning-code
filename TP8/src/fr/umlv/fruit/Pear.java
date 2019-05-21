package fr.umlv.fruit;

import java.util.Objects;

public class Pear implements Fruit
{
    private float weight;
    private int juiceFactor;

    public Pear(float pearWeight, int pearJuiceFactor)
    {
        weight = pearWeight;
        juiceFactor = pearJuiceFactor;
    }

    public int getJuiceFactor()
    {
        return juiceFactor;
    }

    @Override
    public float getWeight()
    {
        return weight;
    }

    @Override
    public float getPrice()
    {
        return 3 * juiceFactor;
    }

    @Override
    public String toString()
    {
        StringBuilder pearStr = new StringBuilder();

        pearStr.append(juiceFactor);
        pearStr.append("\t");
        pearStr.append(getWeight());
        pearStr.append(" g ");

        return pearStr.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pear pear = (Pear) o;
        return Float.compare(pear.weight, weight) == 0 &&
                juiceFactor == pear.juiceFactor;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), juiceFactor);
    }
}
