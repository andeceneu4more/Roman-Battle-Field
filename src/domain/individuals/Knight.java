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
}
