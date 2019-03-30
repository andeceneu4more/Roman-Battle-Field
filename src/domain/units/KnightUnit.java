package domain.units;

import domain.individuals.Commander;
import domain.individuals.Knight;
import tools.Defaults;

import java.util.Vector;

public class KnightUnit extends Unit
{
    private Vector <Knight> formation;

    public KnightUnit(Commander Captain)
    {
        this.unitID = ++generalUnitID;
        this.formation = new Vector();
        commander = Captain;
    }

    public void addSoldier()
    {
        Knight element = new Knight();
        // read element
        element.setUnitID(unitID);
        element.setCommanderID(commander.getSoldierID());
        formation.addElement(element);
    }

    public void printUnit()
    {
        System.out.println("Knight Unit");
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

        rangedStrength = Math.round(Defaults.KNIGHT_RANGED_RATIO * commanderRatio * rating);
        meleeStrength = Math.round(Defaults.KNIGHT_MELEE_RATIO * commanderRatio * rating);
        damage = Defaults.KNIGHT_DAMAGE_RATIO * commanderRatio * rating;
    }
}
