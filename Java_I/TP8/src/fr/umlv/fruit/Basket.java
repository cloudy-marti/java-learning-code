package fr.umlv.fruit;

import java.util.ArrayList;

public class Basket
{
    private ArrayList<FruitQuantity> fruitsBasket;

    public Basket()
    {
        fruitsBasket = new ArrayList<>();
    }

    public void add(Fruit fruit)
    {
        add(fruit, 1);
    }

    public void add(Fruit fruit, int numberOfFruits)
    {
        if(numberOfFruits <= 0)
        {
            throw new IllegalArgumentException("cannot add zero fruits or less");
        }

        int index = fruitsBasket.indexOf(new FruitQuantity(fruit));

        if(index == -1)
        {
            fruitsBasket.add(new FruitQuantity(fruit, numberOfFruits));
        }
        else
        {
            fruitsBasket.get(index).setQuantity(numberOfFruits);
        }
    }

    @Override
    public String toString()
    {
        StringBuilder basketStr = new StringBuilder();

        float price = 0;

        for(FruitQuantity fruit : fruitsBasket)
        {
            basketStr.append(fruit);
            price += fruit.getPrice();
        }

        basketStr.append("\nprice : ");
        basketStr.append(price);

        basketStr.append("\n");

        return basketStr.toString();
    }
}
