package svenhjol.charmony.ebony_wood.common.features.ebony_wood;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import svenhjol.charmony.core.common.features.wood.WoodMaterial;
import svenhjol.charmony.ebony_wood.EbonyWoodMod;

import java.util.Locale;
import java.util.Optional;

public enum EbonyWoodMaterial implements WoodMaterial {
    EBONY;

    @Override
    public BlockSetType blockSetType() {
        return EbonyWood.feature().registers.blockSetType.get();
    }

    @Override
    public WoodType woodType() {
        return EbonyWood.feature().registers.woodType.get();
    }

    @Override
    public SoundType soundType() {
        return SoundType.WOOD;
    }

    @Override
    public String getSerializedName() {
        return name().toLowerCase(Locale.ENGLISH);
    }

    @Override
    public Optional<TreeGrower> tree() {
        return Optional.of(new TreeGrower(
            "ebony",
            Optional.empty(),
            Optional.of(EbonyWood.feature().registers.treeFeature),
            Optional.empty()
        ));
    }
}
