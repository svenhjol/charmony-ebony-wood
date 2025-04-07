package svenhjol.charmony.ebony_wood.integration;

import svenhjol.charmony.core.Charmony;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.integration.BaseModMenuPlugin;
import svenhjol.charmony.ebony_wood.EbonyWoodMod;

@SuppressWarnings("unused")
public final class ModMenuPlugin extends BaseModMenuPlugin {
    @Override
    public Mod mod() {
        return EbonyWoodMod.instance();
    }
}
