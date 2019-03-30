package domain.units;

import java.lang.*;
import java.util.*;
import domain.individuals.Archer;
import domain.individuals.Commander;
import tools.Defaults;

public class ArcherUnit extends Unit
{
    private Vector <Archer> formation;

    public ArcherUnit(Commander Captain)
    {
        this.unitID = ++generalUnitID;
        this.formation = new Vector();
        commander = Captain;
    }

    public void addSoldier()
    {
        Archer element = new Archer();
        // read element
        element.setUnitID(unitID);
        element.setCommanderID(commander.getSoldierID());
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
}
