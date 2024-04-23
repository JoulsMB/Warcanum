package de.wonejo.warcanum.core;

import de.wonejo.warcanum.util.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class BlockTags {

        public static final TagKey<Block> DEAD_LOGS = createTag("dead_logs");

        private static TagKey<Block> createTag ( String pId ) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(Constants.MOD_ID, pId));
        }
    }

    public static class ItemTags {
        public static final TagKey<Item> DEAD_LOGS = createTag ("dead_logs");

        private static TagKey<Item> createTag ( String pId ) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(Constants.MOD_ID, pId));
        }
    }
}
