package de.wonejo.warcanum.tabs;

import de.wonejo.warcanum.core.ModCreativeTabs;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class WarcanumTabs {

    public static CreativeModeTab.@NotNull Builder buildItems (Set<ItemLike> pAllItems) {
        return CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.warcanum.items"))
                .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                .displayItems(new WarcanumItemsTab(pAllItems));
    }

    public static CreativeModeTab.@NotNull Builder buildBlocks (Set<ItemLike> pAllItems) {
        return CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.warcanum.blocks"))
                .withTabsBefore(ModCreativeTabs.Keys.ITEMS)
                .displayItems(new WarcanumBlocksTab(pAllItems));
    }

    public static CreativeModeTab.@NotNull Builder buildEntities (Set<ItemLike> pAllItems) {
        return CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.warcanum.entities"))
                .withTabsBefore(ModCreativeTabs.Keys.BLOCKS)
                .displayItems(new WarcanumEntitiesTab(pAllItems));
    }

}
