package de.wonejo.warcanum.client.render;

import de.wonejo.warcanum.client.core.ModEntityLayers;
import de.wonejo.warcanum.client.model.GhostModel;
import de.wonejo.warcanum.client.render.layer.GhostEyesLayer;
import de.wonejo.warcanum.entity.GhostEntity;
import de.wonejo.warcanum.util.Constants;
import net.minecraft.client.renderer.entity.EndermanRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class GhostRenderer extends MobRenderer<GhostEntity, GhostModel> {

    private static final ResourceLocation[] TEXTURE = {new ResourceLocation(Constants.MOD_ID, "textures/entity/ghost/ghost.png"), new ResourceLocation(Constants.MOD_ID, "textures/entity/ghost/ghost_angry.png")};

    public GhostRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GhostModel(pContext.bakeLayer(ModEntityLayers.GHOST)), 0.2F);
        this.addLayer(new GhostEyesLayer(this));
    }

    public @NotNull ResourceLocation getTextureLocation(@NotNull GhostEntity pEntity) {
        return (pEntity.isCharging() || pEntity.getTarget() != null) ? TEXTURE[1] : TEXTURE[0];
    }

}
