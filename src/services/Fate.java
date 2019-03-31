package services;

import domain.Senate;
import tools.Defaults;

import java.util.Vector;

public class Fate
{
    private static Fate instance = new Fate();
    private double weather, terrain, motivation;
    private int years;

    private Fate() { }

    public void change()
    {
        weather = Math.random() * Defaults.IMPACT;
        terrain = Math.random() * Defaults.IMPACT;
        motivation = Math.random() * Defaults.IMPACT;
    }

    public double getWeather()
    {
        return weather;
    }

    public double getTerrain()
    {
        return terrain;
    }

    public double getMotivation()
    {
        return motivation;
    }

    public static Fate getInstance()
    {
        instance.change();
        return instance;
    }

    public void nextYear()
    {
        years++;
        change();
    }

    public int getYears()
    {
        return years;
    }

    public void resetYears()
    {
        this.years = 0;
    }
}
