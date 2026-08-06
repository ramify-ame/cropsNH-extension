package com.ny3a.cropsnhext.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.ny3a.cropsnhext.CropsNHExt;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Registers the intermediate "flower" items dropped by the addon crops.
 */
public class CropsNHExtItems {

    public static Item flowerNeutronium;
    public static Item flowerCosmicNeutronium;
    public static Item flowerInfinity;
    public static Item flowerInfinityCatalyst;
    public static Item flowerDraconium;
    public static Item flowerAwakenedDraconium;
    public static Item flowerBedrockium;

    private CropsNHExtItems() {}

    public static void init() {
        flowerNeutronium = register("flowerNeutronium");
        flowerCosmicNeutronium = register("flowerCosmicNeutronium");
        flowerInfinity = register("flowerInfinity");
        flowerInfinityCatalyst = register("flowerInfinityCatalyst");
        flowerDraconium = register("flowerDraconium");
        flowerAwakenedDraconium = register("flowerAwakenedDraconium");
        flowerBedrockium = register("flowerBedrockium");
    }

    private static Item register(String name) {
        Item item = new Item().setUnlocalizedName(CropsNHExt.MODID + "." + name)
            .setTextureName(CropsNHExt.MODID + ":" + name)
            .setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerItem(item, name);
        return item;
    }
}
