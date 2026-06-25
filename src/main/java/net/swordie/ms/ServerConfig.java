package net.swordie.ms;

import net.swordie.ms.enums.WorldId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ServerConfig {

    private static final Logger log = LogManager.getLogger(ServerConfig.class);

    private static final String CONFIG_FILE = "resources/server.properties";

    static {
        loadConfig();
    }

    private static void loadConfig() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            props.load(fis);

            EXP = parseDouble(props, "server.expMultiplier", EXP);
            COMBO_ORB_EXP_RATE = parseInt(props, "server.comboOrbExpRate", COMBO_ORB_EXP_RATE);
            MULTI_KILL_BONUS_EXP_MULTIPLIER = parseFloat(props, "server.multiKillBonusExpMultiplier", MULTI_KILL_BONUS_EXP_MULTIPLIER);
            BURNING_FIELD_BONUS_EXP_MULTIPLIER_PER_LEVEL = parseInt(props, "server.burningFieldBonusExpMultiplierPerLevel", BURNING_FIELD_BONUS_EXP_MULTIPLIER_PER_LEVEL);
            EXP_PER_KILL = parseInt(props, "server.expPerKill", EXP_PER_KILL);
            ELITE_CHAMPION_ORB_EXP_MULTIPLIER = parseInt(props, "server.eliteChampionOrbExpMultiplier", ELITE_CHAMPION_ORB_EXP_MULTIPLIER);
            DEATH_PENALTY_EXP_DEBUFF = parseInt(props, "server.deathPenaltyExpDebuff", DEATH_PENALTY_EXP_DEBUFF);
            BLUE_EXP_ORB_MULT = parseDouble(props, "server.blueExpOrbMult", BLUE_EXP_ORB_MULT);
            PURPLE_EXP_ORB_MULT = parseDouble(props, "server.purpleExpOrbMult", PURPLE_EXP_ORB_MULT);
            RED_EXP_ORB_MULT = parseDouble(props, "server.redExpOrbMult", RED_EXP_ORB_MULT);
            GOLD_EXP_ORB_MULT = parseDouble(props, "server.goldExpOrbMult", GOLD_EXP_ORB_MULT);

            MOB_DROP_RATE = parseInt(props, "server.mobDropRate", MOB_DROP_RATE);
            MAX_DROP_CHANCE = parseInt(props, "server.maxDropChance", MAX_DROP_CHANCE);
            NX_DROP_CHANCE = parseInt(props, "server.nxDropChance", NX_DROP_CHANCE);
            DEATH_PENALTY_DROP_DEBUFF = parseInt(props, "server.deathPenaltyDropDebuff", DEATH_PENALTY_DROP_DEBUFF);
            F5_MEDAL_DROP_RATE = parseInt(props, "server.f5MedalDropRate", F5_MEDAL_DROP_RATE);
            F15_MEDAL_DROP_RATE = parseInt(props, "server.f15MedalDropRate", F15_MEDAL_DROP_RATE);
            F25_MEDAL_DROP_RATE = parseInt(props, "server.f25MedalDropRate", F25_MEDAL_DROP_RATE);
            F35_MEDAL_DROP_RATE = parseInt(props, "server.f35MedalDropRate", F35_MEDAL_DROP_RATE);
            F45_MEDAL_DROP_RATE = parseInt(props, "server.f45MedalDropRate", F45_MEDAL_DROP_RATE);
            PRIMROSE_SEED_DROP_RATE = parseInt(props, "server.primroseSeedDropRate", PRIMROSE_SEED_DROP_RATE);

            MOB_MESO_RATE = parseInt(props, "server.mobMesoRate", MOB_MESO_RATE);
            MIN_MONEY_MULT = parseInt(props, "server.minMoneyMult", MIN_MONEY_MULT);
            MAX_MONEY_MULT = parseInt(props, "server.maxMoneyMult", MAX_MONEY_MULT);

            MOB_NX_RATE = parseInt(props, "server.mobNxRate", MOB_NX_RATE);

            DEFAULT_FIELD_MOB_RATE_BY_MOBGEN_COUNT = parseDouble(props, "server.defaultFieldMobRateByMobgenCount", DEFAULT_FIELD_MOB_RATE_BY_MOBGEN_COUNT);
            BASE_MOB_RESPAWN_RATE = parseInt(props, "server.baseMobRespawnRate", BASE_MOB_RESPAWN_RATE);
            KISHIN_MOB_MULTIPLIER = parseDouble(props, "server.kishinMobMultiplier", KISHIN_MOB_MULTIPLIER);
            KISHIN_MOB_RATE_MULTIPLIER = parseDouble(props, "server.kishinMobRateMultiplier", KISHIN_MOB_RATE_MULTIPLIER);
            ELITE_MOB_SPAWN_CHANCE = parseInt(props, "server.eliteMobSpawnChance", ELITE_MOB_SPAWN_CHANCE);
            ELITE_BOSS_HP_RATE = parseLong(props, "server.eliteBossHpRate", ELITE_BOSS_HP_RATE);
            HORNTAIL_CHAOS_MULTIPLIER = parseLong(props, "server.horntailChaosMultiplier", HORNTAIL_CHAOS_MULTIPLIER);
            KING_SLIME_MULTIPLIER = parseInt(props, "server.kingSlimeMultiplier", KING_SLIME_MULTIPLIER);

            BUFFED_MOB_HP_MULTIPLIER = parseInt(props, "server.buffedMobHpMultiplier", BUFFED_MOB_HP_MULTIPLIER);
            BUFFED_MOB_DAMAGE_MULTIPLIER = parseInt(props, "server.buffedMobDamageMultiplier", BUFFED_MOB_DAMAGE_MULTIPLIER);
            MOB_SKILL_CHANCE = parseInt(props, "server.mobSkillChance", MOB_SKILL_CHANCE);
            MOB_ATTACK_CHANCE = parseInt(props, "server.mobAttackChance", MOB_ATTACK_CHANCE);

            BASE_CHAR_POT_UP_RATE = parseInt(props, "server.baseCharPotUpRate", BASE_CHAR_POT_UP_RATE);
            RANDOM_EQUIP_UNIQUE_CHANCE = parseInt(props, "server.randomEquipUniqueChance", RANDOM_EQUIP_UNIQUE_CHANCE);
            RANDOM_EQUIP_EPIC_CHANCE = parseInt(props, "server.randomEquipEpicChance", RANDOM_EQUIP_EPIC_CHANCE);
            RANDOM_EQUIP_RARE_CHANCE = parseInt(props, "server.randomEquipRareChance", RANDOM_EQUIP_RARE_CHANCE);
            THIRD_LINE_CHANCE = parseInt(props, "server.thirdLineChance", THIRD_LINE_CHANCE);
            PRIME_LINE_CHANCE = parseInt(props, "server.primeLineChance", PRIME_LINE_CHANCE);

            NEB_D_PROP = parseInt(props, "server.nebDProp", NEB_D_PROP);
            NEB_C_PROP = parseInt(props, "server.nebCProp", NEB_C_PROP);
            NEB_B_PROP = parseInt(props, "server.nebBProp", NEB_B_PROP);
            NEB_A_PROP = parseInt(props, "server.nebAProp", NEB_A_PROP);
            NEB_S_PROP = parseInt(props, "server.nebSProp", NEB_S_PROP);

            RUNE_CURSE_MULTIPLIER_PER_LEVEL = parseInt(props, "server.runeCurseMultiplierPerLevel", RUNE_CURSE_MULTIPLIER_PER_LEVEL);
            RUNE_SPAWN_CHANCE = parseInt(props, "server.runeSpawnChance", RUNE_SPAWN_CHANCE);

            RANDOM_PORTAL_SPAWN_CHANCE = parseInt(props, "server.randomPortalSpawnChance", RANDOM_PORTAL_SPAWN_CHANCE);

            RANK_UP_CHANCE = parseInt(props, "server.rankUpChance", RANK_UP_CHANCE);
            SECONDARY_LINE_PRIME_CHANCE = parseInt(props, "server.secondaryLinePrimeChance", SECONDARY_LINE_PRIME_CHANCE);

            NODE_SELF_JOB_CHANCE = parseInt(props, "server.nodeSelfJobChance", NODE_SELF_JOB_CHANCE);
            NODE_ENFORCE_CHANCE = parseInt(props, "server.nodeEnforceChance", NODE_ENFORCE_CHANCE);
            NODE_SKILL_CHANCE = parseInt(props, "server.nodeSkillChance", NODE_SKILL_CHANCE);

            SURPRISE_MISSION_CHANCE = parseInt(props, "server.surpriseMissionChance", SURPRISE_MISSION_CHANCE);

            LOTUS_FALLING_FOOTHOLD_CHANCE = parseInt(props, "server.lotusFallingFootholdChance", LOTUS_FALLING_FOOTHOLD_CHANCE);
            GOLLUX_DROP_STONE_CHANCE = parseInt(props, "server.golluxDropStoneChance", GOLLUX_DROP_STONE_CHANCE);
            BOSS_CRYSTAL_PRICE_INCREASE = parseInt(props, "server.bossCrystalPriceIncrease", BOSS_CRYSTAL_PRICE_INCREASE);

            AUCTION_TAX = parseDouble(props, "server.auctionTax", AUCTION_TAX);
            GML_TAX = parseInt(props, "server.gmlTax", GML_TAX);
            MLG_TAX = parseInt(props, "server.mlgTax", MLG_TAX);

            CLEAR_CACHE_RATE = parseLong(props, "server.clearCacheRate", CLEAR_CACHE_RATE);
            LIE_DETECTOR_CHANCE = parseInt(props, "server.lieDetectorChance", LIE_DETECTOR_CHANCE);

            STR_HP_MULT = parseDouble(props, "server.strHpMult", STR_HP_MULT);
            STR_MP_MULT = parseDouble(props, "server.strMpMult", STR_MP_MULT);
            INT_HP_MULT = parseDouble(props, "server.intHpMult", INT_HP_MULT);
            INT_MP_MULT = parseDouble(props, "server.intMpMult", INT_MP_MULT);

            CHANCE_TO_HEAL_HP = parseInt(props, "server.chanceToHealHp", CHANCE_TO_HEAL_HP);
            CHANCE_TO_HEAL_MP = parseInt(props, "server.chanceToHealMp", CHANCE_TO_HEAL_MP);
            CHILLING_STEP_BOSS_MODE_PROC_CHANCE = parseInt(props, "server.chillingStepBossModeProcChance", CHILLING_STEP_BOSS_MODE_PROC_CHANCE);
            DRAGON_STRIKE_DEBUFF_DURATION_MULTIPLIER = parseInt(props, "server.dragonStrikeDebuffDurationMultiplier", DRAGON_STRIKE_DEBUFF_DURATION_MULTIPLIER);
            ORBITAL_FLAME_RANGE_MULTIPLIER = parseDouble(props, "server.orbitalFlameRangeMultiplier", ORBITAL_FLAME_RANGE_MULTIPLIER);
            TRIFFLING_WIND_SIMPACT_MULTIPLIER_PER_SECOND = parseDouble(props, "server.trifflingWindSimpactMultiplierPerSecond", TRIFFLING_WIND_SIMPACT_MULTIPLIER_PER_SECOND);
            TRIFFLING_WIND_SIMPACT_MULTIPLIER_MAX = parseDouble(props, "server.trifflingWindSimpactMultiplierMax", TRIFFLING_WIND_SIMPACT_MULTIPLIER_MAX);
            NETHER_SHIELD_BY_EXECUTION_CHANCE = parseInt(props, "server.netherShieldByExecutionChance", NETHER_SHIELD_BY_EXECUTION_CHANCE);
            GOD_OF_BLADES_BLADE_ENERGY_MULTIPLIER = parseInt(props, "server.godOfBladesBladeEnergyMultiplier", GOD_OF_BLADES_BLADE_ENERGY_MULTIPLIER);
            ADVANCED_TILES_DURATION_MULTIPLIER = parseInt(props, "server.advancedTilesDurationMultiplier", ADVANCED_TILES_DURATION_MULTIPLIER);
            MIND_BREAK_FD_MULTIPLIER = parseInt(props, "server.mindBreakFdMultiplier", MIND_BREAK_FD_MULTIPLIER);
            ELITE_CHAMPION_MIN_DMG_RATIO_FOR_REWARD = parseInt(props, "server.eliteChampionMinDmgRatioForReward", ELITE_CHAMPION_MIN_DMG_RATIO_FOR_REWARD);

            DEFAULT_fieldID = parseInt(props, "server.defaultFieldID", DEFAULT_fieldID);

            log.info("Loaded server config from {}", CONFIG_FILE);
        } catch (IOException e) {
            log.info("No {} found, using defaults.", CONFIG_FILE);
        }
    }

    private static int parseInt(Properties props, String key, int def) {
        return Integer.parseInt(props.getProperty(key, String.valueOf(def)));
    }

    private static long parseLong(Properties props, String key, long def) {
        return Long.parseLong(props.getProperty(key, String.valueOf(def)));
    }

    private static double parseDouble(Properties props, String key, double def) {
        return Double.parseDouble(props.getProperty(key, String.valueOf(def)));
    }

    private static float parseFloat(Properties props, String key, float def) {
        return Float.parseFloat(props.getProperty(key, String.valueOf(def)));
    }

    // --- Non-configurable constants ---
    public static final int USER_LIMIT = 500;
    public static final WorldId WORLD_ID = WorldId.Bera;
    public static final String SERVER_NAME = "Bera";
    public static final String EVENT_MSG = String.format("#bSwordie#k v%d.%s\r\nPlayers online: #b", ServerConstants.VERSION, ServerConstants.MINOR_VERSION);
    public static final String RECOMMEND_MSG = "I recommend this world to you.";
    public static final int MAX_CHARACTERS = 30;
    public static final String HEAP_DUMP_DIR = "../heapdumps";

    // --- EXP Rates ---
    public static double EXP = 500;
    public static int COMBO_ORB_EXP_RATE = 1;
    public static float MULTI_KILL_BONUS_EXP_MULTIPLIER = 0.01f;
    public static int BURNING_FIELD_BONUS_EXP_MULTIPLIER_PER_LEVEL = 5;
    public static int EXP_PER_KILL = 1;
    public static int ELITE_CHAMPION_ORB_EXP_MULTIPLIER = 15;
    public static int DEATH_PENALTY_EXP_DEBUFF = 80;
    public static double BLUE_EXP_ORB_MULT = 2;
    public static double PURPLE_EXP_ORB_MULT = 3.5;
    public static double RED_EXP_ORB_MULT = 5;
    public static double GOLD_EXP_ORB_MULT = 7;

    // --- Drop Rates ---
    public static int MOB_DROP_RATE = 1;
    public static int MAX_DROP_CHANCE = 10000;
    public static int NX_DROP_CHANCE = 25;
    public static int DEATH_PENALTY_DROP_DEBUFF = 80;
    public static int F5_MEDAL_DROP_RATE = 90;
    public static int F15_MEDAL_DROP_RATE = 70;
    public static int F25_MEDAL_DROP_RATE = 60;
    public static int F35_MEDAL_DROP_RATE = 50;
    public static int F45_MEDAL_DROP_RATE = 50;
    public static int PRIMROSE_SEED_DROP_RATE = 80;

    // --- Meso Rates ---
    public static int MOB_MESO_RATE = 2;
    public static int MIN_MONEY_MULT = 20;
    public static int MAX_MONEY_MULT = 40;

    // --- NX Rates ---
    public static int MOB_NX_RATE = 1;

    // --- Mob Spawn ---
    public static double DEFAULT_FIELD_MOB_RATE_BY_MOBGEN_COUNT = 1.5;
    public static int BASE_MOB_RESPAWN_RATE = 5000;
    public static double KISHIN_MOB_MULTIPLIER = 1.7;
    public static double KISHIN_MOB_RATE_MULTIPLIER = 1.7;
    public static int ELITE_MOB_SPAWN_CHANCE = 5;
    public static long ELITE_BOSS_HP_RATE = 500;

    // --- Mob Stats ---
    public static int BUFFED_MOB_HP_MULTIPLIER = 1000;
    public static int BUFFED_MOB_DAMAGE_MULTIPLIER = 10;
    public static int MOB_SKILL_CHANCE = 20;
    public static int MOB_ATTACK_CHANCE = 40;

    // --- Potential / Inner Ability ---
    public static int BASE_CHAR_POT_UP_RATE = 10;
    public static int RANDOM_EQUIP_UNIQUE_CHANCE = 1;
    public static int RANDOM_EQUIP_EPIC_CHANCE = 3;
    public static int RANDOM_EQUIP_RARE_CHANCE = 8;
    public static int THIRD_LINE_CHANCE = 50;
    public static int PRIME_LINE_CHANCE = 15;

    // --- Nebulite ---
    public static int NEB_D_PROP = 40;
    public static int NEB_C_PROP = 20;
    public static int NEB_B_PROP = 15;
    public static int NEB_A_PROP = 15;
    public static int NEB_S_PROP = 10;

    // --- Rune ---
    public static int RUNE_CURSE_MULTIPLIER_PER_LEVEL = 25;
    public static int RUNE_SPAWN_CHANCE = 100;

    // --- Random Portal ---
    public static int RANDOM_PORTAL_SPAWN_CHANCE = 25;

    // --- Familiar ---
    public static int RANK_UP_CHANCE = 4;
    public static int SECONDARY_LINE_PRIME_CHANCE = 50;

    // --- Nodestone ---
    public static int NODE_SELF_JOB_CHANCE = 75;
    public static int NODE_ENFORCE_CHANCE = 60;
    public static int NODE_SKILL_CHANCE = 30;

    // --- Surprise Mission ---
    public static int SURPRISE_MISSION_CHANCE = 5;

    // --- Boss ---
    public static int LOTUS_FALLING_FOOTHOLD_CHANCE = 60;
    public static long HORNTAIL_CHAOS_MULTIPLIER = 4;
    public static int GOLLUX_DROP_STONE_CHANCE = 25;
    public static int BOSS_CRYSTAL_PRICE_INCREASE = 0;
    public static int KING_SLIME_MULTIPLIER = 30;

    // --- Commerce / Tax ---
    public static double AUCTION_TAX = 0.95;
    public static int GML_TAX = 10;
    public static int MLG_TAX = 20;

    // --- Misc ---
    public static long CLEAR_CACHE_RATE = 4;
    public static int LIE_DETECTOR_CHANCE = 7000;

    // --- Stat Multipliers ---
    public static double STR_HP_MULT = 1.5;
    public static double STR_MP_MULT = 0.75;
    public static double INT_HP_MULT = 0.75;
    public static double INT_MP_MULT = 1.5;

    // --- Skill Constants ---
    public static int CHANCE_TO_HEAL_HP = 70;
    public static int CHANCE_TO_HEAL_MP = 70;
    public static int CHILLING_STEP_BOSS_MODE_PROC_CHANCE = 90;
    public static int DRAGON_STRIKE_DEBUFF_DURATION_MULTIPLIER = 3;
    public static double ORBITAL_FLAME_RANGE_MULTIPLIER = 1.5;
    public static double TRIFFLING_WIND_SIMPACT_MULTIPLIER_PER_SECOND = 5;
    public static double TRIFFLING_WIND_SIMPACT_MULTIPLIER_MAX = 6;
    public static int NETHER_SHIELD_BY_EXECUTION_CHANCE = 40;
    public static int GOD_OF_BLADES_BLADE_ENERGY_MULTIPLIER = 2;
    public static int ADVANCED_TILES_DURATION_MULTIPLIER = 2;
    public static int MIND_BREAK_FD_MULTIPLIER = 3;
    public static int ELITE_CHAMPION_MIN_DMG_RATIO_FOR_REWARD = 3;

    // --- Map fallback ---
    public static int DEFAULT_fieldID = 100000000;
}
