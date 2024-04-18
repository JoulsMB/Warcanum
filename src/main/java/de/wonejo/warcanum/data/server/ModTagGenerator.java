package de.wonejo.warcanum.data.server;

import de.wonejo.warcanum.util.Constants;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModTagGenerator {

    public static void generateTagsProvider (GatherDataEvent pEvent, DataGenerator pGenerator, PackOutput pOutput, ExistingFileHelper pHelper)  {
        pGenerator.addProvider(pEvent.includeServer(), new BlockTagsGenerator(pOutput, pEvent.getLookupProvider(), pHelper));
        pGenerator.addProvider(pEvent.includeServer(), new ItemTagsGenerator(pOutput, pEvent.getLookupProvider(), pHelper));
        pGenerator.addProvider(pEvent.includeServer(), new EntityTagsGenerator(pOutput, pEvent.getLookupProvider(), pHelper));
        pGenerator.addProvider(pEvent.includeServer(), new BiomeTagsProvider(pOutput, pEvent.getLookupProvider(), pHelper));
    }

    private static class BlockTagsGenerator extends TagsProvider<Block> {

        protected BlockTagsGenerator(PackOutput p_256596_, CompletableFuture<HolderLookup.Provider> p_256513_, @Nullable ExistingFileHelper existingFileHelper) {
            super(p_256596_, Registries.BLOCK, p_256513_, Constants.MOD_ID, existingFileHelper);
        }

        protected void addTags(HolderLookup.@NotNull Provider pProvider) {

        }

    }

    private static class ItemTagsGenerator extends TagsProvider<Item> {

        protected ItemTagsGenerator(PackOutput p_256596_, CompletableFuture<HolderLookup.Provider> p_256513_, @Nullable ExistingFileHelper existingFileHelper) {
            super(p_256596_, Registries.ITEM, p_256513_, Constants.MOD_ID, existingFileHelper);
        }

        protected void addTags(HolderLookup.@NotNull Provider pProvider) {

        }
    }

    private static class EntityTagsGenerator extends TagsProvider<EntityType<?>> {

        protected EntityTagsGenerator(PackOutput p_256596_, CompletableFuture<HolderLookup.Provider> p_256513_, @Nullable ExistingFileHelper existingFileHelper) {
            super(p_256596_, Registries.ENTITY_TYPE, p_256513_, Constants.MOD_ID, existingFileHelper);
        }

        protected void addTags(HolderLookup.@NotNull Provider pProvider) {

        }
    }

    private static class BiomeTagsProvider extends TagsProvider<Biome> {

        protected BiomeTagsProvider(PackOutput p_256596_, CompletableFuture<HolderLookup.Provider> p_256513_, @Nullable ExistingFileHelper existingFileHelper) {
            super(p_256596_, Registries.BIOME, p_256513_, Constants.MOD_ID, existingFileHelper);
        }

        protected void addTags(HolderLookup.@NotNull Provider pProvider) {

        }
    }
}
