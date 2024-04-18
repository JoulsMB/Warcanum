package de.wonejo.warcanum.core;

import de.wonejo.warcanum.client.core.ModEntityLayers;
import de.wonejo.warcanum.util.Constants;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEventsHandler {

    @SubscribeEvent
    public static void onAttributeCreation (EntityAttributeCreationEvent pEvent) {
        ModEntities.onRegisterEntityTypeAttributes(pEvent);
    }

    @SubscribeEvent
    public static void onRegisterEntityLayer (EntityRenderersEvent.@NotNull RegisterLayerDefinitions pEvent) {
        ModEntityLayers.onRegisterLayers(pEvent);
    }

    @SubscribeEvent
    public static void onRegisterRenderTypes (EntityRenderersEvent.@NotNull RegisterRenderers pRvent){
        ModEntityLayers.onRegisterRenderers(pRvent);
    }

}
