package domain.individuals;

import tools.Defaults;

public class Knight extends Soldier
{
    protected int swordDamage;
    protected double speed;

    public Knight()
    {
        super();
        this.swordDamage = Defaults.KNIGHT_DAMAGE;
        this.speed = Defaults.KNIGHT_SPEED;
    }

    public void setSwordDamage(int swordDamage)
    {
        this.swordDamage = swordDamage;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
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
        System.out.println(swordDamage);
        System.out.println(speed);
    }

    public double rating()
    {
        double rating = swordDamage + speed;
        double xpRatio = (1 + ((xp - Defaults.MINIMUM_XP) / (Defaults.MAXIMUM_XP - Defaults.MINIMUM_XP)));
        rating = xpRatio * rating;
        return rating;
    }

    public void train(double impact)
    {
        swordDamage = (int) Math.round((1 + impact) * swordDamage);
        speed = (1 + impact) * speed;
    }
}
