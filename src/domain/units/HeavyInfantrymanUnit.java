package domain.units;

import domain.individuals.HeavyInfantryman;
import domain.individuals.Soldier;
import services.Fate;
import services.SoldierComparator;
import tools.Defaults;
import tools.Jdbc;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.TreeSet;

public class HeavyInfantrymanUnit extends Unit
{
    private TreeSet<HeavyInfantryman> formation;

    public HeavyInfantrymanUnit()
    {
        this.unitId = ++generalUnitId;
        this.formation = new TreeSet<HeavyInfantryman>(new SoldierComparator());
    }

    public void addSoldier(HeavyInfantryman element)
    {
        element.setUnitId(unitId);
        formation.add(element);
    }

    public void rating()
    {
        try
        {
            damage = 0;
            meleeStrength = 0;
            for (HeavyInfantryman element : formation)
            {
                damage += element.damage();
                meleeStrength += element.strength();
            }
            double commanderRatio = (1 + ((discipline - Defaults.MINIMUM_DISCIPLINE) /
                    (Defaults.MAXIMUM_DISCIPLE - Defaults.MINIMUM_DISCIPLINE)));
            rangedStrength = Math.round(Defaults.HEAVY_RANGED_RATIO * commanderRatio * meleeStrength * discipline);
            meleeStrength = Math.round(Defaults.HEAVY_MELEE_RATIO * commanderRatio * meleeStrength * discipline);
            damage = Defaults.HEAVY_DAMAGE_RATIO * commanderRatio * damage * discipline;
        }
        catch (ArithmeticException exception)
        {
            exception.printStackTrace();
        }
    }

    public Soldier getSoldierById(int id)
    {
        for (HeavyInfantryman element : formation)
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
        for (HeavyInfantryman wanted : formation)
        {
            if (wanted.getSoldierId() == id)
            {
                formation.remove(wanted);
                break;
            }
        }
    }

    public HeavyInfantryman getRandomSoldier()
    {
        int index = (int) Math.round(Math.random() * (formation.size() - 1));
        for (HeavyInfantryman element : formation)
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
        for(HeavyInfantryman element : formation)
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
        for (HeavyInfantryman element : formation)
            element.rest();
    }

    public void nextFewYears(int years)
    {
        for (HeavyInfantryman element : formation)
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
        for (HeavyInfantryman element : formation)
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
        for (HeavyInfantryman element : formation)
        {
            stmt = element.insertSoldier();
            Jdbc.executeStatement(stmt);
        }
    }
}
