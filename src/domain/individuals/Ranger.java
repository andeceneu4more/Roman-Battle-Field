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
}
