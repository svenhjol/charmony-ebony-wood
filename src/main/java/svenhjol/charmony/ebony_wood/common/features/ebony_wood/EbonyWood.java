package svenhjol.charmony.ebony_wood.common.features.ebony_wood;

import svenhjol.charmony.api.core.Configurable;
import svenhjol.charmony.api.core.FeatureDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.base.SidedFeature;
import svenhjol.charmony.api.core.Side;

@FeatureDefinition(side = Side.Common, description = """
    Ebony is a dark wood obtainable from saplings found by sniffers.""")
@SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
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
