package domain.units;

import domain.individuals.Ballister;
import domain.individuals.Soldier;
import services.Fate;
import services.SoldierComparator;
import tools.Defaults;
import tools.Jdbc;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.TreeSet;

public class Ballista extends Unit
{
    private double cooldown;
    private TreeSet<Ballister> formation;

    public Ballista()
    {
        this.unitId = ++generalUnitId;
        this.formation = new TreeSet <Ballister>(new SoldierComparator());
        this.cooldown = Defaults.COOLDOWN;
    }

    public void addSoldier(Ballister element)
    {
        element.setUnitId(unitId);
        formation.add(element);
    }

    public void rating()
    {
        try
        {
            double rating = 0;
            for (Ballister element : formation)
                rating += element.rating();
            rating = rating / formation.size();
            double commanderRatio = (1 + ((discipline - Defaults.MINIMUM_DISCIPLINE) /
                    (Defaults.MAXIMUM_DISCIPLE - Defaults.MINIMUM_DISCIPLINE)));

            rating = commanderRatio * rating;
            rating = discipline * rating;
            rangedStrength = Math.round(Defaults.BALLISTERS_RANGED_RATIO * rating);
            meleeStrength = Math.round(Defaults.BALLISTERS_MELEE_RATIO * rating);
            damage = (Defaults.BALLISTERS_DAMAGE_RATIO * rating) *
                    Math.floor(Defaults.STANDARD_TIME / cooldown);
        }
        catch (ArithmeticException exception)
        {
            exception.printStackTrace();
        }
    }

    public Soldier getSoldierById(int id)
    {
        for (Ballister element : formation)
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
        for (Ballister wanted : formation)
        {
            if (wanted.getSoldierId() == id)
            {
                formation.remove(wanted);
                break;
            }
        }
    }

    public Ballister getRandomSoldier()
    {
        int index = (int) Math.round(Math.random() * (formation.size() - 1));
        for (Ballister element : formation)
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
        for(Ballister element : formation)
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
        for (Ballister element : formation)
            element.rest();
    }

    public void nextFewYears(int years)
    {
        for (Ballister element : formation)
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
        for (Ballister element : formation)
        {
            line = element.getSoldierData().toString() + ',' + cooldown;
            buffer.write(line,0, line.length());
            buffer.newLine();
        }
        return buffer;
    }

    public void writeDataBaseSoldiers() throws  SQLException, RuntimeException {
        PreparedStatement stmt;
        for (Ballister element : formation)
        {
            stmt = element.insertSoldier();
            stmt.setDouble(9, cooldown);
            Jdbc.executeStatement(stmt);
        }
    }
}
