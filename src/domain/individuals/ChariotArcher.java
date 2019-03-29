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
        double cooldown = Defaults.chariotCooldown;
    }

    public void setSpeed(float speed)
    {
        this.speed = speed;
    }

    public void setCooldown(double cooldown)
    {
        this.cooldown = cooldown;
    }
}
