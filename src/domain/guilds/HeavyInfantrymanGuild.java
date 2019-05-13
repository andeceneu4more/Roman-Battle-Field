package domain.guilds;

import domain.individuals.Soldier;
import domain.units.HeavyInfantrymanUnit;
import domain.units.Unit;
import services.AuditLog;
import tools.Defaults;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class HeavyInfantrymanGuild extends Guild
{
    private Vector <HeavyInfantrymanUnit> members;

    public HeavyInfantrymanGuild()
    {
        this.members = new Vector <HeavyInfantrymanUnit>();
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
            if (wanted.getDiscipline() == id)
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
        boolean added = false;
        for (i = 0; i < members.size() && (!added); i++)
        {
            if (members.elementAt(i).getUnitSize() < Defaults.UNIT_CAPACITY)
            {
                members.elementAt(i).addSoldier(recruitment.enrollHeavyInfantryman());
                added = true;
            }
        }
        if (!added)
        {
            HeavyInfantrymanUnit unity = new HeavyInfantrymanUnit();
            unity.addSoldier(recruitment.enrollHeavyInfantryman());
            members.addElement(unity);
        }
        AuditLog.stamp("HeavyInfantryman.addSoldier");
    }

    public void writeSoldiers()
    {
        try
        {
            File writing = new File("src/csv/heavy-infantryman-master.csv");
            BufferedWriter buffer = new BufferedWriter(new FileWriter(writing));
            buffer.write(Defaults.HEAVY_HEADER, 0, Defaults.HEAVY_HEADER.length());
            buffer.newLine();
            for (int i = 0; i < members.size(); i++)
                buffer = members.elementAt(i).writeSoldiers(buffer);
            buffer.close();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        AuditLog.stamp("HeavyInfantryman.writeSoldiers");
    }

    public void rating()
    {
        for (int i = 0; i < members.size(); i++)
            members.elementAt(i).rating();
        AuditLog.stamp("HeavyInfantryman.rating");
    }
}