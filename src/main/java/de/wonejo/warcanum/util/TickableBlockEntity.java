package de.wonejo.warcanum.util;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;

public interface TickableBlockEntity {

    void tick ();

    static <T extends BlockEntity>BlockEntityTicker<T> getTickerHelper (Level pLevel) {
        return getTickerHelper(pLevel, false);
    }

    static <T extends BlockEntity> BlockEntityTicker<T> getTickerHelper ( Level pLevel, boolean pAllowClient ) {
        return pLevel.isClientSide && !pAllowClient ? null : (pLevel1, pPos, pState, pBlockEntity) -> ((TickableBlockEntity) pBlockEntity).tick();
    }
}
