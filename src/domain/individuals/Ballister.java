package domain.individuals;

import tools.Defaults;

public class Ballister extends Soldier
{
    protected int watchfullness;

    public Ballister()
    {
        super();
        this.watchfullness = Defaults.WATCHFULLNESS;
    }

    public void setWatchfullness(int watchfullness)
    {
        this.watchfullness = watchfullness;
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
        System.out.println(watchfullness);
    }

    public double rating()
    {
        double rating = watchfullness;
        double xpRatio = (1 + ((xp - Defaults.MINIMUM_XP) / (Defaults.MAXIMUM_XP - Defaults.MINIMUM_XP)));
        rating = xpRatio * rating;
        return rating;
    }


}
