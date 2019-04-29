package domain.guilds;

import domain.individuals.Soldier;
import domain.units.HeavyInfantrymanUnit;
import domain.units.Unit;
import tools.Defaults;

import java.util.Vector;

public class HeavyInfantrymanGuild extends Guild
{
    private Vector <HeavyInfantrymanUnit> members;

    public HeavyInfantrymanGuild()
    {
        this.members = new Vector <HeavyInfantrymanUnit>();
        this.recruitment.withType("HeavyInfantryman");
    }

    public Soldier getSoldierById(int id)
    {
        Soldier wanted;
        int i;
        for (i = 0; i < members.size(); i++)
        {
            wanted = members.elementAt(i).getSoldierById(id);
            if (wanted != null)
                return wanted;
        }
        return null;
    }

    public Unit getUnitById(int id)
    {
        Unit wanted;
        int i;
        for (i = 0; i < members.size(); i++)
        {
            wanted = members.elementAt(i);
            if (wanted.getUnitId() == id)
                return wanted;
        }
        return null;
    }

    public void nextFewYears(int years)
    {
        int i;
        for (i = 0; i < members.size(); i++)
            members.elementAt(i).nextFewYears(years);
    }

    public void addSoldier()
    {
        int i;
        for (i = 0; i < members.size(); i++)
        {
            if (members.elementAt(i).getUnitSize() < Defaults.UNITY_CAPACITY)
            {
                members.elementAt(i).addSoldier(recruitment.enrollHeavyInfantryman());
            }
        }
    }
}