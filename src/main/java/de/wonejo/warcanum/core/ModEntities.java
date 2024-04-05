package de.wonejo.warcanum.core;

import de.wonejo.warcanum.lib.util.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, Constants.MOD_ID);

    static void registerEntities (IEventBus pBus) {
        ENTITIES.register(pBus);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> createEntity (String pId, Supplier<EntityType.Builder<T>> pBuilder, int pBackgroundColor, int pHighlightColor) {
        DeferredHolder<EntityType<?>, EntityType<T>> entity = ENTITIES.register(pId, () -> {
            EntityType.Builder<T> type = pBuilder.get().setTrackingRange(80).setUpdateInterval(1).setShouldReceiveVelocityUpdates(true);

            return type.build(Constants.MOD_ID + ":" + pId);
        });
        ModItems.create(pId + "_spawnegg", () -> new DeferredSpawnEggItem((Supplier<? extends EntityType<? extends Mob>>) entity.get(), pBackgroundColor, pHighlightColor, new Item.Properties()));
        return entity;
    }

}
