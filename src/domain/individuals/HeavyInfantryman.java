package domain.individuals;

import tools.Defaults;
import tools.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HeavyInfantryman extends Soldier
{
    protected int swordDamage;
    protected int armour;

    public HeavyInfantryman()
    {
        super();
        this.swordDamage = Defaults.HEAVY_DAMAGE;
        this.armour = Defaults.ARMOUR;
    }

    public void setSwordDamage(int swordDamage)
    {
        this.swordDamage = swordDamage;
    }

    public void setArmour(int armour)
    {
        this.armour = armour;
    }

    public void printSoldier()
    {
        System.out.println(name);
        System.out.println(age);
        System.out.println(soldierId);
        System.out.println(unitId);
        System.out.println(health);
        System.out.println(xp);
        System.out.println(swordDamage);
        System.out.println(armour);
    }

    public double damage()
    {
        double rating = swordDamage;
        double xpRatio = (1 + ((xp - Defaults.MINIMUM_XP) / (Defaults.MAXIMUM_XP - Defaults.MINIMUM_XP)));
        rating = xpRatio * rating;
        return rating;
    }
    public double strength()
    {
        double rating = armour;
        double xpRatio = (1 + ((xp - Defaults.MINIMUM_XP) / (Defaults.MAXIMUM_XP - Defaults.MINIMUM_XP)));
        rating = xpRatio * rating;
        return rating;
    }

    public void train(double impact)
    {
        swordDamage = (int) Math.round((1 + impact) * swordDamage);
        armour = (int) Math.round((1 + impact) * armour);
    }

    public StringBuilder getSoldierData()
    {
        StringBuilder line = new StringBuilder("");
        line.append(soldierId );
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
        line.append(swordDamage);
        line.append(',');
        line.append(armour);
        return line;
    }

    public HeavyInfantryman copy()
    {
        HeavyInfantryman legionar = new HeavyInfantryman();
        legionar.soldierId = this.soldierId;
        legionar.unitId = this.unitId;
        legionar.name = this.name;
        legionar.health = this.health;
        legionar.stamina = this.stamina;
        legionar.xp = this.xp;
        legionar.age = this.age;
        legionar.swordDamage = this.swordDamage;
        legionar.armour = this.armour;
        return legionar;
    }

    public PreparedStatement insertSoldier()
    {
        try
        {
            Connection connection = Jdbc.getConnection();
            PreparedStatement stmt =  connection.prepareStatement(Defaults.INSERT_NEW_HEAVY);
            stmt.setInt(1, soldierId);
            stmt.setInt(2, unitId);
            stmt.setString(3, name);
            stmt.setInt(4, health);
            stmt.setInt(5, stamina);
            stmt.setInt(6, xp);
            stmt.setInt(7, age);
            stmt.setInt(8, swordDamage);
            stmt.setInt(9, armour);
            return stmt;
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return null;
    }
}
