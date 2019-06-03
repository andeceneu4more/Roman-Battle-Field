package domain.guilds;

import domain.individuals.Soldier;
import domain.units.ChariotArcherUnit;
import domain.units.Unit;
import services.AuditLog;
import tools.Defaults;
import tools.Jdbc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class ChariotArcherGuild extends Guild
{
    private Vector <ChariotArcherUnit> members;

    public ChariotArcherGuild()
    {
        this.members = new Vector <ChariotArcherUnit>();
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
                members.elementAt(i).addSoldier(recruitment.enrollChariotArcher());
                added = true;
            }
        }
        if (!added)
        {
            ChariotArcherUnit unity = new ChariotArcherUnit();
            unity.addSoldier(recruitment.enrollChariotArcher());
            members.addElement(unity);
        }
        AuditLog.stamp("ChariotArcherGuild.addSoldier");
    }

    public void writeSoldiers()
    {
        try
        {
            File writing = new File("src/csv/chariot-archer-master.csv");
            BufferedWriter buffer = new BufferedWriter(new FileWriter(writing));
            buffer.write(Defaults.CHARIOT_HEADER, 0, Defaults.CHARIOT_HEADER.length());
            buffer.newLine();
            for (int i = 0; i < members.size(); i++)
                buffer = members.elementAt(i).writeSoldiers(buffer);
            buffer.close();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        AuditLog.stamp("ChariotArcherGuild.writeSoldier");
    }

    public void rating()
    {
        for (int i = 0; i < members.size(); i++)
            members.elementAt(i).rating();
        AuditLog.stamp("ChariotArcherGuild.rating");
    }

    public void writeDataBaseSoldiers()
    {
        try
        {
            Jdbc.initTable("chariot_archer", Defaults.CREATE_NEW_CHARIOT);
            for (int i = 0; i < members.size(); i++)
                members.elementAt(i).writeDataBaseSoldiers();
        }
        catch (RuntimeException exception)
        {
            exception.printStackTrace();
        }
    }
}
