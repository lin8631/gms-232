package net.swordie.ms.constants;

import net.swordie.ms.client.jobs.resistance.demon.DemonSlayer;
import net.swordie.ms.handlers.header.OutHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CustomConstants {

    private static final Logger log = LogManager.getLogger(CustomConstants.class);

    private static final String CONFIG_FILE = "resources/pet.properties";

    static {
        loadConfig();
    }

    private static void loadConfig() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            props.load(fis);
            PET_VACUUM_RANGE = Integer.parseInt(props.getProperty("petVacuum.range", String.valueOf(PET_VACUUM_RANGE)));
            PET_VACUUM_INTERVAL = Integer.parseInt(props.getProperty("petVacuum.interval", String.valueOf(PET_VACUUM_INTERVAL)));
            log.info("Loaded pet vacuum config from {}", CONFIG_FILE);
        } catch (IOException e) {
            log.info("No {} found, using defaults.", CONFIG_FILE);
        }
    }
    //Buffed mobs
    public static final int BUFFED_MOB_HP_MULTIPLIER = 1000;
    public static final int BUFFED_MOB_SCALE = 120; //Default scale is 100
    public static final int BUFFED_MOB_DAMAGE_MULTIPLIER = 10;

    public static final boolean AUTO_AGGRO = false;
    public static final int PET_VAC = 4030003;
    public static final int PET_VAC_DELAY = 5000; // in millis
    public static final int PET_VAC_SKILL_ID = 899999990;

    // 宠吸 (Pet Vacuum) - 按角色启用，使用 @petvac 指令开关
    public static int PET_VACUUM_RANGE = 400;              // 拾取范围 (单位)
    public static int PET_VACUUM_INTERVAL = 1200;          // 拾取间隔 (毫秒)


    public static final boolean SSB_AUTOMATIC_ROTATION = true;

    public static final int BOSS_CRYSTAL_PRICE_INCREASE = 0; //percent increase 水晶售賣價格提升倍率
    // GML & MLG Exchange
    public static final int GML_TAX = 10; // 10%
    public static final int MLG_TAX = 20; // 20%
    public static final int GML_WORTH = 1_000_000_000; // 1bil meso
    public static final int MLG_WORTH = 1_000_000; // 1mil cash
    public static final int GOLDEN_MAPLE_LEAF = 4000313; // Item ID
    public static final int MAPLE_LEAF_GOLD = 4430000; // Item ID


    // NodeStones Open QoL (Allow multiple nodestones to be opened in 1 go)
    public static final int MULTI_OPEN_NODESTONE_AMOUNT = 100;

    // Custom Combo Counter Skin
    public static final int COMBO_COUNTER_SKIN_QUEST_ID = 89999999; // skinType=X

    public static boolean isHiddenBlockedOutPacket(OutHeader outHeader) {
        return (outHeader.ordinal() >= OutHeader.REMOTE_MOVE.getValue() && outHeader.ordinal() <= OutHeader.EMOTION.getValue()) ||
                outHeader.equals(OutHeader.USER_ENTER_FIELD);
    }

    public static int getCooldownForSkill(int skillId) {
        switch (skillId) {
            case DemonSlayer.CHAOS_LOCK:
                return 15000;
        }
        return 0;
    }

    public static final boolean LIE_DETECTOR_ENABLED = false;
}
