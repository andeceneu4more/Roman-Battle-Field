package domain.individuals;

import tools.Defaults;

public class Ranger extends Soldier
{
    protected double survivalRate;
    protected int stealth;

    public Ranger()
    {
        this.survivalRate = Defaults.SURVIVAL_RATE;
        this.stealth = Defaults.STEALTH;
    }

    public void setSurvivalRate(double survivalRate)
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
        System.out.println(age);
        System.out.println(soldierId);
        System.out.println(unitId);
        System.out.println(health);
        System.out.println(xp);
        System.out.println(survivalRate);
        System.out.println(stealth);
    }

    public double rating()
    {
        double rating = survivalRate * Defaults.STANDARD_TIME + (1 - survivalRate) *
                Defaults.STANDARD_TIME;
        rating = stealth * rating;
        double xpRatio = (1 + ((xp - Defaults.MINIMUM_XP) / (Defaults.MAXIMUM_XP - Defaults.MINIMUM_XP)));
        rating = xpRatio * rating;
        return rating;
    }

    public void train(double impact)
    {
        stealth = (int) Math.round((1 + impact) * stealth);
        survivalRate = (1 + impact) * survivalRate;
    }
}
