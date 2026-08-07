package com.ny3a.cropsnhext.crops;

import java.awt.Color;

import com.gtnewhorizon.cropsnh.api.CropsNHSoilTypes;
import com.gtnewhorizon.cropsnh.api.ISoilList;
import com.ny3a.cropsnhext.config.CropsNHExtConfig;
import com.ny3a.cropsnhext.init.CropsNHExtItems;

import gregtech.api.enums.Materials;
import gregtech.api.enums.VoltageIndex;

/**
 * GT Neutronium crop. Bright silver-white crystal plant, grows the neutronium flower.
 */
public class CropNeutronium extends CropNHExtBase {

    public CropNeutronium() {
        super(
            "neutronium",
            CropsNHExtItems.flowerNeutronium,
            Materials.Neutronium,
            new Color(0xF0F0F0),
            new Color(0x3A3A3A));
    }

    @Override
    public int getTier() {
        return 15;
    }

    @Override
    public int getMachineBreedingRecipeTier() {
        return VoltageIndex.LuV;
    }

    @Override
    public int getGrowthDuration() {
        return CropsNHExtConfig.getGrowthDuration("neutronium", 20000);
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
