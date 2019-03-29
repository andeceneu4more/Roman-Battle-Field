package domain.units;

import java.lang.*;
import java.util.*;
import domain.individuals.Archer;
import domain.individuals.Commander;
import tools.Defaults;

public class ArcherUnit extends Unit
{
    private int unitID;
    private Vector <Archer> formation;

    public ArcherUnit(Commander Captain)
    {
        this.unitID = ++generalUnitID;
        this.formation = new Vector();
        commander = Captain;
    }

    public void addArcher()
    {
        Archer element = new Archer();
        // read element
        element.setUnitID(unitID);
        element.setCommanderID(commander.getSoldierID());
        formation.addElement(element);
    }

    public void printUnit()
    {
        for (int i = 0; i < formation.size(); i++)
        {
            formation.elementAt(i).printArcher();
        }
    }
    public void unitRating()
    {
        double rating = 0;
        for (int i = 0; i < formation.size(); i++)
        {
            rating += formation.elementAt(i).archerRating();
        }
        double commanderRation = (1 + ((commander.getAbilities() - Defaults.minimumAbilities) /
                (Defaults.maximumAbilities - Defaults.minimumAbilities)));

        rating = commanderRation * rating;
        rangedStrength = Math.round(Defaults.archersRangedRatio * rating);
        meleeStrength = Math.round(Defaults.archersMeleeRatio * rating);
        damage = Defaults.archersDamageRatio * rating;
    }
}
