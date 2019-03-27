package domain.individuals;

public class ChariotArcher extends Archer
{
    protected float speed;

    public ChariotArcher(String[] name, String[] origin, int age, int soldierID, int unitID, int commanderID,
                         int health, int xp, int rangeDamage, double criticalHitRate, float speed)
    {
        super(name, origin, age, soldierID, unitID, commanderID, health, xp, rangeDamage, criticalHitRate);
        this.speed = speed;
    }
}
