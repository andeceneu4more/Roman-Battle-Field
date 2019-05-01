package tools;

import domain.individuals.*;

public class Enrollment
{
    private String type;
    private static int soldierId = 0;
    private final Archer archer = new Archer();
    private final Ballister ballister = new Ballister();
    private final ChariotArcher chariotArcher = new ChariotArcher();
    private final HeavyInfantryman legionar = new HeavyInfantryman();
    private final Knight knight = new Knight();
    private final LightInfantryman lightLegionar = new LightInfantryman();
    private final Ranger ranger = new Ranger();

    public Enrollment withType(String typpe)
    {
        soldierId++;
        type = typpe;
        switch (type)
        {
            case "Archer":
                archer.setSoldierId(soldierId);
                break;

            case "Ballister":
                ballister.setSoldierId(soldierId);
                break;

            case "ChariotArcher":
                chariotArcher.setSoldierId(soldierId);
                break;

            case "HeavyInfantryman":
                legionar.setSoldierId(soldierId);
                break;

            case "Knight":
                knight.setSoldierId(soldierId);
                break;

            case "LightInfantryman":
                lightLegionar.setSoldierId(soldierId);
                break;

            case "Ranger":
                ranger.setSoldierId(soldierId);
                break;
        }
        return this;
    }

    public Enrollment withName(String name)
    {
        switch (type)
        {
            case "Archer":
                archer.setName(name);
                break;

            case "Ballister":
                ballister.setName(name);
                break;

            case "ChariotArcher":
                chariotArcher.setName(name);
                break;

            case "HeavyInfantryman":
                legionar.setName(name);
                break;

            case "Knight":
                knight.setName(name);
                break;

            case "LightInfantryman":
                lightLegionar.setName(name);
                break;

            case "Ranger":
                ranger.setName(name);
                break;
        }
        return this;
    }

    public Enrollment withAge(int age)
    {
        switch (type)
        {
            case "Archer":
                archer.setAge(age);
                break;

            case "Ballister":
                ballister.setAge(age);
                break;

            case "ChariotArcher":
                chariotArcher.setAge(age);
                break;

            case "HeavyInfantryman":
                legionar.setAge(age);
                break;

            case "Knight":
                knight.setAge(age);
                break;

            case "LightInfantryman":
                lightLegionar.setAge(age);
                break;

            case "Ranger":
                ranger.setAge(age);
                break;
        }
        return this;
    }

    public Enrollment withHealth(int health)
    {
        switch (type)
        {
            case "Archer":
                archer.setHealth(health);
                break;

            case "Ballister":
                ballister.setHealth(health);
                break;

            case "ChariotArcher":
                chariotArcher.setHealth(health);
                break;

            case "HeavyInfantryman":
                legionar.setHealth(health);
                break;

            case "Knight":
                knight.setHealth(health);
                break;

            case "LightInfantryman":
                lightLegionar.setHealth(health);
                break;

            case "Ranger":
                ranger.setHealth(health);
                break;
        }
        return this;
    }

    public Enrollment withStamina(int stamina)
    {
        switch (type)
        {
            case "Archer":
                archer.setStamina(stamina);
                break;

            case "Ballister":
                ballister.setStamina(stamina);
                break;

            case "ChariotArcher":
                chariotArcher.setStamina(stamina);
                break;

            case "HeavyInfantryman":
                legionar.setStamina(stamina);
                break;

            case "Knight":
                knight.setStamina(stamina);
                break;

            case "LightInfantryman":
                lightLegionar.setStamina(stamina);
                break;

            case "Ranger":
                ranger.setStamina(stamina);
                break;
        }
        return this;
    }

    public Enrollment withXp(int xp)
    {
        switch (type)
        {
            case "Archer":
                archer.setXp(xp);
                break;

            case "Ballister":
                ballister.setXp(xp);
                break;

            case "ChariotArcher":
                chariotArcher.setXp(xp);
                break;

            case "HeavyInfantryman":
                legionar.setXp(xp);
                break;

            case "Knight":
                knight.setXp(xp);
                break;

            case "LightInfantryman":
                lightLegionar.setXp(xp);
                break;

            case "Ranger":
                ranger.setXp(xp);
                break;
        }
        return this;
    }

    public Enrollment withRangeDamage(int rangeDamage)
    {
        switch (type)
        {
            case "Archer":
                archer.setRangeDamage(rangeDamage);
                break;

            case "Chariot Archer":
                chariotArcher.setRangeDamage(rangeDamage);
                break;

        }
        return this;
    }

    public Enrollment withCriticalHitRate(double criticalHitRate)
    {
        switch (type)
        {
            case "Archer":
                archer.setCriticalHitRate(criticalHitRate);
                break;

            case "Chariot Archer":
                chariotArcher.setCriticalHitRate(criticalHitRate);
                break;

        }
        return this;
    }

    public Enrollment withWatchfullness(int watchfullness)
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
                break;

            case "Knight":
                knight.setSpeed(speed);
                break;
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
            case "HeavyInfantryman":
                legionar.setSwordDamage(swordDamage);
                break;

            case "Knight":
                knight.setSwordDamage(swordDamage);
                break;

            case "LightInfantryman":
                lightLegionar.setSwordDamage(swordDamage);
                break;
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
        return archer.copy();
    }

    public Ballister enrollBallister()
    {
        return ballister.copy();
    }

    public ChariotArcher enrollChariotArcher()
    {
        return chariotArcher.copy();
    }

    public HeavyInfantryman enrollHeavyInfantryman()
    {
        return legionar.copy();
    }

    public Knight enrollKnight()
    {
        return knight.copy();
    }

    public LightInfantryman enrollLightInfantryman()
    {
        return lightLegionar.copy();
    }

    public Ranger enrollRanger()
    {
        return ranger.copy();
    }

}
