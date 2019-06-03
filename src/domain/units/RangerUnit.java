package domain.units;

import domain.individuals.Ranger;
import domain.individuals.Soldier;
import services.Fate;
import services.SoldierComparator;
import tools.Defaults;
import tools.Jdbc;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.TreeSet;

public class RangerUnit extends Unit
{
    private TreeSet<Ranger> formation;

    public RangerUnit()
    {
        this.unitId = ++generalUnitId;
        this.formation = new TreeSet <Ranger>(new SoldierComparator());
    }

    public void addSoldier(Ranger element)
    {
        element.setUnitId(unitId);
        formation.add(element);
    }

    public void rating()
    {
        try
        {
            double rating = 0;
            for (Ranger element : formation)
                rating += element.rating();
            double commanderRatio = (1 + ((discipline - Defaults.MINIMUM_DISCIPLINE) /
                    (Defaults.MAXIMUM_DISCIPLE - Defaults.MINIMUM_DISCIPLINE)));

            rating = commanderRatio * rating;
            rating = discipline * rating;
            rangedStrength = Math.round(Defaults.RANGER_RANGED_RATIO * rating);
            meleeStrength = Math.round(Defaults.RANGER_MELEE_RATIO * rating);
            damage = Defaults.RANGER_DAMAGE_RATIO * rating;
        }
        catch (ArithmeticException exception)
        {
            exception.printStackTrace();
        }
    }

    public Soldier getSoldierById(int id)
    {
        for (Ranger element : formation)
        {
            if (element.getSoldierId() == id)
                return element;
        }
        return null;
    }

    public int getUnitSize()
    {
        return formation.size();
    }

    public void killSoldierById(int id)
    {
        for (Ranger wanted : formation)
        {
            if (wanted.getSoldierId() == id)
            {
                formation.remove(wanted);
                break;
            }
        }
    }

    public Ranger getRandomSoldier()
    {
        int index = (int) Math.round(Math.random() * (formation.size() - 1));
        for (Ranger element : formation)
        {
            if (index == 0)
            {
                return element;
            }
            index--;
        }
        return null;
    }

    public void trainSoldiers(Fate fate)
    {
        if (discipline + Defaults.DISCIPLINE_STEP < Defaults.MAXIMUM_DISCIPLE)
            discipline += Defaults.DISCIPLINE_STEP;
        double impact = (fate.getWeather() + fate.getMotivation() + fate.getTerrain()) / Defaults.FACTORS;
        // uniform training
        double uniformImpact = impact * Defaults.UNIFORM_RATIO;
        for(Ranger element : formation)
            element.trainSoldier(uniformImpact);
        // biased training
        double biasedImpact = impact * Defaults.BIASED_RATIO;
        int sample = (int) Math.round(getUnitSize() * Defaults.BIASED_PERCENT);
        for (int i = 0; i < sample; i++)
        {
            getRandomSoldier().train(biasedImpact);
        }
    }

    public void rest()
    {
        for (Ranger element : formation)
            element.rest();
    }

    public void nextFewYears(int years)
    {
        for (Ranger element : formation)
        {
            element.nextFewYears(years);
            if (element.ifRetired())
            {
                formation.remove(element);
            }
        }
    }

    public BufferedWriter writeSoldiers(BufferedWriter buffer) throws IOException
    {
        String line;
        for (Ranger element : formation)
        {
            line = element.getSoldierData().toString();
            buffer.write(line,0, line.length());
            buffer.newLine();
        }
        return buffer;
    }
    public void writeDataBaseSoldiers() throws RuntimeException
    {
        PreparedStatement stmt;
        for (Ranger element : formation)
        {
            stmt = element.insertSoldier();
            Jdbc.executeStatement(stmt);
        }
    }
}
