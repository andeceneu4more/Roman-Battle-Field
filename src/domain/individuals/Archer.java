package domain.individuals;

import tools.Defaults;

public class Archer extends Soldier
{
    protected int rangeDamage;
    protected double criticalHitRate;

    public Archer()
    {
        super();
        this.rangeDamage = Defaults.RANGE_DAMAGE;
        this.criticalHitRate = Defaults.CRITICAL_HIT_RATE;
    }

    public void setRangeDamage(int rangeDamage)
    {
        this.rangeDamage = rangeDamage;
    }

    public void setCriticalHitRate(double criticalHitRate)
    {
        this.criticalHitRate = criticalHitRate;
    }

    public void printSoldier()
    {
        System.out.println(name);
        System.out.println(age);
        System.out.println(soldierId);
        System.out.println(unitId);
        System.out.println(health);
        System.out.println(xp);
        System.out.println(rangeDamage);
        System.out.println(criticalHitRate);
    }

    public double rating()
    {
        double rating = criticalHitRate * Defaults.STANDARD_TIME + (1 - criticalHitRate) *
                Defaults.STANDARD_TIME * rangeDamage;
        double xpRatio = (1 + ((xp - Defaults.MINIMUM_XP) / (Defaults.MAXIMUM_XP - Defaults.MINIMUM_XP)));
        rating = xpRatio * rating;
        return rating;
    }

    public void train(double impact)
    {
        rangeDamage = (int) Math.round((1 + impact) * rangeDamage);
        criticalHitRate = (1 + impact) * rangeDamage;
    }

    public StringBuilder getSoldierData()
    {
        StringBuilder line = new StringBuilder("");
        line.append(soldierId);
        line.append(',');
        line.append(unitId);
        line.append(',');
        line.append(name);
        line.append(',');
        line.append(health);
        line.append(',');
        line.append(stamina );
        line.append(',');
        line.append(xp);
        line.append(',');
        line.append(age);
        line.append(',');
        line.append(rangeDamage);
        line.append(',');
        line.append(criticalHitRate);
        return line;
    }

    public Archer copy()
    {
        Archer archer = new Archer();
        archer.soldierId = this.soldierId;
        archer.unitId = this.unitId;
        archer.name = this.name;
        archer.health = this.health;
        archer.stamina = this.stamina;
        archer.xp = this.xp;
        archer.age = this.age;
        archer.rangeDamage = this.rangeDamage;
        archer.criticalHitRate = this.criticalHitRate;
        return archer;
    }
}
