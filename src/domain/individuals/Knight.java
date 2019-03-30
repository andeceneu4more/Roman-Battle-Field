package domain.individuals;

import tools.Defaults;

public class Knight extends Soldier
{
    protected int swordDamage;
    protected double speed;

    public Knight()
    {
        super();
        this.swordDamage = Defaults.knightDamage;
        this.speed = Defaults.knightSpeed;
    }

    public void setSwordDamage(int swordDamage)
    {
        this.swordDamage = swordDamage;
    }

    public void setSpeed(float speed)
    {
        this.speed = speed;
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
        System.out.println(speed);
    }
}
