package de.wonejo.warcanum.core;

import de.wonejo.warcanum.util.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    private static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, Constants.MOD_ID);

    static void registerEffects (IEventBus pBus) {
        EFFECTS.register(pBus);
    }
}
