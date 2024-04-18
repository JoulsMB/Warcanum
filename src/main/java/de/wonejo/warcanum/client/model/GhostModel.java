package de.wonejo.warcanum.client.model;

import de.wonejo.warcanum.client.model.animation.GhostAnimations;
import de.wonejo.warcanum.entity.GhostEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.NotNull;

public class GhostModel extends HierarchicalModel<GhostEntity> {

	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart rightArm;
	private final ModelPart leftArm;

	public GhostModel(@NotNull ModelPart root) {
		super(RenderType::entityTranslucent);

		this.root = root.getChild("root");

		this.body = this.root.getChild("body");
		this.rightArm = this.body.getChild("right_arm");
		this.leftArm = this.body.getChild("left_arm");
	}

	public static @NotNull LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition defaultDefinition = meshdefinition.getRoot();
		PartDefinition rootDefinition = defaultDefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition bodyDefinition = rootDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -18.0F, -5.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		bodyDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(16, 28).addBox(5.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		bodyDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 28).addBox(-9.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


	public void setupAnim(@NotNull GhostEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(GhostAnimations.FLY, limbSwing, limbSwingAmount, 1.0F, 2.5F);
	}

	public @NotNull ModelPart root() {
		return this.root;
	}

}