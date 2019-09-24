package fr.umlv.fight;

import java.util.Objects;
import java.lang.StringBuilder;

public class Robot
{
    private String name;
    private int healthPoints;
    private int firePower;

    public Robot(String name)
    {
        this.name = Objects.requireNonNull(name);
        this.healthPoints = 10;
        this.firePower = 2;
    }

    public String getName()
    {
        return this.name;
    }

    public int getHealthPoints()
    {
        return this.healthPoints;
    }

    public void fire(Robot target)
    {
        if(target.isDead())
        {
            /**
             * This function should not be called when the target is already Dead
             * The problem would be the argument so we use IllegalArgumentException
             */
            throw new IllegalArgumentException(target.toString() + " is already Dead !");
        }

        StringBuilder fireStr = new StringBuilder();

        if(this.aim())
        {
            target.healthPoints -= this.firePower;

            fireStr.append(this);
            fireStr.append(" has touched ");
            fireStr.append(target);
            fireStr.append("!");

            System.out.println(fireStr);
        }
        else
        {
            fireStr.append("oops, ");
            fireStr.append(this);
            fireStr.append(" has failed the shot !");

            System.out.println(fireStr);
        }
    }

    public boolean isDead()
    {
        return this.healthPoints <= 0;
    }

    /**
     * This is the rollDice() method, which had been already implemented
     * before reading the rollDice() part
     */
    protected boolean aim()
    {
        return true;
    }

    public void revive()
    {
        this.healthPoints = 10;
    }

    @Override
    public String toString()
    {
        StringBuilder nameStr = new StringBuilder();

        nameStr.append("Robot ");
        nameStr.append(this.name);

        return nameStr.toString();
    }
}
