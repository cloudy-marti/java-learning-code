package fr.umlv.fight;

public class Arena
{
    public Arena()
    {

    }

    private Robot getWinner(Robot first, Robot second)
    {
        Robot winner;

        if(first.isDead())
            winner = second;
        else
            winner = first;

        return winner;
    }

    private Robot getLoser(Robot first, Robot second)
    {
        Robot loser;

        if(first.isDead())
            loser = first;
        else
            loser = second;

        return loser;
    }

    public Robot fight(Robot first, Robot second)
    {
        while(!first.isDead() && !second.isDead())
        {
            first.fire(second);
            second.fire(first);
        }

        Robot winner = this.getWinner(first, second);
        Robot loser = this.getLoser(first, second);

        System.out.println(loser + " has been beaten by "+ winner + " !\n");

        return winner;
    }



}
