package com.company;

import domain.individuals.Archer;
import domain.individuals.Ballister;
import domain.individuals.Commander;
import domain.units.ArcherUnit;
import domain.units.Ballista;

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
    }
}
