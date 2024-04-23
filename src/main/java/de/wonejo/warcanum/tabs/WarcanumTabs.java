package de.wonejo.warcanum.tabs;

import de.wonejo.warcanum.core.ModBlocks;
import de.wonejo.warcanum.core.ModCreativeTabs;
import de.wonejo.warcanum.core.ModItems;
import de.wonejo.warcanum.util.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class WarcanumTabs {

    public static CreativeModeTab.@NotNull Builder buildItems (Set<ItemLike> pAllItems) {
        return CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.warcanum.items"))
                .icon(() -> new ItemStack(ModBlocks.DEAD_WOOD_PLANKS.get()))
                .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                .displayItems(new WarcanumItemsTab(pAllItems));
    }

    public static CreativeModeTab.@NotNull Builder buildBlocks (Set<ItemLike> pAllItems) {
        return CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.warcanum.blocks"))
                .icon(() -> new ItemStack(ModItems.GHOST_PLASMA.get()))
                .withTabsBefore(ModCreativeTabs.Keys.ITEMS)
                .displayItems(new WarcanumBlocksTab(pAllItems));
    }

    public static CreativeModeTab.@NotNull Builder buildEntities (Set<ItemLike> pAllItems) {
        return CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.warcanum.entities"))
                .icon(() -> BuiltInRegistries.ITEM.get(new ResourceLocation(Constants.MOD_ID, "ghost_spawnegg")).getDefaultInstance())
                .withTabsBefore(ModCreativeTabs.Keys.BLOCKS)
                .displayItems(new WarcanumEntitiesTab(pAllItems));
    }

}
