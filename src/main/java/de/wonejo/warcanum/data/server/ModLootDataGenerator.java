package de.wonejo.warcanum.data.server;

import de.wonejo.warcanum.core.ModBlocks;
import de.wonejo.warcanum.core.ModEntities;
import de.wonejo.warcanum.core.ModLootTables;
import de.wonejo.warcanum.mixin.VanillaBlockLootAccessor;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class ModLootDataGenerator {

    public static @NotNull LootTableProvider generateProviders (PackOutput pOutput) {
        return new LootTableProvider(pOutput, ModLootTables.getLootTables(),
                List.of(
                        new LootTableProvider.SubProviderEntry(BlockLootTablesSubGenerator::new, LootContextParamSets.BLOCK),
                        new LootTableProvider.SubProviderEntry(EntityLootTablesSubGenerator::new, LootContextParamSets.ENTITY),
                        new LootTableProvider.SubProviderEntry(ChestLootTableSubGenerator::new, LootContextParamSets.CHEST)
                ));
    }

    private static class ChestLootTableSubGenerator implements LootTableSubProvider {

        public void generate(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> pOutput) {

        }

    }

    private static class EntityLootTablesSubGenerator extends EntityLootSubProvider {

        protected EntityLootTablesSubGenerator() {
            super(FeatureFlags.REGISTRY.allFlags());
        }

        public void generate() {

        }

        protected @NotNull Stream<EntityType<?>> getKnownEntityTypes() {
            return ModEntities.getAllEntities().stream();
        }
    }

    private static class BlockLootTablesSubGenerator extends BlockLootSubProvider {

        protected BlockLootTablesSubGenerator() {
            super(VanillaBlockLootAccessor.getExplosionResistant(), FeatureFlags.REGISTRY.allFlags());
        }

        protected void generate() {
        }

        protected @NotNull Iterable<Block> getKnownBlocks() {
            return ModBlocks.getAllBlocks();
        }
    }
}
