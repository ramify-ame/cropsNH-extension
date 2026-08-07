package com.ny3a.cropsnhext.crops;

import java.awt.Color;

import com.gtnewhorizon.cropsnh.api.CropsNHSoilTypes;
import com.gtnewhorizon.cropsnh.api.ISoilList;
import com.ny3a.cropsnhext.config.CropsNHExtConfig;
import com.ny3a.cropsnhext.init.CropsNHExtItems;

import gregtech.api.enums.Materials;
import gregtech.api.enums.VoltageIndex;

/**
 * Draconic Evolution Awakened Draconium crop. Pink/magenta glowing crystal plant,
 * grows the awakened draconium flower.
 */
public class CropAwakenedDraconium extends CropNHExtBase {

    public CropAwakenedDraconium() {
        super(
            "awakenedDraconium",
            CropsNHExtItems.flowerAwakenedDraconium,
            Materials.DraconiumAwakened,
            new Color(0xB86BB8),
            new Color(0x4A2A4A));
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
        return CropsNHExtConfig.getGrowthDuration("awakenedDraconium", 20000);
    }

    @Override
    public int getMinSeedBedTier() {
        return 8;
    }

    @Override
    public ISoilList getSoilTypes() {
        return CropsNHSoilTypes.stone;
    }
}
