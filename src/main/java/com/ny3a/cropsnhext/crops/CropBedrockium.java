package com.ny3a.cropsnhext.crops;

import java.awt.Color;

import net.minecraft.block.Block;

import com.gtnewhorizon.cropsnh.api.BlockWithMeta;
import com.gtnewhorizon.cropsnh.api.CropsNHSoilTypes;
import com.gtnewhorizon.cropsnh.api.ISoilList;
import com.gtnewhorizon.cropsnh.farming.requirements.SubSoilRequirement;
import com.ny3a.cropsnhext.config.CropsNHExtConfig;
import com.ny3a.cropsnhext.init.CropsNHExtItems;

import cpw.mods.fml.common.registry.GameRegistry;
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
            subSoil(),
            new Color(0x6E6E6E),
            new Color(0x2E2E2E));
    }

    private static SubSoilRequirement subSoil() {
        SubSoilRequirement under = SubSoilRequirement.get("cropsnhext:bedrockiumUnder")
            .addMaterial(Materials.Bedrockium);
        Block exuBedrockium = GameRegistry.findBlock("ExtraUtilities", "block_bedrockium");
        if (exuBedrockium != null) {
            under.addBlock(new BlockWithMeta(exuBedrockium));
        }
        return under;
    }

    @Override
    public int getTier() {
        return 15;
    }

    @Override
    public int getMachineBreedingRecipeTier() {
        return VoltageIndex.EV;
    }

    @Override
    public int getGrowthDuration() {
        return CropsNHExtConfig.getGrowthDuration("bedrockium", 20000);
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
