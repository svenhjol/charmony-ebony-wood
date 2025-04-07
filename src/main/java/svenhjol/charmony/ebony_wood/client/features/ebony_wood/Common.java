package svenhjol.charmony.ebony_wood.client.features.ebony_wood;

import svenhjol.charmony.ebony_wood.common.features.ebony_wood.EbonyWood;
import svenhjol.charmony.ebony_wood.common.features.ebony_wood.Registers;

public class Common {
    public final Registers registers;

    public Common() {
        var feature = EbonyWood.feature();
        registers = feature.registers;
    }
}
