package domain.units;

import domain.individuals.Soldier;
import services.Fate;
import tools.Defaults;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class Unit
{
    protected static int generalUnitId = 0;
    protected long meleeStrength;
    protected long rangedStrength;
    protected double damage;
    protected int discipline;
    protected int unitId;

    public int getDiscipline()
    {
        return discipline;
    }

    public abstract void rating();

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

    public abstract BufferedWriter writeSoldiers(BufferedWriter buffer) throws IOException;

    //    public abstract void decimate(int iterator);

}
