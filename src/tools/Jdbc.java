package tools;

import java.sql.*;
import java.util.ArrayList;

public class Jdbc
{
    public static final String URL = "jdbc:h2:tcp://localhost/~/test";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "";
    public static final String DRIVER_NAME = "org.h2.Driver";

    public static Connection getConnection() throws RuntimeException
    {
        try
        {
            Class.forName(DRIVER_NAME);
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException | ClassNotFoundException exception)
        {
            throw new RuntimeException("Error connecting to the database", exception);
        }
    }

    public static void initTable(String tableName, String createdStatement)
    {
        try (Connection connection = getConnection())
        {
            Statement stmt = connection.createStatement();
            stmt.execute("drop table if exists " + tableName);
            stmt.execute(createdStatement);
        }
        catch (SQLException ex)
        {
            System.out.println("Could not finish database setup!");
            ex.printStackTrace();
        }
    }

    public static void executeStatement(PreparedStatement stmt)
    {
        try
        {
            stmt.executeUpdate();
            stmt.close();
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
    }

    public static void deleteWhere(String table, String condition)
    {
        try (Connection connection = getConnection())
        {
            Statement stmt = connection.createStatement();
            stmt.execute("delete from " + table + " " + condition);
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
    }

    public static void updateWhere(String table, String condition)
    {
        try (Connection connection = getConnection())
        {
            Statement stmt = connection.createStatement();
            stmt.execute("update " + table + " set " + condition);
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
    }

}
