package svenhjol.charmony.ebony_wood;

import net.minecraft.resources.ResourceLocation;
import svenhjol.charmony.api.core.Configurable;
import svenhjol.charmony.api.core.ModDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.api.core.Side;

@ModDefinition(
    id = EbonyWoodMod.ID,
    sides = {Side.Client, Side.Common},
    name = "Ebony Wood",
    description = "Ebony is a dark wood obtainable from saplings found by sniffers.")
public final class EbonyWoodMod extends Mod {
    public static final String ID = "charmony-ebony-wood";
    private static EbonyWoodMod instance;

    private EbonyWoodMod() {}

    public static EbonyWoodMod instance() {
        if (instance == null) {
            instance = new EbonyWoodMod();
        }
        return instance;
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }
}