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
        System.out.println(abilities);
    }
}
