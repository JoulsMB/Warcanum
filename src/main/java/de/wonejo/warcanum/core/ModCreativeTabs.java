package de.wonejo.warcanum.core;

import de.wonejo.warcanum.tabs.WarcanumTabs;
import de.wonejo.warcanum.util.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.stream.Collectors;

public class ModCreativeTabs {

    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

//    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ITEMS = TABS.register(Keys.ITEMS.location().getPath(), () -> WarcanumTabs.buildItems(ModItems.getTabItems().stream().map(DeferredHolder::get).collect(Collectors.toSet())).build());
//    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BLOCKS = TABS.register(Keys.BLOCKS.location().getPath(), () -> WarcanumTabs.buildBlocks(ModItems.getTabItems().stream().map(DeferredHolder::get).collect(Collectors.toSet())).build());
//    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ENTITIES = TABS.register(Keys.ENTITIES.location().getPath(), () -> WarcanumTabs.buildEntities(ModItems.getTabItems().stream().map(DeferredHolder::get).collect(Collectors.toSet())).build());

    static void registerCreativeTabs (IEventBus pBus) {
        TABS.register(pBus);
    }

    public static class Keys {
        public static final ResourceKey<CreativeModeTab> ITEMS = create("items");
        public static final ResourceKey<CreativeModeTab> BLOCKS = create("blocks");
        public static final ResourceKey<CreativeModeTab> ENTITIES = create("entities");

        private static ResourceKey<CreativeModeTab> create ( String pId ) {
            return ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(Constants.MOD_ID, pId));
        }
    }
}
