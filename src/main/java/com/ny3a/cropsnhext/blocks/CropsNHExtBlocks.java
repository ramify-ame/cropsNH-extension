package com.ny3a.cropsnhext.blocks;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Registers the blocks added by this addon.
 */
public final class CropsNHExtBlocks {

    public static BlockInfinityCatalyst blockInfinityCatalyst;

    private CropsNHExtBlocks() {}

    public static void init() {
        blockInfinityCatalyst = new BlockInfinityCatalyst();
        GameRegistry.registerBlock(blockInfinityCatalyst, "blockInfinityCatalyst");
    }
}
