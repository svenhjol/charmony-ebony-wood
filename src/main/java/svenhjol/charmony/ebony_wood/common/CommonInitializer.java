package svenhjol.charmony.ebony_wood.common;

import net.fabricmc.api.ModInitializer;
import svenhjol.charmony.api.core.Side;
import svenhjol.charmony.ebony_wood.EbonyWoodMod;
import svenhjol.charmony.ebony_wood.common.features.ebony_wood.EbonyWood;

public final class CommonInitializer implements ModInitializer {
    @Override
    public void onInitialize() {
        // Ensure charmony is launched first.
        svenhjol.charmony.core.common.CommonInitializer.init();

        // Prepare and run the mod.
        var mod = EbonyWoodMod.instance();

        mod.addSidedFeature(EbonyWood.class);
        mod.run(Side.Common);
    }
}
