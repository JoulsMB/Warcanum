package de.wonejo.warcanum.core;

import de.wonejo.warcanum.util.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    private static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, Constants.MOD_ID);

    static void registerPotions (IEventBus pBus) {
        POTIONS.register(pBus);
    }

    public static void registerPotionMixes () {

    }
}
