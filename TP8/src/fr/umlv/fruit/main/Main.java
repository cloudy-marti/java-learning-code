package fr.umlv.fruit.main;

import fr.umlv.fruit.*;

import java.util.HashSet;

public class Main
{
    public static void main(String... args)
    {
        Apple apple1 = new Apple(20, AppleKind.Golden);
        Apple apple2 = new Apple(40, AppleKind.Pink_Lady);

        Pear pear = new Pear(10, 5);

        Basket basket = new Basket();

        basket.add(apple1, 5);
        basket.add(apple2);
        basket.add(pear, 7);

        basket.add(pear, 3);

        System.out.println(basket);

        HashSet<Apple> set = new HashSet<>();
        set.add(new Apple(20, AppleKind.Golden));
        System.out.println(set.contains(new Apple(20, AppleKind.Golden)));
    }
}
