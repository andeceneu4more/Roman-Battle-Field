package domain.units;

import domain.individuals.Commander;
import domain.individuals.HeavyInfantryman;
import tools.Defaults;
import java.util.Vector;

public class HeavyInfantrymanUnit extends Unit
{
    private Vector <HeavyInfantryman> formation;

    public HeavyInfantrymanUnit(Commander Captain)
    {
        this.unitID = ++generalUnitID;
        this.formation = new Vector();
        commander = Captain;
    }

    public void addSoldier()
    {
        HeavyInfantryman element = new HeavyInfantryman();
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
        damage = 0;
        meleeStrength = 0;
        for (int i = 0; i < formation.size(); i++)
        {
            damage += formation.elementAt(i).damage();
            meleeStrength += formation.elementAt(i).strength();
        }
        double commanderRatio = (1 + ((commander.getAbilities() - Defaults.minimumAbilities) /
                (Defaults.maximumAbilities - Defaults.minimumAbilities)));

        rangedStrength = Math.round(Defaults.heavyRangedRatio * commanderRatio * meleeStrength);
        meleeStrength = Math.round(Defaults.heavyMeleeRatio * commanderRatio * meleeStrength);
        damage = Defaults.heavyDamageRatio * commanderRatio * damage;
    }
}
