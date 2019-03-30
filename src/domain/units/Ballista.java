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
        this.cooldown = Defaults.cooldown;
        commander = Captain;
    }

    public void addBallister()
    {
        Ballister element = new Ballister();
        // read element
        element.setUnitID(unitID);
        element.setCommanderID(commander.getSoldierID());
        formation.addElement(element);
    }

    public void printUnit()
    {
        for (int i = 0; i < formation.size(); i++)
        {
            formation.elementAt(i).printBallister();
        }
    }
    public void unitRating()
    {
        double rating = 0;
        for (int i = 0; i < formation.size(); i++)
        {
            rating += formation.elementAt(i).ballisterRating();
        }
        rating = rating / formation.size();
        double commanderRatio = (1 + ((commander.getAbilities() - Defaults.minimumAbilities) /
                (Defaults.maximumAbilities - Defaults.minimumAbilities)));

        rating = commanderRatio * rating;
        rangedStrength = Math.round(Defaults.ballistersRangedRatio * rating);
        meleeStrength = Math.round(Defaults.ballistersMeleeRatio * rating);
        damage = (Defaults.ballistersDamageRatio * rating) *
                Math.floor(Defaults.standardTime / cooldown);
    }
}
