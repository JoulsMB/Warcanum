package de.wonejo.warcanum.client.model.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class GhostAnimations {

    public static final AnimationDefinition FLY = AnimationDefinition.Builder.withLength(0.5F).looping()
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)))

            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.0F, 8.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 1.25F, 8.0F), AnimationChannel.Interpolations.LINEAR)))

            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.0F, 8.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 1.25F, 8.0F), AnimationChannel.Interpolations.LINEAR)))
        .build();


}
