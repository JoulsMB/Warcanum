package de.wonejo.warcanum.block;

import com.google.common.collect.ImmutableMap;
import de.wonejo.warcanum.core.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ToolAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class WarcanumRotatedPillarBlock extends RotatedPillarBlock {

    public WarcanumRotatedPillarBlock(Properties p_55926_) {
        super(p_55926_);
    }

    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    public int getFireSpreadSpeed(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull Direction pDirection) {
        return 5;
    }

    public @Nullable BlockState getToolModifiedState(@NotNull BlockState pState, @NotNull UseOnContext pContext, @NotNull ToolAction pToolAction, boolean pSimulate) {
        final Map<Block, Block> strippables = new ImmutableMap.Builder<Block, Block>()
                .put(ModBlocks.DEAD_LOG.get(), ModBlocks.STRIPPED_DEAD_LOG.get())
                .put(ModBlocks.DEAD_LOG_WOOD.get(), ModBlocks.STRIPPED_DEAD_LOG_WOOD.get())
                .build();

        if (pContext.getItemInHand().getItem() instanceof AxeItem) {
            if ( strippables.containsKey(pState.getBlock()) )
                return strippables.get(pState.getBlock()).defaultBlockState().setValue(AXIS, pState.getValue(AXIS));
        }

        return super.getToolModifiedState(pState, pContext, pToolAction, pSimulate);
    }
}
