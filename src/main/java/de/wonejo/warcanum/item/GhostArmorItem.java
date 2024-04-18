package de.wonejo.warcanum.item;

import de.wonejo.warcanum.util.armor.WarcanumArmorMaterials;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class GhostArmorItem extends ArmorItem {

    public GhostArmorItem(Type pType) {
        super(WarcanumArmorMaterials.GHOSTLY_PLASMA, pType, new Properties());
    }

    public void inventoryTick(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull Entity pEntity, int pSlotId, boolean pIsSelected) {
        if  ( pEntity instanceof Player player ) {
            if (player.isHurt()) {
            }
        }
    }
}
