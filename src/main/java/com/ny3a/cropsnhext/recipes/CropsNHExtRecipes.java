package com.ny3a.cropsnhext.recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
        registerCraftingRecipes();
        registerCompressorRecipes();
        registerDTPFRecipes();
    }

    /**
     * Large Chemical Reactor recipes.
     */
    private static void registerLCRRecipes() {
        // 4x bedrockium flower + 2000L phthalic acid -> 8x bedrockium dust (2000 EU/t, 10s)
        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(CropsNHExtItems.flowerBedrockium, 4))
            .fluidInputs(Materials.PhthalicAcid.getFluid(2000))
            .itemOutputs(Materials.Bedrockium.getDust(8))
            .duration(200)
            .eut(2000)
            .addTo(RecipeMaps.multiblockChemicalReactorRecipes);

        // 4x neutronium flower + 4000L phthalic acid -> 1152L molten neutronium (2,000,000 EU/t, 90s)
        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(CropsNHExtItems.flowerNeutronium, 4))
            .fluidInputs(Materials.PhthalicAcid.getFluid(4000))
            .fluidOutputs(Materials.Neutronium.getMolten(1152))
            .duration(1800)
            .eut(2000000)
            .addTo(RecipeMaps.multiblockChemicalReactorRecipes);
    }

    /**
     * Simple shapeless crafting for the material dusts.
     */
    private static void registerCraftingRecipes() {
        // neutronium flower -> neutronium dust
        GameRegistry
            .addShapelessRecipe(Materials.Neutronium.getDust(1), new ItemStack(CropsNHExtItems.flowerNeutronium));

        // cosmic neutronium flower -> cosmic neutronium dust
        GameRegistry.addShapelessRecipe(
            Materials.CosmicNeutronium.getDust(1),
            new ItemStack(CropsNHExtItems.flowerCosmicNeutronium));

        // infinity catalyst flower -> infinity catalyst
        Item catalystItem = GameRegistry.findItem("Avaritia", "Resource");
        ItemStack catalystStack = catalystItem != null ? new ItemStack(catalystItem, 1, 5)
            : Materials.InfinityCatalyst.getDust(1);
        GameRegistry.addShapelessRecipe(catalystStack, new ItemStack(CropsNHExtItems.flowerInfinityCatalyst));

        // draconium flower -> draconium dust
        GameRegistry.addShapelessRecipe(Materials.Draconium.getDust(1), new ItemStack(CropsNHExtItems.flowerDraconium));

        // awakened draconium flower -> awakened draconium dust
        GameRegistry.addShapelessRecipe(
            Materials.DraconiumAwakened.getDust(1),
            new ItemStack(CropsNHExtItems.flowerAwakenedDraconium));
    }

    /**
     * Compressor recipes.
     */
    private static void registerCompressorRecipes() {
        // 64x infinity flower -> 1x Infinity Catalyst
        Item catalyst = GameRegistry.findItem("Avaritia", "Resource");
        ItemStack catalystStack = catalyst != null ? new ItemStack(catalyst, 1, 5)
            : Materials.InfinityCatalyst.getDust(1);
        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(CropsNHExtItems.flowerInfinity, 64))
            .itemOutputs(catalystStack)
            .duration(300)
            .eut(480)
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
            .duration(32)
            .eut(819200000)
            .metadata(GTRecipeConstants.COIL_HEAT, 13500)
            .addTo(RecipeMaps.plasmaForgeRecipes);

        // tier 3: excited DTEC catalyst (2x of 18432L)
        GTValues.RA.stdBuilder()
            .itemInputs(flower, infinityCatalyst(2))
            .fluidInputs(Materials.ExcitedDTEC.getFluid(22307))
            .fluidOutputs(Materials.DTR.getFluid(22307), Materials.Infinity.getMolten(36864))
            .circuit(3)
            .duration(64)
            .eut(409600000)
            .metadata(GTRecipeConstants.COIL_HEAT, 13500)
            .addTo(RecipeMaps.plasmaForgeRecipes);

        // tier 2: excited DTRC catalyst (2x of 9216L)
        GTValues.RA.stdBuilder()
            .itemInputs(flower, infinityCatalyst(1))
            .fluidInputs(Materials.ExcitedDTRC.getFluid(50092))
            .fluidOutputs(Materials.DTR.getFluid(25046), Materials.Infinity.getMolten(18432))
            .circuit(2)
            .duration(128)
            .eut(204800000)
            .metadata(GTRecipeConstants.COIL_HEAT, 12600)
            .addTo(RecipeMaps.plasmaForgeRecipes);

        // tier 1: excited DTRC catalyst, diluted (2x of 144L)
        GTValues.RA.stdBuilder()
            .itemInputs(flower, infinityCatalyst(1))
            .fluidInputs(Materials.ExcitedDTRC.getFluid(782))
            .fluidOutputs(Materials.DTR.getFluid(391), Materials.Infinity.getMolten(288))
            .circuit(3)
            .duration(1)
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
            .duration(64)
            .eut(409600000)
            .metadata(GTRecipeConstants.COIL_HEAT, 13500)
            .addTo(RecipeMaps.plasmaForgeRecipes);

        // tier 3: excited DTRC catalyst (2x of 294912L)
        GTValues.RA.stdBuilder()
            .itemInputs(flower)
            .fluidInputs(Materials.ExcitedDTRC.getFluid(2108), Materials.Copper.getMolten(294912))
            .fluidOutputs(Materials.DTR.getFluid(1054), Materials.CosmicNeutronium.getMolten(589824))
            .circuit(1)
            .duration(128)
            .eut(204800000)
            .metadata(GTRecipeConstants.COIL_HEAT, 12600)
            .addTo(RecipeMaps.plasmaForgeRecipes);

        // tier 2: excited DTPC catalyst (2x of 147456L)
        GTValues.RA.stdBuilder()
            .itemInputs(flower)
            .fluidInputs(Materials.ExcitedDTPC.getFluid(4886), Materials.Copper.getMolten(147456))
            .fluidOutputs(Materials.DTR.getFluid(1221), Materials.CosmicNeutronium.getMolten(294912))
            .circuit(1)
            .duration(256)
            .eut(102400000)
            .metadata(GTRecipeConstants.COIL_HEAT, 11700)
            .addTo(RecipeMaps.plasmaForgeRecipes);

        // tier 1: excited DTCC catalyst (2x of 73728L)
        GTValues.RA.stdBuilder()
            .itemInputs(flower)
            .fluidInputs(Materials.ExcitedDTCC.getFluid(12486), Materials.Copper.getMolten(73728))
            .fluidOutputs(Materials.DTR.getFluid(1560), Materials.CosmicNeutronium.getMolten(147456))
            .circuit(1)
            .duration(512)
            .eut(51200000)
            .metadata(GTRecipeConstants.COIL_HEAT, 10800)
            .addTo(RecipeMaps.plasmaForgeRecipes);
    }
}
