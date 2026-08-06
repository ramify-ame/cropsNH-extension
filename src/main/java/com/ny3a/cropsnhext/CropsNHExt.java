package com.ny3a.cropsnhext;

import com.gtnewhorizon.cropsnh.loaders.gtrecipes.CropBreederFakeRecipeLoader;
import com.gtnewhorizon.cropsnh.loaders.gtrecipes.CropGeneExtractorFakeRecipeLoader;
import com.gtnewhorizon.cropsnh.loaders.gtrecipes.CropSynthesizerFakeRecipeLoader;
import com.gtnewhorizon.cropsnh.loaders.gtrecipes.SeedGeneratorFakeRecipeLoader;
import com.ny3a.cropsnhext.crops.CropExtender;
import com.ny3a.cropsnhext.init.CropsNHExtItems;
import com.ny3a.cropsnhext.recipes.CropsNHExtRecipes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

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
    dependencies = "required-after:cropsnh; required-after:gregtech")
public class CropsNHExt {

    public static final String MODID = "cropsnhext";
    public static final String NAME = "CropsNH Extension";
    public static final String VERSION = "1.0.0";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        CropsNHExtItems.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        CropExtender.register();
        CropsNHExtRecipes.register();

        // CropsNH builds the machine recipe maps during its own postInit, which already ran
        // by the time this mod (required-after:cropsnh) is processed. Re-run the fake recipe
        // loaders so the newly registered crops also get their breeding/duplication recipes.
        // The GT recipe maps de-duplicate, so this is safe to call again.
        CropBreederFakeRecipeLoader.postInit();
        SeedGeneratorFakeRecipeLoader.postInit();
        CropSynthesizerFakeRecipeLoader.postInit();
        CropGeneExtractorFakeRecipeLoader.postInit();
    }
}
