package de.wonejo.warcanum.core;

import de.wonejo.warcanum.lib.util.Constants;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Constants.MOD_ID);

    static void registerBlocks (IEventBus pBus) {
        BLOCKS.register(pBus);
    }

    private static <T extends Block, R extends Item> @NotNull DeferredBlock<T> createBlock (String pId, Supplier<T> pBlockSupplier, Function<T, R> pItemMaker) {
        DeferredBlock<T> block = BLOCKS.register(pId, pBlockSupplier);
        ModItems.create(pId, () -> pItemMaker.apply(block.get()));
        return block;
    }

    private static <T extends Block> @NotNull DeferredBlock<T> createBlock (String pId, Supplier<T> pBlock, Item.Properties pItemProperties ) {
        DeferredBlock<T> block = BLOCKS.register(pId, pBlock);
        ModItems.create(pId, () -> new BlockItem(block.get(), pItemProperties));
        return block;
    }

    private static <T extends Block> @NotNull DeferredBlock<T> createBlock (String pId, Supplier<T> pBlock ) {
        return createBlock(pId, pBlock, new Item.Properties());
    }
}
