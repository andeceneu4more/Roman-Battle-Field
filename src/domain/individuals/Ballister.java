package domain.individuals;

public class Ballister extends Soldier
{
    protected float cooldown;

    public Ballister(String[] name, String[] origin, int age, int soldierID, int unitID, int commanderID,
                     int health, int xp, float cooldown)
    {
        super(name, origin, age, soldierID, unitID, commanderID, health, xp);
        this.cooldown = cooldown;
    }
}
