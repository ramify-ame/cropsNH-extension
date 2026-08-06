package com.ny3a.cropsnhext.crops;

import java.awt.Color;

import com.gtnewhorizon.cropsnh.api.CropsNHSoilTypes;
import com.gtnewhorizon.cropsnh.api.ISoilList;
import com.ny3a.cropsnhext.init.CropsNHExtItems;

import gregtech.api.enums.Materials;
import gregtech.api.enums.VoltageIndex;

/**
 * Draconic Evolution Draconium crop. Rich purple crystal plant, grows the draconium flower.
 */
public class CropDraconium extends CropNHExtBase {

    public CropDraconium() {
        super(
            "draconium",
            CropsNHExtItems.flowerDraconium,
            Materials.Draconium,
            new Color(0x6A3AA8),
            new Color(0xB48CE0));
    }

    @Override
    public int getTier() {
        return 13;
    }

    @Override
    public int getMachineBreedingRecipeTier() {
        return VoltageIndex.IV;
    }

    @Override
    public int getGrowthDuration() {
        return 14400;
    }

    @Override
    public int getMinSeedBedTier() {
        return 7;
    }

    @Override
    public ISoilList getSoilTypes() {
        return CropsNHSoilTypes.stone;
    }
}
