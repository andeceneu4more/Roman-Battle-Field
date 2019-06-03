package domain.individuals;

import tools.Defaults;
import tools.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChariotArcher extends Archer
{
    protected double speed;
    protected double cooldown;

    public ChariotArcher()
    {
        super();
        this.speed = Defaults.CHARIOT_SPEED;
        this.cooldown = Defaults.CHARIOT_COOLDOWN;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setCooldown(double cooldown)
    {
        this.cooldown = cooldown;
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
        System.out.println(speed);
        System.out.println(cooldown);
    }

    public double rating()
    {
        double turn = Defaults.STANDARD_TIME / cooldown;
        double rating = criticalHitRate * turn + (1 - criticalHitRate) * turn * (rangeDamage + speed);
        double xpRatio = (1 + ((xp - Defaults.MINIMUM_XP) / (Defaults.MAXIMUM_XP - Defaults.MINIMUM_XP)));
        rating = xpRatio * rating;
        return rating;
    }
    public void train(double impact)
    {
        rangeDamage = (int) Math.round((1 + impact) * rangeDamage);
        criticalHitRate = (1 + impact) * rangeDamage;
        speed = (1 + impact) * speed;
        cooldown = (1 - impact) * cooldown;
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
        line.append(rangeDamage);
        line.append(',');
        line.append(criticalHitRate);
        line.append(',');
        line.append(speed);
        line.append(',');
        line.append(cooldown);
        return line;
    }

    public ChariotArcher copy()
    {
        ChariotArcher chariotArcher = new ChariotArcher();
        chariotArcher.soldierId = this.soldierId;
        chariotArcher.unitId = this.unitId;
        chariotArcher.name = this.name;
        chariotArcher.health = this.health;
        chariotArcher.stamina = this.stamina;
        chariotArcher.xp = this.xp;
        chariotArcher.age = this.age;
        chariotArcher.rangeDamage = this.rangeDamage;
        chariotArcher.criticalHitRate = this.criticalHitRate;
        chariotArcher.speed = this.speed;
        chariotArcher.cooldown = this.cooldown;
        return chariotArcher;
    }

    public PreparedStatement insertSoldier()
    {
        try
        {
            Connection connection = Jdbc.getConnection();
            PreparedStatement stmt =  connection.prepareStatement(Defaults.INSERT_NEW_CHARIOT);
            stmt.setInt(1, soldierId);
            stmt.setInt(2, unitId);
            stmt.setString(3, name);
            stmt.setInt(4, health);
            stmt.setInt(5, stamina);
            stmt.setInt(6, xp);
            stmt.setInt(7, age);
            stmt.setInt(8, rangeDamage);
            stmt.setDouble(9, criticalHitRate);
            stmt.setDouble(10, speed);
            stmt.setDouble(11, cooldown);
            return stmt;
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return null;
    }
}
