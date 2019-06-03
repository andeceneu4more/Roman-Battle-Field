package domain.individuals;

import tools.Defaults;

import java.sql.PreparedStatement;

public abstract class Soldier
{
    protected String name;
    protected int age;
    protected int soldierId;
    protected int unitId;
    protected int health, stamina, xp;

    public Soldier()
    {
        this.name = Defaults.NAME;
        this.age = Defaults.MINIMUM_AGE;
        this.health = Defaults.HEALTH;
        this.xp = Defaults.MINIMUM_XP;
        this.stamina = Defaults.STAMINA;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setStamina(int stamina)
    {
        this.stamina = stamina;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setUnitId(int unitId)
    {
        this.unitId = unitId;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public void setXp(int xp)
    {
        this.xp = xp;
    }

    public void setSoldierId(int soldierId)
    {
        this.soldierId = soldierId;
    }

    public int getSoldierId()
    {
        return soldierId;
    }

    public int getUnitId()
    {
        return unitId;
    }

    public abstract void printSoldier();

    public void trainSoldier(double impact)
    {
        xp = (int) Math.round((1 + impact) * xp);
        stamina = (int) Math.round((1 - impact) * stamina);
    }

    public void rest()
    {
        this.health = Defaults.HEALTH;
        this.stamina = Defaults.STAMINA;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public int getHealth()
    {
        return health;
    }

    public int getStamina()
    {
        return stamina;
    }

    public int getXp()
    {
        return xp;
    }

    public void nextFewYears(int years)
    {
        age += years;
    }

    public boolean ifRetired()
    {
        return age >= Defaults.MAXIMUM_AGE;
    }

    public abstract void train(double impact);
    public abstract StringBuilder getSoldierData();
    public abstract PreparedStatement insertSoldier();
}
