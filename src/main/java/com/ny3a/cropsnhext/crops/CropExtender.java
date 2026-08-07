package com.ny3a.cropsnhext.crops;

import com.gtnewhorizon.cropsnh.api.CropsNHCrops;
import com.gtnewhorizon.cropsnh.api.ICropCard;
import com.gtnewhorizon.cropsnh.farming.mutation.CropMutation;
import com.gtnewhorizon.cropsnh.farming.registries.CropRegistry;

/**
 * Registers all crops of this addon plus their deterministic breeding recipes.
 * Must run after CropsNH's own postInit (see {@code @Mod dependencies}).
 */
public class CropExtender {

    private CropExtender() {}

    public static void register() {
        ICropCard neutronium = register(new CropNeutronium());
        ICropCard cosmicNeutronium = register(new CropCosmicNeutronium());
        ICropCard infinityCatalyst = register(new CropInfinityCatalyst());
        ICropCard infinity = register(new CropInfinity());
        ICropCard draconium = register(new CropDraconium());
        ICropCard awakenedDraconium = register(new CropAwakenedDraconium());
        ICropCard bedrockium = register(new CropBedrockium());

        // deterministic machine-only breeding recipes, gated behind existing endgame crops
        new CropMutation(neutronium, CropsNHCrops.Diareed, CropsNHCrops.Iridine).machineOnly()
            .register();
        new CropMutation(draconium, CropsNHCrops.Iridine, CropsNHCrops.Platina).machineOnly()
            .register();
        // bedrockium = diareed (diamond sugar cane) x stone lily
        new CropMutation(bedrockium, CropsNHCrops.Diareed, CropsNHCrops.StoneLily).machineOnly()
            .register();
        new CropMutation(cosmicNeutronium, neutronium, CropsNHCrops.Stargatium).machineOnly()
            .register();
        new CropMutation(awakenedDraconium, draconium, CropsNHCrops.GodOfThunder).machineOnly()
            .register();
        // like the bee breeding line: cosmic neutronium + neutronium -> infinity catalyst
        new CropMutation(infinityCatalyst, cosmicNeutronium, neutronium).machineOnly()
            .register();
        // cosmic neutronium + infinity catalyst -> infinity
        new CropMutation(infinity, cosmicNeutronium, infinityCatalyst).machineOnly()
            .register();
    }

    private static ICropCard register(ICropCard crop) {
        CropRegistry.instance.register(crop);
        return crop;
    }
}
