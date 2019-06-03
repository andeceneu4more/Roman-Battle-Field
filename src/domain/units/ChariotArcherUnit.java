package domain.units;

import domain.individuals.ChariotArcher;
import domain.individuals.Soldier;
import services.Fate;
import services.SoldierComparator;
import tools.Defaults;
import tools.Jdbc;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.TreeSet;

public class ChariotArcherUnit extends Unit
{
    private TreeSet<ChariotArcher> formation;

    public ChariotArcherUnit()
    {
        this.unitId = ++generalUnitId;
        this.formation = new TreeSet <ChariotArcher>(new SoldierComparator());
    }

    public void addSoldier(ChariotArcher element)
    {
        element.setUnitId(unitId);
        formation.add(element);
    }

    public void rating()
    {
        try
        {
            double rating = 0;
            for (ChariotArcher element : formation)
                rating += element.rating();
            double commanderRatio = (1 + ((discipline - Defaults.MINIMUM_DISCIPLINE) /
                    (Defaults.MAXIMUM_DISCIPLE - Defaults.MINIMUM_DISCIPLINE)));

            rating = commanderRatio * rating;
            rating = discipline * rating;
            rangedStrength = Math.round(Defaults.CHARIOT_RANGED_RATIO * rating);
            meleeStrength = Math.round(Defaults.CHARIOT_MELEE_RATIO * rating);
            damage = Defaults.CHARIOT_DAMAGE_RATIO * rating;
        }
        catch (ArithmeticException exception)
        {
            exception.printStackTrace();
        }
    }

    public Soldier getSoldierById(int id)
    {
        for (ChariotArcher element : formation)
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
        for (ChariotArcher wanted : formation)
        {
            if (wanted.getSoldierId() == id)
            {
                formation.remove(wanted);
                break;
            }
        }
    }

    public ChariotArcher getRandomSoldier()
    {
        int index = (int) Math.round(Math.random() * (formation.size() - 1));
        for (ChariotArcher element : formation)
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
        for(ChariotArcher element : formation)
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
        for (ChariotArcher element : formation)
            element.rest();
    }

    public void nextFewYears(int years)
    {
        for (ChariotArcher element : formation)
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
        for (ChariotArcher element : formation)
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
        for (ChariotArcher element : formation)
        {
            stmt = element.insertSoldier();
            Jdbc.executeStatement(stmt);
        }
    }
}

