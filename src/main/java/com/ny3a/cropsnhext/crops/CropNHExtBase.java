package com.ny3a.cropsnhext.crops;

import java.awt.Color;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary;

import com.gtnewhorizon.cropsnh.api.IPlantRenderShape;
import com.gtnewhorizon.cropsnh.api.ISeedShape;
import com.gtnewhorizon.cropsnh.api.PlantRenderShape;
import com.gtnewhorizon.cropsnh.api.SeedShape;
import com.gtnewhorizon.cropsnh.crops.abstracts.NHCropCard;
import com.gtnewhorizon.cropsnh.farming.requirements.SubSoilRequirement;
import com.gtnewhorizon.cropsnh.farming.requirements.growth.MachineOnlyGrowthRequirement;

import gregtech.api.enums.Materials;

/**
 * Shared base for every endgame crop added by this addon.
 * Follows the SpaceFlower template: drops an intermediate flower item,
 * only grows in machines, needs the matching material block underneath,
 * and is duplicated with one dust of the material + enriched fertilizer.
 */
public abstract class CropNHExtBase extends NHCropCard {

    public CropNHExtBase(String internalId, Item flower, Materials material, Color primarySeedColor,
        Color secondarySeedColor) {
        this(
            internalId,
            flower,
            material,
            SubSoilRequirement.get("cropsnhext:" + internalId + "Under")
                .addMaterial(material),
            primarySeedColor,
            secondarySeedColor);
    }

    public CropNHExtBase(String internalId, Item flower, Materials material, SubSoilRequirement subSoil,
        Color primarySeedColor, Color secondarySeedColor) {
        super(internalId, primarySeedColor, secondarySeedColor);
        this.addLikedBiomes(BiomeDictionary.Type.END, BiomeDictionary.Type.DRY);

        // the crop grows a flower, which is then crafted into the material
        this.addDrop(new ItemStack(flower), 100_00);

        // needs the given block(s) under the crop sticks
        this.addSubSoilRequirement(subSoil);

        // machine-only, like spaceFlower
        this.addGrowthRequirement(new MachineOnlyGrowthRequirement());

        // seed duplication: one dust of the material + enriched fertilizer (auto)
        this.addDuplicationCatalyst("dust" + material.mName, 1);
    }

    @Override
    public String getCreator() {
        return "ny3a";
    }

    @Override
    public ISeedShape getSeedShape() {
        return SeedShape.magic;
    }

    @Override
    public IPlantRenderShape getRenderShape() {
        return PlantRenderShape.X;
    }

    @Override
    public boolean isSeedEnchanted() {
        return true;
    }

    @Override
    public int getMaxGrowthStage() {
        return 4;
    }

    @Override
    protected String getBaseTexturePath() {
        return "cropsnhext:crops/" + internalId + "/";
    }
}
