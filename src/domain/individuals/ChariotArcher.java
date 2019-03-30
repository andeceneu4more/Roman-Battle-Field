package domain.individuals;

import tools.Defaults;

public class ChariotArcher extends Archer
{
    protected double speed;
    protected double cooldown;

    public ChariotArcher()
    {
        super();
        this.speed = Defaults.CHARIOT_SPEED;
        this.cooldown = Defaults.CHARIOT_COOLDOWN;
    }

    public void setSpeed(double speed)
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
        System.out.println(age);
        System.out.println(soldierId);
        System.out.println(unitId);
        System.out.println(commanderId);
        System.out.println(health);
        System.out.println(xp);
        System.out.println(rangeDamage);
        System.out.println(criticalHitRate);
        System.out.println(speed);
        System.out.println(cooldown);
    }

    public double rating()
    {
        double turn = Defaults.STANDARD_TIME / cooldown;
        double rating = criticalHitRate * turn + (1 - criticalHitRate) * turn * (rangeDamage + speed);
        double xpRatio = (1 + ((xp - Defaults.MINIMUM_XP) / (Defaults.MAXIMUM_XP - Defaults.MINIMUM_XP)));
        rating = xpRatio * rating;
        return rating;
    }
}
