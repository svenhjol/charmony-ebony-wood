package svenhjol.charmony.ebony_wood.client;

import net.fabricmc.api.ClientModInitializer;
import svenhjol.charmony.core.enums.Side;
import svenhjol.charmony.ebony_wood.EbonyWoodMod;
import svenhjol.charmony.ebony_wood.client.features.ebony_wood.EbonyWood;

public final class ClientInitializer implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Ensure charmony is launched first.
        svenhjol.charmony.core.client.ClientInitializer.init();

        // Prepare and run the mod.
        var mod = EbonyWoodMod.instance();

        mod.addSidedFeature(EbonyWood.class);
        mod.run(Side.Client);
    }
}
