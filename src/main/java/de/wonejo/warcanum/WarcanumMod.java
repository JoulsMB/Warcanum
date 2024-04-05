package de.wonejo.warcanum;

import de.wonejo.warcanum.core.WarcanumRegistryHandler;
import de.wonejo.warcanum.lib.util.Constants;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Constants.MOD_ID)
public class WarcanumMod {

    public static final Logger LOGGER = LogManager.getLogger();

    private final WarcanumRegistryHandler registryHandler;

    public WarcanumMod (IEventBus pBus) {

        this.registryHandler = new WarcanumRegistryHandler(pBus);
        this.registryHandler.setupRegistries();
    }

}
