package domain.units;

import domain.individuals.Soldier;
import services.Fate;
import tools.Defaults;

public abstract class Unit
{
    protected static int generalUnitId = 0;
    protected long meleeStrength;
    protected long rangedStrength;
    protected double damage;
    protected double discipline;
    protected int abilities;
    protected int unitId;

    public int getUnitId()
    {
        return unitId;
    }


    public void printAtributes()
    {
        System.out.println(rangedStrength);
        System.out.println(meleeStrength);
        System.out.println(damage);
        System.out.println(discipline);
    }
    public abstract void rating();

    public abstract void printUnit();

    public Unit()
    {
        this.discipline = Defaults.DISCIPLINE;
    }

    public abstract Soldier getSoldierById(int id);

    public abstract int getUnitSize();

    public abstract void killSoldierById(int id);

    public abstract Soldier getRandomSoldier();

    public abstract void trainSoldiers(Fate fate);

    public abstract void rest();

    public abstract void nextFewYears(int years);

//    public abstract void decimate(int iterator);
}
