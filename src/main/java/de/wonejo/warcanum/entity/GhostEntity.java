package de.wonejo.warcanum.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

public class GhostEntity extends Monster {
    private static final EntityDataAccessor<Byte> CHARGING_ID = SynchedEntityData.defineId(GhostEntity.class, EntityDataSerializers.BYTE);

    public GhostEntity(EntityType<GhostEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new GhostMoveControl(this);
        this.xpReward = 4;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(4, new GhostChargeAttackGoal());
        this.goalSelector.addGoal(8, new GhostRandomMoveGoal());
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public void tick() {
        this.noPhysics = true;
        super.tick();
        this.noPhysics = false;
        this.setNoGravity(true);
    }

    public void move(@NotNull MoverType pType, @NotNull Vec3 pPos) {
        super.move(pType, pPos);
        this.checkInsideBlocks();
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CHARGING_ID, (byte) 0);
    }
    public static @NotNull AttributeSupplier.Builder getGhostAttributes () {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 32)
                .add(Attributes.MOVEMENT_SPEED, 0.6)
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ARMOR, 0.4)
                .add(Attributes.ATTACK_DAMAGE, 4);
    }

    private boolean getGhostFlag(int pMask) {
        int i = this.entityData.get(CHARGING_ID);
        return (i & pMask) != 0;
    }

    private void setGhostFlag(int pMask, boolean pValue) {
        int i = this.entityData.get(CHARGING_ID);
        if (pValue) {
            i |= pMask;
        } else {
            i &= ~pMask;
        }

        this.entityData.set(CHARGING_ID, (byte)(i & 0xFF));
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if ( pSource.typeHolder().is(DamageTypes.ARROW) ) return false;

        return super.hurt(pSource, pAmount);
    }

    public boolean isCharging() {
        return this.getGhostFlag(1);
    }
    public void setIsCharging(boolean pCharging) {
        this.setGhostFlag(1, pCharging);
    }

    private class GhostMoveControl extends MoveControl {
        public GhostMoveControl(GhostEntity pMob) {
            super(pMob);
        }

        public void tick() {
            if (this.operation == MoveControl.Operation.MOVE_TO) {
                Vec3 vec3 = new Vec3(this.wantedX - GhostEntity.this.getX(), this.wantedY - GhostEntity.this.getY(), this.wantedZ - GhostEntity.this.getZ());
                double d0 = vec3.length();
                if (d0 < GhostEntity.this.getBoundingBox().getSize()) {
                    this.operation = MoveControl.Operation.WAIT;
                    GhostEntity.this.setDeltaMovement(GhostEntity.this.getDeltaMovement().scale(0.5));
                } else {
                    GhostEntity.this.setDeltaMovement(GhostEntity.this.getDeltaMovement().add(vec3.scale(this.speedModifier * 0.05 / d0)));
                    if (GhostEntity.this.getTarget() == null) {
                        Vec3 vec31 = GhostEntity.this.getDeltaMovement();
                        GhostEntity.this.setYRot(-((float) Mth.atan2(vec31.x, vec31.z)) * (180.0F / (float)Math.PI));
                    } else {
                        double d2 = GhostEntity.this.getTarget().getX() - GhostEntity.this.getX();
                        double d1 = GhostEntity.this.getTarget().getZ() - GhostEntity.this.getZ();
                        GhostEntity.this.setYRot(-((float)Mth.atan2(d2, d1)) * (180.0F / (float)Math.PI));
                    }
                    GhostEntity.this.yBodyRot = GhostEntity.this.getYRot();
                }
            }
        }
    }

    private class GhostRandomMoveGoal extends Goal {
        public GhostRandomMoveGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            return !GhostEntity.this.getMoveControl().hasWanted() && GhostEntity.this.random.nextInt(reducedTickDelay(7)) == 0;
        }

        public boolean canContinueToUse() {
            return false;
        }

        public void tick() {
            BlockPos blockpos = GhostEntity.this.blockPosition();

            for(int i = 0; i < 3; ++i) {
                BlockPos blockpos1 = blockpos.offset(GhostEntity.this.random.nextInt(15) - 7, GhostEntity.this.random.nextInt(11) - 5, GhostEntity.this.random.nextInt(15) - 7);
                if (GhostEntity.this.level().isEmptyBlock(blockpos1)) {
                    GhostEntity.this.moveControl
                            .setWantedPosition((double)blockpos1.getX() + 0.5, (double)blockpos1.getY() + 0.5, (double)blockpos1.getZ() + 0.5, 0.25);
                    if (GhostEntity.this.getTarget() == null) {
                        GhostEntity.this.getLookControl()
                                .setLookAt((double)blockpos1.getX() + 0.5, (double)blockpos1.getY() + 0.5, (double)blockpos1.getZ() + 0.5, 180.0F, 20.0F);
                    }
                    break;
                }
            }
        }
    }

    private class GhostChargeAttackGoal extends Goal {
        public GhostChargeAttackGoal () {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            LivingEntity target = GhostEntity.this.getTarget();
            if (target != null && target.isAlive() && !GhostEntity.this.getMoveControl().hasWanted() && GhostEntity.this.random.nextInt(7) == 0)
                return GhostEntity.this.distanceToSqr(target) > 4.0F;
            return false;
        }

        public boolean canContinueToUse() {
            return GhostEntity.this.getMoveControl().hasWanted() && GhostEntity.this.isCharging() && GhostEntity.this.getTarget() != null && GhostEntity.this.getTarget().isAlive();
        }

        public void start() {
            LivingEntity target = GhostEntity.this.getTarget();
            if ( target != null ) {
                Vec3 eyePos = target.getEyePosition();
                GhostEntity.this.getMoveControl().setWantedPosition(eyePos.x, eyePos.y, eyePos.z, 1.0F);
            }

            GhostEntity.this.setIsCharging(true);
        }

        @Override
        public void tick() {
            LivingEntity target = GhostEntity.this.getTarget();
            if ( target != null ) {
                GhostEntity ghost = GhostEntity.this;

                if ( ghost.getBoundingBox().intersects(target.getBoundingBox()) ){
                    ghost.doHurtTarget(target);
                    ghost.setIsCharging(false);
                } else {
                    double distance = ghost.distanceToSqr(target);

                    if  (distance < 9.0) {
                        Vec3 eyePos = target.getEyePosition();
                        ghost.getMoveControl().setWantedPosition(eyePos.x, eyePos.y, eyePos.z, 1.0F);
                    }
                }
            }
        }

        public void stop() {
            GhostEntity.this.setIsCharging(false);
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

}
