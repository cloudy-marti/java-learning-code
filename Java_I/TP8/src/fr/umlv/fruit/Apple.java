package fr.umlv.fruit;

import java.util.Objects;

public class Apple implements Fruit
{
    private float weight;
    private AppleKind variety;

    public Apple(float appleWeight, AppleKind appleVariety)
    {
        weight = appleWeight;
        variety = appleVariety;
    }

    public AppleKind getVariety()
    {
        return variety;
    }

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public float getPrice()
    {
        return weight / 2;
    }

    @Override
    public String toString()
    {
        StringBuilder appleStr = new StringBuilder();

        appleStr.append(variety);
        appleStr.append(" ");
        appleStr.append(getWeight());
        appleStr.append(" g ");

        return appleStr.toString();
    }

    /**
     * IntelliJ : Code -> Generate... -> equals() and hashcode()
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Float.compare(apple.weight, weight) == 0 &&
                variety == apple.variety;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, variety);
    }
}
