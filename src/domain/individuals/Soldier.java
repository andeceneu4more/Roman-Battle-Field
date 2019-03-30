package domain.individuals;

import tools.Defaults;

public abstract class Soldier
{
    protected  static int generalSoldierID = 0;
    protected  String name, origin;
    protected int age;
    protected int soldierID, unitID, commanderID;
    protected int health, xp;

    public Soldier()
    {
        this.name = Defaults.NAME;
        this.origin = Defaults.ORIGIN;
        this.age = Defaults.MINIMUM_AGE;
        this.soldierID = ++generalSoldierID;
        this.health = Defaults.HEALTH;
        this.xp = Defaults.MINIMUM_XP;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setOrigin(String origin)
    {
        this.origin = origin;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setSoldierID(int soldierID)
    {
        this.soldierID = soldierID;
    }

    public void setUnitID(int unitID)
    {
        this.unitID = unitID;
    }

    public void setCommanderID(int commanderID)
    {
        this.commanderID = commanderID;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public void setXp(int xp)
    {
        this.xp = xp;
    }

    public int getSoldierID()
    {
        return soldierID;
    }

    public abstract void printSoldier();
}
