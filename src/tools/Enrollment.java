package tools;

import domain.individuals.*;

public class Enrollment
{
    public Soldier bring(String type)
    {
        switch (type)
        {
            case "Archer":
                return new Archer();

            case "Ballister":
                return new Ballister();

            case "Chariot Archer":
                return new ChariotArcher();

            case "Heavy Infantryman":
                return new HeavyInfantryman();

            case "Knight":
                return new Knight();

            case "Light Infantryman":
                return new LightInfantryman();

            case "Ranger":
                return new Ranger();
        }
        return null;
    }

//    public Soldier enroll()
//    {
//        soldier id
//        unit id
//        commander id
//    }
}
