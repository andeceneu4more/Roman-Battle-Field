package domain.individuals;

public class HeavyInfantryman extends Soldier
{
    protected int swordDamage;
    protected int armour;

    public HeavyInfantryman(String[] name, String[] origin, int age, int soldierID, int unitID, int commanderID,
                            int health, int xp, int swordDamage, int armour)
    {
        super(name, origin, age, soldierID, unitID, commanderID, health, xp);
        this.swordDamage = swordDamage;
        this.armour = armour;
    }
}
