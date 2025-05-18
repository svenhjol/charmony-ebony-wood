package svenhjol.charmony.ebony_wood.client.features.ebony_wood;

import svenhjol.charmony.api.core.FeatureDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.base.SidedFeature;
import svenhjol.charmony.api.core.Side;

import java.util.function.Supplier;

@FeatureDefinition(side = Side.Client, canBeDisabledInConfig = false)
public final class EbonyWood extends SidedFeature {
    public final Registers registers;
    public final Supplier<Common> common;

    public EbonyWood(Mod mod) {
        super(mod);
        common = Common::new;
        registers = new Registers(this);
    }
}
