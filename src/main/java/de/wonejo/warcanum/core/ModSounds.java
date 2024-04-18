package de.wonejo.warcanum.core;

import de.wonejo.warcanum.util.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
    private static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, Constants.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> ARMOR_EQUIP_GHOSTLY_PLASMA = createSound("armor_equip_ghostly_plasma");

    static void registerSounds (IEventBus pBus) {
        SOUNDS.register(pBus);
    }

    private static DeferredHolder<SoundEvent, SoundEvent> createSound ( String pId ) {
        ResourceLocation id = new ResourceLocation(Constants.MOD_ID, pId);
        return SOUNDS.register(pId, () -> SoundEvent.createVariableRangeEvent(id));
    }
}
