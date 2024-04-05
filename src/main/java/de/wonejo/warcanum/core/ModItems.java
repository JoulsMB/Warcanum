package de.wonejo.warcanum.core;

import com.google.common.collect.Sets;
import de.wonejo.warcanum.lib.util.Constants;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.function.Supplier;

public class ModItems {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);
    private static final Set<ItemLike> TAB_ITEMS = Sets.newHashSet();

    static void registerItems (IEventBus pBus) {
        ITEMS.register(pBus);
    }

    static <I extends Item> @NotNull DeferredItem<I> create (String pId, Supplier<? extends I> pSupplier ) {
        DeferredItem<I> items = ITEMS.register(pId, pSupplier);
        TAB_ITEMS.add(items);
        return items;
    }

    public static Set<ItemLike> getTabItems() {
        return TAB_ITEMS;
    }
}
