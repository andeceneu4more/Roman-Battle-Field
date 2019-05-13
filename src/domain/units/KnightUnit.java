package domain.units;

import domain.individuals.Knight;
import domain.individuals.Soldier;
import services.Fate;
import services.SoldierComparator;
import tools.Defaults;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.TreeSet;

public class KnightUnit extends Unit
{
    private TreeSet<Knight> formation;

    public KnightUnit()
    {
        this.unitId = ++generalUnitId;
        this.formation = new TreeSet<Knight>(new SoldierComparator());
    }

    public void addSoldier(Knight element)
    {
        element.setUnitId(unitId);
        formation.add(element);
    }

    public void rating()
    {
        try
        {
            double rating = 0;
            for (Knight element : formation)
                rating += element.rating();
            double commanderRatio = 1 + ((discipline - Defaults.MINIMUM_DISCIPLINE) /
                    (Defaults.MAXIMUM_DISCIPLE - Defaults.MINIMUM_DISCIPLINE));
            rating = discipline * rating;
            rangedStrength = Math.round(Defaults.KNIGHT_RANGED_RATIO * commanderRatio * rating);
            meleeStrength = Math.round(Defaults.KNIGHT_MELEE_RATIO * commanderRatio * rating);
            damage = Defaults.KNIGHT_DAMAGE_RATIO * commanderRatio * rating;
        }
        catch (ArithmeticException exception)
        {
            exception.printStackTrace();
        }
    }

    public Soldier getSoldierById(int id)
    {
        for (Knight element : formation)
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
        for (Knight wanted : formation)
        {
            if (wanted.getSoldierId() == id)
            {
                formation.remove(wanted);
                break;
            }
        }
    }

    public Knight getRandomSoldier()
    {
        int index = (int) Math.round(Math.random() * (formation.size() - 1));
        for (Knight element : formation)
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
        for(Knight element : formation)
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
        for (Knight element : formation)
            element.rest();
    }

    public void nextFewYears(int years)
    {
        for (Knight element : formation)
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
        for (Knight element : formation)
        {
            line = element.getSoldierData().toString();
            buffer.write(line,0, line.length());
            buffer.newLine();
        }
        return buffer;
    }
}
