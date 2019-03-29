package domain.individuals;

import tools.Defaults;

public class Commander extends Soldier
{
    protected int abilities;

    public Commander()
    {
        super();
        this.abilities = Defaults.abilities;
    }

    public int getAbilities()
    {
        return abilities;
    }

    public void setAbilities(int abilities)
    {
        this.abilities = abilities;
    }
}
