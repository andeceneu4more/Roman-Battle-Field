package services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.sql.Timestamp;

public abstract class AuditLog
{
    private static File audit;
    private static BufferedWriter buffer;

    public static void open()
    {
        try
        {
            audit = new File("src/csv/audit-log.csv");
            buffer = new BufferedWriter(new FileWriter(audit));
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    public static void close()
    {
        try
        {
            buffer.close();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    public static void stamp(String functionName)
    {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        try
        {
            String line = functionName + ',' + timestamp.toString();
            buffer.write(line,0, line.length());
            buffer.newLine();
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
