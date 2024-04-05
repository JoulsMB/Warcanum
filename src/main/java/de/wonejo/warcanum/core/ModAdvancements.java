package de.wonejo.warcanum.core;

import de.wonejo.gapi.api.util.Constants;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModAdvancements {
    private static final DeferredRegister<CriterionTrigger<?>> TRIGGERS = DeferredRegister.create(Registries.TRIGGER_TYPE, Constants.MOD_ID);

    static void registerAdvancement (IEventBus pBus) {
        TRIGGERS.register(pBus);
    }
}
