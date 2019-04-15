package fr.umlv.fight;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Robot bob = new Robot("DRD2");
        System.out.println("This is " + bob);

        Robot foo = new Robot("Data");
        System.out.println("This is " + foo + "\n");

        Arena arena = new Arena();

        Robot winner = arena.fight(bob, foo);

        Random seed = new Random();

        Fighter kyle = new Fighter("Kyle", seed.nextInt());
        System.out.println("This is " + kyle + "\n");

        winner.revive();

        winner = arena.fight(winner, kyle);
    }
}
