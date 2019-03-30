package domain.individuals;

import tools.Defaults;

public abstract class Soldier
{
    protected  static int generalSoldierID = 0;
    protected  String name;
    protected int age;
    protected int soldierId, unitId, commanderId;
    protected int health, xp;

    public Soldier()
    {
        this.name = Defaults.NAME;
        this.age = Defaults.MINIMUM_AGE;
        this.soldierId = ++generalSoldierID;
        this.health = Defaults.HEALTH;
        this.xp = Defaults.MINIMUM_XP;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }


    public void setUnitId(int unitId)
    {
        this.unitId = unitId;
    }

    public void setCommanderId(int commanderId)
    {
        this.commanderId = commanderId;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public void setXp(int xp)
    {
        this.xp = xp;
    }

    public int getSoldierId()
    {
        return soldierId;
    }

    public abstract void printSoldier();
}
