package com.company;

import domain.individuals.Archer;
import domain.individuals.Ballister;
import domain.individuals.ChariotArcher;
import domain.individuals.Commander;
import domain.units.ArcherUnit;
import domain.units.Ballista;
import domain.units.ChariotArcherUnit;

public class Main
{
    public static void main(String[] args)
    {
        Commander Achiles = new Commander();
        ArcherUnit myUnit = new ArcherUnit(Achiles);
        myUnit.addArcher();
        myUnit.addArcher();
        myUnit.unitRating();
        myUnit.printAtributes();

        Ballista ballisterUnit = new Ballista(Achiles);
        ballisterUnit.addBallister();
        ballisterUnit.addBallister();
        ballisterUnit.unitRating();
        ballisterUnit.printAtributes();

        ChariotArcherUnit chariots = new ChariotArcherUnit(Achiles);
        chariots.addChariotArcher();
        chariots.addChariotArcher();
        chariots.unitRating();
        chariots.printAtributes();
    }
}
