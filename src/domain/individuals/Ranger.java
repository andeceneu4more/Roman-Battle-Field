package domain.individuals;

public class Ranger extends Soldier
{
    protected float survivalRate;
    protected int stealth;

    public Ranger(String[] name, String[] origin, int age, int soldierID, int unitID, int commanderID, int health,
                  int xp, float survivalRate, int stealth)
    {
        super(name, origin, age, soldierID, unitID, commanderID, health, xp);
        this.survivalRate = survivalRate;
        this.stealth = stealth;
    }
}
