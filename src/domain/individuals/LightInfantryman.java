package domain.individuals;

import tools.Defaults;

public class LightInfantryman extends Soldier
{
    protected int swordDamage;
    protected int agility;

    public LightInfantryman()
    {
        super();
        this.swordDamage = Defaults.LIGHT_DAMAGE;
        this.agility = Defaults.AGILITY;
    }

    public void setSwordDamage(int swordDamage)
    {
        this.swordDamage = swordDamage;
    }

    public void setAgility(int agility)
    {
        this.agility = agility;
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
        System.out.println(agility);
    }

    public double damage()
    {
        double rating = swordDamage;
        double xpRatio = (1 + ((xp - Defaults.MINIMUM_XP) / (Defaults.MAXIMUM_XP - Defaults.MINIMUM_XP)));
        rating = xpRatio * rating;
        return rating;
    }
    public double strength()
    {
        double rating = agility;
        double xpRatio = (1 + ((xp - Defaults.MINIMUM_XP) / (Defaults.MAXIMUM_XP - Defaults.MINIMUM_XP)));
        rating = xpRatio * rating;
        return rating;
    }
}
