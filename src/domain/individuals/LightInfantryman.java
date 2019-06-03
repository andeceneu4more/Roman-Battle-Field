package domain.individuals;

import tools.Defaults;
import tools.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LightInfantryman extends Soldier
{
    protected int swordDamage;
    protected int agility;

    public LightInfantryman()
    {
        super();
        this.swordDamage = Defaults.LIGHT_DAMAGE;
        this.agility = Defaults.AGILITY;
    }

    public void setSwordDamage(int swordDamage)
    {
        this.swordDamage = swordDamage;
    }

    public void setAgility(int agility)
    {
        this.agility = agility;
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
        System.out.println(agility);
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
        double rating = agility;
        double xpRatio = (1 + ((xp - Defaults.MINIMUM_XP) / (Defaults.MAXIMUM_XP - Defaults.MINIMUM_XP)));
        rating = xpRatio * rating;
        return rating;
    }

    public void train(double impact)
    {
        swordDamage = (int) Math.round((1 + impact) * swordDamage);
        agility = (int) Math.round((1 + impact) * agility);
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
        line.append(agility);
        return line;
    }

    public LightInfantryman copy()
    {
        LightInfantryman lightLegionar = new LightInfantryman();
        lightLegionar.soldierId = this.soldierId;
        lightLegionar.unitId = this.unitId;
        lightLegionar.name = this.name;
        lightLegionar.health = this.health;
        lightLegionar.stamina = this.stamina;
        lightLegionar.xp = this.xp;
        lightLegionar.age = this.age;
        lightLegionar.swordDamage = this.swordDamage;
        lightLegionar.agility = this.agility;
        return lightLegionar;
    }

    public PreparedStatement insertSoldier()
    {
        try
        {
            Connection connection = Jdbc.getConnection();
            PreparedStatement stmt =  connection.prepareStatement(Defaults.INSERT_NEW_LIGHT);
            stmt.setInt(1, soldierId);
            stmt.setInt(2, unitId);
            stmt.setString(3, name);
            stmt.setInt(4, health);
            stmt.setInt(5, stamina);
            stmt.setInt(6, xp);
            stmt.setInt(7, age);
            stmt.setInt(8, swordDamage);
            stmt.setInt(9, agility);
            return stmt;
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return null;
    }
}
