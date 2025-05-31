package svenhjol.charmony.ebony_wood.common.features.ebony_wood;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import svenhjol.charmony.core.Charmony;
import svenhjol.charmony.core.base.Setup;
import svenhjol.charmony.core.common.CommonRegistry;
import svenhjol.charmony.core.common.GenericTrades;
import svenhjol.charmony.core.common.features.wood.WoodMaterial;
import svenhjol.charmony.core.common.features.wood.WoodRegistry;
import svenhjol.charmony.core.common.features.wood.types.*;

import java.util.function.Supplier;

public class Registers extends Setup<EbonyWood> {
    public final Supplier<BlockSetType> blockSetType;
    public final Supplier<WoodType> woodType;
    public final Supplier<WoodMaterial> material;
    public final ResourceKey<ConfiguredFeature<?, ?>> treeFeature;

    public Door door;
    public Leaves leaves;
    public Log log;
    public Planks planks;
    public Sapling sapling;
    public Trapdoor trapdoor;

    public Registers(EbonyWood feature) {
        super(feature);
        var commonRegistry = CommonRegistry.forFeature(feature);
        var woodRegistry = WoodRegistry.forRegistry(commonRegistry);

        material = () -> EbonyWoodMaterial.EBONY;
        blockSetType = commonRegistry.blockSetType(material);
        woodType = commonRegistry.woodType("ebony", blockSetType);
        treeFeature = ResourceKey.create(Registries.CONFIGURED_FEATURE, Charmony.id("ebony_tree"));

        var ebony = material.get();

        planks = woodRegistry.planks(ebony);
        door = woodRegistry.door(ebony);
        leaves = woodRegistry.leaves(ebony);
        log = woodRegistry.log(ebony);
        sapling = woodRegistry.sapling(ebony);
        trapdoor = woodRegistry.trapdoor(ebony);

        woodRegistry.boat(ebony);
        woodRegistry.button(ebony);
        woodRegistry.fence(ebony);
        woodRegistry.gate(ebony);
        woodRegistry.hangingSign(ebony);
        woodRegistry.pressurePlate(ebony);
        woodRegistry.sign(ebony);
        woodRegistry.slab(ebony);
        woodRegistry.stairs(ebony, planks);
        woodRegistry.wood(ebony);
    }

    @Override
    public Runnable boot() {
        return () -> {
            if (EbonyWood.feature().wanderingTradersSellSaplings()) {
                var registry = CommonRegistry.forFeature(feature());
                registry.wandererTrade(() -> new GenericTrades.ItemsForEmeralds(
                    sapling.item.get(),
                    20,
                    1,
                    0,
                    1), true);
            }

            LootTableEvents.MODIFY.register(this::handleLootTableModify);
        };
    }

    private void handleLootTableModify(ResourceKey<LootTable> key, LootTable.Builder builder, LootTableSource source, HolderLookup.Provider provider) {
        if (source.isBuiltin() && key == BuiltInLootTables.SNIFFER_DIGGING) {
            var pool = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .when(LootItemRandomChanceCondition.randomChance(0.25f))
                .add(LootItem.lootTableItem(sapling.item.get()).setWeight(1));
            builder.pool(pool.build());
        }
    }
}
