package de.wonejo.warcanum.mixin;

import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(VanillaBlockLoot.class)
public interface VanillaBlockLootAccessor {

    @Accessor("EXPLOSION_RESISTANT")
    static Set<Item> getExplosionResistant () {
        throw new IllegalStateException("Mixin did not apply");
    }

}
