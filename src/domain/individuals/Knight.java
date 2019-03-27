package domain.individuals;

public class Knight extends Soldier
{
    protected int swordDamage;
    protected float speed;

    public Knight(String[] name, String[] origin, int age, int soldierID, int unitID, int commanderID,
                  int health, int xp, int swordDamage, float speed)
    {
        super(name, origin, age, soldierID, unitID, commanderID, health, xp);
        this.swordDamage = swordDamage;
        this.speed = speed;
    }
}
