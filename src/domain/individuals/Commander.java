package domain.individuals;

import tools.Defaults;

public class Commander extends Soldier
{
    protected int abilities;

    public Commander()
    {
        super();
        this.abilities = Defaults.ABILITIES;
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
        System.out.println(age);
        System.out.println(soldierId);
        System.out.println(unitId);
        System.out.println(commanderId);
        System.out.println(health);
        System.out.println(xp);
        System.out.println(abilities);
    }
}
