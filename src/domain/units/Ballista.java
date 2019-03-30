package domain.units;

import domain.individuals.Ballister;
import domain.individuals.Commander;
import tools.Defaults;

import java.util.Vector;

public class Ballista extends Unit
{
    private double cooldown;
    private Vector <Ballister> formation;

    public Ballista(Commander Captain)
    {
        this.unitID = ++generalUnitID;
        this.formation = new Vector();
        this.cooldown = Defaults.COOLDOWN;
        commander = Captain;
    }

    public void addSoldier()
    {
        Ballister element = new Ballister();
        // read element
        element.setUnitID(unitID);
        element.setCommanderID(commander.getSoldierID());
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
}
