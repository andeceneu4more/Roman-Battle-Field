package domain.guilds;

import domain.individuals.Archer;
import domain.individuals.Soldier;
import domain.units.ArcherUnit;
import domain.units.Unit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import services.AuditLog;
import tools.Defaults;
import tools.Jdbc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class ArcherGuild extends Guild
{
    private Vector<ArcherUnit> members;

    public ArcherGuild()
    {
        this.members = new Vector <ArcherUnit>();
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
                members.elementAt(i).addSoldier(recruitment.enrollArcher());
                added = true;
            }
        }
        if (!added)
        {
            ArcherUnit unity = new ArcherUnit();
            unity.addSoldier(recruitment.enrollArcher());
            members.addElement(unity);
        }
        AuditLog.stamp("ArcherGuild.addSoldier");
    }

    public void writeSoldiers()
    {
        try
        {
            File writing = new File("src/csv/archer-master.csv");
            BufferedWriter buffer = new BufferedWriter(new FileWriter(writing));
            buffer.write(Defaults.ARCHERS_HEADER, 0, Defaults.ARCHERS_HEADER.length());
            buffer.newLine();
            for (int i = 0; i < members.size(); i++)
                buffer = members.elementAt(i).writeSoldiers(buffer);
            buffer.close();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        AuditLog.stamp("ArcherGuild.writeSoldiers");
    }

    public void rating()
    {
        for (int i = 0; i < members.size(); i++)
            members.elementAt(i).rating();
        AuditLog.stamp("ArcherGuild.rating");
    }

    public void writeDataBaseSoldiers()
    {
        try
        {
            Jdbc.initTable("archer", Defaults.CREATE_NEW_ARCHER);
            for (int i = 0; i < members.size(); i++)
                members.elementAt(i).writeDataBaseSoldiers();
        }
        catch (RuntimeException exception)
        {
            exception.printStackTrace();
        }
    }

    public ObservableList<Archer> getAll()
    {
        ObservableList<Archer> all = FXCollections.observableArrayList();
        for (int i = 0; i < members.size(); i++)
        {
            ObservableList<Archer> member = members.elementAt(i).getAll();
            all.addAll(member);
        }
        return all;
    }

    public void addSoldier(Archer object)
    {
        int i;
        boolean added = false;
        for (i = 0; i < members.size() && (!added); i++)
        {
            if (members.elementAt(i).getUnitSize() < Defaults.UNIT_CAPACITY)
            {
                members.elementAt(i).addSoldier(object);
                added = true;
            }
        }
        if (!added)
        {
            ArcherUnit unity = new ArcherUnit();
            unity.addSoldier(object);
            members.addElement(unity);
        }
    }

    public Archer getRandomSoldier()
    {
        int index = (int) Math.round(Math.random() * (members.size() - 1));
        for (ArcherUnit element : members)
        {
            if (index == 0)
            {
                return element.getRandomSoldier();
            }
            index--;
        }
        return null;
    }
}
