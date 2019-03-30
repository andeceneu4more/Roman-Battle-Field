package domain.units;

import domain.individuals.Commander;

public abstract class Unit
{
    protected static int generalUnitID = 0;
    protected long meleeStrength;
    protected long rangedStrength;
    protected double damage;
    protected Commander commander;
    protected int unitID;

    public void printAtributes()
    {
        System.out.println(meleeStrength);
        System.out.println(rangedStrength);
        System.out.println(damage);
    }
}
