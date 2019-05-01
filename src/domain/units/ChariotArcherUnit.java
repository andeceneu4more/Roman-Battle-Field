package domain.units;

import domain.individuals.ChariotArcher;
import domain.individuals.Soldier;
import services.Fate;
import tools.Defaults;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Vector;

public class ChariotArcherUnit extends Unit
{
    private Vector <ChariotArcher> formation;

    public ChariotArcherUnit()
    {
        this.unitId = ++generalUnitId;
        this.formation = new Vector <ChariotArcher>();
    }

    public void addSoldier(ChariotArcher element)
    {
        element.setUnitId(unitId);
        formation.addElement(element);
    }

    public void rating()
    {
        double rating = 0;
        for (int i = 0; i < formation.size(); i++)
        {
            rating += formation.elementAt(i).rating();
        }
        double commanderRatio = (1 + ((discipline - Defaults.MINIMUM_DISCIPLINE) /
                (Defaults.MAXIMUM_DISCIPLE - Defaults.MINIMUM_DISCIPLINE)));

        rating = commanderRatio * rating;
        rating = discipline * rating;
        rangedStrength = Math.round(Defaults.CHARIOT_RANGED_RATIO * rating);
        meleeStrength = Math.round(Defaults.CHARIOT_MELEE_RATIO * rating);
        damage = Defaults.CHARIOT_DAMAGE_RATIO * rating;
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
        ChariotArcher wanted;
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

    public ChariotArcher getRandomSoldier()
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
            buffer.write(line, 0, line.length());
            buffer.newLine();
        }
        return buffer;
    }
}

