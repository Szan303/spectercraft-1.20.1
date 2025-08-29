package net.szan.spectercraft.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.szan.spectercraft.damagetypes.ModDamageTypes;
import net.szan.spectercraft.entity.ModEntities;
import net.szan.spectercraft.item.ModItems;

import java.util.List;

public class BloodProjectileEntity extends ThrownItemEntity {

    public static final float BLOOD_DAMAGE = 3.0F; // obrażenia dla jednego celu

    public BloodProjectileEntity(EntityType<? extends ThrownItemEntity> type, World world) {
        super(type, world);
    }

    public BloodProjectileEntity(World world, LivingEntity owner) {
        super(ModEntities.BLOOD_PROJECTILE, owner, world);
    }

    @Override
    protected Item getDefaultItem() {
        // Wygląd itemu pocisku — możesz użyć innej tekstury niż Specter
        return ModItems.BLOOD_PROJECTILE_ITEM;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);

        if (!this.getWorld().isClient) {
            BlockPos pos = this.getBlockPos();

            // Zasięg uderzenia (AOE)
            Box box = new Box(pos).expand(1.5); // promień ~1.5 bloku

            // Pobierz wszystkie żywe byty w zasięgu
            List<LivingEntity> entities = this.getWorld()
                    .getEntitiesByClass(LivingEntity.class, box, e -> e != this.getOwner());

            float totalDamageDealt = 0.0F; // suma obrażeń dla leczenia

//            for (LivingEntity entity : entities) {
//                entity.damage(this.getDamageSources().magic(), BLOOD_DAMAGE);
//                totalDamageDealt += BLOOD_DAMAGE;
//            }

            for (LivingEntity entity : entities) {
                // Pobranie customowego DamageType z rejestru
                DamageSource customSrc = new DamageSource(
                        this.getWorld()
                                .getRegistryManager()
                                .get(RegistryKeys.DAMAGE_TYPE)
                                .entryOf(ModDamageTypes.BLOOD_MAGIC),
                        this.getOwner()
                );

                // Zadajemy obrażenia z nowego źródła
                entity.damage(customSrc, BLOOD_DAMAGE);
                totalDamageDealt += BLOOD_DAMAGE;
            }


            // Leczenie właściciela o 1/3 sumy obrażeń
            if (totalDamageDealt > 0 && this.getOwner() instanceof PlayerEntity player) {
                float healAmount = totalDamageDealt / 3.0F;
                player.heal(healAmount);
            }

            // Usuń pocisk po kolizji
            this.discard();
        }
    }
}