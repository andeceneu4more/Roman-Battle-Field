package domain.individuals;

public class Soldier
{
    protected  String[] name, origin;
    protected int age;
    protected int soldierID, unitID, commanderID;
    protected int health, xp;

    public Soldier(String[] name, String[] origin, int age, int soldierID, int unitID, int commanderID, int health, int xp)
    {
        this.name = name;
        this.origin = origin;
        this.age = age;
        this.soldierID = soldierID;
        this.unitID = unitID;
        this.commanderID = commanderID;
        this.health = health;
        this.xp = xp;
    }
}
