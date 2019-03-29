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
}
