package tools;

public interface Defaults
{
    // Soldier
    public static final String NAME = "Marcus Antonius";
    public static final int HEALTH = 100;
    public static final int STAMINA = 100;
    public static final double STANDARD_TIME = 2000;
    public static final int MINIMUM_AGE = 18;
    public static final int MAXIMUM_AGE = 50;
    public static final int MINIMUM_XP = 30;
    public static final int MAXIMUM_XP = 260;

    // Archer
    public static final int RANGE_DAMAGE = 15;
    public static final double CRITICAL_HIT_RATE = 0.2;

    // ArcherUnit
    public static final double ARCHERS_RANGED_RATIO = 0.00035;
    public static final double ARCHERS_MELEE_RATIO = 0.0005;
    public static final double ARCHERS_DAMAGE_RATIO = 0.0005;
    public static final String ARCHERS_HEADER = "Soldier ID,Unit ID,Name,Health,Stamina,Xp,Age,Range Damage,Critical Hit Rate";

    // Ballister
    public static final int WATCHFULLNESS = 65;

    // Ballista
    public static final double COOLDOWN = 45;
    public static final double BALLISTERS_RANGED_RATIO = 0.2;
    public static final double BALLISTERS_MELEE_RATIO = 0.1;
    public static final double BALLISTERS_DAMAGE_RATIO = 0.0265;
    public static final String BALLISTA_HEADER = "Soldier ID,Unit ID,Name,Health,Stamina,Xp,Age,Watchfullness,Cooldown";

    // ChariotArcher
    public static final double CHARIOT_SPEED = 15;
    public static final int CHARIOT_COOLDOWN = 60;

    // ChariotArcherUnit
    public static final double CHARIOT_RANGED_RATIO = 0.02;
    public static final double CHARIOT_MELEE_RATIO = 0.003;
    public static final double CHARIOT_DAMAGE_RATIO = 0.025;
    public static final String CHARIOT_HEADER = "Soldier ID,Unit ID,Name,Health,Stamina,Xp,Age,Range Damage,Critical Hit Rate,Speed,Cooldown";

    // Knight
    public static final double KNIGHT_SPEED = 70;
    public static final int KNIGHT_DAMAGE = 25;

    // Knight Unit
    public static final double KNIGHT_RANGED_RATIO = 0.38;
    public static final double KNIGHT_MELEE_RATIO = 0.25;
    public static final double KNIGHT_DAMAGE_RATIO = 0.25;
    public static final String KNIGHT_HEADER = "Soldier ID,Unit ID,Name,Health,Stamina,Xp,Age,Sword Damage,Speed";

    // LightInfantryman
    public static final int LIGHT_DAMAGE = 40;
    public static final int AGILITY = 35;

    // LightInfantrymanUnit
    public static final double LIGHT_RANGED_RATIO = 0.8;
    public static final double LIGHT_MELEE_RATIO = 0.7;
    public static final double LIGHT_DAMAGE_RATIO = 0.42;
    public static final String LIGHT_HEADER = "Soldier ID,Unit ID,Name,Health,Stamina,Xp,Age,Sword Damage,Agility";

    // HeavyInfantryman
    public static final int HEAVY_DAMAGE = 70;
    public static final int ARMOUR = 50;

    // HeavyInfantrymanUnit
    public static final double HEAVY_RANGED_RATIO = 0.9;
    public static final double HEAVY_MELEE_RATIO = 1.2;
    public static final double HEAVY_DAMAGE_RATIO = 0.5;
    public static final String HEAVY_HEADER = "Soldier ID,Unit ID,Name,Health,Stamina,Xp,Age,Sword Damage,Armour";

    // Ranger
    public static final double SURVIVAL_RATE = 0.3;
    public static final int STEALTH = 25;

    // RangerUnit
    public static final double RANGER_RANGED_RATIO = 0.00056;
    public static final double RANGER_MELEE_RATIO = 0.0005;
    public static final double RANGER_DAMAGE_RATIO = 0.0008;
    public static final String RANGER_HEADER = "Soldier ID,Unit ID,Name,Health,Stamina,Xp,Age,Survival Rate,Stealth";

    // Fate
    public static final double IMPACT = 100;
    public static final int FACTORS = 3;

    // Training
    public static final double UNIFORM_RATIO = 0.2;
    public static final double BIASED_RATIO = 0.15;
    public static final double BIASED_PERCENT = 0.1;

    // Unit
    public static final int UNIT_CAPACITY = 10;
    public static final int DISCIPLINE = 85;
    public static final int MINIMUM_DISCIPLINE = 80;
    public static final int MAXIMUM_DISCIPLE = 520;
    public static final int DISCIPLINE_STEP = 10;
}
