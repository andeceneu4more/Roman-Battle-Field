package com.company;

import domain.individuals.Archer;
import domain.individuals.Ballister;
import domain.individuals.ChariotArcher;
import domain.individuals.Commander;
import domain.units.ArcherUnit;
import domain.units.Ballista;
import domain.units.ChariotArcherUnit;
import domain.units.HeavyInfantrymanUnit;

public class Main
{
    public static void main(String[] args)
    {
        Commander Achiles = new Commander();
        ArcherUnit myUnit = new ArcherUnit(Achiles);
        myUnit.addSoldier();
        myUnit.addSoldier();
        myUnit.rating();
        myUnit.printAtributes();

        Ballista ballisterUnit = new Ballista(Achiles);
        ballisterUnit.addSoldier();
        ballisterUnit.addSoldier();
        ballisterUnit.addSoldier();
        ballisterUnit.printAtributes();

        ChariotArcherUnit chariots = new ChariotArcherUnit(Achiles);
        chariots.addSoldier();
        chariots.addSoldier();
        chariots.rating();
        chariots.printAtributes();

        HeavyInfantrymanUnit legion = new HeavyInfantrymanUnit(Achiles);
        legion.addSoldier();
        legion.addSoldier();
        legion.rating();
        legion.printAtributes();
    }
}
