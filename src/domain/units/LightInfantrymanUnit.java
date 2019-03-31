package domain.units;

import domain.individuals.Commander;
import domain.individuals.LightInfantryman;
import domain.individuals.Soldier;
import services.Fate;
import tools.Defaults;

import java.util.Vector;

public class LightInfantrymanUnit extends Unit
{
    private Vector <LightInfantryman> formation;

    public LightInfantrymanUnit(Commander Captain)
    {
        this.unitId = ++generalUnitId;
        this.formation = new Vector <LightInfantryman>();
        commander = Captain;
    }

    public void addSoldier(LightInfantryman element)
    {
        element.setUnitId(unitId);
        element.setCommanderId(commander.getSoldierId());
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
        double commanderRatio = (1 + ((commander.getAbilities() - Defaults.MINIMUM_ABILITIES) /
                (Defaults.MAXIMUM_ABILITIES - Defaults.MINIMUM_ABILITIES)));

        rangedStrength = Math.round(Defaults.LIGHT_RANGED_RATIO * commanderRatio * meleeStrength * discipline);
        meleeStrength = Math.round(Defaults.LIGHT_MELEE_RATIO * commanderRatio * meleeStrength * discipline);
        damage = Defaults.LIGHT_DAMAGE_RATIO * commanderRatio * damage * discipline;
    }

    public Soldier getSoldierById(int id)
    {
        if (commander.getSoldierId() == id)
            return commander;
        for (int i = 0; i < formation.size(); i++)
        {
            if (formation.elementAt(i).getSoldierId() == id)
                return formation.elementAt(i);
        }
        return null;
    }

    public int getSoldierNumber()
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
        int index = (int) Math.round(Math.random() * getSoldierNumber());
        return formation.elementAt(index);
    }

    public void trainSoldiers(Fate fate)
    {

        int ability = (int) Math.round(commander.getAbilities() * Defaults.TRAINING_ABILITY);
        commander.setAbilities(ability);
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
        int sample = (int) Math.round(getSoldierNumber() * Defaults.BIASED_PERCENT);
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
