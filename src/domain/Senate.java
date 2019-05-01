package domain;

import domain.guilds.*;
import domain.individuals.Soldier;
import domain.units.*;
import services.Fate;

import java.io.*;

public class Senate
{
    private ArcherGuild archerMaster;
    private BallistaGuild ballistaMaster;
    private ChariotArcherGuild chariotArcherMaster;
    private HeavyInfantrymanGuild heavyInfantrymanMaster;
    private KnightGuild knightMaster;
    private LightInfantrymanGuild lightInfantrymanMaster;
    private RangerGuild rangerMaster;
    private final Fate fate = Fate.getInstance();

    public Senate()
    {
        archerMaster = new ArcherGuild();
        ballistaMaster = new BallistaGuild();
        chariotArcherMaster = new ChariotArcherGuild();
        heavyInfantrymanMaster = new HeavyInfantrymanGuild();
        knightMaster = new KnightGuild();
        lightInfantrymanMaster = new LightInfantrymanGuild();
        rangerMaster = new RangerGuild();
    }

    public Soldier getSoldierById(int id)
    {
        Soldier wanted;
        wanted = archerMaster.getSoldierById(id);
        if (wanted != null)
            return wanted;
        wanted = ballistaMaster.getSoldierById(id);
        if (wanted != null)
            return wanted;
        wanted = chariotArcherMaster.getSoldierById(id);
        if (wanted != null)
            return wanted;
        wanted = heavyInfantrymanMaster.getSoldierById(id);
        if (wanted != null)
            return wanted;
        wanted = knightMaster.getSoldierById(id);
        if (wanted != null)
            return wanted;
        wanted = lightInfantrymanMaster.getSoldierById(id);
        if (wanted != null)
            return wanted;
        wanted = rangerMaster.getSoldierById(id);
        if (wanted != null)
            return wanted;
        return null;
    }

    public Unit getUnitById(int id)
    {
        Unit wanted;
        wanted = archerMaster.getUnitById(id);
        if (wanted != null)
            return wanted;
        wanted = ballistaMaster.getUnitById(id);
        if (wanted != null)
            return wanted;
        wanted = chariotArcherMaster.getUnitById(id);
        if (wanted != null)
            return wanted;
        wanted = heavyInfantrymanMaster.getUnitById(id);
        if (wanted != null)
            return wanted;
        wanted = knightMaster.getUnitById(id);
        if (wanted != null)
            return wanted;
        wanted = lightInfantrymanMaster.getUnitById(id);
        if (wanted != null)
            return wanted;
        wanted = rangerMaster.getUnitById(id);
        if (wanted != null)
            return wanted;
        return null;
    }


    public void killSoldierById(int id)
    {
        Soldier wanted = getSoldierById(id);
        Unit target = getUnitById(wanted.getUnitId());
        target.killSoldierById(id);
    }

    public void trainUnitById(int id)
    {
        Unit target = getUnitById(id);
        target.trainSoldiers(fate);
        fate.change();
    }

    public void restUnitById(int id)
    {
        Unit target = getUnitById(id);
        target.rest();
    }

    public void yearConfig()
    {
        if (fate.getYears() > 0)
        {
            nextFewYears(fate.getYears());
            fate.resetYears();
        }
    }

    public void nextFewYears(int years)
    {
        archerMaster.nextFewYears(years);
        ballistaMaster.nextFewYears(years);
        chariotArcherMaster.nextFewYears(years);
        heavyInfantrymanMaster.nextFewYears(years);
        knightMaster.nextFewYears(years);
        lightInfantrymanMaster.nextFewYears(years);
        rangerMaster.nextFewYears(years);
    }

    public void readSoldiers()
    {
        String csvPath = new File("src/csv/soldiers.csv").getAbsolutePath();
        try
        {
            BufferedReader buffer = new BufferedReader(new FileReader(csvPath));
            String firstLine = buffer.readLine();
            String line = "";
            String[] attributes;
            while ((line = buffer.readLine()) != null)
            {
                attributes = line.split(",");
                switch (attributes[0])
                {
                    case "Archer":
                        archerMaster.read(firstLine, attributes);
                        break;

                    case "Ballister":
                        ballistaMaster.read(firstLine, attributes);
                        break;

                    case "ChariotArcher":
                        chariotArcherMaster.read(firstLine, attributes);
                        break;

                    case "HeavyInfantryman":
                        heavyInfantrymanMaster.read(firstLine, attributes);
                        break;

                    case "Knight":
                        knightMaster.read(firstLine, attributes);
                        break;

                    case "LightInfantryman":
                        lightInfantrymanMaster.read(firstLine, attributes);
                        break;

                    case "Ranger":
                        rangerMaster.read(firstLine, attributes);
                        break;
                }
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    public void writeSoldiers()
    {
        archerMaster.writeSoldiers();
        ballistaMaster.writeSoldiers();
        chariotArcherMaster.writeSoldiers();
        heavyInfantrymanMaster.writeSoldiers();
        knightMaster.writeSoldiers();
        lightInfantrymanMaster.writeSoldiers();
        rangerMaster.writeSoldiers();
    }

    public void rating()
    {
        archerMaster.rating();
        ballistaMaster.rating();
        chariotArcherMaster.rating();
        heavyInfantrymanMaster.rating();
        knightMaster.rating();
        lightInfantrymanMaster.rating();
        rangerMaster.rating();
    }

    // decimarea intr-un guild
    // fight dintre 2 unitati
    // => recompensarea unui soldat + moartea a catorva soldati random
}
