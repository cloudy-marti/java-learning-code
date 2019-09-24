package fr.umlv.fruit;

import java.util.Objects;

class FruitQuantity
{
    private final Fruit fruit;
    private int quantity;

    public FruitQuantity(Fruit newFruit)
    {
        fruit = newFruit;
        quantity = 0;
    }

    public FruitQuantity(Fruit newFruit, int number)
    {
        fruit = newFruit;
        quantity = number;
    }

    public Fruit getFruit()
    {
        return fruit;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int number)
    {
        quantity += number;
    }

    public float getPrice()
    {
        return fruit.getPrice() * quantity;
    }

    @Override
    public String toString()
    {
        return fruit.toString() + "x " + quantity + "\n";
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FruitQuantity that = (FruitQuantity) o;
        return Objects.equals(fruit, that.fruit);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(fruit);
    }
}
