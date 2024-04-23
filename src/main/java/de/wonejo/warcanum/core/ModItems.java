package de.wonejo.warcanum.core;

import com.google.common.collect.Sets;
import de.wonejo.warcanum.util.armor.WarcanumArmorMaterials;
import de.wonejo.warcanum.util.Constants;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.function.Supplier;

public class ModItems {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);
    private static final Set<DeferredHolder<Item, ? extends Item>> TAB_ITEMS = Sets.newHashSet();

    public static final DeferredHolder<Item, Item> GHOST_PLASMA = create("ghost_plasma", () -> new Item(new Item.Properties()));


    public static final DeferredHolder<Item, Item> IRON_KEY = create("iron_key", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> GOLDEN_KEY = create("golden_key", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> SPECTRAL_KEY = create("spectral_key", () -> new Item(new Item.Properties()));


    static void registerItems (IEventBus pBus) {
        ITEMS.register(pBus);
    }

    static <I extends Item> @NotNull DeferredHolder<Item, I> create (String pId, Supplier<? extends I> pSupplier ) {
        DeferredHolder<Item, I> items = ITEMS.register(pId, pSupplier);
        TAB_ITEMS.add(items);
        return items;
    }

    public static Set<DeferredHolder<Item, ? extends Item>> getTabItems() {
        return TAB_ITEMS;
    }
}
