package domain.units;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.*;
import java.util.*;
import domain.individuals.Archer;
import domain.individuals.Soldier;
import services.Fate;
import tools.Defaults;

public class ArcherUnit extends Unit
{
    private Vector <Archer> formation;

    public ArcherUnit()
    {
        this.unitId = ++generalUnitId;
        this.formation = new Vector <Archer>();
    }

    public void addSoldier(Archer element)
    {
        element.setUnitId(unitId);
        formation.addElement(element);
    }

    public void rating()
    {
        try
        {
            double rating = 0;
            for (int i = 0; i < formation.size(); i++) {
                rating += formation.elementAt(i).rating();
            }
            double commanderRatio = (1 + ((discipline - Defaults.MINIMUM_DISCIPLINE) /
                    (Defaults.MAXIMUM_DISCIPLE - Defaults.MINIMUM_DISCIPLINE)));
            rating = commanderRatio * rating;
            rangedStrength = Math.round(Defaults.ARCHERS_RANGED_RATIO * rating);
            meleeStrength = Math.round(Defaults.ARCHERS_MELEE_RATIO * rating);
            damage = Defaults.ARCHERS_DAMAGE_RATIO * rating;
        }
        catch (ArithmeticException exception)
        {
            exception.printStackTrace();
        }
    }

    public Soldier getSoldierById(int id)
    {
        for (int i = 0; i < formation.size(); i++)
        {
            if (formation.elementAt(i).getSoldierId() == id)
                return formation.elementAt(i);
        }
        return null;
    }

    public int getUnitSize()
    {
        return formation.size();
    }

    public void killSoldierById(int id)
    {
        Archer wanted;
        boolean found = false;
        for (int i = 0; i < formation.size() && !found; i++)
        {
            wanted = formation.elementAt(i);
            if (wanted.getSoldierId() == id)
            {
                formation.removeElement(wanted);
                found = true;
            }
        }
    }

    public Archer getRandomSoldier()
    {
         int index = (int) Math.round(Math.random() * getUnitSize());
         return formation.elementAt(index);
    }

    public void trainSoldiers(Fate fate)
    {
        if (discipline + Defaults.DISCIPLINE_STEP < Defaults.MAXIMUM_DISCIPLE)
            discipline += Defaults.DISCIPLINE_STEP;
        double impact = (fate.getWeather() + fate.getMotivation() + fate.getTerrain()) / Defaults.FACTORS;
        // uniform training
        double uniformImpact = impact * Defaults.UNIFORM_RATIO;
        int i;
        for (i = 0; i < formation.size(); i++)
        {
            formation.elementAt(i).trainSoldier(uniformImpact);
        }
        // biased training
        double biasedImpact = impact * Defaults.BIASED_RATIO;
        int sample = (int) Math.round(getUnitSize() * Defaults.BIASED_PERCENT);
        for (i = 0; i < sample; i++)
        {
            getRandomSoldier().train(biasedImpact);
        }
    }

    public void rest()
    {
        for (int i = 0; i < formation.size(); i++)
        {
            formation.elementAt(i).rest();
        }
    }

    public void nextFewYears(int years)
    {
        for (int i = 0; i < formation.size(); i++)
        {
            formation.elementAt(i).nextFewYears(years);
            if (formation.elementAt(i).ifRetired())
            {
                formation.removeElementAt(i);
                i--;
            }
        }
    }

    public BufferedWriter writeSoldiers(BufferedWriter buffer) throws IOException
    {
        String line;
        for (int i = 0; i < formation.size(); i++)
        {
            line = formation.elementAt(i).getSoldierData().toString();
            buffer.write(line,0, line.length());
            buffer.newLine();
        }
        return buffer;
    }
}
