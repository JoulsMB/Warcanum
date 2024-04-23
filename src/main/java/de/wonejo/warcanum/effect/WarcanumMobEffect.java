package de.wonejo.warcanum.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;


// For some reason the MobEffect constructor is protected...
public class WarcanumMobEffect extends MobEffect {

    public WarcanumMobEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }


}
