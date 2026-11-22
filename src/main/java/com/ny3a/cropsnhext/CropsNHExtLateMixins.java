package com.ny3a.cropsnhext;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

@LateMixin
public class CropsNHExtLateMixins implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.cropsnhext.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        return Collections.singletonList("MutationLoaderMixin");
    }
}
