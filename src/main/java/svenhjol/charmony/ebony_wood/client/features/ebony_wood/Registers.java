package svenhjol.charmony.ebony_wood.client.features.ebony_wood;

import net.minecraft.client.renderer.RenderType;
import svenhjol.charmony.core.base.Setup;
import svenhjol.charmony.core.client.ClientRegistry;
import svenhjol.charmony.core.helpers.ColorHelper;

import java.util.List;

public class Registers extends Setup<EbonyWood> {
    public Registers(EbonyWood feature) {
        super(feature);

        var clientRegistry = ClientRegistry.forFeature(feature);
        var commonRegisters = feature.common.get().registers;

        var door = commonRegisters.door;
        var leaves = commonRegisters.leaves;
        var sapling = commonRegisters.sapling;
        var trapdoor = commonRegisters.trapdoor;

        // Cut out transparent areas.
        clientRegistry.blockRenderType(door.block, RenderType::cutout);
        clientRegistry.blockRenderType(sapling.block, RenderType::cutout);
        clientRegistry.blockRenderType(trapdoor.block, RenderType::cutout);

        clientRegistry.blockColor(ColorHelper::leavesColorFromBiome, List.of(leaves.block.get()));
    }
}
