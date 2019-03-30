package domain.units;

import domain.individuals.Ballister;
import domain.individuals.Commander;
import domain.individuals.Soldier;
import tools.Defaults;

import java.util.Vector;

public class Ballista extends Unit
{
    private double cooldown;
    private Vector <Ballister> formation;

    public Ballista(Commander Captain)
    {
        this.unitId = ++generalUnitId;
        this.formation = new Vector();
        this.cooldown = Defaults.COOLDOWN;
        commander = Captain;
    }

    public void setCooldown(double cooldown)
    {
        this.cooldown = cooldown;
    }

    public void addSoldier(Ballister element)
    {
        element.setUnitId(unitId);
        element.setCommanderId(commander.getSoldierId());
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
        double commanderRatio = (1 + ((commander.getAbilities() - Defaults.MINIMUM_ABILITIES) /
                (Defaults.MAXIMUM_ABILITIES - Defaults.MINIMUM_ABILITIES)));

        rating = commanderRatio * rating;
        rangedStrength = Math.round(Defaults.BALLISTERS_RANGED_RATIO * rating);
        meleeStrength = Math.round(Defaults.BALLISTERS_MELEE_RATIO * rating);
        damage = (Defaults.BALLISTERS_DAMAGE_RATIO * rating) *
                Math.floor(Defaults.STANDARD_TIME / cooldown);
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
}
