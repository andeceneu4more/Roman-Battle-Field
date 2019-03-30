package domain.units;

import java.lang.*;
import java.util.*;
import domain.individuals.Archer;
import domain.individuals.Commander;
import domain.individuals.Soldier;
import tools.Defaults;

public class ArcherUnit extends Unit
{
    private Vector <Archer> formation;

    public ArcherUnit(Commander Captain)
    {
        this.unitId = ++generalUnitId;
        this.formation = new Vector();
        commander = Captain;
    }

    public void addSoldier(Archer element)
    {
        element.setUnitId(unitId);
        element.setCommanderId(commander.getSoldierId());
        formation.addElement(element);
    }

    public void printUnit()
    {
        System.out.println("Archer Unit");
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
        double commanderRatio = (1 + ((commander.getAbilities() - Defaults.MINIMUM_ABILITIES) /
                (Defaults.MAXIMUM_ABILITIES - Defaults.MINIMUM_ABILITIES)));

        rating = commanderRatio * rating;
        rangedStrength = Math.round(Defaults.ARCHERS_RANGED_RATIO * rating);
        meleeStrength = Math.round(Defaults.ARCHERS_MELEE_RATIO * rating);
        damage = Defaults.ARCHERS_DAMAGE_RATIO * rating;
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
