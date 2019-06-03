package domain.individuals;

import tools.Defaults;
import tools.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Knight extends Soldier
{
    protected int swordDamage;
    protected double speed;

    public Knight()
    {
        super();
        this.swordDamage = Defaults.KNIGHT_DAMAGE;
        this.speed = Defaults.KNIGHT_SPEED;
    }

    public void setSwordDamage(int swordDamage)
    {
        this.swordDamage = swordDamage;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
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
        System.out.println(speed);
    }

    public double rating()
    {
        double rating = swordDamage + speed;
        double xpRatio = (1 + ((xp - Defaults.MINIMUM_XP) / (Defaults.MAXIMUM_XP - Defaults.MINIMUM_XP)));
        rating = xpRatio * rating;
        return rating;
    }

    public void train(double impact)
    {
        swordDamage = (int) Math.round((1 + impact) * swordDamage);
        speed = (1 + impact) * speed;
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
        line.append(speed);
        return line;
    }

    public Knight copy()
    {
        Knight knight = new Knight();
        knight.soldierId = this.soldierId;
        knight.unitId = this.unitId;
        knight.name = this.name;
        knight.health = this.health;
        knight.stamina = this.stamina;
        knight.xp = this.xp;
        knight.age = this.age;
        knight.swordDamage = this.swordDamage;
        knight.speed = this.speed;
        return knight;
    }

    public PreparedStatement insertSoldier()
    {
        try
        {
            Connection connection = Jdbc.getConnection();
            PreparedStatement stmt =  connection.prepareStatement(Defaults.INSERT_NEW_KNIGHT);
            stmt.setInt(1, soldierId);
            stmt.setInt(2, unitId);
            stmt.setString(3, name);
            stmt.setInt(4, health);
            stmt.setInt(5, stamina);
            stmt.setInt(6, xp);
            stmt.setInt(7, age);
            stmt.setInt(8, swordDamage);
            stmt.setDouble(9, speed);
            return stmt;
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return null;
    }
}
