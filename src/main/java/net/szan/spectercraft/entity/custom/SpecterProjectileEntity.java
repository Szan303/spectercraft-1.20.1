package net.szan.spectercraft.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;


import net.szan.spectercraft.damagetypes.ModDamageTypes;
import net.szan.spectercraft.entity.ModEntities;
import net.szan.spectercraft.item.ModItems;

public class SpecterProjectileEntity extends ThrownItemEntity {
    public SpecterProjectileEntity(EntityType<? extends ThrownItemEntity> type, World world) {
        super(type, world);
    }

    public SpecterProjectileEntity(World world, LivingEntity owner) {
        super(ModEntities.SPECTER_PROJECTILE, owner, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SPECTER_PROJECTILE_ITEM;
    }

        @Override
    protected void onCollision(HitResult hitResult) {
            super.onCollision(hitResult);

            if (!this.getWorld().isClient) {
                BlockPos pos = this.getBlockPos();

                // Obszar 3x3x3 wokół miejsca uderzenia
                Box box = new Box(pos).expand(1.5);

                List<LivingEntity> entities = this.getWorld()
                        .getEntitiesByClass(LivingEntity.class, box, e -> e != this.getOwner());

                for (LivingEntity target : entities) {
                    // pobranie własnego DamageType z rejestru
                    DamageSource customSrc = new DamageSource(
                            this.getWorld()
                                    .getRegistryManager()
                                    .get(RegistryKeys.DAMAGE_TYPE)
                                    .entryOf(ModDamageTypes.SPECTER_MAGIC),
                            this.getOwner()
                    );

                    target.damage(customSrc, 5.0F);
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 0));
                }

                this.discard(); // usuń pocisk
            }
    }
}
