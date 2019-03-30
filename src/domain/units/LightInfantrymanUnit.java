package domain.units;

import domain.individuals.Commander;
import domain.individuals.LightInfantryman;
import domain.individuals.Soldier;
import tools.Defaults;

import java.util.Vector;

public class LightInfantrymanUnit extends Unit
{
    private Vector <LightInfantryman> formation;

    public LightInfantrymanUnit(Commander Captain)
    {
        this.unitId = ++generalUnitId;
        this.formation = new Vector();
        commander = Captain;
    }

    public void addSoldier(LightInfantryman element)
    {
        element.setUnitId(unitId);
        element.setCommanderId(commander.getSoldierId());
        formation.addElement(element);
    }

    public void printUnit()
    {
        System.out.println("Light Infantryman Unit");
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
        double commanderRatio = (1 + ((commander.getAbilities() - Defaults.MINIMUM_ABILITIES) /
                (Defaults.MAXIMUM_ABILITIES - Defaults.MINIMUM_ABILITIES)));

        rangedStrength = Math.round(Defaults.LIGHT_RANGED_RATIO * commanderRatio * meleeStrength);
        meleeStrength = Math.round(Defaults.LIGHT_MELEE_RATIO * commanderRatio * meleeStrength);
        damage = Defaults.LIGHT_DAMAGE_RATIO * commanderRatio * damage;
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
