package de.wonejo.warcanum.tabs;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public abstract class AbstractWarcanumCreativeTab implements CreativeModeTab.DisplayItemsGenerator {
    private CreativeModeTab.Output output;
    private final Set<ItemLike> items;

    public AbstractWarcanumCreativeTab ( Set<ItemLike> pAllItems ) {
        this.items = pAllItems;
    }

    public void accept(CreativeModeTab.@NotNull ItemDisplayParameters pParameters, CreativeModeTab.@NotNull Output pOutput) {
        this.output = pOutput;

        this.addItemsToOutput();
        this.items.forEach(output::accept);
    }

    protected abstract void addItemsToOutput  ();

    protected void add ( ItemLike pItem ) {
        this.items.remove(pItem);
        this.output.accept(pItem);
    }

    protected void add (@NotNull ItemStack pStack) {
        this.items.remove(pStack.getItem());
        this.output.accept(pStack);
    }

    protected void addItem (@NotNull DeferredHolder<Item, ? extends Item> pItem) {
        this.add(pItem.get());
    }

    protected void addItem (DeferredItem<? extends Item> pItem) {
        this.add(pItem);
    }

    protected void addBlock (@NotNull DeferredHolder<Block, ? extends Block> pBlock) {
        this.add(pBlock.get());
    }

    protected void addBlock (@NotNull Block pBlock ) {
        this.add(pBlock.asItem());
    }

    protected void addBlock (DeferredBlock<? extends Block> pBlock) {
        this.add(pBlock);
    }


}
