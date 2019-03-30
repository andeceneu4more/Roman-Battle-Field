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

    public void addChariotArcher()
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
            formation.elementAt(i).printChariotArcher();
        }
    }
    public void unitRating()
    {
        double rating = 0;
        for (int i = 0; i < formation.size(); i++)
        {
            rating += formation.elementAt(i).chariotArcherRating();
        }
        double commanderRation = (1 + ((commander.getAbilities() - Defaults.minimumAbilities) /
                (Defaults.maximumAbilities - Defaults.minimumAbilities)));

        rating = commanderRation * rating;
        rangedStrength = Math.round(Defaults.chariotRangedRatio * rating);
        meleeStrength = Math.round(Defaults.chariotMeleeRatio * rating);
        damage = Defaults.chariotDamageRatio * rating;
    }
}

