package domain.individuals;

import tools.Defaults;

public class LightInfantryman extends Soldier
{
    protected int swordDamage;
    protected int agility;

    public LightInfantryman()
    {
        super();
        this.swordDamage = Defaults.lightDamage;
        this.agility = Defaults.agility;
    }

    public void setSwordDamage(int swordDamage)
    {
        this.swordDamage = swordDamage;
    }

    public void setAgility(int agility)
    {
        this.agility = agility;
    }
}
