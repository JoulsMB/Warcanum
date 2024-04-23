package de.wonejo.warcanum.data.server;

import de.wonejo.warcanum.core.ModBlocks;
import de.wonejo.warcanum.core.ModTags;
import de.wonejo.warcanum.util.Constants;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModTagGenerator {

    public static void generateTagsProvider (GatherDataEvent pEvent, DataGenerator pGenerator, PackOutput pOutput, ExistingFileHelper pHelper)  {
        BlockTagsGenerator generator = new BlockTagsGenerator(pOutput, pEvent.getLookupProvider(), pHelper);
        pGenerator.addProvider(pEvent.includeServer(), generator);
        pGenerator.addProvider(pEvent.includeServer(), new ItemTagsGenerator(pOutput, pEvent.getLookupProvider(), generator.contentsGetter()));
        pGenerator.addProvider(pEvent.includeServer(), new EntityTagsGenerator(pOutput, pEvent.getLookupProvider(), pHelper));
        pGenerator.addProvider(pEvent.includeServer(), new BiomeTagsProvider(pOutput, pEvent.getLookupProvider(), pHelper));
    }

    private static class BlockTagsGenerator extends BlockTagsProvider {

        public BlockTagsGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, Constants.MOD_ID, existingFileHelper);
        }

        protected void addTags(HolderLookup.@NotNull Provider pProvider) {
            this.tag(BlockTags.MINEABLE_WITH_AXE)
                    .add(ModBlocks.DEAD_LOG.get())
                    .add(ModBlocks.DEAD_LOG_WOOD.get())
                    .add(ModBlocks.STRIPPED_DEAD_LOG.get())
                    .add(ModBlocks.STRIPPED_DEAD_LOG_WOOD.get())
                    .add(ModBlocks.DEAD_WOOD_PLANKS.get());

            this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                    .add(ModBlocks.INFERTILE_DIRT.get());

            this.tag(BlockTags.LOGS_THAT_BURN)
                    .add(ModBlocks.DEAD_LOG.get())
                    .add(ModBlocks.DEAD_LOG_WOOD.get())
                    .add(ModBlocks.STRIPPED_DEAD_LOG.get())
                    .add(ModBlocks.STRIPPED_DEAD_LOG_WOOD.get());

            this.tag(BlockTags.PLANKS)
                    .add(ModBlocks.DEAD_WOOD_PLANKS.get());

            this.tag(BlockTags.DIRT)
                    .add(ModBlocks.INFERTILE_DIRT.get());

        }

    }

    private static class ItemTagsGenerator extends ItemTagsProvider {

        public ItemTagsGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags) {
            super(pOutput, pLookupProvider, pBlockTags);
        }

        protected void addTags(HolderLookup.@NotNull Provider pProvider) {
            this.tag(ModTags.ItemTags.DEAD_LOGS)
                    .add(ModBlocks.DEAD_LOG.get().asItem())
                    .add(ModBlocks.DEAD_LOG_WOOD.get().asItem())
                    .add(ModBlocks.STRIPPED_DEAD_LOG.get().asItem())
                    .add(ModBlocks.STRIPPED_DEAD_LOG_WOOD.get().asItem());
        }
    }
    private static class EntityTagsGenerator extends EntityTypeTagsProvider {

        public EntityTagsGenerator(PackOutput p_256095_, CompletableFuture<HolderLookup.Provider> p_256572_, @Nullable ExistingFileHelper existingFileHelper) {
            super(p_256095_, p_256572_, Constants.MOD_ID, existingFileHelper);
        }

        protected void addTags(HolderLookup.@NotNull Provider pProvider) {

        }
    }

    private static class BiomeTagsProvider extends net.minecraft.data.tags.BiomeTagsProvider {


        public BiomeTagsProvider(PackOutput p_255800_, CompletableFuture<HolderLookup.Provider> p_256205_, @Nullable ExistingFileHelper existingFileHelper) {
            super(p_255800_, p_256205_, Constants.MOD_ID, existingFileHelper);
        }

        protected void addTags(HolderLookup.@NotNull Provider pProvider) {

        }
    }
}
