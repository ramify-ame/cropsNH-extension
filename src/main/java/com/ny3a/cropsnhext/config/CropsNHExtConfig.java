package com.ny3a.cropsnhext.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

/**
 * Debug configuration for the addon. Lets you override the growth points
 * (tick duration) of every custom crop without touching code.
 */
public final class CropsNHExtConfig {

    private static Configuration config;

    private CropsNHExtConfig() {}

    public static void load(File configDir) {
        config = new Configuration(new File(configDir, "cropsnhext.cfg"));
        config.load();
        config
            .setCategoryComment("debug", "Growth points (tick duration) for each custom crop. Higher = slower growth.");

        // touch every key once so the file is generated with all entries
        getGrowthDuration("neutronium", 20000);
        getGrowthDuration("cosmicNeutronium", 200000);
        getGrowthDuration("infinity", 200000);
        getGrowthDuration("infinityCatalyst", 20000);
        getGrowthDuration("draconium", 20000);
        getGrowthDuration("awakenedDraconium", 20000);
        getGrowthDuration("bedrockium", 20000);

        config.save();
    }

    public static int getGrowthDuration(String cropId, int defaultValue) {
        return config.get("debug", cropId, defaultValue)
            .getInt();
    }
}
