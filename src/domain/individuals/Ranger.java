package domain.individuals;

import tools.Defaults;

public class Ranger extends Soldier
{
    protected double survivalRate;
    protected int stealth;

    public Ranger()
    {
        this.survivalRate = Defaults.survivalRate;
        this.stealth = Defaults.stealth;
    }

    public void setSurvivalRate(float survivalRate)
    {
        this.survivalRate = survivalRate;
    }

    public void setStealth(int stealth)
    {
        this.stealth = stealth;
    }

    public void printSoldier()
    {
        System.out.println(name);
        System.out.println(origin);
        System.out.println(age);
        System.out.println(soldierID);
        System.out.println(unitID);
        System.out.println(commanderID);
        System.out.println(health);
        System.out.println(xp);
        System.out.println(survivalRate);
        System.out.println(stealth);
    }
}
