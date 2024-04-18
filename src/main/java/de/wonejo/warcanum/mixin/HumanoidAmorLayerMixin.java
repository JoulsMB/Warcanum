package de.wonejo.warcanum.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import de.wonejo.warcanum.core.ModItems;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HumanoidArmorLayer.class)
public class HumanoidAmorLayerMixin {

    @Inject(method = "renderModel(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/item/ArmorItem;Lnet/minecraft/client/model/Model;ZFFFLnet/minecraft/resources/ResourceLocation;)V", at = @At("HEAD"), cancellable = true)
    public void renderModel(PoseStack p_289664_, MultiBufferSource p_289689_, int p_289681_, ArmorItem p_289650_, Model p_289658_, boolean p_289668_, float p_289678_, float p_289674_, float p_289693_, ResourceLocation armorResource, CallbackInfo ci) {
        ci.cancel();

        if (p_289650_.getDefaultInstance().is(ModItems.GHOSTLY_ARMOR_HELMET) || p_289650_.getDefaultInstance().is(ModItems.GHOSTLY_ARMOR_CHESTPLATE) || p_289650_.getDefaultInstance().is(ModItems.GHOSTLY_ARMOR_LEGGINGS) || p_289650_.getDefaultInstance().is(ModItems.GHOSTLY_ARMOR_BOOTS)) {
            VertexConsumer consumer = p_289689_.getBuffer(RenderType.armorCutoutNoCull(armorResource));
            p_289658_.renderToBuffer(p_289664_, consumer, p_289681_, OverlayTexture.NO_OVERLAY, p_289678_, p_289674_, p_289693_, 0.5F);
        } else {
            VertexConsumer vertexconsumer = p_289689_.getBuffer(RenderType.armorCutoutNoCull(armorResource));
            p_289658_.renderToBuffer(p_289664_, vertexconsumer, p_289681_, OverlayTexture.NO_OVERLAY, p_289678_, p_289674_, p_289693_, 1.0F);
        }
    }
}
