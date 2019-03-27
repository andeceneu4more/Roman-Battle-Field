package domain.individuals;

public class LightInfantryman extends Soldier
{
    protected int swordDamage;
    protected int agility;

    public LightInfantryman(String[] name, String[] origin, int age, int soldierID, int unitID, int commanderID,
                            int health, int xp, int swordDamage, int agility)
    {
        super(name, origin, age, soldierID, unitID, commanderID, health, xp);
        this.swordDamage = swordDamage;
        this.agility = agility;
    }
}
