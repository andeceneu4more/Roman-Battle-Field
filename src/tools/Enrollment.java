package tools;

import domain.individuals.*;

public class Enrollment
{
    private String type;
    private final Archer archer = new Archer();
    private final Ballister ballister = new Ballister();
    private final ChariotArcher chariotArcher = new ChariotArcher();
    private final HeavyInfantryman legionar = new HeavyInfantryman();
    private final Knight knight = new Knight();
    private final LightInfantryman lightLegionar = new LightInfantryman();
    private final Ranger ranger = new Ranger();

    public Enrollment withType(String typpe)
    {
        type = typpe;
        return this;
    }

    public Enrollment withName(String name)
    {
        switch (type)
        {
            case "Archer":
                archer.setName(name);

            case "Ballister":
                ballister.setName(name);

            case "Chariot Archer":
                chariotArcher.setName(name);

            case "Heavy Infantryman":
                legionar.setName(name);

            case "Knight":
                knight.setName(name);

            case "Light Infantryman":
                lightLegionar.setName(name);

            case "Ranger":
                ranger.setName(name);
        }
        return this;
    }

    public Enrollment withAge(int age)
    {
        switch (type)
        {
            case "Archer":
                archer.setAge(age);

            case "Ballister":
                ballister.setAge(age);

            case "Chariot Archer":
                chariotArcher.setAge(age);

            case "Heavy Infantryman":
                legionar.setAge(age);

            case "Knight":
                knight.setAge(age);

            case "Light Infantryman":
                lightLegionar.setAge(age);

            case "Ranger":
                ranger.setAge(age);
        }
        return this;
    }

    public Enrollment withHealth(int health)
    {
        switch (type)
        {
            case "Archer":
                archer.setHealth(health);

            case "Ballister":
                ballister.setHealth(health);

            case "Chariot Archer":
                chariotArcher.setHealth(health);

            case "Heavy Infantryman":
                legionar.setHealth(health);

            case "Knight":
                knight.setHealth(health);

            case "Light Infantryman":
                lightLegionar.setHealth(health);

            case "Ranger":
                ranger.setHealth(health);
        }
        return this;
    }

    public Enrollment withXp(int xp)
    {
        switch (type)
        {
            case "Archer":
                archer.setXp(xp);

            case "Ballister":
                ballister.setXp(xp);

            case "Chariot Archer":
                chariotArcher.setXp(xp);

            case "Heavy Infantryman":
                legionar.setXp(xp);

            case "Knight":
                knight.setXp(xp);

            case "Light Infantryman":
                lightLegionar.setXp(xp);

            case "Ranger":
                ranger.setXp(xp);
        }
        return this;
    }

    public Enrollment withRangeDamage(int rangeDamage)
    {
        switch (type)
        {
            case "Archer":
                archer.setRangeDamage(rangeDamage);

            case "Chariot Archer":
                chariotArcher.setRangeDamage(rangeDamage);

        }
        return this;
    }

    public Enrollment withCriticalHitRate(double criticalHitRate)
    {
        switch (type)
        {
            case "Archer":
                archer.setCriticalHitRate(criticalHitRate);

            case "Chariot Archer":
                chariotArcher.setCriticalHitRate(criticalHitRate);

        }
        return this;
    }

    public Enrollment wirhWatchfullness(int watchfullness)
    {
        ballister.setWatchfullness(watchfullness);
        return this;
    }

    public Enrollment withSpeed(double speed)
    {
        switch (type)
        {
            case "Chariot Archer":
                chariotArcher.setSpeed(speed);

            case "Knight":
                knight.setSpeed(speed);

        }
        return this;
    }

    public Enrollment withCooldown(double cooldown)
    {
        chariotArcher.setCooldown(cooldown);
        return this;
    }

    public Enrollment withSwordDamage(int swordDamage)
    {
        switch (type)
        {
            case "Heavy Infantryman":
                legionar.setSwordDamage(swordDamage);

            case "Knight":
                knight.setSwordDamage(swordDamage);

            case "Light Infantryman":
                lightLegionar.setSwordDamage(swordDamage);

        }
        return this;
    }

    public Enrollment withArmour(int armour)
    {
        legionar.setArmour(armour);
        return this;
    }

    public Enrollment withAgility(int agility)
    {
        lightLegionar.setAgility(agility);
        return this;
    }

    public Enrollment withSurvivalRate(double survivalRate)
    {
        ranger.setSurvivalRate(survivalRate);
        return this;
    }

    public Enrollment withStealth(int stealth)
    {
        ranger.setStealth(stealth);
        return this;
    }



    public Archer enrollArcher()
    {
        return archer;
    }

    public Ballister enrollBallister()
    {
        return ballister;
    }

    public ChariotArcher enrollChariotArcher()
    {
        return chariotArcher;
    }

    public HeavyInfantryman enrollHeavyInfantryman()
    {
        return legionar;
    }

    public Knight enrollKnight()
    {
        return knight;
    }

    public LightInfantryman enrollLightInfantryman()
    {
        return lightLegionar;
    }

    public Ranger enrollRanger()
    {
        return ranger;
    }

}
