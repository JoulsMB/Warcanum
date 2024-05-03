package de.wonejo.warcanum.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import de.wonejo.warcanum.client.model.GhostModel;
import de.wonejo.warcanum.entity.GhostEntity;
import de.wonejo.warcanum.util.Constants;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class GhostEyesLayer extends RenderLayer<GhostEntity, GhostModel> {

    private static final ResourceLocation[] EYE_TEXTURES = {new ResourceLocation(Constants.MOD_ID, "textures/entity/ghost/ghost_eyes_layer.png"), new ResourceLocation(Constants.MOD_ID, "textures/entity/ghost/ghost_angry_eyes_layer.png")};

    public GhostEyesLayer(RenderLayerParent<GhostEntity, GhostModel> pRenderer) {
        super(pRenderer);
    }

    public void render(@NotNull PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight, @NotNull GhostEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        RenderType renderType = RenderType.eyes((pLivingEntity.isCharging() || pLivingEntity.getTarget() != null) ? EYE_TEXTURES[1] : EYE_TEXTURES[0]);

        VertexConsumer consumer = pBuffer.getBuffer(renderType);
        this.getParentModel().renderToBuffer(pPoseStack, consumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}
