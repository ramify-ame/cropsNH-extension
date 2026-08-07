package com.ny3a.cropsnhext.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.ny3a.cropsnhext.CropsNHExt;

/**
 * Compressed Infinity Catalyst block. Used as the soil block under the
 * Infinity Catalyst crop.
 */
public class BlockInfinityCatalyst extends Block {

    public BlockInfinityCatalyst() {
        super(Material.iron);
        this.setBlockName(CropsNHExt.MODID + ".blockInfinityCatalyst");
        this.setBlockTextureName(CropsNHExt.MODID + ":blockInfinityCatalyst");
        this.setHardness(50.0F);
        this.setResistance(6000.0F);
        this.setHarvestLevel("pickaxe", 4);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
}
