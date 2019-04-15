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
        if(this.aim())
        {
            target.healthPoints -= this.firePower;
            System.out.println(this + " has touched " + target + "!");
        }
    }

    public boolean isDead()
    {
        return this.healthPoints <= 0;
    }

    public boolean aim()
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
