package domain.units;

import domain.individuals.ChariotArcher;
import domain.individuals.Commander;
import tools.Defaults;

import java.util.Vector;

public class ChariotArcherUnit extends Unit
{
    private Vector <ChariotArcher> formation;

    public ChariotArcherUnit(Commander Captain)
    {
        this.unitID = ++generalUnitID;
        this.formation = new Vector();
        commander = Captain;
    }

    public void addSoldier()
    {
        ChariotArcher element = new ChariotArcher();
        // read element
        element.setUnitID(unitID);
        element.setCommanderID(commander.getSoldierID());
        formation.addElement(element);
    }

    public void printUnit()
    {
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
        double commanderRatio = (1 + ((commander.getAbilities() - Defaults.minimumAbilities) /
                (Defaults.maximumAbilities - Defaults.minimumAbilities)));

        rating = commanderRatio * rating;
        rangedStrength = Math.round(Defaults.chariotRangedRatio * rating);
        meleeStrength = Math.round(Defaults.chariotMeleeRatio * rating);
        damage = Defaults.chariotDamageRatio * rating;
    }
}

