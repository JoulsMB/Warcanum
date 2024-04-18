package de.wonejo.warcanum.core;

import de.wonejo.warcanum.entity.GhostEntity;
import de.wonejo.warcanum.util.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModEntities {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, Constants.MOD_ID);

    public static DeferredHolder<EntityType<?>, EntityType<GhostEntity>> GHOST = createEntity("ghost", () -> EntityType.Builder.of(GhostEntity::new, MobCategory.MONSTER).sized(0.9F, 1.0F), 0xd9e4e2, 0xc7d5d8);

    static void registerEntities (IEventBus pBus) {
        ENTITIES.register(pBus);
    }

    static void onRegisterEntityTypeAttributes (@NotNull EntityAttributeCreationEvent pEvent) {
        pEvent.put(GHOST.get(), GhostEntity.getGhostAttributes().build());
    }

    @SuppressWarnings("unchecked")
    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> createEntity (String pId, Supplier<EntityType.Builder<T>> pBuilder, int pBackgroundColor, int pHighlightColor) {
        DeferredHolder<EntityType<?>, EntityType<T>> entity = ENTITIES.register(pId, () -> {
            EntityType.Builder<T> type = pBuilder.get().setTrackingRange(80).setUpdateInterval(1).setShouldReceiveVelocityUpdates(true);

            return type.build(Constants.MOD_ID + ":" + pId);
        });
        ModItems.create(pId + "_spawnegg", () -> new SpawnEggItem((EntityType<? extends Mob>) entity.get(), pBackgroundColor, pHighlightColor, new Item.Properties()));
        return entity;
    }

    public static @NotNull Set<EntityType<?>> getAllEntities () {
        return ENTITIES.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toUnmodifiableSet());
    }

}
