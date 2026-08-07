package com.ny3a.cropsnhext.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.ny3a.cropsnhext.blocks.CropsNHExtBlocks;
import com.ny3a.cropsnhext.init.CropsNHExtItems;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.util.GTRecipeConstants;

/**
 * Machine and crafting recipes for the addon's flower items.
 * Registered in postInit, after the flower items exist.
 */
public final class CropsNHExtRecipes {

    private CropsNHExtRecipes() {}

    public static void register() {
        registerLCRRecipes();
        registerCompressorRecipes();
        registerDTPFRecipes();
    }

    /**
     * Large Chemical Reactor recipes.
     */
    private static void registerLCRRecipes() {
        // 4x neutronium flower + 4000L phthalic acid -> 1152L molten neutronium (1,966,080 EU/t, 100s)
        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(CropsNHExtItems.flowerNeutronium, 4))
            .fluidInputs(Materials.PhthalicAcid.getFluid(4000))
            .fluidOutputs(Materials.Neutronium.getMolten(1152))
            .circuit(24)
            .duration(200)
            .eut(1966080)
            .addTo(RecipeMaps.multiblockChemicalReactorRecipes);
        // 4x cosmicneutronium flower + 4000L phthalic acid -> 1152L molten cosmicneutronium (1,966,080 EU/t, 100s)
        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(CropsNHExtItems.flowerCosmicNeutronium, 4))
            .fluidInputs(Materials.PhthalicAcid.getFluid(4000))
            .fluidOutputs(Materials.CosmicNeutronium.getMolten(1152))
            .circuit(24)
            .duration(200)
            .eut(1966080)
            .addTo(RecipeMaps.multiblockChemicalReactorRecipes);
        // 4x bedrockium flower + 2000L phthalic acid -> 8x bedrockium dust (7680 EU/t, 10s)
        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(CropsNHExtItems.flowerBedrockium, 4))
            .fluidInputs(Materials.PhthalicAcid.getFluid(2000))
            .itemOutputs(Materials.Bedrockium.getDust(8))
            .duration(200)
            .eut(7680)
            .addTo(RecipeMaps.multiblockChemicalReactorRecipes);
        // 4x cosmicneutronium flower + 2000L phthalic acid -> 8x cosmicneutronium dust (30,720 EU/t, 10s)
        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(CropsNHExtItems.flowerCosmicNeutronium, 4))
            .fluidInputs(Materials.PhthalicAcid.getFluid(2000))
            .itemOutputs(Materials.CosmicNeutronium.getDust(8))
            .duration(200)
            .eut(30720)
            .addTo(RecipeMaps.multiblockChemicalReactorRecipes);
        // 4x neutronium flower + 2000L phthalic acid -> 8x neutroniumdust (30,720 EU/t, 10s)
        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(CropsNHExtItems.flowerNeutronium, 4))
            .fluidInputs(Materials.PhthalicAcid.getFluid(2000))
            .itemOutputs(Materials.Neutronium.getDust(8))
            .duration(200)
            .eut(30720)
            .addTo(RecipeMaps.multiblockChemicalReactorRecipes);
        // 4x infinity catalyst flower + 2000L phthalic acid -> 8x infinity catalyst dust (30,720 EU/t, 10s)
        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(CropsNHExtItems.flowerInfinityCatalyst, 4))
            .fluidInputs(Materials.PhthalicAcid.getFluid(2000))
            .itemOutputs(Materials.InfinityCatalyst.getDust(8))
            .duration(200)
            .eut(30720)
            .addTo(RecipeMaps.multiblockChemicalReactorRecipes);
        // 4x infinity catalyst flower + 1x space flower + 2000L phthalic acid -> 32x infinity catalyst dust (4x)
        Item spaceFlower = GameRegistry.findItem("cropsnh", "materialLeaf");
        if (spaceFlower != null) {
            GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(CropsNHExtItems.flowerInfinityCatalyst, 4), new ItemStack(spaceFlower, 1, 17))
                .fluidInputs(Materials.PhthalicAcid.getFluid(2000))
                .itemOutputs(Materials.InfinityCatalyst.getDust(32))
                .circuit(1)
                .duration(100)
                .eut(122880)
                .addTo(RecipeMaps.multiblockChemicalReactorRecipes);
        }
        // 4x Draconium flower + 2000L phthalic acid -> 8x Draconium dust (7680 EU/t, 10s)
        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(CropsNHExtItems.flowerDraconium, 4))
            .fluidInputs(Materials.PhthalicAcid.getFluid(2000))
            .itemOutputs(Materials.Draconium.getDust(8))
            .duration(200)
            .eut(7680)
            .addTo(RecipeMaps.multiblockChemicalReactorRecipes);
        // 4x Draconium flower + 1x dragon egg (not consumed) + 2000L phthalic acid -> 32x Draconium dust (4x)
        GTValues.RA.stdBuilder()
            .itemInputs(
                new ItemStack(CropsNHExtItems.flowerDraconium, 4),
                new ItemStack(Item.getItemFromBlock(Blocks.dragon_egg), 0))
            .fluidInputs(Materials.PhthalicAcid.getFluid(2000))
            .itemOutputs(Materials.Draconium.getDust(32))
            .circuit(1)
            .duration(100)
            .eut(30720)
            .addTo(RecipeMaps.multiblockChemicalReactorRecipes);
        // 4x AwakenedDraconium + 2000L phthalic acid -> 8x AwakenedDraconium (30,720 EU/t, 10s)
        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(CropsNHExtItems.flowerAwakenedDraconium, 4))
            .fluidInputs(Materials.PhthalicAcid.getFluid(2000))
            .itemOutputs(Materials.DraconiumAwakened.getDust(8))
            .duration(200)
            .eut(30720)
            .addTo(RecipeMaps.multiblockChemicalReactorRecipes);
        // 4x AwakenedDraconium flower + 1x dragon heart (not consumed) + 2000L phthalic acid -> 32x AwakenedDraconium
        // dust (4x)
        Item dragonHeart = GameRegistry.findItem("DraconicEvolution", "dragonHeart");
        if (dragonHeart != null) {
            GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(CropsNHExtItems.flowerAwakenedDraconium, 4), new ItemStack(dragonHeart, 0))
                .fluidInputs(Materials.PhthalicAcid.getFluid(2000))
                .itemOutputs(Materials.DraconiumAwakened.getDust(32))
                .circuit(1)
                .duration(100)
                .eut(122880)
                .addTo(RecipeMaps.multiblockChemicalReactorRecipes);
        }

    }

    /**
     * Compressor recipes.
     */
    private static void registerCompressorRecipes() {
        // 9x infinity catalyst ingot -> 1x infinity catalyst block (491520 EU/t, 196 ticks)
        GTValues.RA.stdBuilder()
            .itemInputs(Materials.InfinityCatalyst.getIngots(9))
            .itemOutputs(new ItemStack(CropsNHExtBlocks.blockInfinityCatalyst))
            .duration(196)
            .eut(491520)
            .addTo(RecipeMaps.compressorRecipes);
    }

    /**
     * Transcendent Plasma Forge (DTPF) recipes.
     * The flower replaces the GT Bees honeycomb used in the vanilla DTPF reactions and yields
     * twice the molten output. Params mirror the real comb recipes from GTNewHorizonsCoreMod's
     * DTPFRecipes (DTPFCalculator tier values, coil heats 10800-13500).
     */
    private static void registerDTPFRecipes() {
        registerInfinityDTPFRecipes();
        registerCosmicNeutroniumDTPFRecipes();
    }

    private static ItemStack infinityCatalyst(int count) {
        Item catalyst = GameRegistry.findItem("Avaritia", "Resource");
        return catalyst != null ? new ItemStack(catalyst, count, 5) : Materials.InfinityCatalyst.getDust(count);
    }

    /**
     * All four DTPF catalyst tiers for Infinity (flower replaces the infinity comb, 2x molten).
     */
    private static void registerInfinityDTPFRecipes() {
        ItemStack flower = new ItemStack(CropsNHExtItems.flowerInfinity);

        // tier 4: excited DTSC catalyst (2x of 36864L)
        GTValues.RA.stdBuilder()
            .itemInputs(flower, infinityCatalyst(4))
            .fluidInputs(Materials.ExcitedDTSC.getFluid(9667))
            .fluidOutputs(Materials.DTR.getFluid(19334), Materials.Infinity.getMolten(73728))
            .circuit(3)
            .duration(625)
            .eut(819200000)
            .metadata(GTRecipeConstants.COIL_HEAT, 13500)
            .addTo(RecipeMaps.plasmaForgeRecipes);

        // tier 3: excited DTEC catalyst (2x of 18432L)
        GTValues.RA.stdBuilder()
            .itemInputs(flower, infinityCatalyst(2))
            .fluidInputs(Materials.ExcitedDTEC.getFluid(22307))
            .fluidOutputs(Materials.DTR.getFluid(22307), Materials.Infinity.getMolten(36864))
            .circuit(3)
            .duration(1250)
            .eut(409600000)
            .metadata(GTRecipeConstants.COIL_HEAT, 13500)
            .addTo(RecipeMaps.plasmaForgeRecipes);

        // tier 2: excited DTRC catalyst (2x of 9216L)
        GTValues.RA.stdBuilder()
            .itemInputs(flower, infinityCatalyst(1))
            .fluidInputs(Materials.ExcitedDTRC.getFluid(50092))
            .fluidOutputs(Materials.DTR.getFluid(25046), Materials.Infinity.getMolten(18432))
            .circuit(2)
            .duration(2500)
            .eut(204800000)
            .metadata(GTRecipeConstants.COIL_HEAT, 12600)
            .addTo(RecipeMaps.plasmaForgeRecipes);

        // tier 1: excited DTRC catalyst, diluted (2x of 144L)
        GTValues.RA.stdBuilder()
            .itemInputs(flower, infinityCatalyst(1))
            .fluidInputs(Materials.ExcitedDTRC.getFluid(782))
            .fluidOutputs(Materials.DTR.getFluid(391), Materials.Infinity.getMolten(288))
            .circuit(3)
            .duration(19)
            .eut(3200000)
            .metadata(GTRecipeConstants.COIL_HEAT, 10800)
            .addTo(RecipeMaps.plasmaForgeRecipes);
    }

    /**
     * All four DTPF catalyst tiers for Cosmic Neutronium (flower replaces the cosmic comb, 2x molten).
     * The vanilla cosmic recipes derive their cost params from the material's EBF recipe at load time,
     * so the catalyst/residue/duration/eut below follow the same tier scaling as the Infinity ones.
     */
    private static void registerCosmicNeutroniumDTPFRecipes() {
        ItemStack flower = new ItemStack(CropsNHExtItems.flowerCosmicNeutronium);

        // tier 4: excited DTEC catalyst (2x of 589824L)
        GTValues.RA.stdBuilder()
            .itemInputs(flower)
            .fluidInputs(Materials.ExcitedDTEC.getFluid(889), Materials.Copper.getMolten(589824))
            .fluidOutputs(Materials.DTR.getFluid(889), Materials.CosmicNeutronium.getMolten(1179648))
            .circuit(1)
            .duration(106)
            .eut(409600000)
            .metadata(GTRecipeConstants.COIL_HEAT, 13500)
            .addTo(RecipeMaps.plasmaForgeRecipes);

        // tier 3: excited DTRC catalyst (2x of 294912L)
        GTValues.RA.stdBuilder()
            .itemInputs(flower)
            .fluidInputs(Materials.ExcitedDTRC.getFluid(2108), Materials.Copper.getMolten(294912))
            .fluidOutputs(Materials.DTR.getFluid(1054), Materials.CosmicNeutronium.getMolten(589824))
            .circuit(1)
            .duration(213)
            .eut(204800000)
            .metadata(GTRecipeConstants.COIL_HEAT, 12600)
            .addTo(RecipeMaps.plasmaForgeRecipes);

        // tier 2: excited DTPC catalyst (2x of 147456L)
        GTValues.RA.stdBuilder()
            .itemInputs(flower)
            .fluidInputs(Materials.ExcitedDTPC.getFluid(4886), Materials.Copper.getMolten(147456))
            .fluidOutputs(Materials.DTR.getFluid(1221), Materials.CosmicNeutronium.getMolten(294912))
            .circuit(1)
            .duration(427)
            .eut(102400000)
            .metadata(GTRecipeConstants.COIL_HEAT, 11700)
            .addTo(RecipeMaps.plasmaForgeRecipes);

        // tier 1: excited DTCC catalyst (2x of 73728L)
        GTValues.RA.stdBuilder()
            .itemInputs(flower)
            .fluidInputs(Materials.ExcitedDTCC.getFluid(12486), Materials.Copper.getMolten(73728))
            .fluidOutputs(Materials.DTR.getFluid(1560), Materials.CosmicNeutronium.getMolten(147456))
            .circuit(1)
            .duration(854)
            .eut(51200000)
            .metadata(GTRecipeConstants.COIL_HEAT, 10800)
            .addTo(RecipeMaps.plasmaForgeRecipes);
    }
}
