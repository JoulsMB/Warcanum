package de.wonejo.warcanum.client.core;

import net.neoforged.bus.api.IEventBus;

public class WarcanumClientRegistry {

    private final IEventBus bus;

    public WarcanumClientRegistry ( IEventBus pBus ) {
        this.bus = pBus;
    }

    public void setupRegistries () {
        bus.addListener(ModEntityLayers::onRegisterRenderers);
        bus.addListener(ModEntityLayers::onRegisterLayers);
    }
}
