package com.ny3a.cropsnhext.crops;

import java.awt.Color;

import com.gtnewhorizon.cropsnh.api.CropsNHSoilTypes;
import com.gtnewhorizon.cropsnh.api.ISoilList;
import com.ny3a.cropsnhext.config.CropsNHExtConfig;
import com.ny3a.cropsnhext.init.CropsNHExtItems;

import gregtech.api.enums.Materials;
import gregtech.api.enums.VoltageIndex;

/**
 * Avaritia Infinity crop. Iridescent white crystal plant, grows the infinity flower.
 */
public class CropInfinity extends CropNHExtBase {

    public CropInfinity() {
        super("infinity", CropsNHExtItems.flowerInfinity, Materials.Infinity, new Color(0xFFFFFF), new Color(0xD6E4FF));
    }

    @Override
    public int getTier() {
        return 15;
    }

    @Override
    public int getMachineBreedingRecipeTier() {
        return VoltageIndex.UHV;
    }

    @Override
    public int getGrowthDuration() {
        return CropsNHExtConfig.getGrowthDuration("infinity", 200000);
    }

    @Override
    public int getMinSeedBedTier() {
        return 9;
    }

    @Override
    public ISoilList getSoilTypes() {
        return CropsNHSoilTypes.end;
    }
}
