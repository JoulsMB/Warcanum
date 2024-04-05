package de.wonejo.warcanum.core;

import net.neoforged.bus.api.IEventBus;

public class WarcanumRegistryHandler {

    private final IEventBus bus;

    public WarcanumRegistryHandler ( IEventBus pBus ) {
        this.bus = pBus;
    }

    public void setupRegistries () {
        ModAdvancements.registerAdvancement(this.bus);
        ModBlocks.registerBlocks(this.bus);
        ModItems.registerItems(this.bus);
    }

}
