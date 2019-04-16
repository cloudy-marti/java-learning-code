package fr.umlv.fight;

import java.util.Random;
import java.lang.String;
import java.lang.StringBuilder;

public class Fighter extends Robot
{
    private Random randomSeed;
    private int firePower;

    public Fighter(String name, int seed)
    {
        super(name);
        this.randomSeed = new Random(seed);
        this.firePower = 12;
    }

    @Override
    public String toString()
    {
        StringBuilder nameStr = new StringBuilder();

        nameStr.append("Fighter ");
        nameStr.append(super.getName());

        return nameStr.toString();
    }

    @Override
    protected boolean aim()
    {
        return this.randomSeed.nextBoolean();
    }
}
