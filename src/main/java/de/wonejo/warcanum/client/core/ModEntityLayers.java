package de.wonejo.warcanum.client.core;

import de.wonejo.warcanum.client.model.GhostModel;
import de.wonejo.warcanum.client.render.GhostRenderer;
import de.wonejo.warcanum.core.ModEntities;
import de.wonejo.warcanum.util.Constants;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.jetbrains.annotations.NotNull;

public class ModEntityLayers {

    public static final ModelLayerLocation GHOST = new ModelLayerLocation(new ResourceLocation(Constants.MOD_ID, "ghost"), "main");

    public static void onRegisterRenderers (EntityRenderersEvent.@NotNull RegisterRenderers pEvent) {
        pEvent.registerEntityRenderer(ModEntities.GHOST.get(), GhostRenderer::new);
    }

    public static void onRegisterLayers (EntityRenderersEvent.@NotNull RegisterLayerDefinitions pEvent) {
        pEvent.registerLayerDefinition(GHOST, GhostModel::createBodyLayer);
    }

}
