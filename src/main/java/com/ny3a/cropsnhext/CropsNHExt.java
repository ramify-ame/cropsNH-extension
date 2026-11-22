package com.ny3a.cropsnhext;

import com.ny3a.cropsnhext.blocks.CropsNHExtBlocks;
import com.ny3a.cropsnhext.config.CropsNHExtConfig;
import com.ny3a.cropsnhext.init.CropsNHExtItems;
import com.ny3a.cropsnhext.recipes.CropsNHExtRecipes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * GTNH extension mod that adds endgame mineral crops to CropsNH
 * (Neutronium, Cosmic Neutronium, Infinity, Draconium, Awakened Draconium, Bedrockium).
 *
 * The crops follow the SpaceFlower template: they grow an intermediate flower item,
 * need the matching material block underneath, and are bred/duplicated in machines.
 */
@Mod(
    modid = CropsNHExt.MODID,
    name = CropsNHExt.NAME,
    version = CropsNHExt.VERSION,
    dependencies = "required-after:cropsnh;required-after:gregtech")
public class CropsNHExt {

    public static final String MODID = "cropsnhext";
    public static final String NAME = "CropsNH Extension";
    public static final String VERSION = BuildInfo.GRADLETOKEN_VERSION;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        CropsNHExtConfig.load(event.getModConfigurationDirectory());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        CropsNHExtBlocks.init();
        CropsNHExtItems.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        CropsNHExtRecipes.register();
    }
}
