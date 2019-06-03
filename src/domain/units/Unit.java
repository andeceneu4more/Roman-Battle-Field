package domain.units;

import domain.individuals.Archer;
import domain.individuals.Soldier;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import services.Fate;
import tools.Defaults;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.SQLException;

public abstract class Unit
{
    protected static int generalUnitId = 0;
    protected long meleeStrength;
    protected long rangedStrength;
    protected double damage;
    protected int discipline;

    public int getUnitId()
    {
        return unitId;
    }

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

    public abstract void writeDataBaseSoldiers() throws SQLException, RuntimeException;

    //    public abstract void decimate(int iterator);

}
