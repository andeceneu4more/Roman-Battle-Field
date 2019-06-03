package domain.individuals;

import domain.units.Ballista;
import tools.Defaults;
import tools.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ballister extends Soldier
{
    protected int watchfullness;

    public Ballister()
    {
        super();
        this.watchfullness = Defaults.WATCHFULLNESS;
    }

    public void setWatchfullness(int watchfullness)
    {
        this.watchfullness = watchfullness;
    }

    public void printSoldier()
    {
        System.out.println(name);
        System.out.println(age);
        System.out.println(soldierId);
        System.out.println(unitId);
        System.out.println(health);
        System.out.println(xp);
        System.out.println(watchfullness);
    }

    public double rating()
    {
        double rating = watchfullness;
        double xpRatio = 1 + ((xp - Defaults.MINIMUM_XP) / (Defaults.MAXIMUM_XP - Defaults.MINIMUM_XP));
        rating = xpRatio * rating;
        return rating;
    }

    public void train(double impact)
    {
        watchfullness = (int) Math.round((1 + impact) * watchfullness);
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
        line.append(watchfullness);
        return line;
    }

    public Ballister copy()
    {
        Ballister ballister = new Ballister();
        ballister.soldierId = this.soldierId;
        ballister.unitId = this.unitId;
        ballister.name = this.name;
        ballister.health = this.health;
        ballister.stamina = this.stamina;
        ballister.xp = this.xp;
        ballister.age = this.age;
        ballister.watchfullness = this.watchfullness;
        return ballister;
    }

    public PreparedStatement insertSoldier()
    {
        try
        {
            Connection connection = Jdbc.getConnection();
            PreparedStatement stmt =  connection.prepareStatement(Defaults.INSERT_NEW_BALLISTA);
            stmt.setInt(1, soldierId);
            stmt.setInt(2, unitId);
            stmt.setString(3, name);
            stmt.setInt(4, health);
            stmt.setInt(5, stamina);
            stmt.setInt(6, xp);
            stmt.setInt(7, age);
            stmt.setInt(8, watchfullness);
            return stmt;
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return null;
    }
}
