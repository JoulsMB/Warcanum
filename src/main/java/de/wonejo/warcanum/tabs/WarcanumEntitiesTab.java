package de.wonejo.warcanum.tabs;

import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.stream.Collectors;

public class WarcanumEntitiesTab extends AbstractWarcanumCreativeTab{

    public WarcanumEntitiesTab(@NotNull Set<ItemLike> pAllItems) {
        super(pAllItems.stream().filter((item) -> item instanceof SpawnEggItem).collect(Collectors.toSet()));
    }

    protected void addItemsToOutput() {

    }
}
