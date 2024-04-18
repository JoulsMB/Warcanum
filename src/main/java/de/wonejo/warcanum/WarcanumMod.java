package de.wonejo.warcanum;

import de.wonejo.warcanum.client.WarcanumClientMod;
import de.wonejo.warcanum.core.WarcanumRegistryHandler;
import de.wonejo.warcanum.util.Constants;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Constants.MOD_ID)
public class WarcanumMod {

    public static final Logger LOGGER = LogManager.getLogger();

    public static WarcanumClientMod CLIENT;


    public WarcanumMod (IEventBus pBus) {

        pBus.addListener(this::onCommonSetup);

        CLIENT = new WarcanumClientMod(pBus);
        WarcanumRegistryHandler registryHandler = new WarcanumRegistryHandler(pBus);
        registryHandler.setupRegistries();
        CLIENT.getClientRegistry().setupRegistries();
    }

    private void onCommonSetup (final FMLCommonSetupEvent pEvent) {

    }

}
