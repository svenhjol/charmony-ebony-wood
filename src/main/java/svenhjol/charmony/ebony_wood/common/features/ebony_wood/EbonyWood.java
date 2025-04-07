package svenhjol.charmony.ebony_wood.common.features.ebony_wood;

import svenhjol.charmony.core.annotations.Configurable;
import svenhjol.charmony.core.annotations.FeatureDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.base.SidedFeature;
import svenhjol.charmony.core.enums.Side;

@FeatureDefinition(side = Side.Common, description = """
    Ebony is a dark wood obtainable from saplings found by sniffers.""")
public final class EbonyWood extends SidedFeature {
    public final Registers registers;

    @Configurable(
        name = "Wandering traders sell saplings",
        description = "If true, wandering traders offer ebony saplings as a rare trade."
    )
    private static boolean wanderingTradersSellSaplings = false;

    public EbonyWood(Mod mod) {
        super(mod);
        registers = new Registers(this);
    }

    public static EbonyWood feature() {
        return Mod.getSidedFeature(EbonyWood.class);
    }

    public boolean wanderingTradersSellSaplings() {
        return wanderingTradersSellSaplings;
    }
}
