package domain.guilds;

import domain.individuals.Soldier;
import domain.units.RangerUnit;
import domain.units.Unit;
import services.AuditLog;
import tools.Defaults;
import tools.Jdbc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class RangerGuild extends Guild
{
    private Vector <RangerUnit> members;

    public RangerGuild()
    {
        this.members = new Vector <RangerUnit>();
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
        boolean added = false;
        for (i = 0; i < members.size() && (!added); i++)
        {
            if (members.elementAt(i).getUnitSize() < Defaults.UNIT_CAPACITY)
            {
                members.elementAt(i).addSoldier(recruitment.enrollRanger());
                added = true;
            }
        }
        if (!added)
        {
            RangerUnit unity = new RangerUnit();
            unity.addSoldier(recruitment.enrollRanger());
            members.addElement(unity);
        }
        AuditLog.stamp("Ranger.addSoldier");
    }

    public void writeSoldiers()
    {
        try
        {
            File writing = new File("src/csv/ranger-master.csv");
            BufferedWriter buffer = new BufferedWriter(new FileWriter(writing));
            buffer.write(Defaults.RANGER_HEADER, 0, Defaults.RANGER_HEADER.length());
            buffer.newLine();
            for (int i = 0; i < members.size(); i++)
                buffer = members.elementAt(i).writeSoldiers(buffer);
            buffer.close();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        AuditLog.stamp("Ranger.writeSoldier");
    }

    public void rating()
    {
        for (int i = 0; i < members.size(); i++)
            members.elementAt(i).rating();
        AuditLog.stamp("Ranger.rating");
    }

    public void writeDataBaseSoldiers()
    {
        try
        {
            Jdbc.initTable("ranger", Defaults.CREATE_NEW_RANGER);
            for (int i = 0; i < members.size(); i++)
                members.elementAt(i).writeDataBaseSoldiers();
        }
        catch (RuntimeException exception)
        {
            exception.printStackTrace();
        }
    }
}
