package domain.units;

import domain.individuals.LightInfantryman;
import domain.individuals.Soldier;
import services.Fate;
import services.SoldierComparator;
import tools.Defaults;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

public class LightInfantrymanUnit extends Unit
{
    private TreeSet<LightInfantryman> formation;

    public LightInfantrymanUnit()
    {
        this.unitId = ++generalUnitId;
        this.formation = new TreeSet <LightInfantryman>(new SoldierComparator());
    }

    public void addSoldier(LightInfantryman element)
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
            for (LightInfantryman element : formation)
            {
                damage += element.damage();
                meleeStrength += element.strength();
            }
            double commanderRatio = (1 + ((discipline - Defaults.MINIMUM_DISCIPLINE) /
                    (Defaults.MAXIMUM_DISCIPLE - Defaults.MINIMUM_DISCIPLINE)));

            rangedStrength = Math.round(Defaults.LIGHT_RANGED_RATIO * commanderRatio * meleeStrength * discipline);
            meleeStrength = Math.round(Defaults.LIGHT_MELEE_RATIO * commanderRatio * meleeStrength * discipline);
            damage = Defaults.LIGHT_DAMAGE_RATIO * commanderRatio * damage * discipline;
        }
        catch (ArithmeticException exception)
        {
            exception.printStackTrace();
        }
    }

    public Soldier getSoldierById(int id)
    {
        for (LightInfantryman element : formation)
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
        for (LightInfantryman wanted : formation)
        {
            if (wanted.getSoldierId() == id)
            {
                formation.remove(wanted);
                break;
            }
        }
    }

    public LightInfantryman getRandomSoldier()
    {
        int index = (int) Math.round(Math.random() * (formation.size() - 1));
        for (LightInfantryman element : formation)
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
        for(LightInfantryman element : formation)
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
        for (LightInfantryman element : formation)
            element.rest();
    }

    public void nextFewYears(int years)
    {
        for (LightInfantryman element : formation)
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
        for (LightInfantryman element : formation)
        {
            line = element.getSoldierData().toString();
            buffer.write(line,0, line.length());
            buffer.newLine();
        }
        return buffer;
    }
}
