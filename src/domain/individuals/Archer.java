package domain.individuals;

public class Archer extends Soldier
{
    protected int rangeDamage;
    protected double criticalHitRate;

    public Archer(String[] name, String[] origin, int age, int soldierID, int unitID, int commanderID,
                  int health, int xp, int rangeDamage, double criticalHitRate)
    {
        super(name, origin, age, soldierID, unitID, commanderID, health, xp);
        this.rangeDamage = rangeDamage;
        this.criticalHitRate = criticalHitRate;
    }
}
