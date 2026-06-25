package net.swordie.ms.constants;

import net.swordie.ms.ServerConfig;

import java.util.List;

public class MobExpConstants {
    public record MobExpRate(
        int minLevel,
        double rate
    ) {}

    public static final double MOB_EXP_BASE_RATE = ServerConfig.EXP;

    public static final List<MobExpRate> MOB_EXP_RATE_PER_MIN_LEVEL = List.of(
        new MobExpRate(1, 1),
        new MobExpRate(10, MOB_EXP_BASE_RATE)
    );

    public static double getRateForCharacterLevel(int level) {
        double rate = 1;
        for (MobExpRate mobExpRate : MOB_EXP_RATE_PER_MIN_LEVEL) {
            if (mobExpRate.minLevel() <= level) {
                rate = mobExpRate.rate();
            } else {
                break;
            }
        }
        return rate;
    }
}
