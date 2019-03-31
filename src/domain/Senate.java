package domain;

import domain.individuals.Commander;
import domain.individuals.Soldier;
import domain.units.*;
import services.Fate;
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
    private final Fate fate = Fate.getInstance();

    public Senate()
    {
        consul = new Commander();
        archers = new Vector <ArcherUnit>();
        ballista = new Vector <Ballista>();
        chariotArchers = new Vector <ChariotArcherUnit>();
        legionars = new Vector <HeavyInfantrymanUnit>();
        knights = new Vector <KnightUnit>();
        lightLegionars = new Vector <LightInfantrymanUnit>();
        rangers = new Vector <RangerUnit>();
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
        consul.nextFewYears(years);
        int i;
        for (i = 0; i < archers.size(); i++)
            archers.elementAt(i).nextFewYears(years);
        for (i = 0; i < ballista.size(); i++)
            ballista.elementAt(i).nextFewYears(years);
        for (i = 0; i < chariotArchers.size(); i++)
            chariotArchers.elementAt(i).nextFewYears(years);
        for (i = 0; i < legionars.size(); i++)
            legionars.elementAt(i).nextFewYears(years);
        for (i = 0; i < knights.size(); i++)
            knights.elementAt(i).nextFewYears(years);
        for (i = 0; i < rangers.size(); i++)
            rangers.elementAt(i).nextFewYears(years);
    }

    // decimarea unui comandant
    // fight dintre 2 unitati
    // recompensarea unui soldat
    // un repository cu comandantii?
}
