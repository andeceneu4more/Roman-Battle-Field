package com.company;

import domain.individuals.*;
import domain.units.*;

public class Main
{
    public static void main(String[] args)
    {
        Commander Achiles = new Commander();
        System.out.println("Archers");
        ArcherUnit archers = new ArcherUnit(Achiles);
        archers.addSoldier();
        archers.addSoldier();
        archers.rating();
        archers.printAtributes();

        System.out.println("Ballista");
        Ballista ballisterUnit = new Ballista(Achiles);
        ballisterUnit.addSoldier();
        ballisterUnit.addSoldier();
        ballisterUnit.addSoldier();
        ballisterUnit.printAtributes();

        System.out.println("Chariots");
        ChariotArcherUnit chariots = new ChariotArcherUnit(Achiles);
        chariots.addSoldier();
        chariots.addSoldier();
        chariots.rating();
        chariots.printAtributes();

        System.out.println("Legion");
        HeavyInfantrymanUnit legion = new HeavyInfantrymanUnit(Achiles);
        legion.addSoldier();
        legion.addSoldier();
        legion.rating();
        legion.printAtributes();

        System.out.println("Velits");
        LightInfantrymanUnit velits = new LightInfantrymanUnit(Achiles);
        velits.addSoldier();
        velits.addSoldier();
        velits.rating();
        velits.printAtributes();

        System.out.println("Knights");
        KnightUnit knights = new KnightUnit(Achiles);
        knights.addSoldier();
        knights.addSoldier();
        knights.rating();
        knights.printAtributes();

        System.out.println("Rangers");
        RangerUnit rangers = new RangerUnit(Achiles);
        rangers.addSoldier();
        rangers.addSoldier();
        rangers.rating();
        rangers.printAtributes();
    }
}
