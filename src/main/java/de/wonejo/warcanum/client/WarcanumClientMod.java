package de.wonejo.warcanum.client;

import de.wonejo.warcanum.client.core.WarcanumClientRegistry;
import net.neoforged.bus.api.IEventBus;

public class WarcanumClientMod {

    private final IEventBus bus;
    private final WarcanumClientRegistry clientRegistry;

    public WarcanumClientMod ( IEventBus pBus ) {
        this.bus = pBus;
        this.clientRegistry = new WarcanumClientRegistry(bus);
    }

    public WarcanumClientRegistry getClientRegistry() {
        return clientRegistry;
    }
}
