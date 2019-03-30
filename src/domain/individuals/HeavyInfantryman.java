package domain.individuals;

import tools.Defaults;

public class HeavyInfantryman extends Soldier
{
    protected int swordDamage;
    protected int armour;

    public HeavyInfantryman()
    {
        super();
        this.swordDamage = Defaults.heavyDamage;
        this.armour = Defaults.armour;
    }

    public void setSwordDamage(int swordDamage)
    {
        this.swordDamage = swordDamage;
    }

    public void setArmour(int armour)
    {
        this.armour = armour;
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
        System.out.println(swordDamage);
        System.out.println(armour);
    }

    public double damage()
    {
        double rating = swordDamage;
        double xpRatio = (1 + ((xp - Defaults.minimumXP) / (Defaults.maximumXP - Defaults.minimumXP)));
        rating = xpRatio * rating;
        return rating;
    }
    public double strength()
    {
        double rating = armour;
        double xpRatio = (1 + ((xp - Defaults.minimumXP) / (Defaults.maximumXP - Defaults.minimumXP)));
        rating = xpRatio * rating;
        return rating;
    }
}
