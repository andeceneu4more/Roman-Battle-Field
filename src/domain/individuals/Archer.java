package domain.individuals;

import tools.Defaults;

public class Archer extends Soldier
{
    protected int rangeDamage;
    protected double criticalHitRate;

    public Archer()
    {
        super();
        this.rangeDamage = Defaults.rangeDamage;
        this.criticalHitRate = Defaults.criticalHitRate;
    }

    public void setRangeDamage(int rangeDamage)
    {
        this.rangeDamage = rangeDamage;
    }

    public void setCriticalHitRate(double criticalHitRate)
    {
        this.criticalHitRate = criticalHitRate;
    }

    public void printArcher()
    {
        System.out.println(name);
        System.out.println(origin);
        System.out.println(age);
        System.out.println(soldierID);
        System.out.println(unitID);
        System.out.println(commanderID);
        System.out.println(health);
        System.out.println(xp);
        System.out.println(rangeDamage);
        System.out.println(criticalHitRate);
    }

    public double archerRating()
    {
        double rating = criticalHitRate * Defaults.standardTime + (1 - criticalHitRate) * rangeDamage;
        double ageRatio = (1 + ((age - Defaults.minimumAge) / (Defaults.maximumAge - Defaults.minimumAge)));
        rating = ageRatio * rating;
        double xpRatio = (1 + ((xp - Defaults.minimumXP) / (Defaults.maximumXP - Defaults.minimumXP)));
        rating = xpRatio * rating;
        return rating;
    }
}
