package domain;

import domain.individuals.Commander;
import domain.individuals.Soldier;
import domain.units.*;
import tools.Enrollment;

import java.util.Vector;

public class Senate
{
    private Commander consul;
    private Vector <ArcherUnit> archers;
    private Vector <Ballista> ballista;
    private Vector <ChariotArcherUnit> chariotArchers;
    private Vector <HeavyInfantrymanUnit> legionars;
    private Vector <KnightUnit> knights;
    private Vector <LightInfantrymanUnit> lightLegionars;
    private Vector <RangerUnit> rangers;
    private Enrollment recruitment;

    public Senate()
    {
        consul = new Commander();
        archers = new Vector();
        ballista = new Vector();
        chariotArchers = new Vector();
        legionars = new Vector();
        knights = new Vector();
        lightLegionars = new Vector();
        rangers = new Vector();
        recruitment = new Enrollment();
    }

    public void initialize()
    {
        consul = new Commander();
        ArcherUnit archerUnit = new ArcherUnit(consul);
        archerUnit.addSoldier(recruitment.withType("Archer").withName("Marius").enrollArcher());
        archerUnit.addSoldier(recruitment.withType("Archer").withName("Caius").enrollArcher());
        archerUnit.rating();
        archers.addElement(archerUnit);

        Ballista ballisterUnit = new Ballista(consul);
        ballisterUnit.addSoldier(recruitment.withType("Ballister").withName("Marius").enrollBallister());
        ballisterUnit.addSoldier(recruitment.withType("Ballister").withName("Flavius").enrollBallister());
        ballisterUnit.rating();
        ballista.addElement(ballisterUnit);

        ChariotArcherUnit chariots = new ChariotArcherUnit(consul);
        chariots.addSoldier(recruitment.withType("Chariot Archer").withName("Liviu").enrollChariotArcher());
        chariots.addSoldier(recruitment.withType("Chariot Archer").withName("Luca").enrollChariotArcher());
        chariots.rating();
        chariotArchers.addElement(chariots);

        HeavyInfantrymanUnit legion = new HeavyInfantrymanUnit(consul);
        legion.addSoldier(recruitment.withType("Heavy Infantryman").withName("Luca").enrollHeavyInfantryman());
        legion.addSoldier(recruitment.withType("Heavy Infantryman").withName("Aurelius").enrollHeavyInfantryman());
        legion.rating();
        legionars.addElement(legion);

        KnightUnit knightUnit = new KnightUnit(consul);
        knightUnit.addSoldier(recruitment.withType("Knight").withName("Paul").enrollKnight());
        knightUnit.addSoldier(recruitment.withType("Knight").withName("Luca").enrollKnight());
        knightUnit.rating();
        knights.addElement(knightUnit);

        LightInfantrymanUnit velits = new LightInfantrymanUnit(consul);
        velits.addSoldier(recruitment.withType("Light Infantryman").withName("Aurelius").enrollLightInfantryman());
        velits.addSoldier(recruitment.withType("Light Infantryman").withName("Marcus").enrollLightInfantryman());
        velits.rating();
        lightLegionars.addElement(velits);

        System.out.println("Rangers");
        RangerUnit rangerUnit = new RangerUnit(consul);
        rangerUnit.addSoldier(recruitment.withType("Ranger").withName("Octavian").enrollRanger());
        rangerUnit.addSoldier(recruitment.withType("Ranger").withName("Lucius").enrollRanger());
        rangerUnit.rating();
        rangers.addElement(rangerUnit);
    }

    public Soldier getSoldierById(int id)
    {
        if (consul.getSoldierId() == id)
            return  consul;
        Soldier wanted;
        int i;
        for (i = 0; i < archers.size(); i++)
        {
            wanted = archers.elementAt(i).getSoldierById(id);
            if (wanted != null)
                return wanted;
        }
        for (i = 0; i < ballista.size(); i++)
        {
            wanted = ballista.elementAt(i).getSoldierById(id);
            if (wanted != null)
                return wanted;
        }
        for (i = 0; i < chariotArchers.size(); i++)
        {
            wanted = chariotArchers.elementAt(i).getSoldierById(id);
            if (wanted != null)
                return wanted;
        }
        for (i = 0; i < legionars.size(); i++)
        {
            wanted = legionars.elementAt(i).getSoldierById(id);
            if (wanted != null)
                return wanted;
        }
        for (i = 0; i < knights.size(); i++)
        {
            wanted = knights.elementAt(i).getSoldierById(id);
            if (wanted != null)
                return wanted;
        }
        for (i = 0; i < rangers.size(); i++)
        {
            wanted = rangers.elementAt(i).getSoldierById(id);
            if (wanted != null)
                return wanted;
        }
        return null;
    }

    public Unit getUnitById(int id)
    {
        Unit wanted;
        int i;
        for (i = 0; i < archers.size(); i++)
        {
            wanted = archers.elementAt(i);
            if (wanted.getUnitId() == id)
                return wanted;
        }
        for (i = 0; i < ballista.size(); i++)
        {
            wanted = ballista.elementAt(i);
            if (wanted.getUnitId() == id)
                return wanted;
        }
        for (i = 0; i < chariotArchers.size(); i++)
        {
            wanted = chariotArchers.elementAt(i);
            if (wanted.getUnitId() == id)
                return wanted;
        }
        for (i = 0; i < legionars.size(); i++)
        {
            wanted = legionars.elementAt(i);
            if (wanted.getUnitId() == id)
                return wanted;
        }
        for (i = 0; i < knights.size(); i++)
        {
            wanted = knights.elementAt(i);
            if (wanted.getUnitId() == id)
                return wanted;
        }
        for (i = 0; i < rangers.size(); i++)
        {
            wanted = rangers.elementAt(i);
            if (wanted.getUnitId() == id)
                return wanted;
        }
        return null;
    }

    public Commander getCommanderById(int id)
    {
        Commander wanted;
        int i;
        for (i = 0; i < archers.size(); i++)
        {
            wanted = archers.elementAt(i).getCommander();
            if (wanted.getSoldierId() == id)
                return wanted;
        }
        for (i = 0; i < ballista.size(); i++)
        {
            wanted = ballista.elementAt(i).getCommander();
            if (wanted.getSoldierId() == id)
                return wanted;
        }
        for (i = 0; i < chariotArchers.size(); i++)
        {
            wanted = chariotArchers.elementAt(i).getCommander();
            if (wanted.getSoldierId() == id)
                return wanted;
        }
        for (i = 0; i < legionars.size(); i++)
        {
            wanted = legionars.elementAt(i).getCommander();
            if (wanted.getSoldierId() == id)
                return wanted;
        }
        for (i = 0; i < knights.size(); i++)
        {
            wanted = knights.elementAt(i).getCommander();
            if (wanted.getSoldierId() == id)
                return wanted;
        }
        for (i = 0; i < rangers.size(); i++)
        {
            wanted = rangers.elementAt(i).getCommander();
            if (wanted.getSoldierId() == id)
                return wanted;
        }
        return null;
    }

    // killSoldierByID
    // get Random solider dintr-o unitate
    // decimarea unui comandant
    // antrenamentul facut de o unitate
    // retirement
    // ratio + teren random
    // trecerea unui an
    // damage dintre 2 unitati
    // un repository cu comandantii?
}
