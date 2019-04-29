package domain.guilds;

import domain.individuals.Soldier;
import domain.units.Unit;
import tools.Enrollment;

import java.io.IOException;

public abstract class Guild
{
    protected Enrollment recruitment;

    public Guild()
    {
        this.recruitment =  new Enrollment();
    }

    public abstract Soldier getSoldierById(int id);
    public abstract Unit getUnitById(int id);
    public abstract void nextFewYears(int years);
    public abstract void addSoldier();
    public void read(String firstLine, String[] attributes) throws IOException
    {
        try
        {
            int i = 0, intStatus;
            double doubleStatus;
            for (String attributeName : firstLine.split(","))
            {
                if (!attributes[i].equals("-"))
                {
                    switch (attributeName)
                    {
                        case "Name":
                            recruitment.withName(attributes[i]);
                            break;

                        case "Health":
                            intStatus = Integer.parseInt(attributes[i]);
                            recruitment.withHealth(intStatus);
                            break;

                        case "Stamina":
                            intStatus = Integer.parseInt(attributes[i]);
                            recruitment.withStamina(intStatus);
                            break;

                        case "XP":
                            intStatus = Integer.parseInt(attributes[i]);
                            recruitment.withXp(intStatus);
                            break;

                        case "Age":
                            intStatus = Integer.parseInt(attributes[i]);
                            recruitment.withAge(intStatus);
                            break;

                        case "Range Damage":
                            intStatus = Integer.parseInt(attributes[i]);
                            recruitment.withRangeDamage(intStatus);
                            break;

                        case "Critical Hit Rate":
                            doubleStatus = Double.parseDouble(attributes[i]);
                            recruitment.withCriticalHitRate(doubleStatus);
                            break;

                        case "Watchfullness":
                            intStatus = Integer.parseInt(attributes[i]);
                            recruitment.withWatchfullness(intStatus);
                            break;
                        case "Speed":
                            doubleStatus = Double.parseDouble(attributes[i]);
                            recruitment.withSpeed(doubleStatus);
                            break;

                        case "Cooldown":
                            doubleStatus = Double.parseDouble(attributes[i]);
                            recruitment.withCooldown(doubleStatus);
                            break;

                        case "Armour":
                            intStatus = Integer.parseInt(attributes[i]);
                            recruitment.withArmour(intStatus);
                            break;

                        case "Agility":
                            intStatus = Integer.parseInt(attributes[i]);
                            recruitment.withAgility(intStatus);
                            break;

                        case "Sword Damage":
                            intStatus = Integer.parseInt(attributes[i]);
                            recruitment.withSwordDamage(intStatus);
                            break;

                        case "Stealth":
                            intStatus = Integer.parseInt(attributes[i]);
                            recruitment.withStealth(intStatus);
                            break;

                        case "Survival Rate":
                            doubleStatus = Double.parseDouble(attributes[i]);
                            recruitment.withSurvivalRate(doubleStatus);
                            break;
                    }
                }
                i++;
            }
            addSoldier();
        }
        catch (NumberFormatException exception)
        {
            exception.printStackTrace();
        }
    }
}
