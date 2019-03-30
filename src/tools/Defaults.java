package tools;

import domain.individuals.Archer;
import domain.individuals.Commander;

public interface Defaults
{
    // Soldier
    public static String name = "Marcus Antonius";
    public static String origin = "roman";
    public static int health = 100;
    public static double standardTime = 2000;
    public static int minimumAge = 18;
    public static int maximumAge = 50;
    public static int minimumXP = 30;
    public static int maximumXP = 260;

    // Commander
    public static int abilities = 85;
    public static int minimumAbilities = 80;
    public static int maximumAbilities = 520;

    // Archer
    public static int rangeDamage = 15;
    public static double criticalHitRate = 0.2;

    // ArcherUnit
    public static double archersRangedRatio = 0.00035;
    public static double archersMeleeRatio = 0.0005;
    public static double archersDamageRatio = 0.0005;

    // Ballister
    public static int watchfullness = 65;
    public static int minimumWatchfullness = 40;
    public static int maximumWatchfullness = 95;

    // Ballista
    public static double cooldown = 45;
    public static double ballistersRangedRatio = 0.2;
    public static double ballistersMeleeRatio = 0.1;
    public static double ballistersDamageRatio = 0.0265;

    // ChariotArcher
    public static double chariotSpeed = 15;
    public static int chariotCooldown = 60;

    // ChariotArcherUnit
    public static double chariotRangedRatio = 0.02;
    public static double chariotMeleeRatio = 0.003;
    public static double chariotDamageRatio = 0.025;

    // Knight
    public static double knightSpeed = 70;
    public static int knightDamage = 25;

    // LightInfantryman
    public static int lightDamage = 40;
    public static int agility = 35;

    // HeavyInfantryman
    public static int heavyDamage = 70;
    public static int armour = 50;

    // Ranger
    public static double survivalRate = 0.3;
    public static int stealth = 25;




}
