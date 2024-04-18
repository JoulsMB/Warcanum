package de.wonejo.warcanum.tabs;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.stream.Collectors;

public class WarcanumBlocksTab extends AbstractWarcanumCreativeTab{

    public WarcanumBlocksTab(@NotNull Set<ItemLike> pAllItems) {
        super(pAllItems.stream().filter((item) -> item instanceof BlockItem).collect(Collectors.toSet()));
    }

    protected void addItemsToOutput() {

    }
}
