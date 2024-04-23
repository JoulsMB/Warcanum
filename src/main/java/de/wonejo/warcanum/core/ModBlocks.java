package de.wonejo.warcanum.core;

import de.wonejo.warcanum.block.WarcanumRotatedPillarBlock;
import de.wonejo.warcanum.util.Constants;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModBlocks {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Constants.MOD_ID);

    public static final DeferredHolder<Block, Block> INFERTILE_DIRT = createBlock("infertile_dirt", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.ROOTED_DIRT).strength(1.2F)));

    public static final DeferredHolder<Block, WarcanumRotatedPillarBlock> DEAD_LOG = createBlock("dead_log", () -> new WarcanumRotatedPillarBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(2.0F)));
    public static final DeferredHolder<Block, WarcanumRotatedPillarBlock> STRIPPED_DEAD_LOG = createBlock("stripped_dead_log", () -> new WarcanumRotatedPillarBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(2.0F)));
    public static final DeferredHolder<Block, WarcanumRotatedPillarBlock> DEAD_LOG_WOOD = createBlock("stripped_log_wood", () -> new WarcanumRotatedPillarBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(2.0F)));
    public static final DeferredHolder<Block, WarcanumRotatedPillarBlock> STRIPPED_DEAD_LOG_WOOD = createBlock("stripped_dead_log_wood", () -> new WarcanumRotatedPillarBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(2.0F)));
    public static final DeferredHolder<Block, Block> DEAD_WOOD_PLANKS = createBlock("dead_wood_plank", () -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(1.5F)));
    public static final DeferredHolder<Block, SlabBlock> DEAD_WOOD_SLAB = createBlock("dead_wood_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(1.5F)));


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

    public static @NotNull Set<Block> getAllBlocks () {
        return BLOCKS.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toUnmodifiableSet());
    }
}
