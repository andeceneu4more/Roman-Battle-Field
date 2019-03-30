package domain.individuals;

import tools.Defaults;

public class Archer extends Soldier
{
    protected int rangeDamage;
    protected double criticalHitRate;

    public Archer()
    {
        super();
        this.rangeDamage = Defaults.RANGE_DAMAGE;
        this.criticalHitRate = Defaults.CRITICAL_HIT_RATE;
    }

    public void setRangeDamage(int rangeDamage)
    {
        this.rangeDamage = rangeDamage;
    }

    public void setCriticalHitRate(double criticalHitRate)
    {
        this.criticalHitRate = criticalHitRate;
    }

    public void printSoldier()
    {
        System.out.println(name);
        System.out.println(age);
        System.out.println(soldierId);
        System.out.println(unitId);
        System.out.println(commanderId);
        System.out.println(health);
        System.out.println(xp);
        System.out.println(rangeDamage);
        System.out.println(criticalHitRate);
    }

    public double rating()
    {
        double rating = criticalHitRate * Defaults.STANDARD_TIME + (1 - criticalHitRate) *
                Defaults.STANDARD_TIME * rangeDamage;
        double xpRatio = (1 + ((xp - Defaults.MINIMUM_XP) / (Defaults.MAXIMUM_XP - Defaults.MINIMUM_XP)));
        rating = xpRatio * rating;
        return rating;
    }
}
