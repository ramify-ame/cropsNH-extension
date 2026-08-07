package com.ny3a.cropsnhext.crops;

import java.awt.Color;

import com.gtnewhorizon.cropsnh.api.BlockWithMeta;
import com.gtnewhorizon.cropsnh.api.CropsNHSoilTypes;
import com.gtnewhorizon.cropsnh.api.ISoilList;
import com.gtnewhorizon.cropsnh.farming.requirements.BlockUnderRequirement;
import com.ny3a.cropsnhext.blocks.CropsNHExtBlocks;
import com.ny3a.cropsnhext.config.CropsNHExtConfig;
import com.ny3a.cropsnhext.init.CropsNHExtItems;

import gregtech.api.enums.Materials;
import gregtech.api.enums.VoltageIndex;

/**
 * Avaritia Infinity Catalyst crop. Warm-white iridescent crystal plant, grows the
 * infinity catalyst flower. Requires a UV seed bed, grows on the Infinity Catalyst block.
 */
public class CropInfinityCatalyst extends CropNHExtBase {

    public CropInfinityCatalyst() {
        super(
            "infinityCatalyst",
            CropsNHExtItems.flowerInfinityCatalyst,
            Materials.InfinityCatalyst,
            blockUnder(),
            new Color(0xF0F0F0),
            new Color(0xC8B890));
    }

    private static BlockUnderRequirement blockUnder() {
        return BlockUnderRequirement.get("cropsnhext:infinityCatalystUnder")
            .addBlock(new BlockWithMeta(CropsNHExtBlocks.blockInfinityCatalyst))
            .addMaterial(Materials.InfinityCatalyst);
    }

    @Override
    public int getTier() {
        return 15;
    }

    @Override
    public int getMachineBreedingRecipeTier() {
        return VoltageIndex.UV;
    }

    @Override
    public int getGrowthDuration() {
        return CropsNHExtConfig.getGrowthDuration("infinityCatalyst", 20000);
    }

    @Override
    public int getMinSeedBedTier() {
        return VoltageIndex.UV;
    }

    @Override
    public ISoilList getSoilTypes() {
        return CropsNHSoilTypes.end;
    }
}
