package domain.units;

import domain.individuals.Commander;
import domain.individuals.Soldier;

public abstract class Unit
{
    protected static int generalUnitId = 0;
    protected long meleeStrength;
    protected long rangedStrength;
    protected double damage;
    protected Commander commander;
    protected int unitId;

    public int getUnitId()
    {
        return unitId;
    }

    public Commander getCommander()
    {
        return commander;
    }

    public void printAtributes()
    {
        System.out.println(rangedStrength);
        System.out.println(meleeStrength);
        System.out.println(damage);
    }
    public abstract void rating();

    public abstract void printUnit();

    public abstract Soldier getSoldierById(int id);

    public abstract int getSoldierNumber();
}
