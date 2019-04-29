package domain.units;

import domain.individuals.Ballister;
import domain.individuals.Soldier;
import services.Fate;
import tools.Defaults;

import java.util.Vector;

public class Ballista extends Unit
{
    private double cooldown;
    private Vector <Ballister> formation;

    public Ballista()
    {
        this.unitId = ++generalUnitId;
        this.formation = new Vector <Ballister>();
        this.cooldown = Defaults.COOLDOWN;
    }

    public void setCooldown(double cooldown)
    {
        this.cooldown = cooldown;
    }

    public void addSoldier(Ballister element)
    {
        element.setUnitId(unitId);
        formation.addElement(element);
    }

    public void printUnit()
    {
        System.out.println("Ballista");
        for (int i = 0; i < formation.size(); i++)
        {
            formation.elementAt(i).printSoldier();
        }
    }
    public void rating()
    {
        double rating = 0;
        for (int i = 0; i < formation.size(); i++)
        {
            rating += formation.elementAt(i).rating();
        }
        rating = rating / formation.size();
        double commanderRatio = (1 + ((abilities - Defaults.MINIMUM_ABILITIES) /
                (Defaults.MAXIMUM_ABILITIES - Defaults.MINIMUM_ABILITIES)));

        rating = commanderRatio * rating;
        rating = discipline * rating;
        rangedStrength = Math.round(Defaults.BALLISTERS_RANGED_RATIO * rating);
        meleeStrength = Math.round(Defaults.BALLISTERS_MELEE_RATIO * rating);
        damage = (Defaults.BALLISTERS_DAMAGE_RATIO * rating) *
                Math.floor(Defaults.STANDARD_TIME / cooldown);
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
        Ballister wanted;
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

    public Ballister getRandomSoldier()
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
