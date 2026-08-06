package com.ny3a.cropsnhext.crops;

import java.awt.Color;

import com.gtnewhorizon.cropsnh.api.CropsNHSoilTypes;
import com.gtnewhorizon.cropsnh.api.ISoilList;
import com.ny3a.cropsnhext.init.CropsNHExtItems;

import gregtech.api.enums.Materials;
import gregtech.api.enums.VoltageIndex;

/**
 * Extra Utilities Bedrockium crop. Chunky dark-gray rock plant, grows the bedrockium flower.
 */
public class CropBedrockium extends CropNHExtBase {

    public CropBedrockium() {
        super(
            "bedrockium",
            CropsNHExtItems.flowerBedrockium,
            Materials.Bedrockium,
            new Color(0x6E6E6E),
            new Color(0x2E2E2E));
    }

    @Override
    public int getTier() {
        return 13;
    }

    @Override
    public int getMachineBreedingRecipeTier() {
        return VoltageIndex.EV;
    }

    @Override
    public int getGrowthDuration() {
        return 12000;
    }

    @Override
    public int getMinSeedBedTier() {
        return 6;
    }

    @Override
    public ISoilList getSoilTypes() {
        return CropsNHSoilTypes.stone;
    }
}
