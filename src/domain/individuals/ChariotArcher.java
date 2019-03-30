package domain.individuals;

import tools.Defaults;

public class ChariotArcher extends Archer
{
    protected double speed;
    protected double cooldown;

    public ChariotArcher()
    {
        super();
        this.speed = Defaults.chariotSpeed;
        this.cooldown = Defaults.chariotCooldown;
    }

    public void setSpeed(float speed)
    {
        this.speed = speed;
    }

    public void setCooldown(double cooldown)
    {
        this.cooldown = cooldown;
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
        System.out.println(rangeDamage);
        System.out.println(criticalHitRate);
        System.out.println(speed);
        System.out.println(cooldown);
    }

    public double rating()
    {
        double turn = Defaults.standardTime / cooldown;
        double rating = criticalHitRate * turn + (1 - criticalHitRate) * turn * (rangeDamage + speed);
        double xpRatio = (1 + ((xp - Defaults.minimumXP) / (Defaults.maximumXP - Defaults.minimumXP)));
        rating = xpRatio * rating;
        return rating;
    }
}
