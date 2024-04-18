package de.wonejo.warcanum.util;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.crafting.CraftingHelper;

import java.util.function.Function;

public class Util {

    public static Codec<ItemStack> itemStackResultCodec () {
        return ExtraCodecs.either(BuiltInRegistries.ITEM.byNameCodec(), ItemStack.ITEM_WITH_COUNT_CODEC).xmap(either -> either.map(ItemStack::new, Function.identity()),
                stack -> {
                    if (stack.getCount() != -1) {
                        return Either.right(stack);
                    }

                    var tagForWriting = CraftingHelper.getTagForWriting(stack);
                    var attachments = stack.serializeAttachments();
                    return tagForWriting == null && attachments == null ? Either.left(stack.getItem()) : Either.right(stack);
                });
    }
}
