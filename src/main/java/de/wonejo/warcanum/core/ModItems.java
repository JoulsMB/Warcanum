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

    public static final DeferredHolder<Item, Item> GHOSTLY_PLASMA = create("ghostly_plasma", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, ArmorItem> GHOSTLY_ARMOR_HELMET = create("ghostly_armor_helmet", () -> new ArmorItem(WarcanumArmorMaterials.GHOSTLY_PLASMA, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, ArmorItem> GHOSTLY_ARMOR_CHESTPLATE = create("ghostly_armor_chestplate", () -> new ArmorItem(WarcanumArmorMaterials.GHOSTLY_PLASMA, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredHolder<Item, ArmorItem> GHOSTLY_ARMOR_LEGGINGS = create("ghostly_armor_leggings", () -> new ArmorItem(WarcanumArmorMaterials.GHOSTLY_PLASMA, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredHolder<Item, ArmorItem> GHOSTLY_ARMOR_BOOTS = create("ghostly_armor_boots", () -> new ArmorItem(WarcanumArmorMaterials.GHOSTLY_PLASMA, ArmorItem.Type.BOOTS, new Item.Properties()));


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
