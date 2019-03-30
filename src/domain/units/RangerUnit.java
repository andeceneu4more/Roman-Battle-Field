package domain.units;

import domain.individuals.Commander;
import domain.individuals.Ranger;
import tools.Defaults;

import java.util.Vector;

public class RangerUnit extends Unit
{
    private Vector <Ranger> formation;

    public RangerUnit(Commander Captain)
    {
        this.unitID = ++generalUnitID;
        this.formation = new Vector();
        commander = Captain;
    }

    public void addSoldier()
    {
        Ranger element = new Ranger();
        // read element
        element.setUnitID(unitID);
        element.setCommanderID(commander.getSoldierID());
        formation.addElement(element);
    }

    public void printUnit()
    {
        System.out.println("Ranger Unit");
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
        rangedStrength = Math.round(Defaults.RANGER_RANGED_RATIO * rating);
        meleeStrength = Math.round(Defaults.RANGER_MELEE_RATIO * rating);
        damage = Defaults.RANGER_DAMAGE_RATIO * rating;
    }
}
