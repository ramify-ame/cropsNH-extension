package com.ny3a.cropsnhext.crops;

import java.awt.Color;

import com.gtnewhorizon.cropsnh.api.CropsNHSoilTypes;
import com.gtnewhorizon.cropsnh.api.ISoilList;
import com.ny3a.cropsnhext.config.CropsNHExtConfig;
import com.ny3a.cropsnhext.init.CropsNHExtItems;

import gregtech.api.enums.Materials;
import gregtech.api.enums.VoltageIndex;

/**
 * Avaritia Cosmic Neutronium crop. Near-black crystal with a blue-violet glow,
 * grows the cosmic neutronium flower.
 */
public class CropCosmicNeutronium extends CropNHExtBase {

    public CropCosmicNeutronium() {
        super(
            "cosmicNeutronium",
            CropsNHExtItems.flowerCosmicNeutronium,
            Materials.CosmicNeutronium,
            new Color(0x24242E),
            new Color(0x8FA8E8));
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
        return CropsNHExtConfig.getGrowthDuration("cosmicNeutronium", 200000);
    }

    @Override
    public int getMinSeedBedTier() {
        return 8;
    }

    @Override
    public ISoilList getSoilTypes() {
        return CropsNHSoilTypes.end;
    }
}
