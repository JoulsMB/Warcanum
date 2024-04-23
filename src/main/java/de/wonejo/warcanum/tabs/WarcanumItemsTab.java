package de.wonejo.warcanum.tabs;

import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.Set;
import java.util.stream.Collectors;

public class WarcanumItemsTab extends AbstractWarcanumCreativeTab{

    public WarcanumItemsTab(Set<ItemLike> pAllItems) {
        super(pAllItems.stream().filter((item) -> !(item instanceof SpawnEggItem) && !(item instanceof Block)).collect(Collectors.toSet()));
    }

    protected void addItemsToOutput() {

    }

}
