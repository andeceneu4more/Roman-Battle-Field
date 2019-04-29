package domain.units;

import domain.individuals.LightInfantryman;
import domain.individuals.Soldier;
import services.Fate;
import tools.Defaults;

import java.util.Vector;

public class LightInfantrymanUnit extends Unit
{
    private Vector <LightInfantryman> formation;

    public LightInfantrymanUnit()
    {
        this.unitId = ++generalUnitId;
        this.formation = new Vector <LightInfantryman>();
    }

    public void addSoldier(LightInfantryman element)
    {
        element.setUnitId(unitId);
        formation.addElement(element);
    }

    public void printUnit()
    {
        System.out.println("Light Infantryman Unit");
        for (int i = 0; i < formation.size(); i++)
        {
            formation.elementAt(i).printSoldier();
        }
    }

    public void rating()
    {
        damage = 0;
        meleeStrength = 0;
        for (int i = 0; i < formation.size(); i++)
        {
            damage += formation.elementAt(i).damage();
            meleeStrength += formation.elementAt(i).strength();
        }
        double commanderRatio = (1 + ((abilities - Defaults.MINIMUM_ABILITIES) /
                (Defaults.MAXIMUM_ABILITIES - Defaults.MINIMUM_ABILITIES)));

        rangedStrength = Math.round(Defaults.LIGHT_RANGED_RATIO * commanderRatio * meleeStrength * discipline);
        meleeStrength = Math.round(Defaults.LIGHT_MELEE_RATIO * commanderRatio * meleeStrength * discipline);
        damage = Defaults.LIGHT_DAMAGE_RATIO * commanderRatio * damage * discipline;
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
        LightInfantryman wanted;
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

    public Soldier getRandomSoldier()
    {
        int index = (int) Math.round(Math.random() * getUnitSize());
        return formation.elementAt(index);
    }

    public void trainSoldiers(Fate fate)
    {

        abilities = (int) Math.round(abilities * Defaults.TRAINING_ABILITY);
        discipline += 0.1;
        double impact = (fate.getWeather() + fate.getMotivation() + fate.getTerrain()) / 3;
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
}
